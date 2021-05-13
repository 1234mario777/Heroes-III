package pl.sdk.creatures.attacking;

import com.google.common.collect.Range;
import pl.sdk.creatures.CreatureDynamicStats;

public interface AttackerStatisticIf {
    double getAttackRange();
    int getAttack();
    Range<Integer> getDamage();
    int getAmount();
    void setDamage(CreatureDynamicStats aS);
    void setAttack(CreatureDynamicStats aS);
}
