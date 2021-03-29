package pl.sdk.skills;

import pl.sdk.spells.*;

import java.util.List;

public abstract class AbstractEconomySkillFactory {
    private static final String INVALID_FACTORY_NAME = "Invalid spell type name";

    public static AbstractEconomySkillFactory getInstance(SkillStatistic aSkill ) {
        switch (aSkill) {
            case ARCHERY:
                return new EconomySkillFactory();
            case TEST:
                return new EconomyTestSkillFactory();
            default:
                throw new IllegalArgumentException( INVALID_FACTORY_NAME );
        }
    }

    public abstract EconomySpell create(String aName );
}
