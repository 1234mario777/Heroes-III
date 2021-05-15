package pl.sdk.hero;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.EconomyEngine;
import pl.sdk.Fraction;
import pl.sdk.creatures.EconomyTestFractionFactory;
import pl.sdk.spells.AbstractEconomySpellFactory;
import pl.sdk.spells.SpellFactoryType;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static pl.sdk.Fraction.NECROPOLIS;
import static pl.sdk.spells.SpellStatistic.*;

class SpellShopTest
{
	EconomyEngine economyEngine;
	private final AbstractEconomySpellFactory spellFactory = AbstractEconomySpellFactory.getInstance( SpellFactoryType.TEST );
	Player player1;
	Player player2;

	@BeforeEach
	void init()
	{
		Random playerOneRand = mock( Random.class );
		when( playerOneRand.nextInt(anyInt())).thenReturn(4);
		Random playerTwoRand = mock( Random.class );
		when( playerTwoRand.nextInt(anyInt())).thenReturn(4);
		SpellShop shop1 = new SpellShop(playerOneRand, spellFactory);
		SpellShop shop2 = new SpellShop(playerTwoRand, spellFactory);
		EconomyHero hero1 = new EconomyHero();
		EconomyHero hero2 = new EconomyHero();
		player1 = new Player( hero1, shop1, 1000 );
		player2 = new Player( hero2, shop2, 1000 );
		economyEngine = new EconomyEngine(player1, player2);
	}

	@Test
	void shouldCorrectlyCreatePopulationForBothPlayers()
	{
		assertEquals( 9, economyEngine.getCurrentSpellPopulation().size() );
		economyEngine.pass();
		assertEquals( 9, economyEngine.getCurrentSpellPopulation().size() );
	}

	@Test
	void afterRoundEndPopulationInShopShouldBeRecreated()
	{
		economyEngine.pass();
		economyEngine.pass();
		assertEquals( 9, economyEngine.getCurrentSpellPopulation().size() );
		economyEngine.pass();
		assertEquals( 9, economyEngine.getCurrentSpellPopulation().size() );

	}

	@Test
	void heroShouldCanBuySpell() {
		economyEngine.getActivePlayer().getGold();
		economyEngine.buySpell(spellFactory.create(TEST_HASTE.getName()));

		assertEquals(700, player1.getGold());
		assertEquals(1, player1.getSpells().size());
	}

	@Test
	void heroShouldCanBuyMoreThanOneSpell() {
		economyEngine.buySpell(spellFactory.create(TEST_HASTE.getName()));
		economyEngine.buySpell(spellFactory.create(TEST_MAGIC_ARROW.getName()));

		assertEquals(400, player1.getGold());
		assertEquals(2, player1.getSpells().size());
	}

	@Test
	void heroCannotBuyCreatureWhenHasNotEnoughGold() {
		assertThrows(IllegalStateException.class, () -> economyEngine.buySpell(spellFactory.create(TEST_TELEPORT.getName())));
		assertEquals(1000, player1.getGold());
		assertEquals(0, player1.getSpells().size());
	}

	@Test
	void heroOnePurchaseShouldNotAffectOnHeroTwoPopulation()
	{
		economyEngine.buySpell(spellFactory.create(TEST_HASTE.getName()));

		assertEquals( 8, economyEngine.getCurrentSpellPopulation().size() );
		assertEquals(1, player1.getSpells().size());

		economyEngine.pass();
		economyEngine.buySpell(spellFactory.create(TEST_HASTE.getName()));

		assertEquals( 8, economyEngine.getCurrentSpellPopulation().size() );
		assertEquals(1, player2.getSpells().size());
	}

	@Test
	void afterPurchaseSpellPopulationShouldBeDecreasedByBought1()
	{
		//when
		economyEngine.buySpell(spellFactory.create(TEST_HASTE.getName()));
		//then
		assertEquals( 8, economyEngine.getCurrentSpellPopulation().size() );
	}


	@Test
	void shouldThrowExceptionWhenTryToPurchaseTheSameSpellAgain()
	{
		//when
		economyEngine.buySpell(spellFactory.create(TEST_HASTE.getName()));
		//then
		assertThrows(IllegalStateException.class, () -> economyEngine.buySpell(spellFactory.create(TEST_HASTE.getName())));
		assertEquals( 8, economyEngine.getCurrentSpellPopulation().size() );
		assertEquals(1, player1.getSpells().size());
	}

	@Test
	void shouldCorrectlyCheckIfPlayerHasSpell()
	{
		//when
		economyEngine.buySpell(spellFactory.create(TEST_HASTE.getName()));

		//then
		assertTrue(economyEngine.hasSpell( TEST_HASTE.getName() ) );
		assertFalse(economyEngine.hasSpell( TELEPORT.getName() ) );
	}
}