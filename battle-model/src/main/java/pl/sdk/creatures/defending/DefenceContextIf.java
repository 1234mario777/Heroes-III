package pl.sdk.creatures.defending;


import java.beans.PropertyChangeListener;

public interface DefenceContextIf {


    void addObserver(String aEventType, PropertyChangeListener aObs);
    void applyDamage(int aDamageToDeal);

	DefenceStatistic getDefenceStatistic();
}
