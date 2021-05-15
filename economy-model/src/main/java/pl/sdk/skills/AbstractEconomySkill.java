package pl.sdk.skills;

import pl.sdk.creatures.EconomyCreature;
import pl.sdk.hero.Player;

import java.util.List;

public abstract class AbstractEconomySkill {

    public final SkillStatistic skillStatistic;

    public AbstractEconomySkill(SkillStatistic aSkillStatistic){ skillStatistic = aSkillStatistic; }
    public String getName() {return skillStatistic.getName(); }
    public String getDescription(){return skillStatistic.getDescription();}
    public SkillStatistic.TargetType getTargetType() { return skillStatistic.getTargetType(); }
    public SkillStatistic.SkillType getSkillType() { return skillStatistic.getSkillType(); }
    public SkillStatistic getSkillStatistic(){ return skillStatistic; }
    public SkillStatistic.SkillLevel getSkillLevel(){ return skillStatistic.getSkillLevel(); }

    public abstract void applyEffect(Player aPlayer);
}

