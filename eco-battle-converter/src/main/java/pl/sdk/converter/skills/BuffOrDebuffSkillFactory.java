package pl.sdk.converter.skills;

import pl.sdk.converter.SkillMasteries;
import pl.sdk.creatures.CreatureDynamicStats;
import pl.sdk.skills.AbstractSkill;
import pl.sdk.skills.BuffOrDebuffSkill;
import pl.sdk.skills.BuffStatistic;
import pl.sdk.skills.EconomySkill;
import pl.sdk.spells.UpgradeCreatureStats;

public class BuffOrDebuffSkillFactory extends SkillFactory {

    AbstractSkill createInner(EconomySkill aEs, SkillMasteries aSkillMasteries) {
        UpgradeCreatureStats stats;
        switch (aEs.getSkillStatistic()) {
            case ARCHERY:
                switch (aSkillMasteries.get(aEs)) {
                    case BASIC:
                        stats = UpgradeCreatureStats.builder().damagePercentage(0.1).build();
                        return new BuffOrDebuffSkill(aEs.getName(), aEs.getTargetType(), stats);
                    case ADVANCED:
                        stats = UpgradeCreatureStats.builder().damagePercentage(0.2).build();
                        return new BuffOrDebuffSkill(aEs.getName(), aEs.getTargetType(), stats);
                    case EXPERT:
                        stats = UpgradeCreatureStats.builder().damagePercentage(0.5).build();
                        return new BuffOrDebuffSkill(aEs.getName(), aEs.getTargetType(), stats);
                }
            case OFFENCE:
                switch (aSkillMasteries.get(aEs)) {
                    case BASIC:
                        stats = UpgradeCreatureStats.builder().damagePercentage(0.1).build();
                        return new BuffOrDebuffSkill(aEs.getName(), aEs.getTargetType(), stats);
                    case ADVANCED:
                        stats = UpgradeCreatureStats.builder().damagePercentage(0.2).build();
                        return new BuffOrDebuffSkill(aEs.getName(), aEs.getTargetType(), stats);
                    case EXPERT:
                        stats = UpgradeCreatureStats.builder().damagePercentage(0.3).build();
                        return new BuffOrDebuffSkill(aEs.getName(), aEs.getTargetType(), stats);
                }
            case ARMOURER:
                switch (aSkillMasteries.get(aEs)) {
                    case BASIC:
                        stats = UpgradeCreatureStats.builder().armorPercentage(0.05).build();
                        return new BuffOrDebuffSkill(aEs.getName(), aEs.getTargetType(), stats);
                    case ADVANCED:
                        stats = UpgradeCreatureStats.builder().armorPercentage(0.1).build();
                        return new BuffOrDebuffSkill(aEs.getName(), aEs.getTargetType(), stats);
                    case EXPERT:
                        stats = UpgradeCreatureStats.builder().armorPercentage(0.15).build();
                        return new BuffOrDebuffSkill(aEs.getName(), aEs.getTargetType(), stats);
                }
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

