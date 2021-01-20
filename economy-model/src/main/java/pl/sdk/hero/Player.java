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

	CreatureShop getCreatureShop()
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
}
