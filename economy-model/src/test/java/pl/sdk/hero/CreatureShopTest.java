package pl.sdk.hero;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.EconomyEngine;
import pl.sdk.creatures.EconomyTestFractionFactory;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static pl.sdk.hero.Fraction.NECROPOLIS;

class CreatureShopTest
{
	EconomyEngine economyEngine;
	private final EconomyTestFractionFactory creatureFactory = new EconomyTestFractionFactory();
	@BeforeEach
	void init()
	{
		Random rand = mock( Random.class );
		when( rand.nextDouble() ).thenReturn( 1.0 );
		CreatureShop shop1 = new CreatureShop(rand);
		CreatureShop shop2 = new CreatureShop(rand);
		EconomyHero hero1 = new EconomyHero(NECROPOLIS, 1000);
		EconomyHero hero2 = new EconomyHero(NECROPOLIS, 1000);
		Player player1 = new Player( hero1, shop1 );
		Player player2 = new Player( hero2, shop2 );
		economyEngine = new EconomyEngine(player1, player2);
	}

	@Test
	void toGameStartCurrentPopulationShouldBeEqualToCreatureGrowth()
	{
		assertEquals( 12, economyEngine.getCurrentPopulation(1) );
		assertEquals( 8, economyEngine.getCurrentPopulation(2) );
		assertEquals( 7, economyEngine.getCurrentPopulation(3) );
		assertEquals( 4, economyEngine.getCurrentPopulation(4) );
		assertEquals( 3, economyEngine.getCurrentPopulation(5) );
		assertEquals( 2, economyEngine.getCurrentPopulation(6) );
		assertEquals( 1, economyEngine.getCurrentPopulation(7) );
	}

	@Test
	void toGameStartAfterPassCurrentPopulationShouldBeEqualToCreatureGrowth()
	{
		economyEngine.pass();

		assertEquals( 12, economyEngine.getCurrentPopulation(1) );
		assertEquals( 8, economyEngine.getCurrentPopulation(2) );
		assertEquals( 7, economyEngine.getCurrentPopulation(3) );
		assertEquals( 4, economyEngine.getCurrentPopulation(4) );
		assertEquals( 3, economyEngine.getCurrentPopulation(5) );
		assertEquals( 2, economyEngine.getCurrentPopulation(6) );
		assertEquals( 1, economyEngine.getCurrentPopulation(7) );
	}

	@Test
	void afterRoundEndPopulationInShopShouldIncreaseByCreatureGrowth()
	{
		//when
		economyEngine.pass();
		economyEngine.pass();
		//then
		assertEquals( 24, economyEngine.getCurrentPopulation(1) );
		assertEquals( 16, economyEngine.getCurrentPopulation(2) );
		assertEquals( 14, economyEngine.getCurrentPopulation(3) );
		assertEquals( 8, economyEngine.getCurrentPopulation(4) );
		assertEquals( 6, economyEngine.getCurrentPopulation(5) );
		assertEquals( 4, economyEngine.getCurrentPopulation(6) );
		assertEquals( 2, economyEngine.getCurrentPopulation(7) );

		economyEngine.pass();

		assertEquals( 24, economyEngine.getCurrentPopulation(1) );
		assertEquals( 16, economyEngine.getCurrentPopulation(2) );
		assertEquals( 14, economyEngine.getCurrentPopulation(3) );
		assertEquals( 8, economyEngine.getCurrentPopulation(4) );
		assertEquals( 6, economyEngine.getCurrentPopulation(5) );
		assertEquals( 4, economyEngine.getCurrentPopulation(6) );
		assertEquals( 2, economyEngine.getCurrentPopulation(7) );

	}

	@Test
	void afterPurchaseCreaturePopulationShouldBeDecreasedByBoughtAmount()
	{
		//when
		economyEngine.buy(creatureFactory.create(false, 1, 10));
		//then
		assertEquals( 2, economyEngine.getCurrentPopulation(1) );
	}

