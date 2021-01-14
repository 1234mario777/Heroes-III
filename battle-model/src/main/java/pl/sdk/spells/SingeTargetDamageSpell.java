package pl.sdk.spells;

public class SingeTargetDamageSpell extends AbstractSpell{

    private final int damage;

    public SingeTargetDamageSpell(int aSpellDamage, int aManaCost, SpellStatistic.TargetType aTargetType) {
        super(aManaCost, aTargetType);
        damage = aSpellDamage;
    }

    public int getDamage() {
        return damage;
    }

    public int getSplashRange() {
        return 0;
    }
}
