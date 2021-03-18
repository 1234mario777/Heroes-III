package pl.sdk.creatures;

import com.google.common.collect.Range;
import org.junit.jupiter.api.Test;
import pl.sdk.creatures.attacking.AttackEngine;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CreatureCounterAttackTest {

    private static final int NOT_IMPORTANT = 5;

    @Test
    void creatureShouldCounterAttack(){
        Creature attacker = new Creature.Builder()
                .name("Attacker")
                .attack(NOT_IMPORTANT)
                .armor(NOT_IMPORTANT)
                .maxHp(100)
                .moveRange(NOT_IMPORTANT)
                .damage(Range.closed(NOT_IMPORTANT,NOT_IMPORTANT))
                .build();
        Creature defender = new Creature.Builder()
                .name("Defender")
                .attack(NOT_IMPORTANT)
                .armor(10)
                .maxHp(100)
                .moveRange(NOT_IMPORTANT)
                .damage(Range.closed(10,10))
                .build();

        AttackEngine attackEngine = new AttackEngine();
        attackEngine.attack(attacker.getAttackContext(),defender.getDefenceContext());

        assertEquals(90,attacker.getCurrentHp());
    }

    @Test
    void creatureShouldCounterAttackOnlyOnceAtTurn(){
        Creature attacker = new Creature.Builder()
                .name("Attacker")
                .attack(NOT_IMPORTANT)
                .armor(NOT_IMPORTANT)
                .maxHp(100)
                .moveRange(NOT_IMPORTANT)
                .damage(Range.closed(NOT_IMPORTANT,NOT_IMPORTANT))
                .build();
        Creature attacker2 = new Creature.Builder()
                .name("Attacker")
                .attack(NOT_IMPORTANT)
                .armor(NOT_IMPORTANT)
                .maxHp(100)
                .moveRange(NOT_IMPORTANT)
                .damage(Range.closed(NOT_IMPORTANT,NOT_IMPORTANT))
                .build();
        Creature defender = new Creature.Builder()
                .name("Defender")
                .attack(NOT_IMPORTANT)
                .armor(10)
                .maxHp(100)
                .moveRange(NOT_IMPORTANT)
                .damage(Range.closed(10,10))
                .build();

        AttackEngine attackEngine = new AttackEngine();
        attackEngine.attack(attacker.getAttackContext(),defender.getDefenceContext());
        attackEngine.attack(attacker2.getAttackContext(),defender.getDefenceContext());

        assertEquals(90,attacker.getCurrentHp());
        assertEquals(100,attacker2.getCurrentHp());
    }

}