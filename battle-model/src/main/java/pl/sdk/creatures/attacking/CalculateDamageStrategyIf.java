package pl.sdk.creatures.attacking;

import pl.sdk.creatures.defending.DefenceContextIf;

public interface CalculateDamageStrategyIf {

    enum TYPE{
        DEFAULT,
    };

    static CalculateDamageStrategyIf create(TYPE aType){
        switch (aType){
            case defaultStrategy:
                new DefaultCalculateStrategy();
            default:
                throw new IllegalArgumentException("");
        }
    }

    int calculateDamage(AttackContextIf attacker, DefenceContextIf aDefender);
}
