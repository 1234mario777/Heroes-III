package pl.sdk.skills;

import java.util.Objects;

public class BuffOrDebuffSkill extends AbstractSkill {

    public BuffOrDebuffSkill(SkillStatistic.TargetType aTargetType, String aName,SkillStatistic.SkillType aSkillType,Object aEffect,SkillStatistic.SkillLevel aLevel) {
        super(aTargetType,aName,aSkillType,aEffect,aLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public boolean equals(Object aO) {
        if (this == aO) return true;
        if (aO == null || getClass() != aO.getClass() || getName() == null) return false;
        BuffOrDebuffSkill that = (BuffOrDebuffSkill) aO;
        return getName().equals(that.getName());
    }
}
