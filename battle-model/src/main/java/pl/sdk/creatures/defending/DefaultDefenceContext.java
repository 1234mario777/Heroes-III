package pl.sdk.creatures.defending;

import pl.sdk.creatures.DefaultDamageApplier;

public class DefaultDefenceContext implements DefenceContextIf {

    private DefaultDamageApplier damageApplier;
    private int armor;

    DefaultDefenceContext(DefaultDamageApplier aDamageApplier, int aArmor) {
        damageApplier = aDamageApplier;
        armor = aArmor;
    }

    @Override
    public DefaultDamageApplier getDamageApplier() {
        return damageApplier;
    }

    @Override
    public boolean canCounterAttack() {
        return true;
    }

    @Override
    public int getArmor() {
        return armor;
    }
}
