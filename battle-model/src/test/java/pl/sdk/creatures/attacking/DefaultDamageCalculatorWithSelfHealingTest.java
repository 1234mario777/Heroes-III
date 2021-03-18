package pl.sdk.creatures.attacking;

import com.google.common.collect.Range;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.creatures.Creature;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DefaultDamageCalculatorWithSelfHealingTest {

    private int NOT_IMPORTANT = 5;
    private int THE_SAME_FOR_BOTH_CREATURES = 10;
    private AttackerStatisticIf attackerStats;
    private Creature defender;
    private Random rand;

//    @BeforeEach
//    void init(){
//        rand = mock(Random.class);
//        when(rand.nextInt(anyInt())).thenReturn(0);
//        attackerStats = AttackerWithBuffEtcStatistic.builder().
//                attack(10)
//                .amount(1)
//                .damage(Range.closed(5,5))
//                .build();
//        attacker = new Creature.Builder()
//                .name("Selfheal Test Unit")
//                .maxHp(30)
//                .attack(THE_SAME_FOR_BOTH_CREATURES)
//                .armor(THE_SAME_FOR_BOTH_CREATURES)
//                .damage(Range.closed(10, 20))
//                .calcDmgStrategy(new DefaultCalculateStrategy(rand))
//                .moveRange(NOT_IMPORTANT)
//                .amount(10)
//                .build();
//        attacker = new HealAfterAttackCreatureDecorator(attacker, 0.5);
//        defender = new Creature.Builder()
//                .name("Defender")
//                .maxHp(NOT_IMPORTANT)
//                .attack(THE_SAME_FOR_BOTH_CREATURES)
//                .armor(THE_SAME_FOR_BOTH_CREATURES)
//                .damage(Range.closed(0, 0))
//                .moveRange(NOT_IMPORTANT)
//                .amount(NOT_IMPORTANT)
//                .build();
//    }
//
//    @Test
//    void shouldHeal50HpBecauseAttackedFor100(){
//        attacker.attack(defender);
//
//        assertEquals(11,attacker.getAmount());
//        assertEquals(20,attacker.getCurrentHp());
//    }

}