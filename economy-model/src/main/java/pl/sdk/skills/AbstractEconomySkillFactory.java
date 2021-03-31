package pl.sdk.skills;

import pl.sdk.spells.*;

import java.util.List;

public abstract class AbstractEconomySkillFactory {
    private static final String INVALID_FACTORY_NAME = "Invalid skill type name";

    public static AbstractEconomySkillFactory getInstance(SkillStatistic aSkill ) {
        switch (aSkill) {
            case ARCHERY:
                return new EconomySkillFactory();
            default:
                throw new IllegalArgumentException( INVALID_FACTORY_NAME );
        }
    }

    public abstract EconomySkill create(String aName );
}
