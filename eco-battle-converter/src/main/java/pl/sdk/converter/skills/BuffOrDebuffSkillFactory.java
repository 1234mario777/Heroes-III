package pl.sdk.converter.skills;

import pl.sdk.converter.SkillMasteries;
import pl.sdk.creatures.skills.AbstractSkill;
import pl.sdk.creatures.skills.BuffOrDebuffSkill;
import pl.sdk.creatures.skills.BuffStatistic;
import pl.sdk.skills.*;

public class BuffOrDebuffSkillFactory extends SkillFactory {

    AbstractSkill createInner(EconomySkill aEs, SkillMasteries aSkillMasteries) {
        BuffStatistic stats;
        switch (aEs.getSkillStatistic()) {
            case ARCHERY:
                switch (aSkillMasteries.get(aEs)) {
                    case BASIC:
                        stats = BuffStatistic.builder().attackPercentage(0.1).build();
                        return new BuffOrDebuffSkill(aEs.getName(), aEs.getTargetType(), stats);
                    case ADVANCED:
                        stats = BuffStatistic.builder().attackPercentage(0.2).build();
                        return new BuffOrDebuffSkill(aEs.getName(), aEs.getTargetType(), stats);
                    case EXPERT:
                        stats = BuffStatistic.builder().attackPercentage(0.5).build();
                        return new BuffOrDebuffSkill(aEs.getName(), aEs.getTargetType(), stats);
                }
            case OFFENCE:
                break;
            case ARMOURER:
                break;
            case LEADERSHIP:
                break;
            case RESISTANCE:
                break;
            case LUCK:
                break;
            default:
                throw new UnsupportedOperationException("Cannot recognize mastery level");
        }
        return null;
    }
}

