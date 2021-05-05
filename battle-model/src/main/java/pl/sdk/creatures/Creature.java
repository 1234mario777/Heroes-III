package pl.sdk.creatures;

import com.google.common.collect.Range;
import lombok.NoArgsConstructor;
import pl.sdk.creatures.attacking.*;
import pl.sdk.creatures.defending.DefenceContextFactory;
import pl.sdk.creatures.defending.DefenceContextIf;
import pl.sdk.creatures.movingContext.MoveContext;
import pl.sdk.creatures.movingContext.MoveContextIf;
import pl.sdk.creatures.spells.BuffContainer;
import pl.sdk.creatures.spells.MagicResFactory;
import pl.sdk.creatures.spells.MagicResistanceContextIf;
import pl.sdk.creatures.retaliating.RetaliationContextFactory;
import pl.sdk.creatures.retaliating.RetaliationContextIf;
import pl.sdk.spells.BuffOrDebuffSpell;
import pl.sdk.spells.BuffStatistic;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


@NoArgsConstructor
public class Creature implements PropertyChangeListener {

    public static final String LIFE_CHANGED = "LIFE_CHANGED";
    private String name;

    private BuffContainer buffContainter;
    private MagicResistanceContextIf magicDamageReducer;
    private MoveContextIf moveContext;
    private DefenceContextIf defenceContext;
    private AttackContextIf attackContext;
    private RetaliationContextIf retaliationContext;
    private CreatureDynamicStats addictionalStats;

    // Constructor for mockito. Don't use it! You have builder here.

    Creature(String aName, DefenceContextIf aDefenceContext, AttackContextIf aAttackContext, MoveContextIf aMoveContextIf, MagicResistanceContextIf aMagicResContext) {
        name = aName;
        defenceContext = aDefenceContext;
        attackContext = aAttackContext;
        defenceContext.addObserver(LIFE_CHANGED, aAttackContext);
        moveContext = aMoveContextIf;
        retaliationContext = RetaliationContextFactory.create(1);
        magicDamageReducer = aMagicResContext;

        buffContainter = new BuffContainer();
    }

    public boolean isArcher(){
        return this.getAttackContext().getAttackerStatistic().getAttackRange() >= 100;
    }
    public BuffContainer getBuffContainer() {
        return buffContainter;
    }

    public DefenceContextIf getDefenceContext() {
        return defenceContext;
    }

    public AttackContextIf getAttackContext() {
        return attackContext;
    }

    public int getCurrentHp() {
        return defenceContext.getCurrentHp();
    }

    public String getName() {
        return name;
    }

    public int getMoveRange() {
        int ret = moveContext.getMoveRange();
        int percentageBuff = getPercentageBuff(ret);
        int scalarBuff = getScalarBuff();

        return ret + percentageBuff + scalarBuff + addictionalStats.getMoveRange();
    }

    private int getScalarBuff() {
        return buffContainter.getAllBuffStats().stream()
                .filter(b -> b.getMoveRange() != 0)
                .mapToInt(BuffStatistic::getMoveRange).sum();
    }

    private int getPercentageBuff(int aRet) {
        return buffContainter.getAllBuffStats().stream()
                .filter(b -> b.getMoveRangePercentage() != 0.0)
                .mapToInt(b -> (int) (Math.round(aRet * (b.getMoveRangePercentage()))))
                .sum();
    }

    public int getAmount() {
        return defenceContext.getCurrentAmount();
    }

    public String currentHealth() {
        StringBuilder sb = new StringBuilder();
        sb.append(getCurrentHp());
        sb.append("/");
        sb.append(defenceContext.getMaxHp());
        return sb.toString();
    }

//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append(name);
//        sb.append(System.lineSeparator());
//        sb.append(getCurrentHp());
//        sb.append("/");
//        sb.append(getDefenceContext().getMaxHp());
//        return sb.toString();
//    }

    public void applyMagicDamage(int aDamage) {
        defenceContext.applyDamage(magicDamageReducer.reduceMagicDamageDamage(aDamage));
    }

    public void buff(BuffOrDebuffSpell aBuffOrDebuff) {
        buffContainter.add(aBuffOrDebuff);
    }

