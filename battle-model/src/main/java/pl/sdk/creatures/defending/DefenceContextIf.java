package pl.sdk.creatures.defending;

import pl.sdk.creatures.attacking.CounterAttackerIf;

import java.beans.PropertyChangeEvent;

public interface DefenceContextIf extends CounterAttackerIf {

    boolean canCounterAttack();
    int getArmor();
    int getCurrentHp();
    int getMaxHp();
    int getCurrentAmount();

    void applyDamage(int aDamageToDeal);
}
