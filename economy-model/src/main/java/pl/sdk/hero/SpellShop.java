package pl.sdk.hero;

import pl.sdk.spells.AbstractEconomySpellFactory;
import pl.sdk.spells.EconomySpell;

import java.util.*;

import static pl.sdk.spells.SpellFactoryType.DEFAULT;

public class SpellShop extends AbstractShop<EconomySpell>
{
	public static final String PLAYER_HAS_ALREADY_BOUGHT_THIS_SPELL = "Player has already bought this spell!";
	public static final String HERO_CANNOT_CONSUME_MORE_SPELLS = "Hero cannot consume more spells";
	private final AbstractEconomySpellFactory spellFactory;
	private final Random rand;

	SpellShop( )
	{
		super(new DefaultShopCalculator(), new ArrayList<>());
		spellFactory = AbstractEconomySpellFactory.getInstance( DEFAULT );
		rand = new Random();
		createPopulation();
	}

	SpellShop( Random aRand, AbstractEconomySpellFactory aFactory )
	{
		super(new DefaultShopCalculator(aRand), new ArrayList<>());
		spellFactory = aFactory;
		rand = aRand;
		createPopulation();
	}

	@Override
	protected void createPopulation( )
	{
		List<EconomySpell> allSpells = spellFactory.getAllSpells();
		int spellAmount = getSpellAmount(allSpells);
		Collections.shuffle(allSpells);
		allSpells.subList(0, spellAmount).forEach(s -> getShopPopulation().add(s));
	}

	@Override
	protected void addItem(Player aActivePlayer, EconomySpell aShopItem) {
		aActivePlayer.addSpell(aShopItem);
	}

	@Override
	protected String getSubtractPopulationErrorMessage() {
		return PLAYER_HAS_ALREADY_BOUGHT_THIS_SPELL;
	}

	@Override
	protected String getBuyErrorMessage() {
		return HERO_CANNOT_CONSUME_MORE_SPELLS;
	}

	List<EconomySpell> getCurrentSpellPopulation()
	{
		return List.copyOf(getShopPopulation());
	}

	boolean canBuySpell(Player aPlayer, EconomySpell aSpell) {
		return getCalculator().calculateMaxAmount(aPlayer.getGold(), aSpell.getGrowth(), aSpell.getGoldCost()) == 1;
	}

	private int getSpellAmount(List<EconomySpell> allSpells) {
		int amount = allSpells.size()/2;
		return 1 + amount + rand.nextInt(amount);
	}
}
