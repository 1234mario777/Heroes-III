package pl.sdk.spells;

public class SingeTargetDamageSpell {

    private final int damage;

    public SingeTargetDamageSpell(int aSpellDamage) {
        damage = aSpellDamage;
    }

    public int getDamage() {
        return damage;
    }

    public int getSplashRange() {
        return 0;
    }
}
