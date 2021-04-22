package pl.sdk.skills;

import pl.sdk.spells.BuffOrDebuffSpell;

import java.util.Objects;

public class BuffOrDebuffSkill extends AbstractSkill {

    private final BuffStatistic buffStats;
    private final SkillStatistic.TargetType targetType;

    public BuffOrDebuffSkill(String aName, SkillStatistic.TargetType aTargetType, BuffStatistic aSkillStats) {
        super(aName, aTargetType);
        buffStats = aSkillStats;
        targetType = aTargetType;
    }

    public BuffStatistic getBuffStats() { return buffStats; }

    @Override
    public SkillStatistic.TargetType getTargetType() {
        return targetType;
    }

    @Override
    public boolean equals(Object aO) {
        if (this == aO) return true;
        if (aO == null || getClass() != aO.getClass() || getName() == null) return false;
        BuffOrDebuffSpell that = (BuffOrDebuffSpell) aO;
        return getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
