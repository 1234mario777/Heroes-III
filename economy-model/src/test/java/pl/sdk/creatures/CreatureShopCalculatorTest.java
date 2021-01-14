package pl.sdk.creatures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.hero.EconomyHero;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CreatureShopCalculatorTest
{
	private final EconomyNecropolisFactory creatureFactory = new EconomyNecropolisFactory();
	private Random rand;
	EconomyCreature creature;
	@BeforeEach
	void init() {
		creature = creatureFactory.create(false, 1, 1);
	}

	@Test
	void shouldCorrectlyCalculateMaxAmountToBuyWhenGrowthIsSmallerThanPurchaseOpportunity()
	{
		EconomyHero hero1 = new EconomyHero(EconomyHero.Fraction.NECROPOLIS, 3000);
		rand = mock(Random.class);
		when( rand.nextDouble() ).thenReturn( 0.5 );
		CreatureShopCalculator calculator = new CreatureShopCalculator(rand);
		assertEquals( 9,  calculator.calculateMaxAmount( hero1, creature ));
	}

	@Test
	void shouldCorrectlyCalculateMaxAmountToBuyWhenGrowthIsBiggerThanPurchaseOpportunity()
	{
		EconomyHero hero = new EconomyHero(EconomyHero.Fraction.NECROPOLIS, 600);
		rand = mock(Random.class);
		when( rand.nextDouble() ).thenReturn( 1.0 );
		CreatureShopCalculator calculator = new CreatureShopCalculator(rand);
		assertEquals( 10,  calculator.calculateMaxAmount( hero, creature ));
	}

	@Test
	void shouldCorrectlyCalculateMaxAmountToBuyWhenGrowthEqualsPurchaseOpportunity()
	{
		EconomyHero hero = new EconomyHero(EconomyHero.Fraction.NECROPOLIS, 720);
		rand = mock(Random.class);
		when( rand.nextDouble() ).thenReturn( 1.0 );
		CreatureShopCalculator calculator = new CreatureShopCalculator(rand);
		assertEquals( 12,  calculator.calculateMaxAmount( hero, creature ));
	}

}