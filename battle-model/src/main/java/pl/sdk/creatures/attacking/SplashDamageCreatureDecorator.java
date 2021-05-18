package pl.sdk.creatures.attacking;


import pl.sdk.creatures.CreatureDynamicStats;

import java.beans.PropertyChangeEvent;

public class SplashDamageCreatureDecorator implements AttackContextIf {

    AttackContextIf decorated;
    SplashRange splashRange;

    SplashDamageCreatureDecorator(SplashRange aSplashRange, AttackContextIf aDecorated) {
        decorated = aDecorated;
        splashRange = aSplashRange;
    }

    @Override
    public SplashRange getSplashRange() {
        return splashRange;
    }

    @Override
    public CalculateDamageStrategyIf getDamageCalculator() {
        return decorated.getDamageCalculator();
    }

    @Override
    public AttackStatistic getAttackerStatistic() {
        return decorated.getAttackerStatistic();
    }

    @Override
    public boolean canYouCounterAttackMe() {
        return decorated.canYouCounterAttackMe();
    }

    @Override
    public void addAdictionalStats(CreatureDynamicStats aS) {
        decorated.getAttackerStatistic().setDamage(aS);
//        decorated.getAttackerStatistic().setAttack(aS);
    }


    @Override
    public void propertyChange(PropertyChangeEvent aPropertyChangeEvent) {
        decorated.propertyChange(aPropertyChangeEvent);
    }
}
