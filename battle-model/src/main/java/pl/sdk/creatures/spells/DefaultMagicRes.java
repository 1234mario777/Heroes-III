package pl.sdk.creatures.spells;

public class DefaultMagicRes implements MagicResistanceContextIf{

    private final int percentageSpellResistance;

    DefaultMagicRes() {
        percentageSpellResistance = 0;
    }

    DefaultMagicRes(int aPercentageSpellResistance) {
        percentageSpellResistance = aPercentageSpellResistance;
    }

    @Override
    public int reduceMagicDamageDamage(int aDamage) {
        return (int) (aDamage * ((100-percentageSpellResistance) / 100.0));
    }
}
