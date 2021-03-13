package pl.sdk.creatures;


public class SplashDamageCreatureDecorator implements AttackIf {

    AttackIf decorated;

    SplashDamageCreatureDecorator(AttackIf aDecorated) {
        decorated = aDecorated;
    }

    @Override
    public SplashRange getSplashRange() {
        return decorated.getSplashRange();
    }

    @Override
    public CalculateDamageStrategyIf getDamageCalculator() {
        return decorated.getDamageCalculator();
    }

    @Override
    public AttackerStatisticIf getAttackerStatistic() {
        return decorated.getAttackerStatistic();
    }

    @Override
    public boolean canYouCounterAttackMe() {
        return decorated.canYouCounterAttackMe();
    }
}
