package pl.sdk.creatures.attacking;

import com.google.common.collect.Range;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DoubleDamageChanceCalculatorTest {

    private int DEFENDER_DEFENCE = 10;
    private AttackerStatisticIf attackerStats;
    private Random rand;

    @BeforeEach
    void init(){
        attackerStats = AttackerWithBuffEtcStatistic.builder().
                attack(10)
                .amount(20)
                .damage(Range.closed(5,5))
                .build();
        rand = mock(Random.class);
        when(rand.nextInt(anyInt())).thenReturn(0);
    }

    @Test
    void shouldDealDoubleDamageIfRandomPositive(){
        when(rand.nextDouble()).thenReturn(0.19);
        CalculateDamageStrategyIf calc = new CalculateDamageIncreaseWithRandomChanceStrategyIf(0.2,2.0,rand);

        int result = calc.calculateDamage(attackerStats, DEFENDER_DEFENCE);

        assertEquals(200,result);
    }

    @Test
    void shouldDealNormalDamageIfRandomNegative(){
        when(rand.nextDouble()).thenReturn(0.21);
        CalculateDamageStrategyIf calc = new CalculateDamageIncreaseWithRandomChanceStrategyIf(0.2,2.0,rand);

        int result = calc.calculateDamage(attackerStats, DEFENDER_DEFENCE);

        assertEquals(100,result);
    }
}
