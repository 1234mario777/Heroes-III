package pl.sdk.hero;

import pl.sdk.Fraction;
import pl.sdk.creatures.AbstractEconomyFractionFactory;
import pl.sdk.creatures.EconomyCreature;
import pl.sdk.spells.AbstractEconomySpellFactory;
import pl.sdk.spells.EconomySpell;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static pl.sdk.spells.SpellFactoryType.DEFAULT;

public class SpellShop extends AbstractShop
{
	public static final String EXCEPTION_MESSAGE = "hero cannot consume more spells";
	public static final String PLAYER_HAS_ALREADY_BOUGHT_THIS_SPELL = "Player has already bought this spell!";
	private final AbstractEconomySpellFactory spellFactory;
	private List<EconomySpell> spellPopulation;

	SpellShop( )
	{
		calculator = new SpellShopCalculator(  );
		spellFactory = AbstractEconomySpellFactory.getInstance( DEFAULT );
		spellPopulation = new ArrayList<>();
		createPopulation();
	}

	SpellShop( Random aRand, AbstractEconomySpellFactory aFactory )
	{
		calculator = new SpellShopCalculator(aRand);
		spellFactory = aFactory;
		spellPopulation = new ArrayList<>();
		createPopulation();
	}

	private void createPopulation( )
	{
		List<EconomySpell> allSpells = spellFactory.getAllSpells();
		int populationSize = calculatePopulation( allSpells.size() );
		Random rand = new Random();

		for (int i = 0; i < populationSize; i++) {
			int randomIndex = rand.nextInt(allSpells.size());
			spellPopulation.add( allSpells.get( randomIndex ) );
			allSpells.remove(randomIndex);
		}
	}

	private int calculatePopulation( int aSize )
	{
		return calculator.randomize( aSize );
	}

	List<EconomySpell> getCurrentSpellPopulation()
	{
		return spellPopulation;
	}

	@Override
	protected void handlePopulation()
	{
		spellPopulation = new ArrayList<>();
		createPopulation();
	}

	void buy( Player aActivePlayer, EconomySpell aEconomySpell )
	{
		aActivePlayer.substractGold(aEconomySpell.getGoldCost());
		subtractPopulation(aEconomySpell);
		try{
			aActivePlayer.addSpell(aEconomySpell);
		}catch(Exception e){
			aActivePlayer.addGold(aEconomySpell.getGoldCost());
			restorePopulation( aEconomySpell );
			throw new IllegalStateException( EXCEPTION_MESSAGE );
		}
	}

	private void restorePopulation( EconomySpell aEconomySpell )
	{
		spellPopulation.add( aEconomySpell );
	}

	private void subtractPopulation( EconomySpell aEconomySpell )
	{
		if ( !spellPopulation.stream().map( EconomySpell::getName ).collect( Collectors.toList() ).contains( aEconomySpell.getName() ))
		{
			throw new IllegalStateException( PLAYER_HAS_ALREADY_BOUGHT_THIS_SPELL );

		}
		for ( int i = 0; i < spellPopulation.size() ; i++ )
		{
			if ( spellPopulation.get( i ).getName().equals( aEconomySpell.getName() ) )
				spellPopulation.remove( i );
		}
	}

	int calculateMaxAmount( Player aPlayer, EconomySpell aSpell )
	{
		return calculator.calculateMaxAmount(aPlayer.getGold(), aSpell.getGrowth(), aSpell.getGoldCost());
	}

}
