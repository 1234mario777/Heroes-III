package pl.sdk.creatures;

public interface DefenceContextIf {

    DefaultDamageApplier getDamageApplier();
    boolean canCounterAttack();
    int getArmor();
}
