package pl.sdk.skills;

import pl.sdk.spells.*;

import java.util.List;

public abstract class AbstractEconomySkillFactory {
    private static final String INVALID_FACTORY_NAME = "Invalid spell type name";

    public static AbstractEconomySkillFactory getInstance(SpellFactoryType aFactory ) {
        switch (aFactory) {
            case ARCHERY:
                return new EconomySkillFactory();
            case TEST:
                return new EconomyTestSpellFactory();
            default:
                throw new IllegalArgumentException( INVALID_FACTORY_NAME );
        }
    }

    public abstract EconomySpell create(String aName );
}
