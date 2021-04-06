package pl.sdk.spells;

import pl.sdk.AbstractSpell;
import pl.sdk.creatures.Creature;

public class DamageSpell extends AbstractSpell {

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

    @Override
    public void cast(Creature aCreature) {
        aCreature.applyMagicDamage(damage);
    }

    public int getDamage() {
        return damage;
    }
}
