package pl.sdk.skills;

import pl.sdk.Hero;
import pl.sdk.creatures.Creature;

import java.util.List;

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
    public abstract void applyEffect(List<Creature> aCreatureList);
    public abstract void applyEffect(Creature aCreature);
    @Override
    public String toString() { return "AbstractSkill{" + "name='" + name + '\'' + '}'; }
}
