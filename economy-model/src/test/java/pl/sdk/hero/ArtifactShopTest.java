package pl.sdk.hero;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.EconomyEngine;
import pl.sdk.artifacts.ArtifactStatistic;
import pl.sdk.artifacts.EconomyArtifact;
import pl.sdk.artifacts.EconomyArtifactFactory;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static pl.sdk.artifacts.ArtifactStatistic.*;

class ArtifactShopTest {

    private EconomyArtifactFactory artifactFactory;
    Player player1;
    Player player2;
    EconomyEngine economyEngine;

    @BeforeEach
    void init() {
        artifactFactory = new EconomyArtifactFactory();
        Random playerOneRand = mock(Random.class);
        when(playerOneRand.nextInt(anyInt())).thenReturn(6);
        Random playerTwoRand = mock(Random.class);
        when(playerTwoRand.nextInt(anyInt())).thenReturn(6);
        ArtifactShop shop1 = new ArtifactShop(playerOneRand, artifactFactory);
        ArtifactShop shop2 = new ArtifactShop(playerTwoRand, artifactFactory);
        EconomyHero hero1 = new EconomyHero();
        EconomyHero hero2 = new EconomyHero();
        player1 = new Player(hero1, shop1, 10000);
        player2 = new Player(hero2, shop2, 10000);
        economyEngine = new EconomyEngine(player1, player2);
    }

    @Test
    void shouldCorrectlyCreatePopulationForBothPlayers()
    {
        assertEquals( 13, economyEngine.getCurrentArtifactPopulation().size() );
        economyEngine.pass();
        assertEquals( 13, economyEngine.getCurrentArtifactPopulation().size() );
    }

    @Test
    void afterRoundEndPopulationInShopShouldBeRecreated()
    {
        economyEngine.pass();
        economyEngine.pass();
        assertEquals( 13, economyEngine.getCurrentArtifactPopulation().size() );
        economyEngine.pass();
        assertEquals( 13, economyEngine.getCurrentArtifactPopulation().size() );

    }

    @Test
    void heroShouldCanBuyArtifact() {
        //when
        economyEngine.buyArtifact(artifactFactory.create(RING_OF_VITALITY.getName()));
        //then
        assertEquals(5000, player1.getGold());
        assertEquals(1, player1.getArtifacts().size());
    }

    @Test
    void afterPurchaseArtifactPopulationShouldBeDecreasedByBoughtOne() {
        //when
        economyEngine.buyArtifact(artifactFactory.create(RING_OF_VITALITY.getName()));
        //then
        assertEquals(12, economyEngine.getCurrentArtifactPopulation().size());
    }

    @Test
    void shouldThrowExceptionWhenTryToPurchaseTheSameArtifactAgain() {
        //when
        economyEngine.buyArtifact(artifactFactory.create(RING_OF_VITALITY.getName()));
        //then
        assertThrows(IllegalStateException.class, () -> economyEngine.buyArtifact(artifactFactory.create(RING_OF_VITALITY.getName())));
        assertEquals(12, economyEngine.getCurrentArtifactPopulation().size());
        assertEquals(1, player1.getArtifacts().size());
    }

    @Test
    void heroShouldBuyMoreThanOneArtifact() {
        //when
        economyEngine.buyArtifact(artifactFactory.create(RING_OF_VITALITY.getName()));
        economyEngine.buyArtifact(artifactFactory.create(SURCOAT_OF_COUNTERPOISE.getName()));
        //then
        assertEquals(1000, player1.getGold());
        assertEquals(2, player1.getArtifacts().size());
    }

    @Test
    void heroCannotBuyArtifactWhenHasNotEnoughGold() {
        assertThrows(IllegalStateException.class, () -> economyEngine.buyArtifact(artifactFactory.create(TOME_OF_AIR_MAGIC.getName())));
        assertEquals(10000, player1.getGold());
        assertEquals(0, player1.getArtifacts().size());
    }

    @Test
    void heroShouldNotBuyArtifactWhenHasNoEmptySlot() {
        economyEngine.buyArtifact(artifactFactory.create(STATEMANS_MEDAL.getName()));

        assertThrows(IllegalStateException.class, () -> economyEngine.buyArtifact(artifactFactory.create(COLLAR_OF_CONJURING.getName())));
        assertEquals(5000, player1.getGold());
        assertEquals(1, player1.getArtifacts().size());
    }

    @Test
    void heroOnePurchaseShouldNotAffectOnHeroTwoPopulation() {
        economyEngine.buyArtifact(artifactFactory.create(COLLAR_OF_CONJURING.getName()));

        assertEquals(12, economyEngine.getCurrentArtifactPopulation().size());
        assertEquals(1, player1.getArtifacts().size());

        economyEngine.pass();
        economyEngine.buyArtifact(artifactFactory.create(COLLAR_OF_CONJURING.getName()));

        assertEquals(12, economyEngine.getCurrentArtifactPopulation().size());
        assertEquals(1, player2.getArtifacts().size());
    }

    @Test
    void shouldCorrectlyCheckIfPlayerHasArtifact() {
        //when
        economyEngine.buyArtifact(artifactFactory.create(COLLAR_OF_CONJURING.getName()));
        //then
        assertTrue(economyEngine.hasArtifact(COLLAR_OF_CONJURING.getName()));
        assertFalse(economyEngine.hasArtifact(RING_OF_VITALITY.getName()));
        assertFalse(economyEngine.hasArtifact(SURCOAT_OF_COUNTERPOISE.getName()));
        assertFalse(economyEngine.hasArtifact(ORB_OF_TEMPESTOUS_FIRE.getName()));
        assertFalse(economyEngine.hasArtifact(PENDANT_OF_LIFE.getName()));
        assertFalse(economyEngine.hasArtifact(BLACKSHARD_OF_THE_DEAD_KNIGHT.getName()));
        assertFalse(economyEngine.hasArtifact(SHIELD_OF_THE_YAWNING_DEAD.getName()));
        assertFalse(economyEngine.hasArtifact(ARMOR_OF_WONDER.getName()));
        assertFalse(economyEngine.hasArtifact(PENDANT_OF_COURAGE.getName()));
        assertFalse(economyEngine.hasArtifact(GOLDEN_BOW.getName()));
        assertFalse(economyEngine.hasArtifact(STATEMANS_MEDAL.getName()));
        assertFalse(economyEngine.hasArtifact(RING_OF_THE_WAYFARER.getName()));
        assertFalse(economyEngine.hasArtifact(TOME_OF_AIR_MAGIC.getName()));
    }
}