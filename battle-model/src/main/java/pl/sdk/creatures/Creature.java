package pl.sdk.creatures;

import lombok.AllArgsConstructor;
import lombok.Builder;
import pl.sdk.creatures.attacking.AttackContextIf;
import pl.sdk.creatures.attacking.CounterAttackerIf;
import pl.sdk.creatures.defending.DefenceContextIf;
import pl.sdk.spells.BuffOrDebuffSpell;
import pl.sdk.spells.BuffStatistic;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

@Builder
@AllArgsConstructor
public class Creature implements PropertyChangeListener {

    //TODO remove purestats?
    private CreatureStatisticIf pureStats;
    private int currentHp;
    private int amount;

    private BuffContainer buffContainter;
    private DefaultMagicDamageReducer magicDamageReducer;

    private DefenceContextIf defenceContext;
    private AttackContextIf attackContext;

    // Constructor for mockito. Don't use it! You have builder here.

    public Creature(CreatureStatisticIf aPureStats, int aAmount, DefenceContextIf aDefenceContext, AttackContextIf aAttackContext){
        amount = aAmount;
        pureStats = aPureStats;
        currentHp = pureStats.getMaxHp();

        defenceContext = aDefenceContext;
        attackContext = aAttackContext;

        buffContainter = new BuffContainer();
        magicDamageReducer = new DefaultMagicDamageReducer();
    }

    CreatureStatisticIf getPureStats() {
        return pureStats;
    }

    public BuffContainer getBuffContainer(){
        return buffContainter;
    }

    public DefenceContextIf getDefenceContext() {
        return defenceContext;
    }

    public AttackContextIf getAttackContext() {
        return attackContext;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public String getName(){
        return pureStats.getTranslatedName();
    }

    public int getMoveRange() {
        int ret = pureStats.getMoveRange();
        int percentageBuff = getPercentageBuff(ret);
        int scalarBuff = getScalarBuff();

        return ret + percentageBuff + scalarBuff;
    }

    private int getScalarBuff() {
        return buffContainter.getAllBuffStats().stream()
                    .filter(b -> b.getMoveRange() != 0)
                    .mapToInt(BuffStatistic::getMoveRange).sum();
    }

    private int getPercentageBuff(int aRet) {
        return buffContainter.getAllBuffStats().stream()
                    .filter(b -> b.getMoveRangePercentage() != 0.0)
                    .mapToInt(b ->  (int)(Math.round( aRet * (b.getMoveRangePercentage()))))
                    .sum();
    }

    public int getAmount(){
        return amount;
    }

    public String currentHealth() {
        StringBuilder sb = new StringBuilder();
        sb.append(getCurrentHp());
        sb.append("/");
        sb.append(pureStats.getMaxHp());
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(pureStats.getTranslatedName());
        sb.append(System.lineSeparator());
        sb.append(getCurrentHp());
        sb.append("/");
        sb.append(pureStats.getMaxHp());
        return sb.toString();
    }

    public void applyMagicDamage(int aDamage) {
        defenceContext.getDamageApplier().applyDamage(magicDamageReducer.reduceDamage(aDamage));
    }

    public void buff(BuffOrDebuffSpell aBuffOrDebuff) {
        buffContainter.add(aBuffOrDebuff);
    }

    void setCurrentHp(int aCurrentHp) {
        currentHp = aCurrentHp;
    }

    void setAmount(int aAmount) {
        amount = aAmount;
    }

    public int getMaxHp() {
        return pureStats.getMaxHp();
    }

    @Override
    public void propertyChange(PropertyChangeEvent aPropertyChangeEvent) {
        throw new UnsupportedOperationException();
    }
}
