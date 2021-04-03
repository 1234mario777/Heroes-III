package pl.sdk.skills;

public abstract class AbstractSkill {
    protected final String name;
    private final SkillStatistic.TargetType targetType;

    public AbstractSkill(SkillStatistic.TargetType aTargetType, String aName) {
        targetType = aTargetType;
        name = aName;
    }

    public String getName() {
        return name;
    }

    SkillStatistic.TargetType getTargetType() {
        return targetType;
    }

}
