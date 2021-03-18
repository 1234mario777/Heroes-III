package pl.sdk.creatures.attacking;

import com.google.common.collect.Range;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.attacking.AttackEngine;
import pl.sdk.creatures.attacking.DefaultCalculateStrategy;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AttackCreatureTest {

    public static final int NOT_IMPORTANT = 5;
    private Random randomizer;

    @BeforeEach
    void init(){
        randomizer = mock(Random.class);
        when(randomizer.nextInt(anyInt())).thenReturn(4);
    }


    @Test
    void creatureShouldDealExactlyDamageWhenAttackAndArmorAreEquals(){
        Creature attacker = new Creature.Builder()
                .name("Attacker")
                .attack(10)
                .armor(NOT_IMPORTANT)
                .maxHp(100)
                .moveRange(NOT_IMPORTANT)
                .damage(Range.closed(20,20))
                .build();
        Creature defender = new Creature.Builder()
                .name("Defender")
                .attack(NOT_IMPORTANT)
                .armor(10)
                .maxHp(100)
                .moveRange(NOT_IMPORTANT)
                .damage(Range.closed(5,5))
                .build();

        AttackEngine attackEngine = new AttackEngine();
        attackEngine.attack(attacker.getAttackContext(),defender.getDefenceContext());

        assertEquals(80,defender.getCurrentHp());
    }

    @Test
    void creatureShouldDealDamagePlus10PercentWhenAttackIsGreaterThenArmorBy2Points(){
        Creature attacker = new Creature.Builder()
                .name("Attacker")
                .attack(10)
                .armor(NOT_IMPORTANT)
                .maxHp(100)
                .moveRange(NOT_IMPORTANT)
                .damage(Range.closed(20,20))
                .build();
        Creature defender = new Creature.Builder()
                .name("Defender")
                .attack(NOT_IMPORTANT)
                .armor(8)
                .maxHp(100)
                .moveRange(NOT_IMPORTANT)
                .damage(Range.closed(NOT_IMPORTANT,NOT_IMPORTANT))
                .build();

        AttackEngine attackEngine = new AttackEngine();
        attackEngine.attack(attacker.getAttackContext(),defender.getDefenceContext());

        assertEquals(78,defender.getCurrentHp());
    }

    @Test
    void creatureShouldDealDamageMinus5PercentWhenArmorIsGreaterThenAttackBy2Points(){
        Creature attacker = new Creature.Builder()
                .name("Attacker")
                .attack(10)
                .armor(NOT_IMPORTANT)
                .maxHp(100).moveRange(NOT_IMPORTANT)
                .damage(Range.closed(10,20))
                .calcDmgStrategy(new DefaultCalculateStrategy(randomizer))
                .build();
        Creature defender = new Creature.Builder()
                .name("Defender")
                .attack(NOT_IMPORTANT)
                .armor(12)
                .maxHp(100)
                .moveRange(NOT_IMPORTANT)
                .damage(Range.closed(NOT_IMPORTANT,NOT_IMPORTANT))
                .build();
        AttackEngine attackEngine = new AttackEngine();
        attackEngine.attack(attacker.getAttackContext(),defender.getDefenceContext());

        assertEquals(87,defender.getCurrentHp());
    }

    @Test
    void shouldDealTwoXMoreDamageWhenStackHasTwoUnits(){
        Creature attacker = new Creature.Builder()
                .name("Attacker")
                .attack(10).armor(NOT_IMPORTANT)
                .maxHp(100).moveRange(NOT_IMPORTANT)
                .damage(Range.closed(10,20))
                .damageCalculator(new DefaultCalculateStrategy(randomizer))
                .amount(2)
                .build();
        Creature defender = new Creature.Builder()
                .name("Defender")
                .attack(NOT_IMPORTANT)
                .armor(12)
                .maxHp(100)
                .moveRange(NOT_IMPORTANT)
                .damage(Range.closed(NOT_IMPORTANT,NOT_IMPORTANT))
                .build();
        AttackEngine attackEngine = new AttackEngine();
        attackEngine.attack(attacker.getAttackContext(),defender.getDefenceContext());

        assertEquals(74,defender.getCurrentHp());
    }
}