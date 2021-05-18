package pl.sdk.creatures.defending;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import static pl.sdk.creatures.Creature.LIFE_CHANGED;

public class DefaultDefenceContext implements DefenceContextIf {

    private final DefenceStatistic stats;
    private DefaultDamageApplier damageApplier;
    private PropertyChangeSupport obsSupport = new PropertyChangeSupport(this);

    DefaultDefenceContext(DefaultDamageApplier aDamageApplier, int aArmor, int aMaxAmount, int aMaxHp) {
        damageApplier = aDamageApplier;
        stats = new DefenceStatistic(aArmor, aMaxAmount, aMaxHp);
    }

    @Override
    public void applyDamage(int aDamageToDeal) {
        CreatureLifeStats creatureLifeStats = damageApplier.countDamageToApply(this, aDamageToDeal);
        obsSupport.firePropertyChange(LIFE_CHANGED, new CreatureLifeStats(stats.getCurrentHp(),stats.getAmount()), creatureLifeStats);
        stats.setAmount( creatureLifeStats.getAmount() );
        stats.setCurrentHp( creatureLifeStats.getHp() );
    }

    @Override
    public DefenceStatistic getDefenceStatistic()
    {
        return stats;
    }


    public void addObserver(String aEventType, PropertyChangeListener aObs){
        obsSupport.addPropertyChangeListener(aEventType, aObs);
        obsSupport.firePropertyChange(LIFE_CHANGED, null, new CreatureLifeStats(stats.getCurrentHp(),stats.getAmount()));
    }
}
