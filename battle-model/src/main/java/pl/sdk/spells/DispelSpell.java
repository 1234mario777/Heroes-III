package pl.sdk.spells;

public class DispelSpell extends AbstractSpell{

    public DispelSpell() {
        super(5, SpellStatistic.TargetType.ALLY, SpellStatistic.SpellElement.WATER);
    }

    @Override
    public int getSplashRange() {
        return 0;
    }
}
