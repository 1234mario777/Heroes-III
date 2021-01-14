package pl.sdk.spells;

public class BuffSpell extends AbstractSpell{

    private final int duration;
    public BuffSpell(int aManaCost, int aDuration) {
        super(aManaCost, SpellStatistic.TargetType.ALLY);
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
