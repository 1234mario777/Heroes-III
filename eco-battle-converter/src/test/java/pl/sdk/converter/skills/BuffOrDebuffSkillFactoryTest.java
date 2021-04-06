package pl.sdk.converter.skills;

import org.junit.jupiter.api.Test;
import pl.sdk.skills.EconomySkill;
import pl.sdk.skills.SkillStatistic;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuffOrDebufSkillFactoryTest {
    @Test
    void shouldConvertArcherySkillCorrectly(){
        EconomySkill convert = new EconomySkill(SkillStatistic.ARCHERY);

        BuffOrDebuffSkill skill = (BuffOrDebuffSkill) new BuffOrDebuffSkillFactory().createInner(convert);

        assertEquals(SkillStatistic.TargetType.ALLIES,skill.getTargetType());
    }
}
