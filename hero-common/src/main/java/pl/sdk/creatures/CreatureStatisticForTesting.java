package pl.sdk.creatures;

import com.google.common.collect.Range;
import lombok.Builder;

@Builder
public class CreatureStatisticForTesting {
    private final String name;
    private final int attack;
    private final int armor;
    private final int maxHp;
    private final int moveRange;
    private final Range<Integer> damage;
    private final int tier;
    private final String description;
    private final boolean isUpgraded;
    private final int growth;
}
