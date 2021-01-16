package pl.sdk.hero;

import java.util.Random;

public class CreatureShopCalculator
{
	private final Random rand;

	private double randomFactor;

	CreatureShopCalculator(  )
	{
		rand = new Random(  );
		generateRandomFactor();
	}

	CreatureShopCalculator( Random aRand )
	{
		rand = aRand;
		generateRandomFactor();
	}

	void generateRandomFactor()
	{
		randomFactor = 0.5 + (1 - 0.5) * rand.nextDouble();
	}

	int calculateMaxAmount( int aHeroGold, int aPopulation, int aGoldCost )
	{
		return Math.min(aHeroGold/aGoldCost, aPopulation);
	}

	int randomize(int aPopulation)
	{
		return ( int ) (aPopulation * randomFactor);
	}
}
