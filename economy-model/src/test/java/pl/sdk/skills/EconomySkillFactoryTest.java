package pl.sdk.skills;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.creatures.EconomyCreature;
import pl.sdk.creatures.EconomyNecropolisFactory;
import pl.sdk.creatures.EconomyTestFractionFactory;
import pl.sdk.hero.Player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pl.sdk.Fraction.NECROPOLIS;

public class EconomySkillFactoryTest {

    public static final String ARCHERY = "Archery";
    private EconomySkill skill;

    @BeforeEach
    void init(){ skill = new EconomySkillFactory().create(SkillStatistic.ARCHERY); }
    @Test
    void factoryShouldCreateSpellNameCorrectly()
    {
        assertEquals( ARCHERY, skill.getName() );
    }
}
