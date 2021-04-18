package pl.sdk.hero;

import java.util.Random;

public class SkillShopCalculator extends AbstractShopCalculator {
    SkillShopCalculator()
    {
        super();
    }

    SkillShopCalculator( Random aRand )
    {
        super( aRand );
    }

    @Override
    int calculateMaxAmount( int aHeroGold, int aAmount, int aGoldCost )
    {
        return Math.min( aHeroGold / aGoldCost, aAmount ) >= 1 ? 1 : 0;
    }
}
