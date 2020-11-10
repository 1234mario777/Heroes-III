package pl.sdk;

import com.google.common.collect.Range;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreatureBuilderTest {

    private static final int NOT_IMPORTANT = 5;

    @Test
    void shouldCreateCorrectCreatureFromBuilder(){
        Creature creature = new Creature("Attacker",10,NOT_IMPORTANT,100,NOT_IMPORTANT, Range.closed(10,20), new DefaultDamageCalculator());
        Creature creatureFromBuilder = new Creature.Builder()
                .name("Attacker")
                .armor(5)
                .attack(10)
                .damage(Range.closed(10, 20))
                .maxHp(100)
                .moveRange(5)
                .damageCalculator(new DamageCalculator())
                .build();

        assertEquals(creature.getCurrentHp(),creatureFromBuilder.getCurrentHp());
        assertEquals(creature.getName(),creatureFromBuilder.getName());
        assertEquals(creature.getArmor(),creatureFromBuilder.getArmor());
        assertEquals(creature.getAttack(),creatureFromBuilder.getAttack());
        assertEquals(creature.getDamage(),creatureFromBuilder.getDamage());
        assertEquals(creature.getMoveRange(),creatureFromBuilder.getMoveRange());
    }

}