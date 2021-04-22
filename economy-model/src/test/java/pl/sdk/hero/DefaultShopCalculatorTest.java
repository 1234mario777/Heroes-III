package pl.sdk.hero;

import org.junit.jupiter.api.Test;
import pl.sdk.Fraction;
import pl.sdk.artifacts.*;

import static org.junit.jupiter.api.Assertions.*;
import static pl.sdk.artifacts.ArtifactStatistic.STATEMANS_MEDAL;

class DefaultShopCalculatorTest {

    private final EconomyArtifactFactory artifactFactory = new EconomyArtifactFactory();
    EconomyArtifact artifact;


    @Test
    void shouldReturn1IfPlayerCanAffordToFewArtifactsPurchase() {
        artifact = artifactFactory.create(STATEMANS_MEDAL.getName());
        Player aPlayer = new Player(Fraction.NECROPOLIS, 10000);
        DefaultShopCalculator aCalculator = new DefaultShopCalculator();
        assertEquals(1, aCalculator.calculateMaxAmount(aPlayer.getGold(), artifact.getGrowth(), artifact.getGoldCost()));
    }

    @Test
    void shouldReturn1IfPlayerCanAffordToExactlyOneArtifactPurchase() {
        artifact = artifactFactory.create(STATEMANS_MEDAL.getName());
        Player aPlayer = new Player(Fraction.NECROPOLIS, 5000);
        DefaultShopCalculator aCalculator = new DefaultShopCalculator();
        assertEquals(1, aCalculator.calculateMaxAmount(aPlayer.getGold(), artifact.getGrowth(), artifact.getGoldCost()));
    }

    @Test
    void shouldReturn0IfPlayerCanNotAffordToArtifactPurchase() {
        artifact = artifactFactory.create(STATEMANS_MEDAL.getName());
        Player aPlayer = new Player(Fraction.NECROPOLIS, 4000);
        DefaultShopCalculator aCalculator = new DefaultShopCalculator();
        assertEquals(0, aCalculator.calculateMaxAmount(aPlayer.getGold(), artifact.getGrowth(), artifact.getGoldCost()));
    }

}