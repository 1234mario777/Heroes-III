package pl.sdk.creatures.attacking;

import com.google.common.collect.Range;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AttackerWithBuffEtcStatistic implements AttackerStatisticIf{
    double attackRange;
    int attack;
    Range<Integer> damage;
    int amount;
}
