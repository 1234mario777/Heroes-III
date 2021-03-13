package pl.sdk.creatures.defending;

import pl.sdk.creatures.CreatureStatistic;
import pl.sdk.creatures.DefaultDamageApplier;

public class DefenceContextFactory {
    public static DefenceContextIf create(CreatureStatistic aStats) {
        switch (aStats){
            default:
                return new DefaultDefenceContext(new DefaultDamageApplier(), aStats.getArmor());
        }
    }
}
