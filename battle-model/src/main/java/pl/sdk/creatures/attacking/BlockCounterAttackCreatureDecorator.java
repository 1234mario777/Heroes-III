package pl.sdk.creatures.attacking;

import pl.sdk.creatures.CreatureDynamicStats;

import java.beans.PropertyChangeEvent;

class BlockCounterAttackCreatureDecorator implements AttackContextIf {

    private final AttackContextIf decorated;

    public BlockCounterAttackCreatureDecorator(AttackContextIf aDecorated){
        decorated = aDecorated;
    }

    @Override
    public boolean canYouCounterAttackMe() {
        return false;
    }

    @Override
    public void addAdictionalStats(CreatureDynamicStats aS) {

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
        return decorated.getAttackerStatistic();
    }

    @Override
    public void propertyChange(PropertyChangeEvent aPropertyChangeEvent) {
        decorated.propertyChange(aPropertyChangeEvent);
    }
}
