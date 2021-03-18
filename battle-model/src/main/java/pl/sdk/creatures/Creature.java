package pl.sdk.creatures;

import com.google.common.collect.Range;
import lombok.NoArgsConstructor;
import pl.sdk.creatures.attacking.*;
import pl.sdk.creatures.defending.DefenceContextFactory;
import pl.sdk.creatures.defending.DefenceContextIf;
import pl.sdk.spells.BuffOrDebuffSpell;
import pl.sdk.spells.BuffStatistic;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.LinkedList;
import java.util.Queue;


@NoArgsConstructor
public class Creature implements PropertyChangeListener {

    private String name;

    private BuffContainer buffContainter;
    private DefaultMagicDamageReducer magicDamageReducer;

    private MoveContextIf moveContext;
    private DefenceContextIf defenceContext;
    private AttackContextIf attackContext;

    // Constructor for mockito. Don't use it! You have builder here.

    Creature(DefenceContextIf aDefenceContext, AttackContextIf aAttackContext, MoveContextIf aMoveContextIf) {
        defenceContext = aDefenceContext;
        attackContext = aAttackContext;
        moveContext = aMoveContextIf;

        buffContainter = new BuffContainer();
        magicDamageReducer = new DefaultMagicDamageReducer();
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
        defenceContext.applyDamage(magicDamageReducer.reduceDamage(aDamage));
    }

    public void buff(BuffOrDebuffSpell aBuffOrDebuff) {
        buffContainter.add(aBuffOrDebuff);
    }

    public int getMaxHp() {
        return defenceContext.getMaxHp();
    }

    @Override
    public void propertyChange(PropertyChangeEvent aPropertyChangeEvent) {
//        defenceContext.endTurnEvent(aPropertyChangeEvent);
        throw new UnsupportedOperationException();
    }

    public boolean canCounterAttack() {
        return defenceContext.canCounterAttack();
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
        private Integer attackRange;
        private CalculateDamageStrategyIf calcDmgStrategy;

        private Queue<AttackContextIf> attackDecorators = new LinkedList<>();
        private Queue<DefenceContextIf> defenceDecorators = new LinkedList<>();
        private Queue<MoveContextIf> moveDecorators = new LinkedList<>();
        private DefaultMagicDamageReducer magicDamageReducer;

        public Builder statistic(CreatureStatistic stats) {
            this.stats = stats;
            return this;
        }

        public Builder addAttackDecorator(AttackContextIf aAttackDecorator) {
            attackDecorators.add(aAttackDecorator);
            return this;
        }

        public Builder addDefenceDecorator(DefenceContextIf aDefenceDecorator) {
            defenceDecorators.add(aDefenceDecorator);
            return this;
        }

        public Builder addMoveDecorator(MoveContextIf aMoveDecorator) {
            moveDecorators.add(aMoveDecorator);
            return this;
        }

        public Builder magicDamageReducer(DefaultMagicDamageReducer aMagicDamageReducer) {
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
            return new Creature(tempDefenceContext, tempAttackContext, new MoveContext(moveRange));
        }

        private void preconditions() {
            if (magicDamageReducer == null) {
                this.magicDamageReducer = new DefaultMagicDamageReducer();
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
        }

        private DefenceContextIf prepareDefendingContext() {
            DefenceContextIf ret = DefenceContextFactory.create(this.armor, amount, maxHp);
            if (!defenceDecorators.isEmpty()) {
                DefenceContextIf decorator = defenceDecorators.peek();
                // - selfdecorate.
            }
            return ret;
        }

        private AttackContextIf prepareAttackingContext() {
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
