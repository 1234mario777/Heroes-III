package pl.sdk.spells;

public class DamageSpell extends AbstractSpell{

    private final int damage;
    private final int splashRange;

    public DamageSpell(int aManaCost, SpellStatistic.TargetType aTargetType, SpellStatistic.SpellElement aElement, int aSpellDamage, int aSplashRange, String aName) {
        super(aManaCost, aTargetType, aElement, aName);
        splashRange = aSplashRange;
        damage = aSpellDamage;
    }

    @Override
    public int getSplashRange() {
        return splashRange;
    }

    public int getDamage() {
        return damage;
    }
}
