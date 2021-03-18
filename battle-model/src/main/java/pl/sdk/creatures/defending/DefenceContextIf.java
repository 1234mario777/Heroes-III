package pl.sdk.creatures.defending;

import pl.sdk.creatures.DefaultDamageApplier;
import pl.sdk.creatures.attacking.CounterAttackerIf;

public interface DefenceContextIf extends CounterAttackerIf {

    DefaultDamageApplier getDamageApplier();
    boolean canCounterAttack();
    int getArmor();
    int getCurrentHp();
    int getMaxHp();
    int getCurrentAmount();
}
