package pl.sdk.creatures;

import com.google.common.collect.Range;
import pl.sdk.spells.BuffStatistic;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.*;

public class Creature implements PropertyChangeListener {

    private final CreatureStatisticIf stats;
    private Set<BuffStatistic> buffsAndDebuffs;
    private int currentHp;
    private boolean counterAttackedInThisTurn;
    private CalculateDamageStrategy calculateDamageStrategy;
    private int amount;
    private DefaultMagicDamageReducer magicDamageReducer;

    // Constructor for mockito. Don't use it! You have builder here.
    Creature(){
        stats = CreatureStatistic.TEST;
        magicDamageReducer = new DefaultMagicDamageReducer();
        buffsAndDebuffs = new HashSet<>();
    }

    Creature(CreatureStatisticIf aStats){
        stats = aStats;
        currentHp = stats.getMaxHp();
        buffsAndDebuffs = new HashSet<>();
    }

    public void attack(Creature aDefender) {
        if (isAlive()){
            int damageToDeal = calculateDamage(this, aDefender);
            aDefender.applyDamage(damageToDeal);
            counterAttack(aDefender);
        }
    }

    int calculateDamage(Creature aAttacker, Creature aDefender) {
        return calculateDamageStrategy.calculateDamage(aAttacker, aDefender);
    }

    void counterAttack(Creature aDefender) {
        if (!aDefender.counterAttackedInThisTurn){
            int damageToDealInCounterAttack = calculateDamage(aDefender, this);
            applyDamage(damageToDealInCounterAttack);
            aDefender.counterAttackedInThisTurn = true;
        }
    }

    public void applyDamage(int aDamageToApply) {
        int fullCurrentHp = (stats.getMaxHp() * (amount - 1)) + currentHp - aDamageToApply;
        if (fullCurrentHp <= 0) {
            amount = 0;
            currentHp = 0;
        }
        else
        {
            if(fullCurrentHp % stats.getMaxHp()==0)
            {
                currentHp=stats.getMaxHp();
                amount=fullCurrentHp/stats.getMaxHp();
            }
            else
            {
                currentHp = fullCurrentHp % stats.getMaxHp();
                if (aDamageToApply >= 0){
                    amount = (fullCurrentHp/stats.getMaxHp()) + 1;
                }else{
                    amount = (fullCurrentHp/stats.getMaxHp());
                }
            }
        }
    }

    public DefaultMagicDamageReducer getMagicDamageReducer(){
        return magicDamageReducer;
    }

    public boolean isAlive() {
        return amount > 0;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public String getName(){
        return stats.getTranslatedName();
    }

    public boolean canCounterAttack() {
        return !counterAttackedInThisTurn;
    }

    public int getMoveRange() {
        return stats.getMoveRange() + buffsAndDebuffs.stream().mapToInt(BuffStatistic::getMoveRange).sum();
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

    public boolean[][] getSplashRange() {
        boolean[][] ret = new boolean[3][3];
        ret[1][1] = true;
        return ret;
    }

    public void applyMagicDamage(int aDamage) {
        applyDamage(getMagicDamageReducer().reduceDamage(aDamage));
    }

    public void buff(BuffStatistic aBuffStatistic) {
        buffsAndDebuffs.add(aBuffStatistic);
    }

    public void removeBuff(BuffStatistic aBuffStatistic) {
        buffsAndDebuffs.remove(aBuffStatistic);
    }

    public static class Builder {
        private CreatureStatisticIf stats;
        private CalculateDamageStrategy damageCalculator;
        private DefaultMagicDamageReducer magicDamageReducer;
        private Integer amount;

        public Builder statistic(CreatureStatisticIf aStats){
            this.stats = aStats;
            return this;
        };
        public Builder amount(int amount){
            this.amount=amount;
            return this;
        }
        Builder damageCalculator (CalculateDamageStrategy aCalculateDamageStrategy){
            this.damageCalculator = aCalculateDamageStrategy;
            return this;
        }
        Builder defaultMagicDamageReducer (DefaultMagicDamageReducer aMagicDamageReducer){
            this.magicDamageReducer = aMagicDamageReducer;
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
                ret.calculateDamageStrategy = new DefaultCalculateStrategy();
            }
            if (magicDamageReducer != null){
                ret.magicDamageReducer = magicDamageReducer;
            }
            else{
                ret.magicDamageReducer = new DefaultMagicDamageReducer();
            }
            return ret;
        }

        Creature createInstance(CreatureStatisticIf aStats) {
            return new Creature(aStats);
        }
    }

    static class BuilderForTesting {
        private String name;
        private Integer attack;
        private Integer armor;
        private Integer maxHp;
        private Integer moveRange;
        private Range<Integer> damage;
        private CalculateDamageStrategy damageCalculator;
        private Integer amount;
        private DefaultMagicDamageReducer magicDamageApplier;

        BuilderForTesting name (String name){
            this.name = name;
            return this;
        }
        BuilderForTesting attack (int attack){
            this.attack = attack;
            return this;
        }
        BuilderForTesting armor (int armor){
            this.armor = armor;
            return this;
        }
        BuilderForTesting maxHp (int maxHp){
            this.maxHp = maxHp;
            return this;
        }
        BuilderForTesting moveRange (int moveRange){
            this.moveRange = moveRange;
            return this;
        }
        BuilderForTesting damage (Range<Integer> damage){
            this.damage = damage;
            return this;
        };
        BuilderForTesting amount(int amount){
            this.amount=amount;
            return this;
        }
        BuilderForTesting damageCalculator (CalculateDamageStrategy aCalculateDamageStrategy){
            this.damageCalculator = aCalculateDamageStrategy;
            return this;
        }
        BuilderForTesting magicDamageApplier (DefaultMagicDamageReducer aMagicDamageApplier){
            this.magicDamageApplier = aMagicDamageApplier;
            return this;
        }

        Creature build(){
            Set<String> emptyFields = new HashSet<>();
            if (name == null ){
                emptyFields.add("name");
            }
            if (attack == null){
                emptyFields.add("attack");
            }
            if (armor == null){
                emptyFields.add("armor");
            }
            if (maxHp == null){
                emptyFields.add("maxHp");
            }
            if (moveRange == null){
                emptyFields.add("moveRange");
            }
            if (damage == null){
                emptyFields.add("damage");
            }
            if (!emptyFields.isEmpty()){
                throw new IllegalStateException("These fileds: " + Arrays.toString(emptyFields.toArray()) + " cannot be empty");
            }

            CreatureStatisticIf stats = new CreatureStatisticForTesting(name, attack, armor, maxHp, moveRange, damage);
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
                ret.calculateDamageStrategy = new DefaultCalculateStrategy();
            }
            if(magicDamageApplier != null){
                ret.magicDamageReducer = magicDamageApplier;
            }
            else{
                ret.magicDamageReducer = new DefaultMagicDamageReducer();
            }
            return ret;
        }

        Creature createInstance(CreatureStatisticIf aStats) {
            return new Creature(aStats);
        }
    }
}
