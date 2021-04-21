package pl.sdk.artifacts;

public enum ArtifactSlot {

    HEAD(1),
    NECK(1),
    TORSO(1),
    SHOULDERS(1),
    RIGHT_HAND(1),
    LEFT_HEAND(1),
    FINGERS(2),
    FEET(1),
    MISCELLANEOUS(4);

    ArtifactSlot(int aAmount) {
        amount = aAmount;
    }

    private int amount;

    public int getAmount() {
        return amount;
    }
}
