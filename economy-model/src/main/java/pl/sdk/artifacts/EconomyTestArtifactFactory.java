package pl.sdk.artifacts;

import java.util.ArrayList;
import java.util.List;

import static pl.sdk.artifacts.ArtifactStatistic.*;

class EconomyTestArtifactFactory extends AbstractEconomyArtifactFactory {

    private static final String EXCEPTION_MESSAGE = "Invalid artifact name";

    @Override
    public EconomyArtifact create(String aName) {
        if (aName.equals(TEST_RING_OF_VITALITY.getName())) {
            return new EconomyArtifact(TEST_RING_OF_VITALITY);
        } else if (aName.equals(TEST_RING_OF_LIFE.getName())) {
            return new EconomyArtifact(TEST_RING_OF_LIFE);
        } else if (aName.equals(TEST_RING_OF_CONJURING.getName())) {
            return new EconomyArtifact(TEST_RING_OF_CONJURING);
        } else {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }

    @Override
    public List<EconomyArtifact> getAllArtifacts() {
        List<EconomyArtifact> artifacts = new ArrayList<>();
        List.of(TEST_RING_OF_VITALITY.getName(), TEST_RING_OF_LIFE.getName(), TEST_RING_OF_CONJURING.getName())
                .forEach(artifactName -> artifacts.add(create(artifactName)));
        return artifacts;
    }
}
