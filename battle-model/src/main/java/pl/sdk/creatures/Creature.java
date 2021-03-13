package pl.sdk.creatures;

import com.google.common.collect.Range;
import pl.sdk.spells.BuffOrDebuffSpell;
import pl.sdk.spells.BuffStatistic;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.*;

public class Creature implements PropertyChangeListener, AttackableIf, CounterAttackerIf {

    private final CreatureStatisticIf stats;
    private BuffContainer buffContainter;
    private int currentHp;
    private boolean counterAttackedInThisTurn;
    private CalculateDamageStrategyIf calculateDamageStrategy;
    private int amount;
    private DefaultMagicDamageReducer magicDamageReducer;
    private DefaultDamageApplier damageApplier;

    // Constructor for mockito. Don't use it! You have builder here.
    Creature(){
        stats = CreatureStatistic.TEST;
        magicDamageReducer = new DefaultMagicDamageReducer();
        buffContainter = new BuffContainer();
    }

    Creature(CreatureStatisticIf aStats){
        stats = aStats;
        currentHp = stats.getMaxHp();
        buffContainter = new BuffContainer();
    }

    int calculateDamage(Creature aAttacker, Creature aDefender) {
        return calculateDamageStrategy.calculateDamage(aAttacker, aDefender);
    }

    void counterAttack(Creature aDefender) {
        if (!aDefender.counterAttackedInThisTurn){
            int damageToDealInCounterAttack = calculateDamage(aDefender, this);
            getDamageApplier().applyDamage(damageToDealInCounterAttack);
            aDefender.counterAttackedInThisTurn = true;
        }
    }

    public BuffContainer getBuffContainer(){
        return buffContainter;
    }

    public DefaultMagicDamageReducer getMagicDamageReducer(){
        return magicDamageReducer;
    }

    public boolean isAlive() {
        return amount > 0;
    }

    @Override
    public CalculateDamageStrategyIf getDamageCalculator() {
        return null;
    }

    @Override
    public AttackerStatisticIf getAttackerStatistic() {
        return AttackerWithBuffEtcStatistic.builder()
                .amount(amount)
                .attack(getAttack())
                .attackRange(getAttackRange())
                .damage(getDamage())
                .build();
    }

    @Override
    public boolean attackerIsCounterAttackable() {
        return true;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public String getName(){
        return stats.getTranslatedName();
    }

    @Override
    public DefaultDamageApplier getDamageApplier() {
        return null;
    }

    public boolean canCounterAttack() {
        return !counterAttackedInThisTurn;
    }

    public int getMoveRange() {
        int ret = stats.getMoveRange();
        int percentageBuff = buffContainter.getAllBuffStats().stream()
                .filter(b -> b.getMoveRangePercentage() != 0.0)
                .mapToInt(b ->  (int)(Math.round( ret * (b.getMoveRangePercentage()))))
                .sum();
        int scalarBuff = buffContainter.getAllBuffStats().stream()
                .filter(b -> b.getMoveRange() != 0)
                .mapToInt(BuffStatistic::getMoveRange).sum();

        return ret + percentageBuff + scalarBuff;
    }

    public int getDefaultMoveRange() {
        return stats.getMoveRange();
    }

    @Override
    public void propertyChange(PropertyChangeEvent aPropertyChangeEvent) {
        counterAttackedInThisTurn = false;
    }

    public int getAttack() {
        return stats.getAttack();
    }

    public int getArmor() {
        return stats.getArmor();
    }

    public Range<Integer> getDamage() {
        return stats.getDamage();
    }

    public int getAmount(){
        return amount;
    }

    public String currentHealth() {
        StringBuilder sb = new StringBuilder();
        sb.append(getCurrentHp());
        sb.append("/");
        sb.append(stats.getMaxHp());
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(stats.getTranslatedName());
        sb.append(System.lineSeparator());
        sb.append(getCurrentHp());
        sb.append("/");
        sb.append(stats.getMaxHp());
        return sb.toString();
    }

    public double getAttackRange() {
        return 1.0;
    }

    void setCurrentHpToMaximum() {
        currentHp = stats.getMaxHp();
    }

    public SplashRange getSplashRange() {
        boolean[][] ret = new boolean[3][3];
        ret[1][1] = true;
        return new SplashRange(ret);
    }

    public void applyMagicDamage(int aDamage) {
        getDamageApplier().applyDamage(getMagicDamageReducer().reduceDamage(aDamage));
    }

    public void buff(BuffOrDebuffSpell aBuffOrDebuff) {
        buffContainter.add(aBuffOrDebuff);
    }

    int getMaxHp() {
        return stats.getMaxHp();
    }

    void setCurrentHp(int aCurrentHp) {
        currentHp = aCurrentHp;
    }

    void setAmount(int aAmount) {
        amount = aAmount;
    }

    public static class Builder {
        private CreatureStatisticIf stats;
        private CalculateDamageStrategyIf damageCalculator;
        private DefaultMagicDamageReducer magicDamageReducer;
        private Integer amount;
        private DefaultDamageApplier damageApplier;

        public Builder statistic(CreatureStatisticIf aStats){
            this.stats = aStats;
            return this;
        };
        public Builder amount(int amount){
            this.amount=amount;
            return this;
        }
        Builder damageCalculator (CalculateDamageStrategyIf aCalculateDamageStrategy){
            this.damageCalculator = aCalculateDamageStrategy;
            return this;
        }
        Builder MagicDamageReducer (DefaultMagicDamageReducer aMagicDamageReducer){
            this.magicDamageReducer = aMagicDamageReducer;
            return this;
        }
        Builder DamageApplier (DefaultDamageApplier aDamageApplier){
            this.damageApplier = aDamageApplier;
            return this;
        }

        public Creature build(){
            Set<String> emptyFields = new HashSet<>();
            if (stats == null){
                emptyFields.add("stats");
            }
            if (!emptyFields.isEmpty()){
                throw new IllegalStateException("These fileds: " + Arrays.toString(emptyFields.toArray()) + " cannot be empty");
            }

            Creature ret = createInstance(stats);
            if(amount == null){
                ret.amount=1;
            }
            else{
                ret.amount = amount;
            }
            if (damageCalculator != null){
                ret.calculateDamageStrategy = damageCalculator;
            }
            else{
                ret.calculateDamageStrategy = new DefaultCalculateStrategyIf();
            }
            if (magicDamageReducer != null){
                ret.magicDamageReducer = magicDamageReducer;
            }
            else{
                ret.magicDamageReducer = new DefaultMagicDamageReducer();
            }

            if (damageApplier != null){
                ret.damageApplier = damageApplier;
            }
            else{
                ret.damageApplier = new DefaultDamageApplier(ret);
            }
            return ret;
        }

        Creature createInstance(CreatureStatisticIf aStats) {
            return new Creature(aStats);
        }
    }
}
