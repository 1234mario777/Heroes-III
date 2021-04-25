package pl.sdk.converter.skills;

import pl.sdk.converter.SkillMasteries;
import pl.sdk.creatures.skills.AbstractSkill;
import pl.sdk.skills.EconomySkill;

public abstract class SkillFactory {

    public static AbstractSkill create(EconomySkill aEs, SkillMasteries aMasteries){
        switch(aEs.getSkillType()){
            case BUFF:
            case DEBUFF:
                return new BuffOrDebuffSkillFactory().createInner(aEs, aMasteries);
            default:
                throw new UnsupportedOperationException("Cannot recognize type: " + aEs.getSkillType());
        }
    }
    abstract AbstractSkill createInner(EconomySkill aEs, SkillMasteries aMasteries);

}
