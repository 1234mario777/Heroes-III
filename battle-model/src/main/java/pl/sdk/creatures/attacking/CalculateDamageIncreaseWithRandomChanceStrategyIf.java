package pl.sdk.creatures.attacking;

import java.util.Random;

class CalculateDamageIncreaseWithRandomChanceStrategyIf extends AbstractCalculateDamageStrategyIf {

    private final double chanceToIncrease;
    private final double increaseFactor;

    CalculateDamageIncreaseWithRandomChanceStrategyIf(double aChance, double aIncreaseFactor) {
        this(aChance,aIncreaseFactor,new Random());
    }

    CalculateDamageIncreaseWithRandomChanceStrategyIf(double aChance, double aIncreaseFactor, Random aRand) {
        super(aRand);
        chanceToIncrease = aChance;
        increaseFactor = aIncreaseFactor;
    }

    @Override
    double changeDamageAfter(double aDamageToChange, AttackContextIf aAttacker) {
        if (getRand().nextDouble() <= chanceToIncrease){
            aDamageToChange = aDamageToChange * increaseFactor;
        }
        return aDamageToChange;
    }
}
