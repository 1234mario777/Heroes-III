package pl.sdk.creatures.spells;


public class DefaultMagicRes implements MagicResistanceContextIf{

    private MagicResStatistic stats;

    DefaultMagicRes(MagicResStatistic aMagicResStatistic) {
        stats = aMagicResStatistic;
    }

    @Override
    public int reduceMagicDamageDamage(int aDamage) {
        return (int) (aDamage * (1 - stats.getPercentageSpellResistance()));
    }

    @Override
    public MagicResStatistic getMagicResStatistic() {
        return stats;
    }

}
