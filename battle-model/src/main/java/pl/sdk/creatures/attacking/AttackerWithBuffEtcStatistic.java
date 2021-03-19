package pl.sdk.creatures.attacking;

import com.google.common.collect.Range;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class AttackerWithBuffEtcStatistic implements AttackerStatisticIf{
    double attackRange;
    int attack;
    Range<Integer> damage;
    int amount;

    AttackerWithBuffEtcStatistic(int aAmount, AttackerStatisticIf aCopy) {
        amount = aAmount;
        attack = aCopy.getAttack();
        damage = aCopy.getDamage();
        attackRange = aCopy.getAttackRange();
    }
}
