package pl.sdk.creatures;

public interface AttackerIf extends AttackerStatisticIf {

    SplashRange getSplashRange();
    boolean isAlive();
    CalculateDamageStrategyIf getDamageCalculator();


}
