package pl.sdk.converter.skills;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.converter.SkillMasteries;
import pl.sdk.skills.BuffOrDebuffSkill;
import pl.sdk.hero.Player;
import pl.sdk.skills.EconomySkill;
import pl.sdk.skills.EconomySkillFactory;
import pl.sdk.skills.SkillStatistic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pl.sdk.Fraction.NECROPOLIS;

public class BuffOrDebuffSkillFactoryTest {
    public static final String ARCHERY = "Archery";
    private EconomySkill skill;
    private Player player;

    @BeforeEach
    void init(){
        skill = new EconomySkillFactory().create(SkillStatistic.ARCHERY);
        player = new Player(NECROPOLIS, 3000);
    }
    @Test
    void shouldConvertArcherySkillCorrectly(){
        BuffOrDebuffSkill convSkill = (BuffOrDebuffSkill) new BuffOrDebuffSkillFactory().createInner(skill, new SkillMasteries(skill, SkillStatistic.SkillLevel.BASIC));
        assertEquals(SkillStatistic.TargetType.ALLIES, convSkill.getTargetType());
    }
    @Test
    void shouldReturnEconomySkillList(){
        player.buySkill(player,skill);
        assertEquals(player.getSkillList().get(0),skill);
    }

}
