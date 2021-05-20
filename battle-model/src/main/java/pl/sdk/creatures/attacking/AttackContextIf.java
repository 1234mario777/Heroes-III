package pl.sdk.creatures.attacking;

import pl.sdk.creatures.CreatureDynamicStats;

import java.beans.PropertyChangeListener;

public interface AttackContextIf extends PropertyChangeListener {

    SplashRange getSplashRange();
    CalculateDamageStrategyIf getDamageCalculator();
    AttackStatistic getAttackerStatistic();
    boolean canYouCounterAttackMe();
}
