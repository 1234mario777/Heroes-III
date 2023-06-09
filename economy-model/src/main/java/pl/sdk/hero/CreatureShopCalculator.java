package pl.sdk.hero;

import java.util.Random;

class CreatureShopCalculator extends AbstractShopCalculator
{

	CreatureShopCalculator()
	{
		super();
	}

	CreatureShopCalculator( Random aRand )
	{
		super( aRand );
	}

	@Override
	int calculateMaxAmount( int aHeroGold, int aAmount, int aGoldCost )
	{
		return Math.min( aHeroGold / aGoldCost, aAmount );
	}

}
