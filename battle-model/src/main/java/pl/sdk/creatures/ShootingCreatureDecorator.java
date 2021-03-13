package pl.sdk.creatures;

class ShootingCreatureDecorator implements AttackerIf {

    private final Creature decorated;

    ShootingCreatureDecorator(Creature aDecorated) {
        decorated = aDecorated;
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
    public double getAttackRange() {
        return 15.0;
    }
}
