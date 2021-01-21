package pl.sdk.hero;

import pl.sdk.creatures.EconomyCreature;

import java.util.List;

public class Player
{
	EconomyHero hero;
	CreatureShop creatureShop;

	public Player( EconomyHero aHero )
	{
		hero = aHero;
		creatureShop = new CreatureShop(  );
	}

	Player( EconomyHero aHero, CreatureShop aCreatureShop )
	{
		hero = aHero;
		creatureShop = aCreatureShop;
	}

	EconomyHero getHero()
	{
		return hero;
	}

	public CreatureShop getCreatureShop()
	{
		return creatureShop;
	}

	void substractGold( int aGold )
	{
		hero.substractGold( aGold );
	}

	public void addGold( int aGold )
	{
		hero.addGold( aGold );
	}

	void addCreature( EconomyCreature aEconomyCreature )
	{
		hero.addCreature( aEconomyCreature );
	}

	public List<EconomyCreature> getCreatures()
	{
		return hero.getCreatures();
	}

	public int getGold()
	{
		return hero.getGold();
	}

	public void buy( Player aActivePlayer, EconomyCreature aEconomyCreature )
	{
		creatureShop.buy( aActivePlayer, aEconomyCreature );
	}

	public int calculateMaxAmount( EconomyCreature aCreature )
	{
		return creatureShop.calculateMaxAmount(this, aCreature );
	}

	public int getCurrentPopulation( int aTier )
	{
		return creatureShop.getCurrentPopulation( aTier );
	}
}
