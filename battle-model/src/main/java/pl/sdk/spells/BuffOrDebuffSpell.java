package pl.sdk.spells;

import pl.sdk.creatures.Creature;

import java.util.Objects;

public class BuffOrDebuffSpell extends AbstractSpell{

    private final int duration;
    private BuffStatistic buffStats;

    public BuffOrDebuffSpell(int aManaCost, int aDuration, SpellStatistic.SpellElement aElement, SpellStatistic.TargetType aTargetType, String aName, BuffStatistic aSpellStats) {
        super(aManaCost, aTargetType, aElement, aName);
        duration = aDuration;
        buffStats = aSpellStats;
    }

    public int getDuration() {
        return duration;
    }

    public BuffStatistic getBuffStats() {
        return buffStats;
    }

    @Override
    public int getSplashRange() {
        return 0;
    }

    @Override
    public void cast(Creature aCreature) {
        aCreature.buff(this);
    }


    @Override
    public boolean equals(Object aO) {
        if (this == aO) return true;
        if (aO == null || getClass() != aO.getClass() || getName() == null) return false;
        BuffOrDebuffSpell that = (BuffOrDebuffSpell) aO;
        return getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
