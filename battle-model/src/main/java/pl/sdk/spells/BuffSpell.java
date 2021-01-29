package pl.sdk.spells;

public class BuffSpell extends AbstractSpell{

    private final int duration;
    public BuffSpell(int aManaCost, int aDuration, SpellStatistic.SpellElement aElement, SpellStatistic.TargetType aTargetType, String aName) {
        super(aManaCost, aTargetType, aElement, aName);
        duration = aDuration;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public int getSplashRange() {
        return 0;
    }
}
