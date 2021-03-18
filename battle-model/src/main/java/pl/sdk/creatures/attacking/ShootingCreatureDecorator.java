package pl.sdk.creatures.attacking;

class ShootingCreatureDecorator implements AttackContextIf {

    private final AttackContextIf decorated;

    ShootingCreatureDecorator(AttackContextIf aDecorated) {
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
        return false;
    }

}
