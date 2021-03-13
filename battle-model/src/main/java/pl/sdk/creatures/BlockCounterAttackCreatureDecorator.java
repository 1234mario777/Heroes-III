package pl.sdk.creatures;

//TODO doesn;'t work new model
class BlockCounterAttackCreatureDecorator implements AttackerIf {

    private final Creature decorated;

    public BlockCounterAttackCreatureDecorator(Creature aDecorated){
        decorated = aDecorated;
    }

    @Override
    public boolean attackerIsCounterAttackable() {
        return false;
    }

    @Override
    public SplashRange getSplashRange() {
        return decorated.getSplashRange();
    }

    @Override
    public boolean isAlive() {
        return decorated.isAlive();
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
