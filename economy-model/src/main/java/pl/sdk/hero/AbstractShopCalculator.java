package pl.sdk.hero;

import java.util.Random;


public abstract class AbstractShopCalculator
{
	private final Random rand;

	private double randomFactor;

	AbstractShopCalculator(  )
	{
		rand = new Random(  );
		generateRandomFactor();
	}

	AbstractShopCalculator( Random aRand )
	{
		rand = aRand;
		generateRandomFactor();
	}

	void generateRandomFactor()
	{
		randomFactor = 0.5 + (1 - 0.5) * rand.nextDouble();
	}

	int randomize(int aAmount)
	{
		return ( int ) (aAmount * randomFactor);
	}

	abstract int calculateMaxAmount( int aHeroGold, int aAmount, int aGoldCost );
}
