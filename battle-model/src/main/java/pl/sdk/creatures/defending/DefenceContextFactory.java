package pl.sdk.creatures.defending;

import pl.sdk.creatures.CreatureStatistic;

public class DefenceContextFactory {
    public static DefenceContextIf create(int aArmor) {
        return new DefaultDefenceContext(new DefaultDamageApplier(), aArmor);
    }

    public static DefenceContextIf create(CreatureStatistic aStats) {
        switch (aStats) {
            default:
                return new DefaultDefenceContext(new DefaultDamageApplier(), aStats.getArmor());
        }
    }
}
