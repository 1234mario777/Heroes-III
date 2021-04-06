package pl.sdk.converter.skills;

import pl.sdk.skills.AbstractSkill;
import pl.sdk.skills.EconomySkill;
import pl.sdk.spells.BuffStatistic;

public class BuffOrDebuffSkillTypeFactory extends SkillFactory{
    @Override
    AbstractSkill createInner(EconomySkill aEs){
        BuffStatistic stats;
        switch(aEs.getSkillStatistic()){
            case ARCHERY:
                return new BuffOrDebuffSkill(aEs.getTargetType(), aEs.getName());
            default:
                throw new UnsupportedOperationException("Cannot recognize skill");
        }
    }
}
