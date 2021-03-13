package pl.sdk.creatures;

import java.util.Random;

class DefaultCalculateStrategyIf extends AbstractCalculateDamageStrategyIf {

    private final Random rand;

    DefaultCalculateStrategyIf(){
        this(new Random());
    }

    DefaultCalculateStrategyIf(Random aRandomizer) {
        super(aRandomizer);
        rand = aRandomizer;
    }

    @Override
    double changeDamageAfter(double aWholeStackDamageToDeal, AttackerIf aAttacker) {
        return aWholeStackDamageToDeal;
    }
}
