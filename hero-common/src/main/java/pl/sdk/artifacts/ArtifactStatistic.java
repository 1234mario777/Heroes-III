package pl.sdk.artifacts;


import static pl.sdk.artifacts.ArtifactSlot.*;

public enum ArtifactStatistic {

    RING_OF_VITALITY("Ring Of Vitality","Increases health of all your units by 1", FINGERS, 5000),
    SURCOAT_OF_COUNTERPOISE("Surcoat of Counterpoise", "+10% to magic resistance", SHOULDERS, 4000),
    ORB_OF_TEMPESTOUS_FIRE("Orb of Tempestuous Fire", "Hero's fire spells to extra 50% damage", MISCELLANEOUS, 6000),
    PENDANT_OF_LIFE("Pendant of Life", "Renders your units immune to the death ripple spell", NECK, 2500),
    BLACKSHARD_OF_THE_DEAD_KNIGHT("Blackshard of the Dead Knight", "+3 attack skill", RIGHT_HAND, 3000),
    SHIELD_OF_THE_YAWNING_DEAD("Shield of the Yawning Dead", "+3 defence skill", LEFT_HEAND, 3000),
    ARMOR_OF_WONDER("Armor of Wonder", "+1 to all 4 primary skills", TORSO, 4000),
    PENDANT_OF_COURAGE("Pendant of Courage", "+3 luck and morale", NECK, 7000),
    GOLDEN_BOW("Golden Bow", "Your troops can shoot at any distance through any obstacle without penalty", MISCELLANEOUS, 8000),
    COLLAR_OF_CONJURING("Collar of Conjuring", "Increases duration of all your spells by 1", NECK, 500),
    STATEMANS_MEDAL("Stateman's Medal", "reduces the cost of surrendering", NECK, 5000),
    RING_OF_THE_WAYFARER("Ring of the Wayfarer", "Increases the combat speed of all your units by 1", FINGERS, 5000),
    TOME_OF_AIR_MAGIC("Tome of Air Magic", "All air spells are available to hero when equipped", MISCELLANEOUS, 20000);

    ArtifactStatistic(String aName, String aDescription, ArtifactSlot aArtifactSlot, int aGoldCost) {
        name = aName;
        description = aDescription;
        artifactSlot = aArtifactSlot;
        goldCost = aGoldCost;
    }

    private final String name;
    private final String description;
    private final ArtifactSlot artifactSlot;
    private final int goldCost;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ArtifactSlot getArtifactSlot() {
        return artifactSlot;
    }

    int getGoldCost() {
        return goldCost;
    }
}

