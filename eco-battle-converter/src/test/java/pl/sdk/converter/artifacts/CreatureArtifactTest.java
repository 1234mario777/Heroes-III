package pl.sdk.converter.artifacts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.Fraction;
import pl.sdk.Hero;
import pl.sdk.creatures.AbstractFractionFactory;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.CreatureDynamicStats;
import pl.sdk.spells.DamageSpell;
import pl.sdk.spells.EconomySpell;
import pl.sdk.spells.SpellStatistic;
import pl.sdk.spells.UpgradeCreatureStats;

import java.util.List;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class CreatureArtifactTest {

    private Creature creature;
    private Hero hero;

    @BeforeEach
    void init() {
        creature = AbstractFractionFactory.getInstance(Fraction.TEST_FRACTION).create(false, 1,1);
        hero = new Hero(List.of(creature));
    }

    @Test
    void shouldIncreaseCreatureHealthByOne() {
        //given
        UpgradeCreatureStats increaseHealthStats = UpgradeCreatureStats.builder().maxHp(1).build();
        CreatureArtifact artifact = new CreatureArtifact("", increaseHealthStats);
        //when
        artifact.apply(hero);
        //then
        assertEquals(7, creature.getCurrentHp());
    }

    @Test
    void shouldIncreaseCreatureHealthByFiftyPercent() {
        //given
        UpgradeCreatureStats increaseHealthStats = UpgradeCreatureStats.builder().maxHpPercentage(0.5).build();
        CreatureArtifact artifact = new CreatureArtifact("", increaseHealthStats);
        //when
        artifact.apply(hero);
        //then
        assertEquals(9, creature.getCurrentHp());
    }

    @Test
    void shouldIncreaseCreatureMoveRangeByOne() {
        //given
        UpgradeCreatureStats increaseMoveRangeStats = UpgradeCreatureStats.builder().moveRange(1).build();
        CreatureArtifact artifact = new CreatureArtifact("", increaseMoveRangeStats);
        //when
        artifact.apply(hero);
        //then
        assertEquals(5, creature.getMoveRange());
    }

    @Test
    void shouldIncreaseCreatureMoveRangeByFiftyPercent() {
        //given
        UpgradeCreatureStats increaseMoveRangeStats = UpgradeCreatureStats.builder().moveRangePercentage(0.5).build();
        CreatureArtifact artifact = new CreatureArtifact("", increaseMoveRangeStats);
        //when
        artifact.apply(hero);
        //then
        assertEquals(6, creature.getMoveRange());
    }

    @Test
    void shouldDeal10HpDamageBecauseIncreaseCreatureMagicResistanceByFiftyPercent() {
        //given
        Creature creatureToTest = AbstractFractionFactory.getInstance(Fraction.TEST_FRACTION).create(true, 7,1);
        Hero heroToTest = new Hero(List.of(creatureToTest));
        UpgradeCreatureStats increaseMagicResistanceStats = UpgradeCreatureStats.builder().magicResistancePercentage(0.5).build();
        CreatureArtifact artifact = new CreatureArtifact("", increaseMagicResistanceStats);
        DamageSpell spell = new DamageSpell(0, SpellStatistic.TargetType.ENEMY, SpellStatistic.SpellElement.FIRE, 20, 0, "");
        //when
        artifact.apply(heroToTest);
        spell.cast(creatureToTest);
        //then
        assertEquals(190, creatureToTest.getCurrentHp());
    }

    @Test
    void shouldHaveMaxAttackRangeBecauseCanShootThroughObstacle() {
        //given
        Creature shootingCreature = AbstractFractionFactory.getInstance(Fraction.TEST_FRACTION).create(true, 5,1);
        Hero heroWithShootingCreature = new Hero(List.of(shootingCreature));
        UpgradeCreatureStats enableShootingThroughObstacle = UpgradeCreatureStats.builder().shootingThroughObstacle(true).build();
        CreatureArtifact artifact = new CreatureArtifact("", enableShootingThroughObstacle);
        //when
        artifact.apply(heroWithShootingCreature);
        //then
        assertEquals(Double.MAX_VALUE, shootingCreature.getAttackContext().getAttackerStatistic().getAttackRange());
    }


}