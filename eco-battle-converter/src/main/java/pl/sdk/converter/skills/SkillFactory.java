package pl.sdk.converter.skills;

import pl.sdk.skills.AbstractEconomySkill;

public abstract class SkillFactory {
    public static AbstractSkill create(AbstractEconomySkill aEs){
        switch (aEs.getSkillType()){
            case BUFF:
                return new BuffOrDebuffSkillFactory().createInner(aEs);
            case DEBUFF:
                return new BuffOrDebuffSkillFactory().createInner(aEs);
//            case EFFECT:
//                return  new EffectSkillFactory().createInner(aEs);
            case MAP_CHANGE:
                throw new UnsupportedOperationException("not implemented YET: " + aEs.getSkillType());
            default:
                throw new UnsupportedOperationException("Cannot recognize type: " + aEs.getSkillType());

        }
    }
    abstract AbstractSkill createInner(AbstractEconomySkill aType);
}
