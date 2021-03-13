package pl.sdk.creatures;

public interface AttackableIf {

    DefaultDamageApplier getDamageApplier();
    boolean canCounterAttack();
    int getArmor();
}
