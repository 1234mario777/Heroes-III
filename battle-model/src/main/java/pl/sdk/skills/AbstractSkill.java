package pl.sdk.skills;

import pl.sdk.Hero;

public abstract class AbstractSkill {

    protected final String name;
    protected final SkillStatistic.TargetType targetType;

    public AbstractSkill(String aName, SkillStatistic.TargetType aTargetType){
        targetType = aTargetType;
        name = aName;
    }

    SkillStatistic.TargetType getTargetType() { return targetType; }
    String getName() { return name; }
    public abstract void applyEffect(Hero aHero);
    @Override
    public String toString() { return "AbstractSkill{" + "name='" + name + '\'' + '}'; }
}
