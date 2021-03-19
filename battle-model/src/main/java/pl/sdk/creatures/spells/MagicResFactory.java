package pl.sdk.creatures.spells;

public class MagicResFactory {

    public static MagicResistanceContextIf create (int aMagicResistance){
        return new DefaultMagicRes(aMagicResistance);
    }
}
