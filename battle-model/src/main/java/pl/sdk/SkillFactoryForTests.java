package pl.sdk;

import pl.sdk.skills.BuffOrDebuffSkill;
import pl.sdk.skills.SkillStatistic;

public class SkillFactoryForTests {

    public static BuffOrDebuffSkill createArchery(){
        return new BuffOrDebuffSkill(SkillStatistic.TargetType.ALLIES,"ARCHERY",SkillStatistic.SkillType.BUFF,SkillStatistic.ARCHERY.getEffect(), SkillStatistic.SkillLevel.BASIC);
    }
}
