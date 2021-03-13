package pl.sdk.creatures.attacking;

public interface AttackContextIf {

    SplashRange getSplashRange();
    CalculateDamageStrategyIf getDamageCalculator();
    AttackerStatisticIf getAttackerStatistic();
    boolean canYouCounterAttackMe();
}
