package pl.sdk.hero;

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
}
