package pl.sdk.creatures.attacking;

import com.google.common.collect.Range;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.checkerframework.checker.units.qual.C;
import pl.sdk.creatures.CreatureDynamicStats;

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

    @Override
    public void setDamage(CreatureDynamicStats aS) {
        Integer down = (Integer)((int) (damage.lowerEndpoint() * aS.getDamagePercentage())+(int) (damage.lowerEndpoint()));
        Integer up = (Integer)((int) (damage.upperEndpoint() * aS.getDamagePercentage()) + (int) (damage.upperEndpoint()));
        damage =  Range.closed(down,up);
    }

    @Override
    public void setAttack(CreatureDynamicStats aS) {
        attack = aS.getAttack();
    }
}
