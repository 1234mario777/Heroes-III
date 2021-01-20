package pl.sdk.hero;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.creatures.EconomyCreature;
import pl.sdk.creatures.EconomyNecropolisFactory;


import static org.junit.jupiter.api.Assertions.*;

class CreatureShopCalculatorTest
{
	private final EconomyNecropolisFactory creatureFactory = new EconomyNecropolisFactory();
	EconomyCreature creature;
	@BeforeEach
	void init() {
		creature = creatureFactory.create(false, 1, 1);
	}

	@Test
	void shouldCorrectlyCalculateMaxAmountToBuyWhenGrowthIsSmallerThanPurchaseOpportunity()
	{
		EconomyHero hero = new EconomyHero(EconomyHero.Fraction.NECROPOLIS, 3000);
		CreatureShopCalculator calculator = new CreatureShopCalculator();
		assertEquals( 12,  calculator.calculateMaxAmount( hero.getGold(), creature.getGrowth(), creature.getGoldCost() ) );
	}

	@Test
	void shouldCorrectlyCalculateMaxAmountToBuyWhenGrowthIsBiggerThanPurchaseOpportunity()
	{
		EconomyHero hero = new EconomyHero(EconomyHero.Fraction.NECROPOLIS, 600);
		CreatureShopCalculator calculator = new CreatureShopCalculator();
		assertEquals( 10,  calculator.calculateMaxAmount( hero.getGold(), creature.getGrowth(), creature.getGoldCost() ) );
	}

	@Test
	void shouldCorrectlyCalculateMaxAmountToBuyWhenGrowthEqualsPurchaseOpportunity()
	{
		EconomyHero hero = new EconomyHero(EconomyHero.Fraction.NECROPOLIS, 720);
		CreatureShopCalculator calculator = new CreatureShopCalculator();
		assertEquals( 12,  calculator.calculateMaxAmount( hero.getGold(), creature.getGrowth(), creature.getGoldCost() ) );
	}

}