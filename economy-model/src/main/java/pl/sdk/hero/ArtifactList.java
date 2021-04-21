package pl.sdk.hero;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import pl.sdk.artifacts.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class ArtifactList {

    private Multimap<ArtifactSlot, EconomyArtifact> artifacts;

    public ArtifactList() {
        artifacts = ArrayListMultimap.create();
    }

    void add(EconomyArtifact aArtifact) {
        if (hasEmptySlot(aArtifact.getName())) {
            artifacts.put(aArtifact.getArtifactStats().getArtifactSlot(), aArtifact);
        } else {
            throw new IllegalStateException("There is no empty slot for this artifact");
        }
    }

    boolean contains(EconomyArtifact aArtifact) {
        return artifacts.containsValue(aArtifact);
    }

    void remove(EconomyArtifact aArtifact) {
        artifacts.remove(aArtifact.getArtifactStats().getArtifactSlot(), aArtifact);
    }

    List<EconomyArtifact> getArtifacts() {
        return artifacts.values().stream().collect(Collectors.toList());
    }

    boolean hasEmptySlot(String aArtifactName) {
        Optional<ArtifactSlot> slot = Stream.of(ArtifactStatistic.values())
                                .filter(as -> as.getName().equals(aArtifactName))
                                .map(as -> as.getArtifactSlot())
                                .findFirst();

        if (slot.isPresent()) {
            return hasEmptySlot(slot.get());
        } else {
            throw new IllegalArgumentException("Incorrect artifact name");
        }
    }

    private boolean hasEmptySlot(ArtifactSlot aSlot) {
        if (artifacts.containsKey(aSlot)) {
            return artifacts.get(aSlot).size() < aSlot.getAmount();
        }
        return true;
    }

}
