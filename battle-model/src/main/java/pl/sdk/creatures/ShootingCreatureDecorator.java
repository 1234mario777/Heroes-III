package pl.sdk.creatures;

class ShootingCreatureDecorator implements AttackIf {

    private final AttackIf decorated;

    ShootingCreatureDecorator(AttackIf aDecorated) {
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
        return AttackerWithBuffEtcStatistic.builder()
                .damage(decorated.getAttackerStatistic().getDamage())
                .attackRange(15.0)
                .attack(decorated.getAttackerStatistic().getAttack())
                .amount(decorated.getAttackerStatistic().getAmount())
                .build();
    }

    @Override
    public boolean canYouCounterAttackMe() {
        return decorated.canYouCounterAttackMe();
    }

}
