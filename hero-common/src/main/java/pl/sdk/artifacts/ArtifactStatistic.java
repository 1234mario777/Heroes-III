package pl.sdk.artifacts;


import static pl.sdk.artifacts.ArtifactSlot.*;
import static pl.sdk.artifacts.ArtifactStatistic.TargerType.*;

public enum ArtifactStatistic {

    RING_OF_VITALITY("Ring Of Vitality","Increases health of all your units by 1", FINGERS, 5000, CREATURE),
    SURCOAT_OF_COUNTERPOISE("Surcoat of Counterpoise", "+10% to magic resistance", SHOULDERS, 4000, CREATURE),
    ORB_OF_TEMPESTOUS_FIRE("Orb of Tempestuous Fire", "Hero's fire spells to extra 50% damage", MISCELLANEOUS, 6000, SPELL),
    PENDANT_OF_LIFE("Pendant of Life", "Renders your units immune to the death ripple spell", NECK, 2500, SPELL),
    BLACKSHARD_OF_THE_DEAD_KNIGHT("Blackshard of the Dead Knight", "+3 attack skill", RIGHT_HAND, 3000, HERO),
    SHIELD_OF_THE_YAWNING_DEAD("Shield of the Yawning Dead", "+3 defence skill", LEFT_HEAND, 3000, HERO),
    ARMOR_OF_WONDER("Armor of Wonder", "+1 to all 4 primary skills", TORSO, 4000, HERO),
    PENDANT_OF_COURAGE("Pendant of Courage", "+3 luck and morale", NECK, 7000, HERO),
    GOLDEN_BOW("Golden Bow", "Your troops can shoot at any distance through any obstacle without penalty", MISCELLANEOUS, 8000, CREATURE),
    COLLAR_OF_CONJURING("Collar of Conjuring", "Increases duration of all your spells by 1", NECK, 500, SPELL),
    STATEMANS_MEDAL("Stateman's Medal", "reduces the cost of surrendering", NECK, 5000, HERO),
    RING_OF_THE_WAYFARER("Ring of the Wayfarer", "Increases the combat speed of all your units by 1", FINGERS, 5000, CREATURE),
    TOME_OF_AIR_MAGIC("Tome of Air Magic", "All air spells are available to hero when equipped", MISCELLANEOUS, 20000, SPELL);

    public enum TargerType{
        CREATURE, HERO, SPELL;
    }

    ArtifactStatistic(String aName, String aDescription, ArtifactSlot aArtifactSlot, int aGoldCost, TargerType aTargerType) {
        name = aName;
        description = aDescription;
        artifactSlot = aArtifactSlot;
        goldCost = aGoldCost;
        targerType = aTargerType;
    }

    private final String name;
    private final String description;
    private final ArtifactSlot artifactSlot;
    private final int goldCost;
    private final TargerType targerType;

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

    public TargerType getTargerType() {
        return targerType;
    }
}

