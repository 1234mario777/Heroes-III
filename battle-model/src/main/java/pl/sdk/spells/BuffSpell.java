package pl.sdk.spells;

import pl.sdk.GameEngine;
import pl.sdk.creatures.Creature;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Objects;

public class BuffSpell extends AbstractSpell implements PropertyChangeListener {

    private final int duration;
    private int roundsToEnd;
    private Creature creature;
    private BuffStatistic buffStats;

    public BuffSpell(int aManaCost, int aDuration, SpellStatistic.SpellElement aElement, SpellStatistic.TargetType aTargetType, String aName) {
        super(aManaCost, aTargetType, aElement, aName);
        duration = aDuration;
        buffStats = new BuffStatistic(3);
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public int getSplashRange() {
        return 0;
    }

    @Override
    public void cast(Creature aCreature, GameEngine aGameEngine) {
        creature = aCreature;
        roundsToEnd = duration;
        aCreature.buff(buffStats);
        aGameEngine.addObserver(GameEngine.END_OF_TURN, this);

    }

    @Override
    public void propertyChange(PropertyChangeEvent aPropertyChangeEvent) {

        if ( roundsToEnd == 0 ){
            creature.removeBuff(this.buffStats);
        }
        else {
            roundsToEnd--;
        }
    }

    @Override
    public boolean equals(Object aO) {
        if (this == aO) return true;
        if (aO == null || getClass() != aO.getClass() || getName() == null) return false;
        DebuffSpell that = (DebuffSpell) aO;
        return getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
