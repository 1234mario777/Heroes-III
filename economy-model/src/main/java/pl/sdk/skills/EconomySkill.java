package pl.sdk.skills;

import pl.sdk.creatures.EconomyCreature;

import java.util.List;

public class EconomySkill {

    public final SkillStatistic skillStatistic;

    public EconomySkill(SkillStatistic aSkillStatistic){
        skillStatistic = aSkillStatistic;
    }

    public String getName() {
        return skillStatistic.getName();
    }
    public String getDescription(){return skillStatistic.getDescription();}
    public SkillStatistic.TargetType getTargetType() { return skillStatistic.getTargetType(); }
    public SkillStatistic.SkillType getSkillType() { return skillStatistic.getSkillType(); }
    public Object getEffect(){
        return skillStatistic.getEffect();
    }
    public SkillStatistic getSkillStatistic(){ return skillStatistic; }
    public SkillStatistic.SkillLevel getSkillLevel(){ return skillStatistic.getSkillLevel(); }

    public void applyEffect(List<EconomyCreature> aCreatures) {
        skillStatistic.getEffect().apply(aCreatures);
    }
}

