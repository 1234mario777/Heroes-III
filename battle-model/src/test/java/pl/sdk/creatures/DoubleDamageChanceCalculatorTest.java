package pl.sdk.creatures;

import com.google.common.collect.Range;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DoubleDamageChanceCalculatorTest {

    private int NOT_IMPORTANT = 5;
    private int THE_SAME_FOR_BOTH_CREATURES = 10;
    private Creature attacker;
    private Creature defender;
    private Random rand;

    @BeforeEach
    void init(){
        attacker = new Creature.BuilderForTesting()
                .name("Double Damage Chance Test Unit")
                .maxHp(NOT_IMPORTANT)
                .attack(THE_SAME_FOR_BOTH_CREATURES)
                .armor(THE_SAME_FOR_BOTH_CREATURES)
                .damage(Range.closed(10, 20))
                .moveRange(NOT_IMPORTANT)
                .amount(10)
                .build();
        defender = new Creature.BuilderForTesting()
                .name("Defender")
                .maxHp(NOT_IMPORTANT)
                .attack(THE_SAME_FOR_BOTH_CREATURES)
                .armor(THE_SAME_FOR_BOTH_CREATURES)
                .damage(Range.closed(NOT_IMPORTANT, NOT_IMPORTANT))
                .moveRange(NOT_IMPORTANT)
                .amount(NOT_IMPORTANT)
                .build();
        rand = mock(Random.class);
        when(rand.nextInt(anyInt())).thenReturn(0);
    }

    @Test
    void shouldDealDoubleDamageIfRandomPositive(){
        when(rand.nextDouble()).thenReturn(0.19);
        CalculateDamageStrategy calc = new CalculateDamageIncreaseWithRandomChanceStrategy(0.2,2.0,rand);

        int result = calc.calculateDamage(attacker, defender);

        assertEquals(200,result);
    }

    @Test
    void shouldDealNormalDamageIfRandomNegative(){
        when(rand.nextDouble()).thenReturn(0.21);
        CalculateDamageStrategy calc = new CalculateDamageIncreaseWithRandomChanceStrategy(0.2,2.0,rand);

        int result = calc.calculateDamage(attacker, defender);

        assertEquals(100,result);
    }
}
