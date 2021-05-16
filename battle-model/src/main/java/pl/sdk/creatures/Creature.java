package pl.sdk.creatures;

import com.google.common.collect.Range;
import lombok.NoArgsConstructor;
import pl.sdk.board.TileIf;
import pl.sdk.creatures.attacking.*;
import pl.sdk.creatures.defending.DefenceContextFactory;
import pl.sdk.creatures.defending.DefenceContextIf;
import pl.sdk.creatures.moving.MoveContextFactory;
import pl.sdk.creatures.moving.MoveContextIf;
import pl.sdk.creatures.spells.BuffContainer;
import pl.sdk.creatures.spells.MagicResFactory;
import pl.sdk.creatures.spells.MagicResistanceContextIf;
import pl.sdk.creatures.retaliating.RetaliationContextFactory;
import pl.sdk.creatures.retaliating.RetaliationContextIf;
import pl.sdk.spells.BuffOrDebuffSpell;
import pl.sdk.spells.UpgradeCreatureStats;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


@NoArgsConstructor
public class Creature implements PropertyChangeListener, TileIf
{

    public static final String LIFE_CHANGED = "LIFE_CHANGED";
    private String name;

    private BuffContainer buffContainter;
    private MagicResistanceContextIf magicDamageReducer;

    private MoveContextIf moveContext;
    private DefenceContextIf defenceContext;
    private AttackContextIf attackContext;
    private RetaliationContextIf retaliationContext;

    // Constructor for mockito. Don't use it! You have builder here.

    Creature(String aName, DefenceContextIf aDefenceContext, AttackContextIf aAttackContext, MoveContextIf aMoveContextIf, MagicResistanceContextIf aMagicResContext) {
        name = aName;
        defenceContext = aDefenceContext;
        attackContext = aAttackContext;
        defenceContext.addObserver(LIFE_CHANGED, aAttackContext);
        moveContext = aMoveContextIf;
        retaliationContext = RetaliationContextFactory.create(1);
        magicDamageReducer = aMagicResContext;

        buffContainter = new BuffContainer(this::upgradeCreatureStatistics );
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

    public MoveContextIf getMoveContext() { return moveContext; }

    public int getCurrentHp() {
        return defenceContext.getDefenceStatistic().getCurrentHp();
    }

    public String getName() {
        return name;
    }

    public int getMoveRange() {
        return moveContext.getMoveStatistic().getMoveRange();
    }

    public int getAmount() {
        return defenceContext.getDefenceStatistic().getAmount();
    }

    public void applyMagicDamage(int aDamage) {
        defenceContext.applyDamage(magicDamageReducer.reduceMagicDamageDamage(aDamage));
    }

    public void buff(BuffOrDebuffSpell aBuffOrDebuff) {
        buffContainter.add(aBuffOrDebuff);
    }

    public void upgradeCreatureStatistics( UpgradeCreatureStats aUpgradeStats ) {
       moveContext.getMoveStatistic().setMoveRange( moveContext.getMoveStatistic().getMoveRange() + aUpgradeStats.getMoveRange() );
       moveContext.getMoveStatistic().setMoveRange( calculateUpgradingStats( moveContext.getMoveStatistic().getMoveRange(), aUpgradeStats.getMoveRangePercentage() ) );

       defenceContext.getDefenceStatistic().setArmor(defenceContext.getDefenceStatistic().getArmor() + aUpgradeStats.getArmor());
       defenceContext.getDefenceStatistic().setArmor( calculateUpgradingStats(defenceContext.getDefenceStatistic().getArmor(), aUpgradeStats.getArmor()) );
       defenceContext.getDefenceStatistic().setMaxAmount( defenceContext.getDefenceStatistic().getMaxHp() + aUpgradeStats.getMaxHp() );
       defenceContext.getDefenceStatistic().setMaxAmount( calculateUpgradingStats( defenceContext.getDefenceStatistic().getMaxHp(), aUpgradeStats.getMaxHp() ));
       defenceContext.getDefenceStatistic().setMaxAmount( defenceContext.getDefenceStatistic().getMaxAmount() + aUpgradeStats.getMaxHp());
       defenceContext.getDefenceStatistic().setMaxAmount( calculateUpgradingStats( defenceContext.getDefenceStatistic().getMaxAmount(), aUpgradeStats.getMaxHp() ));

       attackContext.getAttackerStatistic().setAttack(attackContext.getAttackerStatistic().getAttack() + aUpgradeStats.getAttack());
       attackContext.getAttackerStatistic().setAttack(calculateUpgradingStats( attackContext.getAttackerStatistic().getAttack(), aUpgradeStats.getAttack()));
       attackContext.getAttackerStatistic().setDamage( Range.closed(
               attackContext.getAttackerStatistic().getDamage().lowerEndpoint() + aUpgradeStats.getDamage().lowerEndpoint(),
               attackContext.getAttackerStatistic().getDamage().upperEndpoint() + aUpgradeStats.getDamage().upperEndpoint()));
        attackContext.getAttackerStatistic().setDamage( Range.closed(
                attackContext.getAttackerStatistic().getDamage().lowerEndpoint() + (int)(attackContext.getAttackerStatistic().getDamage().lowerEndpoint() * aUpgradeStats.getArmorPercentage()),
                attackContext.getAttackerStatistic().getDamage().upperEndpoint() + (int)(attackContext.getAttackerStatistic().getDamage().upperEndpoint() * aUpgradeStats.getArmorPercentage())));
    }

    private int calculateUpgradingStats( int aCurrent, double abuffPercentage )
    {
        return aCurrent + (int)(aCurrent * abuffPercentage);
    }

    public int getMaxHp() {
        return defenceContext.getDefenceStatistic().getMaxHp();
    }

    @Override
    public void propertyChange(PropertyChangeEvent aPropertyChangeEvent) {
        retaliationContext.endTurnEvent(aPropertyChangeEvent);
    }

    public boolean canRetaliate() {
        return retaliationContext.canRetaliate();
    }

    public void updateRetaliateCounter() {
        retaliationContext.updateRetaliateCounter();
    }

    @Override
    public boolean isStandable()
    {
        return false;
    }

    @Override
    public boolean isCrossable( MovementType aMovementType )
    {
        if (aMovementType.equals( MovementType.FLYING ))
            return true;
        else
            return false;
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
        private MovementType movementType;

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

        public Builder moveStrategy( MovementType aMovementType )
        {
            this.movementType = aMovementType;
            return this;
        }

        public Creature build() {
            preconditions();
            DefenceContextIf tempDefenceContext = prepareDefendingContext();
            AttackContextIf tempAttackContext = prepareAttackingContext();
            MoveContextIf tempMoveContext = prepareMovingContext();
            return new Creature(name, tempDefenceContext, tempAttackContext, tempMoveContext, magicDamageReducer);
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
            if (movementType == null) {
                movementType = MovementType.GROUND;
                if (stats != null ){
                    movementType = stats.getMovementType();
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
                    AttackStatistic.builder()
                                   .amount(this.amount)
                                   .attack(this.attack)
                                   .attackRange(1)
                                   .damage(this.damage)
                                   .build(),
                    calcDmgStrategy
            );
        }

        private MoveContextIf prepareMovingContext()
        {
            if ( stats != null )
            {
                return MoveContextFactory.create( stats.getMovementType(), stats.getMoveRange() );
            }
            return MoveContextFactory.create( movementType, moveRange );
        }
    }
}