    public int getMaxHp() {
        return defenceContext.getMaxHp();
    }

    @Override
    public void propertyChange(PropertyChangeEvent aPropertyChangeEvent) {
        retaliationContext.endTurnEvent(aPropertyChangeEvent);
        buffContainter.endTurnEvent(aPropertyChangeEvent);
    }

    public boolean canRetaliate() {
        return retaliationContext.canRetaliate();
    }

    public void updateRetaliateCounter() {
        retaliationContext.updateRetaliateCounter();
    }

    public void increaseStatByPercentage(CreatureDynamicStats aBuilder) {
        addictionalStats = aBuilder;
    }

    public void increaseStat(CreatureDynamicStats aBuilder) {
        addictionalStats = aBuilder;
    }

    public static class Builder {
        private CreatureStatistic stats;

        private String name;
        private Integer attack;
        private Integer armor;
        private Integer maxHp;
        private Integer moveRange;
        private Range<Integer> damage;
        private Integer amount;
        private CalculateDamageStrategyIf calcDmgStrategy;

        private MagicResistanceContextIf magicDamageReducer;

        public Builder statistic(CreatureStatistic stats) {
            this.stats = stats;
            return this;
        }

        public Builder magicResContext(MagicResistanceContextIf aMagicDamageReducer) {
            magicDamageReducer = aMagicDamageReducer;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder attack(int attack) {
            this.attack = attack;
            return this;
        }

        public Builder armor(int armor) {
            this.armor = armor;
            return this;
        }

        public Builder maxHp(int maxHp) {
            this.maxHp = maxHp;
            return this;
        }

        public Builder moveRange(int moveRange) {
            this.moveRange = moveRange;
            return this;
        }

        public Builder damage(Range<Integer> damage) {
            this.damage = damage;
            return this;
        }

        public Builder amount(int amount) {
            this.amount = amount;
            return this;
        }

        public Builder calcDmgStrategy(CalculateDamageStrategyIf calcDmgStrategy) {
            this.calcDmgStrategy = calcDmgStrategy;
            return this;
        }
        public Creature build() {
            preconditions();
            DefenceContextIf tempDefenceContext = prepareDefendingContext();
            AttackContextIf tempAttackContext = prepareAttackingContext();
            return new Creature(name, tempDefenceContext, tempAttackContext, new MoveContext(moveRange), magicDamageReducer);
        }

        private void preconditions() {
            if (magicDamageReducer == null) {
                this.magicDamageReducer = MagicResFactory.create(0);
            }
            if (amount == null) {
                amount = 1;
            }
            if (armor == null) {
                armor = 1;
                if (stats != null ){
                    armor = stats.getArmor();
                }
            }
            if (attack == null) {
                attack = 1;
                if (stats != null ){
                    attack = stats.getAttack();
                }
            }
            if (damage == null) {
                damage = Range.closed(1,1);
                if (stats != null ){
                    damage = stats.getDamage();
                }
            }
            if (moveRange == null) {
                moveRange = 1;
                if (stats != null ){
                    moveRange = stats.getMoveRange();
                }
            }
            if (maxHp == null) {
                maxHp = 1;
                if (stats != null ){
                    maxHp = stats.getMaxHp();
                }
            }
            if (name == null) {
                if (stats != null ){
                    name = stats.getTranslatedName();
                }
            }
        }

        private DefenceContextIf prepareDefendingContext() {
            return DefenceContextFactory.create(this.armor, amount, maxHp);
        }

        private AttackContextIf prepareAttackingContext() {
            if (stats != null){
                return AttackContextFactory.create(stats);
            }
            //for testing
            if (calcDmgStrategy == null) {
                calcDmgStrategy = CalculateDamageStrategyIf.create(CalculateDamageStrategyIf.TYPE.DEFAULT);
            }
            return AttackContextFactory.create(
                    AttackerWithBuffEtcStatistic.builder()
                            .amount(this.amount)
                            .attack(this.attack)
                            .attackRange(1)
                            .damage(this.damage)
                            .build(),
                    calcDmgStrategy
            );
        }
    }
}
