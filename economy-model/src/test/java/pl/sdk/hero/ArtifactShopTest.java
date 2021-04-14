package pl.sdk.hero;

import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.configuration.IMockitoConfiguration;
import pl.sdk.EconomyEngine;
import pl.sdk.artifacts.AbstractEconomyArtifactFactory;
import pl.sdk.artifacts.ArtifactFactoryType;
import pl.sdk.artifacts.ArtifactStatistic;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static pl.sdk.artifacts.ArtifactStatistic.*;

class ArtifactShopTest {

    private final AbstractEconomyArtifactFactory artifactFactory = AbstractEconomyArtifactFactory.getInstance(ArtifactFactoryType.TEST);
    Player player1;
    EconomyEngine economyEngine;

    @BeforeEach
    void init() {
        Random playerOneRand = mock(Random.class);
        when(playerOneRand.nextDouble()).thenReturn(1.0);
        Random playerTwoRand = mock(Random.class);
        when(playerTwoRand.nextDouble()).thenReturn(0.2);
        ArtifactShop shop1 = new ArtifactShop(playerOneRand, artifactFactory);
        ArtifactShop shop2 = new ArtifactShop(playerTwoRand, artifactFactory);
        EconomyHero hero1 = new EconomyHero();
        EconomyHero hero2 = new EconomyHero();
        player1 = new Player(hero1, shop1, 1000);
        Player player2 = new Player(hero1, shop2, 1000);
        economyEngine = new EconomyEngine(player1, player2);
    }

    @Test
    void shouldCorrectlyRandomizePopulationForBothPlayers() {
        assertEquals(3, economyEngine.getCurrentArtifactPopulation().size());

        economyEngine.pass();

        assertEquals(1, economyEngine.getCurrentArtifactPopulation().size());
    }

    @Test
    void afterEndOfRoundPopulationInShopShouldBeRandomized() {
        //when
        economyEngine.pass();
        economyEngine.pass();
        //then
        assertEquals(3, economyEngine.getCurrentArtifactPopulation().size());
        economyEngine.pass();
        assertEquals(1, economyEngine.getCurrentArtifactPopulation().size());
    }

    @Test
    void heroShouldCanBuyArtifact() {
        //when
        economyEngine.buyArtifact(artifactFactory.create(TEST_RING_OF_VITALITY.getName()));
        //then
        assertEquals(990, player1.getGold());
        assertEquals(1, player1.getArtifacts().size());
    }

    @Test
    void afterPurchaseArtifactPopulationShouldBeDecreasedByBoughtOne() {
        //when
        economyEngine.buyArtifact(artifactFactory.create(TEST_RING_OF_VITALITY.getName()));
        //then
        assertEquals(2, economyEngine.getCurrentArtifactPopulation().size());
    }

    @Test
    void shouldThrowExceptionWhenTryToPurchaseTheSameArtifactAgain() {
        //when
        economyEngine.buyArtifact(artifactFactory.create(TEST_RING_OF_VITALITY.getName()));
        //then
        assertThrows(IllegalStateException.class, () -> economyEngine.buyArtifact(artifactFactory.create(TEST_RING_OF_VITALITY.getName())));
        assertEquals(2, economyEngine.getCurrentArtifactPopulation().size());
        assertEquals(1, player1.getArtifacts().size());
    }

    @Test
    void heroShouldBuyMoreThanOneArtifact() {
        //when
        economyEngine.buyArtifact(artifactFactory.create(TEST_RING_OF_VITALITY.getName()));
        economyEngine.buyArtifact(artifactFactory.create(TEST_RING_OF_LIFE.getName()));
        //then
        assertEquals(970, player1.getGold());
        assertEquals(2, player1.getArtifacts().size());
    }

    @Test
    void heroCannotBuyArtifactWhenHasNotEnoughGold() {
        assertThrows(IllegalStateException.class, () -> economyEngine.buyArtifact(artifactFactory.create(TEST_RING_OF_CONJURING.getName())));
        assertEquals(1000, player1.getGold());
        assertEquals(0, player1.getArtifacts().size());
    }

    @Test
    void heroShouldNotBuyArtifactWhenHasNoEmptySlot() {
        Random playerOneRand = mock(Random.class);
        when(playerOneRand.nextDouble()).thenReturn(1.0);
        ArtifactShop firstPlayerShop = new ArtifactShop(playerOneRand, artifactFactory);
        EconomyHero firstHero = new EconomyHero();
        Player firstPlayer = new Player(firstHero, firstPlayerShop, 4000);
        economyEngine = new EconomyEngine(firstPlayer, player1);
        economyEngine.buyArtifact(artifactFactory.create(TEST_RING_OF_VITALITY.getName()));
        economyEngine.buyArtifact(artifactFactory.create(TEST_RING_OF_LIFE.getName()));

        assertThrows(IllegalStateException.class, () -> economyEngine.buyArtifact(artifactFactory.create(TEST_RING_OF_CONJURING.getName())));
        assertEquals(3970, firstPlayer.getGold());
        assertEquals(2, firstPlayer.getArtifacts().size());
    }

    @Test
    void heroOnePurchaseShouldNotAffectOnHeroTwoPopulation() {
        Random playerTwoRand = mock(Random.class);
        when(playerTwoRand.nextDouble()).thenReturn(1.0);
        ArtifactShop secondPlayerShop = new ArtifactShop(playerTwoRand, artifactFactory);
        EconomyHero secondHero = new EconomyHero();
        Player secondPlayer = new Player(secondHero, secondPlayerShop, 1000);
        economyEngine = new EconomyEngine(player1, secondPlayer);
        //when
        economyEngine.buyArtifact(artifactFactory.create(TEST_RING_OF_VITALITY.getName()));
        //then
        assertEquals(2, economyEngine.getCurrentArtifactPopulation().size());
        assertEquals(1, player1.getArtifacts().size());
        economyEngine.pass();
        economyEngine.buyArtifact(artifactFactory.create(TEST_RING_OF_VITALITY.getName()));
        assertEquals(2, economyEngine.getCurrentArtifactPopulation().size());
        assertEquals(1, secondPlayer.getArtifacts().size());
    }

    @Test
    void shouldCorrectlyCheckIfPlayerHasArtifact() {
        //when
        economyEngine.buyArtifact(artifactFactory.create(TEST_RING_OF_VITALITY.getName()));
        //then
        assertTrue(economyEngine.hasArtifact(TEST_RING_OF_VITALITY.getName()));
        assertFalse(economyEngine.hasArtifact(TEST_RING_OF_LIFE.getName()));
        assertFalse(economyEngine.hasArtifact(TEST_RING_OF_CONJURING.getName()));
    }
}