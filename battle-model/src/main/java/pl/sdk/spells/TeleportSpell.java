package pl.sdk.spells;

import pl.sdk.AbstractSpell;

public class TeleportSpell extends AbstractSpell {

    public TeleportSpell(String aName) {
        super(15, SpellStatistic.TargetType.ALLY, SpellStatistic.SpellElement.WATER, aName);
    }

    @Override
    public int getSplashRange() {
        return 0;
    }
}
