package pl.sdk.creatures.attacking;

import java.util.Random;

public class DefaultCalculateStrategy extends AbstractCalculateDamageStrategyIf {

    private final Random rand;

    DefaultCalculateStrategy(){
        this(new Random());
    }

    DefaultCalculateStrategy(Random aRandomizer) {
        super(aRandomizer);
        rand = aRandomizer;
    }

    @Override
    double changeDamageAfter(double aWholeStackDamageToDeal, AttackStatistic aAttacker) {
        return aWholeStackDamageToDeal;
    }
}
