package pl.sdk.creatures.attacking;

import java.beans.PropertyChangeEvent;

class HealAfterAttackCreatureDecorator implements AttackContextIf {

    private double selfHealingPercentage;
    private AttackContextIf decorated;

    HealAfterAttackCreatureDecorator(AttackContextIf aDecorated, double aSelfHealingPercentage) {
        decorated = aDecorated;
        selfHealingPercentage = aSelfHealingPercentage;
    }

    @Override
    public SplashRange getSplashRange() {
        return decorated.getSplashRange();
    }

    @Override
    public CalculateDamageStrategyIf getDamageCalculator() {
        return decorated.getDamageCalculator();
    }

    @Override
    public AttackerStatisticIf getAttackerStatistic() {
        return decorated.getAttackerStatistic();
    }

    @Override
    public boolean canYouCounterAttackMe() {
        return decorated.canYouCounterAttackMe();
    }

    @Override
    public void propertyChange(PropertyChangeEvent aPropertyChangeEvent) {
        decorated.propertyChange(aPropertyChangeEvent);
    }
}
