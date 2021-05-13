package pl.sdk.converter.skills;

import pl.sdk.converter.SkillMasteries;
import pl.sdk.creatures.CreatureDynamicStats;
import pl.sdk.skills.AbstractSkill;
import pl.sdk.skills.BuffOrDebuffSkill;
import pl.sdk.skills.BuffStatistic;
import pl.sdk.skills.EconomySkill;

public class BuffOrDebuffSkillFactory extends SkillFactory {

    AbstractSkill createInner(EconomySkill aEs, SkillMasteries aSkillMasteries) {
        CreatureDynamicStats stats;
        switch (aEs.getSkillStatistic()) {
            case ARCHERY:
                switch (aSkillMasteries.get(aEs)) {
                    case BASIC:
                        stats = CreatureDynamicStats.builder().damagePercentage(0.1).build();
                        return new BuffOrDebuffSkill(aEs.getName(), aEs.getTargetType(), stats);
                    case ADVANCED:
                        stats = CreatureDynamicStats.builder().damagePercentage(0.2).build();
                        return new BuffOrDebuffSkill(aEs.getName(), aEs.getTargetType(), stats);
                    case EXPERT:
                        stats = CreatureDynamicStats.builder().damagePercentage(0.5).build();
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

