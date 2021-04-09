package pl.sdk.skills;

import pl.sdk.hero.Player;

public class HeroEconomySkill extends CreatureEconomySkill {
    public HeroEconomySkill(SkillStatistic aName) {
        super(aName);
    }

    @Override
    public void applyEffect(Player aPlayer) {
        switch (this.skillStatistic.getSkillType()){
            case BUFF:
            case DEBUFF:
                switch (skillStatistic){
                    case LEADERSHIP:
                        switch (skillStatistic.getSkillLevel()){
                            case BASIC: increseHeroStats(aPlayer,1);
                            case ADVANCED: increseHeroStats(aPlayer,2);
                            case EXPERT: increseHeroStats(aPlayer,3);
                        }
                    default:
                        throw new UnsupportedOperationException("not implement yet!");
                }
            case EFFECT:
                throw new UnsupportedOperationException("not implement yet!");
            default:
                throw new UnsupportedOperationException("not implement yet!");
        }
    }
    void increseHeroStats(Player aP, int aIncrease){

    }
}
