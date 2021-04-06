package pl.sdk.skills;

public abstract class AbstractSkill {
    protected final String name;
    private final SkillStatistic.TargetType targetType;
    private final SkillStatistic.SkillType skillType;
    private final Object effect;
    private final SkillStatistic.SkillLevel level;

    public AbstractSkill(SkillStatistic.TargetType aTargetType, String aName,SkillStatistic.SkillType aSkillType,Object aEffect, SkillStatistic.SkillLevel aLevel) {
        targetType = aTargetType;
        name = aName;
        skillType = aSkillType;
        effect = aEffect;
        level = aLevel;
    }

    public String getName() {
        return name;
    }

    public SkillStatistic.SkillLevel getLevel() { return level; }

    public SkillStatistic.SkillType getSkillType() {
        return skillType;
    }

    public Object getEffect() {
        return effect;
    }

    public SkillStatistic.TargetType getTargetType() {
        return targetType;
    }

}
