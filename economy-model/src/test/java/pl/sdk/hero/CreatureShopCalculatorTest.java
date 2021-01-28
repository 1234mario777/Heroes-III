package pl.sdk.hero;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.creatures.EconomyCreature;
import pl.sdk.creatures.EconomyTestFractionFactory;


import static org.junit.jupiter.api.Assertions.*;
import static pl.sdk.hero.Fraction.NECROPOLIS;

class CreatureShopCalculatorTest
{
	private final EconomyTestFractionFactory creatureFactory = new EconomyTestFractionFactory();
	EconomyCreature creature;
	@BeforeEach
	void init() {
		creature = creatureFactory.create(false, 1, 1);
	}

	@Test
	void shouldCorrectlyCalculateMaxAmountToBuyWhenGrowthIsSmallerThanPurchaseOpportunity()
	{
		Player player = new Player(NECROPOLIS, 3000);
		CreatureShopCalculator calculator = new CreatureShopCalculator();
		assertEquals( 12,  calculator.calculateMaxAmount( player.getGold(), creature.getGrowth(), creature.getGoldCost() ) );
	}

	@Test
	void shouldCorrectlyCalculateMaxAmountToBuyWhenGrowthIsBiggerThanPurchaseOpportunity()
	{
		Player player = new Player(NECROPOLIS, 600);
		CreatureShopCalculator calculator = new CreatureShopCalculator();
		assertEquals( 10,  calculator.calculateMaxAmount( player.getGold(), creature.getGrowth(), creature.getGoldCost() ) );
	}

	@Test
	void shouldCorrectlyCalculateMaxAmountToBuyWhenGrowthEqualsPurchaseOpportunity()
	{
		Player player = new Player(NECROPOLIS, 720);
		CreatureShopCalculator calculator = new CreatureShopCalculator();
		assertEquals( 12,  calculator.calculateMaxAmount( player.getGold(), creature.getGrowth(), creature.getGoldCost() ) );
	}

}