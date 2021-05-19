package pl.sdk.converter.artifacts;

import pl.sdk.artifacts.EconomyArtifact;
import pl.sdk.creatures.CreatureDynamicStats;
import pl.sdk.spells.UpgradeCreatureStats;

class CreatureArtifactFactory extends ArtifactFactory{

    @Override
    AbstractArtifact createInner(EconomyArtifact aEconomyArtifact) {
        switch (aEconomyArtifact.getArtifactStats()) {
            case RING_OF_VITALITY:
                return new CreatureArtifact(aEconomyArtifact.getArtifactStats().getName(), UpgradeCreatureStats.builder().maxHp(1).build());
            case RING_OF_THE_WAYFARER:
                return new CreatureArtifact(aEconomyArtifact.getArtifactStats().getName(), UpgradeCreatureStats.builder().moveRange(1).build());
            case SURCOAT_OF_COUNTERPOISE:
                return new CreatureArtifact(aEconomyArtifact.getArtifactStats().getName(), UpgradeCreatureStats.builder().magicResistancePercentage(0.1).build());
            case GOLDEN_BOW:
                return new CreatureArtifact(aEconomyArtifact.getArtifactStats().getName(), UpgradeCreatureStats.builder().shootingThroughObstacle(true).build());
            default:
                throw new UnsupportedOperationException("Cannot recognize artifact");
        }
    }
}
