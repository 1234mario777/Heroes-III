package pl.sdk.creatures;

import com.google.common.collect.Range;
import lombok.AllArgsConstructor;
import lombok.Builder;
import pl.sdk.creatures.attacking.*;
import pl.sdk.creatures.defending.DefenceContextFactory;
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

    private BuffContainer buffContainter;
    private DefaultMagicDamageReducer magicDamageReducer;

    private DefenceContextIf defenceContext;
    private AttackContextIf attackContext;

    // Constructor for mockito. Don't use it! You have builder here.

    public Creature(CreatureStatisticIf aPureStats, int aAmount, DefenceContextIf aDefenceContext, AttackContextIf aAttackContext) {
        defenceContext = aDefenceContext;
        attackContext = aAttackContext;

        buffContainter = new BuffContainer();
        magicDamageReducer = new DefaultMagicDamageReducer();
    }

    CreatureStatisticIf getPureStats() {
        return pureStats;
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

    public int getMaxHp() {
        return pureStats.getMaxHp();
    }

    @Override
    public void propertyChange(PropertyChangeEvent aPropertyChangeEvent) {
        throw new UnsupportedOperationException();
    }

    public boolean canCounterAttack() {
        return defenceContext.canCounterAttack();
    }

    DefaultDamageApplier getDamageApplier() {
        return defenceContext.getDamageApplier();
    }

    static class BuilderForTesting {
        private Integer attack;
        private Integer armor;
        private Integer maxHp;
        private Integer moveRange;
        private Range<Integer> damage;
        private Integer amount;

        BuilderForTesting attack(int attack) {
            this.attack = attack;
            return this;
        }

        BuilderForTesting armor(int armor) {
            this.armor = armor;
            return this;
        }

        BuilderForTesting maxHp(int maxHp) {
            this.maxHp = maxHp;
            return this;
        }

        BuilderForTesting moveRange(int moveRange) {
            this.moveRange = moveRange;
            return this;
        }

        BuilderForTesting damage(Range<Integer> damage) {
            this.damage = damage;
            return this;
        }

        BuilderForTesting amount(int amount) {
            this.amount = amount;
            return this;
        }

        Creature build() {

            DefenceContextIf tempDefenceContext = DefenceContextFactory.create(this.armor);
            AttackContextIf tempAttackContext = AttackContextFactory.create(
                    AttackerWithBuffEtcStatistic.builder()
                            .amount(this.amount)
                            .attack(this.attack)
                            .attackRange(1)
                            .damage(this.damage)
                            .build(),
                    CalculateDamageStrategyIf.create(CalculateDamageStrategyIf.TYPE.DEFAULT)
            );

            Creature ret = new Creature(null, this.amount, tempDefenceContext, tempAttackContext);

            ret.magicDamageReducer = new DefaultMagicDamageReducer();

            return ret;
        }
    }
}
