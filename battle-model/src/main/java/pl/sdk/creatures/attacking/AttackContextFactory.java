package pl.sdk.creatures.attacking;

import pl.sdk.creatures.CreatureStatistic;

public class AttackContextFactory {

    public static AttackContextIf create(AttackerWithBuffEtcStatistic aStats, CalculateDamageStrategyIf aCalculateDamageStrategyIf) {
        return new DefaultAttackContext(aCalculateDamageStrategyIf, aStats);
    }

    public static AttackContextIf create(CreatureStatistic aStats) {
        switch (aStats) {
            default:
                return new DefaultAttackContext(new DefaultCalculateStrategy(), mapStatsToAttackContextStats(aStats));
        }
    }

    private static AttackerStatisticIf mapStatsToAttackContextStats(CreatureStatistic aStatistic) {
        return AttackerWithBuffEtcStatistic.builder()
                .attack(aStatistic.getAttack())
                .attackRange(1)
                .damage(aStatistic.getDamage())
                .build();
    }

    private static AttackerStatisticIf mapStatsToAttackContextStatsForShooter(CreatureStatistic aStatistic) {
        return AttackerWithBuffEtcStatistic.builder()
                .attack(aStatistic.getAttack())
                .attackRange(Double.MAX_VALUE)
                .damage(aStatistic.getDamage())
                .build();
    }
}
