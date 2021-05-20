package pl.sdk.creatures.attacking;

import pl.sdk.creatures.CreatureDynamicStats;

import java.beans.PropertyChangeEvent;

class ShootingCreatureDecorator implements AttackContextIf {

    private final AttackContextIf decorated;

    ShootingCreatureDecorator(AttackContextIf aDecorated) {
        decorated = aDecorated;
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
    public AttackStatistic getAttackerStatistic() {
        return AttackStatistic.builder()
                              .damage(decorated.getAttackerStatistic().getDamage())
                              .attackRange(Double.MAX_VALUE)
                              .attack(decorated.getAttackerStatistic().getAttack())
                              .build();
    }

    @Override
    public boolean canYouCounterAttackMe() {
        return false;
    }

    @Override
    public void propertyChange(PropertyChangeEvent aPropertyChangeEvent) {
        decorated.propertyChange(aPropertyChangeEvent);
    }

}
