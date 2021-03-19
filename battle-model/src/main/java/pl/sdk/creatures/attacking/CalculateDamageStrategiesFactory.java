package pl.sdk.creatures.attacking;

public class CalculateDamageStrategiesFactory {

    public enum Type{
        DEFAULT
    }

    public static CalculateDamageStrategyIf create(CalculateDamageStrategiesFactory.Type aType){
        return new DefaultCalculateStrategy();
    }
}
