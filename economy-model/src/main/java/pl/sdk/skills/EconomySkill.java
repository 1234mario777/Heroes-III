package pl.sdk.skills;

public class EconomySkill {

    private final SkillStatistic skillStatistic;

    public EconomySkill(SkillStatistic aSkillStatistic){
        skillStatistic = aSkillStatistic;
    }

    String getName() {
        return skillStatistic.getName();
    }

    String getDescription(){
        return skillStatistic.getDescription();
    }

    Object getEffect(){
        return skillStatistic.getEffect();
    }
}
