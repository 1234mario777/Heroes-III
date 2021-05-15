package pl.sdk.creatures.attacking;

import pl.sdk.creatures.defending.CreatureLifeStats;

import java.beans.PropertyChangeEvent;

public class DefaultAttackContext implements AttackContextIf {
    private CalculateDamageStrategyIf calculateDamageStrategy;
    private AttackStatistic stats;

    DefaultAttackContext(CalculateDamageStrategyIf aCalculateDamageStrategy, AttackStatistic aStats) {
        calculateDamageStrategy = aCalculateDamageStrategy;
        stats = aStats;
    }

    @Override
    public SplashRange getSplashRange() {
        return new SplashRange();
    }

    @Override
    public CalculateDamageStrategyIf getDamageCalculator() {
        return calculateDamageStrategy;
    }

    @Override
    public AttackStatistic getAttackerStatistic() {
        return stats;
    }

    @Override
    public boolean canYouCounterAttackMe() {
        return true;
    }

    @Override
    public void propertyChange(PropertyChangeEvent aPropertyChangeEvent) {
        stats = new AttackStatistic(((CreatureLifeStats)aPropertyChangeEvent.getNewValue()).getAmount(),stats);
    }
}
