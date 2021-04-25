package pl.sdk.converter.skills;

import pl.sdk.hero.Player;
import pl.sdk.skills.SkillStatistic;

public abstract class AbstractSkill {

    protected final String name;
    protected final SkillStatistic.TargetType targetType;

    public AbstractSkill(String aName, SkillStatistic.TargetType aTargetType){
        targetType = aTargetType;
        name = aName;
    }

    SkillStatistic.TargetType getTargetType() { return targetType; }
    String getName() { return name; }
    abstract void applyEffect(Player aPlayer, double aIterator);
    @Override
    public String toString() { return "AbstractSkill{" + "name='" + name + '\'' + '}'; }
}
