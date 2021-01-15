package pl.sdk.spells;

public class DispelSpell extends AbstractSpell{

    public DispelSpell(SpellStatistic.TargetType aTargetType) {
        super(5, aTargetType, SpellStatistic.SpellElement.WATER);
    }

    @Override
    public int getSplashRange() {
        return 0;
    }
}
