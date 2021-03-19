package pl.sdk.creatures.attacking;

public interface CalculateDamageStrategyIf {

    enum TYPE{
        DEFAULT,
    };

    static CalculateDamageStrategyIf create(TYPE aType){
        switch (aType){
            case DEFAULT:
                return new DefaultCalculateStrategy();
            default:
                throw new IllegalArgumentException("");
        }
    }

    int calculateDamage(AttackerStatisticIf aAttackerStats, int aDefenderArmor);
}
