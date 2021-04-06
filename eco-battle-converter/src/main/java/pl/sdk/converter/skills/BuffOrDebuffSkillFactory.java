package pl.sdk.converter.skills;

import pl.sdk.skills.AbstractSkill;
import pl.sdk.skills.BuffOrDebuffSkill;
import pl.sdk.skills.EconomySkill;
import pl.sdk.spells.BuffStatistic;

public class BuffOrDebuffSkillFactory extends SkillFactory{
    @Override
    AbstractSkill createInner(EconomySkill aEs){
        BuffStatistic stats;
        switch(aEs.getSkillStatistic()){
            case ARCHERY:
                return new BuffOrDebuffSkill(aEs.getTargetType(), aEs.getName(),aEs.getSkillType(),aEs.getEffect(), aEs.getSkillLevel());
            default:
                throw new UnsupportedOperationException("Cannot recognize skill");
        }
    }
}
