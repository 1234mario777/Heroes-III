package pl.sdk.creatures;

class HealAfterAttackCreatureDecorator implements AttackIf {

    private double selfHealingPercentage;
    private AttackIf decorated;

    HealAfterAttackCreatureDecorator(AttackIf aDecorated, double aSelfHealingPercentage) {
        decorated = aDecorated;
        selfHealingPercentage = aSelfHealingPercentage;
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
