package pl.sdk.creatures;

import com.google.common.collect.Range;

public interface AttackerStatisticIf {
    double getAttackRange();
    int getAttack();
    Range<Integer> getDamage();
    int getAmount();
}
