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
                            case BASIC: increaseHeroMorale(aPlayer,1);
                            case ADVANCED: increaseHeroMorale(aPlayer,2);
                            case EXPERT: increaseHeroMorale(aPlayer,3);
                        }
                    case LUCK:
                        switch (skillStatistic.getSkillLevel()){
                            case BASIC: increaseHeroLuck(aPlayer,1);
                            case ADVANCED: increaseHeroLuck(aPlayer,2);
                            case EXPERT: increaseHeroLuck(aPlayer,3);
                        }
                    case RESISTANCE:
                        switch (skillStatistic.getSkillLevel()){
                            case BASIC: increaseHeroChanceToSpellFail(aPlayer,0.05);
                            case ADVANCED: increaseHeroChanceToSpellFail(aPlayer,0.1);
                            case EXPERT: increaseHeroChanceToSpellFail(aPlayer,0.2);
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
    void increaseHeroMorale(Player aP, int aIncrease){

    }
    void increaseHeroLuck(Player aP, int aIncrease) {

    }
    void increaseHeroChanceToSpellFail(Player aP, double aIncrease){

    }
}
