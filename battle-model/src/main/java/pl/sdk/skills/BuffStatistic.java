package pl.sdk.skills;

import com.google.common.collect.Range;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import pl.sdk.creatures.Creature;

@Builder
@AllArgsConstructor
@Getter
public class BuffStatistic {

    private int moveRange;
    private int attack;
    private int armor;
    private int maxHp;
    private Range<Integer> damage;

    private double moveRangePercentage;
    private double attackPercentage;
    private double armorPercentage;
    private double maxHpPercentage;
    private double damagePercentage;

    public BuffStatistic(int aMoveRange) {
        moveRange = aMoveRange;
    }

}
