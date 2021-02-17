package pl.sdk.creatures;

public class DefaultMagicDamageReducer {

    private final int percentageSpellResistance;

    DefaultMagicDamageReducer() {
        percentageSpellResistance = 0;
    }

    DefaultMagicDamageReducer(int aPercentageSpellResistance) {
        percentageSpellResistance = aPercentageSpellResistance;
    }

    int reduceDamage(int aDamage) {
        return (int) (aDamage * ((100-percentageSpellResistance) / 100.0));
    }
}
