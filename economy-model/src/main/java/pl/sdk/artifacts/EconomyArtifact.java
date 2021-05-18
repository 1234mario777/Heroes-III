package pl.sdk.artifacts;


import pl.sdk.hero.EconomyShopIf;

public class EconomyArtifact implements EconomyShopIf {

    public static final int ARTIFACT_GROWTH = 1;

    private final ArtifactStatistic artifactStats;

    private final int goldCost;
    EconomyArtifact(ArtifactStatistic aArtifactStats) {
        artifactStats = aArtifactStats;
        goldCost = aArtifactStats.getGoldCost();
    }

    public int getGoldCost() {
        return goldCost;
    }

    public String getName() {
        return artifactStats.getName();
    }

    public int getGrowth() {
        return ARTIFACT_GROWTH;
    }

    public ArtifactStatistic getArtifactStats() {
        return artifactStats;
    }


}
