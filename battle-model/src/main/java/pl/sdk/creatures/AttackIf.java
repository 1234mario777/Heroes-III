package pl.sdk.creatures;

public interface AttackIf {

    SplashRange getSplashRange();
    CalculateDamageStrategyIf getDamageCalculator();
    AttackerStatisticIf getAttackerStatistic();
    boolean canYouCounterAttackMe();
}
