package pl.sdk.creatures.attacking;

import pl.sdk.creatures.defending.CreatureLifeStats;

import java.beans.PropertyChangeEvent;

public class DefaultAttackContext implements AttackContextIf {
    private CalculateDamageStrategyIf calculateDamageStrategy;
    private AttackerStatisticIf stats;

    DefaultAttackContext(CalculateDamageStrategyIf aCalculateDamageStrategy, AttackerStatisticIf aStats) {
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
    public AttackerStatisticIf getAttackerStatistic() {
        return stats;
    }

    @Override
    public boolean canYouCounterAttackMe() {
        return true;
    }

    @Override
    public void propertyChange(PropertyChangeEvent aPropertyChangeEvent) {
        stats = new AttackerWithBuffEtcStatistic(((CreatureLifeStats)aPropertyChangeEvent.getNewValue()).getAmount(),stats);
    }
}
