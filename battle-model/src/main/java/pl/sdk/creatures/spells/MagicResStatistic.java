package pl.sdk.creatures.spells;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MagicResStatistic {

    private double percentageSpellResistance;

    public MagicResStatistic(double aPercentageSpellResistance) {
        percentageSpellResistance = aPercentageSpellResistance;
    }
}
