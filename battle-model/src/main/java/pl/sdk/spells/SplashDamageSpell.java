package pl.sdk.spells;

public class SplashDamageSpell extends SingeTargetDamageSpell{

    private final int splashRange;

    public SplashDamageSpell(int aSpellDamage, int aManaCost, int aSplashRange) {
        super(aManaCost, aSpellDamage);
        splashRange = aSplashRange;
    }

    @Override
    public int getSplashRange() {
        return splashRange;
    }
}
