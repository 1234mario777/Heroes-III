package pl.sdk.spells;

public class TeleportSpell extends AbstractSpell {

    public TeleportSpell() {
        super(15, SpellStatistic.TargetType.ALLY, SpellStatistic.SpellElement.WATER);
    }

    @Override
    public int getSplashRange() {
        return 0;
    }
}
