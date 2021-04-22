package pl.sdk.skills;

import java.util.ArrayList;
import java.util.List;

public class EconomySkillFactory {
    private static final String EXCEPTION_MESSAGE = "Invalid skill name";

    public EconomySkill create(SkillStatistic aName) {
        switch (aName.getTargetType()){
            case ALL_ENEMIES:
            case ALLIES:
                return new EconomySkill(new CreatureEconomySkill(aName));
            case ENEMY_HERO: //Uwazaj aby nie dac debafow na bohatera ze skillem
            case HERO:
                return new EconomySkill(new HeroEconomySkill(aName));
            default:
                throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }


    public List<EconomySkill> getAllSkills(){
        List<EconomySkill> skillList = new ArrayList<>();
        List.of( SkillStatistic.ARCHERY, SkillStatistic.OFFENCE, SkillStatistic.ARMOURER, SkillStatistic.LEADERSHIP,SkillStatistic.RESISTANCE,SkillStatistic.LUCK)
                .forEach( skillName -> skillList.add( create( skillName ) ) );
        return skillList;
    }
}
