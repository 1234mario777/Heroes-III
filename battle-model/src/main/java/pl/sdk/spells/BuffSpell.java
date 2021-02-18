package pl.sdk.spells;

import pl.sdk.creatures.Creature;
import pl.sdk.creatures.CreatureStatisticForTesting;

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

    @Override
    public void cast(Creature aCreature) {
        BuffStatistic hasteStats = new BuffStatistic(3);
        aCreature.buff(hasteStats);
    }
}
