package pl.sdk.spells;

public class DispelSpell extends AbstractSpell {

    public DispelSpell(SpellStatistic.TargetType aTargetType, String aName) {
        super(5, aTargetType, SpellStatistic.SpellElement.WATER, aName);
    }

    @Override
    public int getSplashRange() {
        return 0;
    }
}
