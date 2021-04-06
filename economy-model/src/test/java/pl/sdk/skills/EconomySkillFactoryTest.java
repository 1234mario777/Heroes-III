package pl.sdk.skills;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EconomySkillFactoryTest {

    public static final String ARCHERY = "Archery";

    @Test
    void factoryShouldCreateSpellNameCorrectly()
    {
        EconomySkill skill = AbstractEconomySkillFactory.getInstance(SkillFactoryType.DEFAULT).create(SkillStatistic.ARCHERY);
        assertEquals( ARCHERY, skill.getName() );
    }
}
