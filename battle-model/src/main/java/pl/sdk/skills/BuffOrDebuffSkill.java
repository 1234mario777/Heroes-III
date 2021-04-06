package pl.sdk.converter.skills;

import pl.sdk.skills.AbstractSkill;
import pl.sdk.skills.SkillStatistic;

import java.util.Objects;

public class BuffOrDebuffSkill extends AbstractSkill {

    public BuffOrDebuffSkill(SkillStatistic.TargetType aTargetType, String aName) {
        super(aTargetType,aName);
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
