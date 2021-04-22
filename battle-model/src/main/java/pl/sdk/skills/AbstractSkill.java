package pl.sdk.skills;

public abstract class AbstractSkill {

    protected final String name;
    protected final SkillStatistic.TargetType targetType;

    public AbstractSkill(String aName, SkillStatistic.TargetType aTargetType){
        targetType = aTargetType;
        name = aName;
    }

    SkillStatistic.TargetType getTargetType() { return targetType; }
    String getName() { return name; }

    @Override
    public String toString() { return "AbstractSkill{" + "name='" + name + '\'' + '}'; }
}
