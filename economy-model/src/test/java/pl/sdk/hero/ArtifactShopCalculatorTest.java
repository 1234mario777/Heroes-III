package pl.sdk.hero;

import org.junit.jupiter.api.Test;
import pl.sdk.Fraction;
import pl.sdk.artifacts.AbstractEconomyArtifactFactory;
import pl.sdk.artifacts.ArtifactFactoryType;
import pl.sdk.artifacts.ArtifactStatistic;
import pl.sdk.artifacts.EconomyArtifact;

import static org.junit.jupiter.api.Assertions.*;
import static pl.sdk.artifacts.ArtifactStatistic.TEST_RING_OF_VITALITY;

class ArtifactShopCalculatorTest {

    private final AbstractEconomyArtifactFactory artifactFactory = AbstractEconomyArtifactFactory.getInstance(ArtifactFactoryType.TEST);
    EconomyArtifact artifact;

    @Test
    void shouldCorrectlyCountArtifactCost() {
        artifact = artifactFactory.create(TEST_RING_OF_VITALITY.getName());
        assertEquals(10, artifact.getGoldCost());
    }

    @Test
    void shouldReturn1IfPlayerCanAffordToFewArtifactsPurchase() {
        artifact = artifactFactory.create(TEST_RING_OF_VITALITY.getName());
        Player aPlayer = new Player(Fraction.NECROPOLIS, 1000);
        ArtifactShopCalculator aCalculator = new ArtifactShopCalculator();
        assertEquals(1, aCalculator.calculateMaxAmount(aPlayer.getGold(), artifact.getGrowth(), artifact.getGoldCost()));
    }

    @Test
    void shouldReturn1IfPlayerCanAffordToExactlyOneArtifactPurchase() {
        artifact = artifactFactory.create(TEST_RING_OF_VITALITY.getName());
        Player aPlayer = new Player(Fraction.NECROPOLIS, 10);
        ArtifactShopCalculator aCalculator = new ArtifactShopCalculator();
        assertEquals(1, aCalculator.calculateMaxAmount(aPlayer.getGold(), artifact.getGrowth(), artifact.getGoldCost()));
    }

    @Test
    void shouldReturn0IfPlayerCanNotAffordToArtifactPurchase() {
        artifact = artifactFactory.create(TEST_RING_OF_VITALITY.getName());
        Player aPlayer = new Player(Fraction.NECROPOLIS, 9);
        ArtifactShopCalculator aCalculator = new ArtifactShopCalculator();
        assertEquals(0, aCalculator.calculateMaxAmount(aPlayer.getGold(), artifact.getGrowth(), artifact.getGoldCost()));
    }

}