package pl.sdk.converter.artifacts;

import pl.sdk.artifacts.EconomyArtifact;

public abstract class ArtifactFactory {

    public static AbstractArtifact create(EconomyArtifact aEconomyArtifact) {
        switch (aEconomyArtifact.getArtifactStats().getTargerType()) {
            case CREATURE:
                return new CreatureArtifactFactory().createInner(aEconomyArtifact);
            case HERO:
                throw new UnsupportedOperationException("Not implemented yet artifact target type" + aEconomyArtifact.getArtifactStats().getTargerType());
            case SPELL:
                throw new UnsupportedOperationException("Not implemented yet artifact target type" + aEconomyArtifact.getArtifactStats().getTargerType());
            default:
                throw new UnsupportedOperationException("Cannot recognize artifact target type " + aEconomyArtifact.getArtifactStats().getTargerType());
        }
    }

    abstract AbstractArtifact createInner(EconomyArtifact aEconomyArtifact);
}
