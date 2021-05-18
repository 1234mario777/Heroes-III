package pl.sdk.artifacts;

import java.util.ArrayList;
import java.util.List;

import static pl.sdk.artifacts.ArtifactStatistic.*;

public class EconomyArtifactFactory {

    private static final String EXCEPTION_MESSAGE = "Invalid artifact name";

    public EconomyArtifact create(String aName) {
        if (aName.equals(RING_OF_VITALITY.getName())) {
            return new EconomyArtifact(RING_OF_VITALITY);
        } else if (aName.equals(SURCOAT_OF_COUNTERPOISE.getName())) {
            return new EconomyArtifact(SURCOAT_OF_COUNTERPOISE);
        } else if (aName.equals(ORB_OF_TEMPESTOUS_FIRE.getName())) {
            return new EconomyArtifact(ORB_OF_TEMPESTOUS_FIRE);
        } else if (aName.equals(PENDANT_OF_LIFE.getName())) {
            return new EconomyArtifact(PENDANT_OF_LIFE);
        } else if (aName.equals(ARMOR_OF_WONDER.getName())) {
            return new EconomyArtifact(ARMOR_OF_WONDER);
        } else if (aName.equals(PENDANT_OF_COURAGE.getName())) {
            return new EconomyArtifact(PENDANT_OF_COURAGE);
        } else if (aName.equals(BLACKSHARD_OF_THE_DEAD_KNIGHT.getName())) {
            return new EconomyArtifact(BLACKSHARD_OF_THE_DEAD_KNIGHT);
        } else if (aName.equals(SHIELD_OF_THE_YAWNING_DEAD.getName())) {
            return new EconomyArtifact(SHIELD_OF_THE_YAWNING_DEAD);
        } else if (aName.equals(GOLDEN_BOW.getName())) {
            return new EconomyArtifact(GOLDEN_BOW);
        } else if (aName.equals(COLLAR_OF_CONJURING.getName())) {
            return new EconomyArtifact(COLLAR_OF_CONJURING);
        } else if (aName.equals(STATEMANS_MEDAL.getName())) {
            return new EconomyArtifact(STATEMANS_MEDAL);
        } else if (aName.equals(RING_OF_THE_WAYFARER.getName())) {
            return new EconomyArtifact(RING_OF_THE_WAYFARER);
        } else if (aName.equals(TOME_OF_AIR_MAGIC.getName())) {
            return new EconomyArtifact(TOME_OF_AIR_MAGIC);
        } else {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }

    public List<EconomyArtifact> getAllArtifacts() {
        List<EconomyArtifact> artifacts = new ArrayList<>();
        List.of(RING_OF_VITALITY.getName(),
                SURCOAT_OF_COUNTERPOISE.getName(),
                ORB_OF_TEMPESTOUS_FIRE.getName(),
                PENDANT_OF_LIFE.getName(),
                BLACKSHARD_OF_THE_DEAD_KNIGHT.getName(),
                SHIELD_OF_THE_YAWNING_DEAD.getName(),
                ARMOR_OF_WONDER.getName(),
                PENDANT_OF_COURAGE.getName(),
                GOLDEN_BOW.getName(),
                COLLAR_OF_CONJURING.getName(),
                STATEMANS_MEDAL.getName(),
                RING_OF_THE_WAYFARER.getName(),
                TOME_OF_AIR_MAGIC.getName())
                    .forEach(artifactName -> artifacts.add(create(artifactName)));
        return artifacts;
    }
}
