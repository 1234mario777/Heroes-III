package pl.sdk.creatures.attacking;

import com.google.common.collect.Range;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class AttackStatistic {
    double attackRange;
    int attack;
    Range<Integer> damage;
    int amount;

    AttackStatistic(int aAmount, AttackStatistic aCopy ) {
        amount = aAmount;
        attack = aCopy.getAttack();
        damage = aCopy.getDamage();
        attackRange = aCopy.getAttackRange();
    }

    public void setAttackRange( double aAttackRange )
    {
        attackRange = aAttackRange;
    }

    public void setAttack( int aAttack )
    {
        attack = aAttack;
    }

    public void setDamage( Range<Integer> aDamage )
    {
        damage = aDamage;
    }
}
