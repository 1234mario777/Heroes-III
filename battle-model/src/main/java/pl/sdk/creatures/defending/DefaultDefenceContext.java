package pl.sdk.creatures.defending;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import static pl.sdk.creatures.Creature.LIFE_CHANGED;

public class DefaultDefenceContext implements DefenceContextIf {

    private DefaultDamageApplier damageApplier;
    private int armor;
    private int currentHp;
    private int maxHp;
    private int maxAmount;
    private int amount;
    private PropertyChangeSupport obsSupport = new PropertyChangeSupport(this);

    DefaultDefenceContext(DefaultDamageApplier aDamageApplier, int aArmor, int aMaxAmount, int aMaxHp) {
        damageApplier = aDamageApplier;
        armor = aArmor;
        maxHp = aMaxHp;
        currentHp = maxHp;
        maxAmount = aMaxAmount;
        amount = maxAmount;
    }

    @Override
    public int getArmor() {
        return armor;
    }

    @Override
    public int getCurrentHp() {
        return currentHp;
    }

    @Override
    public int getMaxHp() {
        return maxHp;
    }

    @Override
    public int getCurrentAmount() {
        return amount;
    }

    @Override
    public void applyDamage(int aDamageToDeal) {
        CreatureLifeStats creatureLifeStats = damageApplier.countDamageToApply(this, aDamageToDeal);
        obsSupport.firePropertyChange(LIFE_CHANGED, new CreatureLifeStats(currentHp,amount), creatureLifeStats);
        amount = creatureLifeStats.getAmount();
        currentHp = creatureLifeStats.getHp();
    }

    public void addObserver(String aEventType, PropertyChangeListener aObs){
        obsSupport.addPropertyChangeListener(aEventType, aObs);
        obsSupport.firePropertyChange(LIFE_CHANGED, null, new CreatureLifeStats(currentHp,amount));
    }
}
