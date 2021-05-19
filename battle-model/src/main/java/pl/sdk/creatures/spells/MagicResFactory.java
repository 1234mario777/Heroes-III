package pl.sdk.creatures.spells;

public class MagicResFactory {

    public static MagicResistanceContextIf create (MagicResStatistic aMagicResistance){
        return new DefaultMagicRes(aMagicResistance);
    }
}
