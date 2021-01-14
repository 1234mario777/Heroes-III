package pl.sdk.spells;

public class SplashDamageSpell extends SingeTargetDamageSpell{

    private final int splashRange;

    public SplashDamageSpell(int aManaCost, int aSpellDamage, int aSplashRange, SpellStatistic.SpellElement aElement) {
        super(aManaCost, aSpellDamage, aElement);
        splashRange = aSplashRange;
    }

    @Override
    public int getSplashRange() {
        return splashRange;
    }
}
