package pl.sdk.converter.skills;

import pl.sdk.skills.AbstractEconomySkill;
import pl.sdk.spells.BuffStatistic;

public class BuffOrDebuffSkillFactory extends SkillFactory{
    @Override
    AbstractSkill createInner(AbstractEconomySkill aEs){
        BuffStatistic stats;
        switch(aEs.getSkillStatistic()){
            case ARCHERY:
                return new BuffOrDebuffSkill(aEs.getTargetType(), aEs.getName(),aEs.getSkillType(),aEs.getEffect(), aEs.getSkillLevel());
            default:
                throw new UnsupportedOperationException("Cannot recognize skill");
        }
    }
}
