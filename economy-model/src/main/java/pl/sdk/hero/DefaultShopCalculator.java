package pl.sdk.hero;

import java.util.Random;

class DefaultShopCalculator extends AbstractShopCalculator {

    DefaultShopCalculator() { super();
    }

    DefaultShopCalculator(Random aRand) {
        super(aRand);
    }

    @Override
    int calculateMaxAmount(int aHeroGold, int aAmount, int aGoldCost) {
        return Math.min(aHeroGold / aGoldCost, aAmount) >= 1 ? 1 : 0;
    }
}
