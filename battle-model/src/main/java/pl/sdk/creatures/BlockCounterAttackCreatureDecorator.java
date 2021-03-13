package pl.sdk.creatures;

class BlockCounterAttackCreatureDecorator implements AttackIf {

    private final AttackIf decorated;

    public BlockCounterAttackCreatureDecorator(AttackIf aDecorated){
        decorated = aDecorated;
    }

    @Override
    public boolean canYouCounterAttackMe() {
        return false;
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
}
