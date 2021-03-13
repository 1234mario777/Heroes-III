package pl.sdk.creatures.attacking;

import pl.sdk.creatures.CreatureStatistic;

public class AttackContextFactory {

    public static AttackContextIf create (CreatureStatistic aStats, int aAmount){
        switch(aStats){
            default:
                return new DefaultAttackContext(new DefaultCalculateStrategy(), mapStatsToAttackContextStats(aAmount, aStats));
        }
    }

    private static AttackerStatisticIf mapStatsToAttackContextStats(int aAmount, CreatureStatistic aStatistic) {
        return AttackerWithBuffEtcStatistic.builder()
                .amount(aAmount)
                .attack(aStatistic.getAttack())
                .attackRange(1)
                .damage(aStatistic.getDamage())
                .build();
    }

    private static AttackerStatisticIf mapStatsToAttackContextStatsForShooter(int aAmount, CreatureStatistic aStatistic) {
        return AttackerWithBuffEtcStatistic.builder()
                .amount(aAmount)
                .attack(aStatistic.getAttack())
                .attackRange(Double.MAX_VALUE)
                .damage(aStatistic.getDamage())
                .build();
    }
}
