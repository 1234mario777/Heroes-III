package pl.sdk.creatures.defending;

import java.beans.PropertyChangeListener;

public interface DefenceContextIf {

    int getArmor();
    int getCurrentHp();
    int getMaxHp();
    int getCurrentAmount();
    void addObserver(String aEventType, PropertyChangeListener aObs);
    void applyDamage(int aDamageToDeal);
}
