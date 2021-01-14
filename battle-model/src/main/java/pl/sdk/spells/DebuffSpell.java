package pl.sdk.spells;

public class DebuffSpell extends AbstractSpell{

    private final int duration;

    public DebuffSpell(int aManaCost, int aDuration, SpellStatistic.SpellElement aElement) {
        super(aManaCost, SpellStatistic.TargetType.ENEMY, aElement);
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
