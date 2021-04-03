package pl.sdk.converter.skills;

import pl.sdk.skills.AbstractSkill;
import pl.sdk.skills.EconomySkill;

public abstract class SkillFactory {
    public static AbstractSkill create(EconomySkill aEs){
        switch (aEs.getSkillType()){
            case BUFF:
                return new BuffOrDebuffSkillTypeFactory().createInner(aEs);
            case DEBUFF:
                return new BuffOrDebuffSkillTypeFactory().createInner(aEs);
//            case EFFECT:
//                return  new EffectSkillFactory().createInner(aEs);
            case MAP_CHANGE:
                throw new UnsupportedOperationException("not implemented YET: " + aEs.getSkillType());
            default:
                throw new UnsupportedOperationException("Cannot recognize type: " + aEs.getSkillType());

        }
    }
    abstract AbstractSkill createInner(EconomySkill aType);
}
