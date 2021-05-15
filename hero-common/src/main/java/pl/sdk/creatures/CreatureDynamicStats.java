package pl.sdk.creatures;

import com.google.common.collect.Range;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CreatureDynamicStats {

    private int moveRange;
    private int attack;
    private int armor;
    private int maxHp;
    private Range<Integer> damage;

    private double damageReduction;
    private double moveRangePercentage;
    private double attackPercentage;
    private double armorPercentage;
    private double maxHpPercentage;
    private double damagePercentage;
}
