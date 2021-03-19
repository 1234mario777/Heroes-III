package pl.sdk.creatures.attacking;

import com.google.common.collect.Range;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.attacking.AttackEngine;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApplyDamageTest {

    private static final int NOT_IMPORTANT = 5;
    private Creature defender;
    private static final int IMMORTAL=99999;

    @BeforeEach
    void init(){
        defender = new Creature.Builder()
                .attack(NOT_IMPORTANT)
                .armor(NOT_IMPORTANT)
                .maxHp(100)
                .amount(10)
                .moveRange(NOT_IMPORTANT)
                .damage(Range.closed(NOT_IMPORTANT,NOT_IMPORTANT))
                .build();
    }
    @Test
    void shouldLostOneCreatureFromStackAndHasFullHp(){
        Creature attacker = new Creature.Builder()
                .name("Name")
                .attack(NOT_IMPORTANT)
                .armor(NOT_IMPORTANT)
                .maxHp(NOT_IMPORTANT)
                .moveRange(1)
                .damage(Range.closed(100, 100))
                .build();

        AttackEngine attackEngine = new AttackEngine();
        attackEngine.attack(attacker.getAttackContext(),defender.getDefenceContext());

        assertEquals(9, defender.getAmount());
        assertEquals(100, defender.getCurrentHp());
    }

    @Test
    void shouldLostTwoCreatureFromStackAndHasFullHp(){
        Creature attacker = new Creature.Builder()
                .name("Name")
                .attack(NOT_IMPORTANT)
                .armor(NOT_IMPORTANT)
                .maxHp(NOT_IMPORTANT)
                .moveRange(1)
                .damage(Range.closed(200, 200))
                .build();

        AttackEngine attackEngine = new AttackEngine();
        attackEngine.attack(attacker.getAttackContext(),defender.getDefenceContext());

        assertEquals(8, defender.getAmount());
        assertEquals(100, defender.getCurrentHp());
    }

    @Test
    void shouldLostOneCreatureFromStackAndHas1Hp(){
        Creature attacker = new Creature.Builder()
                .name("Name")
                .attack(NOT_IMPORTANT)
                .armor(NOT_IMPORTANT)
                .maxHp(NOT_IMPORTANT)
                .moveRange(1)
                .damage(Range.closed(199, 199))
                .build();

        AttackEngine attackEngine = new AttackEngine();
        attackEngine.attack(attacker.getAttackContext(),defender.getDefenceContext());

        assertEquals(9, defender.getAmount());
        assertEquals(1, defender.getCurrentHp());
    }

    @Test
    void shouldLost99HpButWithoutCreatureFromStack(){
        Creature attacker = new Creature.Builder()
                .name("Name")
                .attack(NOT_IMPORTANT)
                .armor(NOT_IMPORTANT)
                .maxHp(NOT_IMPORTANT)
                .moveRange(1)
                .damage(Range.closed(99, 99))
                .build();

        AttackEngine attackEngine = new AttackEngine();
        attackEngine.attack(attacker.getAttackContext(),defender.getDefenceContext());

        assertEquals(10, defender.getAmount());
        assertEquals(1, defender.getCurrentHp());
    }

    @Test
    void shouldLost198HpBecauseAttackTwiceShouldBe9StackAnd2Hp(){
        Creature attacker = new Creature.Builder()
                .name("Name")
                .attack(NOT_IMPORTANT)
                .armor(NOT_IMPORTANT)
                .maxHp(IMMORTAL)
                .moveRange(1)
                .damage(Range.closed(99, 99))
                .build();

        AttackEngine attackEngine = new AttackEngine();
        attackEngine.attack(attacker.getAttackContext(),defender.getDefenceContext());
        attackEngine.attack(attacker.getAttackContext(),defender.getDefenceContext());

        assertEquals(9, defender.getAmount());
        assertEquals(2, defender.getCurrentHp());
    }
}