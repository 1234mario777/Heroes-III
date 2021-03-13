package pl.sdk.creatures;

public interface AttackerIf {

    SplashRange getSplashRange();
    boolean isAlive();
    CalculateDamageStrategyIf getDamageCalculator();
}