	@Test
	void heroOnePurchaseShouldNotAffectOnHeroTwoPopulation()
	{
		//when
		economyEngine.buy(creatureFactory.create(false, 1, 10));
		//then
		assertEquals( 2, economyEngine.getCurrentPopulation(1) );
		economyEngine.pass();
		assertEquals( 12, economyEngine.getCurrentPopulation(1) );
	}

	@Test
	void shouldThrowExceptionWhenTryToPurchaseMoreCreatureThanPopulationIs()
	{
		assertThrows(IllegalStateException.class, () ->economyEngine.buy(creatureFactory.create(false, 1, 13)));
		assertEquals( 12, economyEngine.getCurrentPopulation( 1 ) );
	}

	@Test
	void afterPurchaseAndRoundEndPopulationAmountShouldBeCorrect()
	{
		//when
		economyEngine.buy(creatureFactory.create(false, 1, 12));
		economyEngine.pass();
		economyEngine.buy( creatureFactory.create(false, 2, 3) );
		economyEngine.pass();
		//then
		assertEquals( 12, economyEngine.getCurrentPopulation(1) );
		assertEquals( 16, economyEngine.getCurrentPopulation(2) );
		economyEngine.pass();
		assertEquals( 24, economyEngine.getCurrentPopulation(1) );
		assertEquals( 13, economyEngine.getCurrentPopulation(2) );
	}

	@Test
	void shouldCorrectlyRandomizePopulationGrowthForBothPlayers()
	{
		Random rand = mock( Random.class );
		when( rand.nextDouble() ).thenReturn( 0.5 );
		CreatureShop shop1 = new CreatureShop(rand);
		CreatureShop shop2 = new CreatureShop(rand);
		EconomyHero hero1 = new EconomyHero(NECROPOLIS, 1000);
		EconomyHero hero2 = new EconomyHero(NECROPOLIS, 1000);
		Player player1 = new Player( hero1, shop1 );
		Player player2 = new Player( hero2, shop2 );
		economyEngine = new EconomyEngine(player1, player2);

		assertEquals( 9, economyEngine.getCurrentPopulation(1) );
		assertEquals( 6, economyEngine.getCurrentPopulation(2) );
		assertEquals( 5, economyEngine.getCurrentPopulation(3) );
		assertEquals( 3, economyEngine.getCurrentPopulation(4) );
		assertEquals( 2, economyEngine.getCurrentPopulation(5) );
		assertEquals( 1, economyEngine.getCurrentPopulation(6) );
		assertEquals( 0, economyEngine.getCurrentPopulation(7) );

		economyEngine.pass();

		assertEquals( 9, economyEngine.getCurrentPopulation(1) );
		assertEquals( 6, economyEngine.getCurrentPopulation(2) );
		assertEquals( 5, economyEngine.getCurrentPopulation(3) );
		assertEquals( 3, economyEngine.getCurrentPopulation(4) );
		assertEquals( 2, economyEngine.getCurrentPopulation(5) );
		assertEquals( 1, economyEngine.getCurrentPopulation(6) );
		assertEquals( 0, economyEngine.getCurrentPopulation(7) );

		economyEngine.pass();

		assertEquals( 18, economyEngine.getCurrentPopulation(1) );
		assertEquals( 12, economyEngine.getCurrentPopulation(2) );
		assertEquals( 10, economyEngine.getCurrentPopulation(3) );
		assertEquals( 6, economyEngine.getCurrentPopulation(4) );
		assertEquals( 4, economyEngine.getCurrentPopulation(5) );
		assertEquals( 2, economyEngine.getCurrentPopulation(6) );
		assertEquals( 0, economyEngine.getCurrentPopulation(7) );

		economyEngine.pass();

		assertEquals( 18, economyEngine.getCurrentPopulation(1) );
		assertEquals( 12, economyEngine.getCurrentPopulation(2) );
		assertEquals( 10, economyEngine.getCurrentPopulation(3) );
		assertEquals( 6, economyEngine.getCurrentPopulation(4) );
		assertEquals( 4, economyEngine.getCurrentPopulation(5) );
		assertEquals( 2, economyEngine.getCurrentPopulation(6) );
		assertEquals( 0, economyEngine.getCurrentPopulation(7) );
	}
}