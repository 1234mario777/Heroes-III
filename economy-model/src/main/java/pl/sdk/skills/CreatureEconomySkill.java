package pl.sdk.skills;

import pl.sdk.creatures.EconomyCreature;
import pl.sdk.hero.Player;

public class CreatureEconomySkill extends AbstractEconomySkill {
    public CreatureEconomySkill(SkillStatistic aSkills) {
        super(aSkills);
    }

    @Override
    public void applyEffect(Player aPlayer){
       aPlayer.getCreatures().stream()
               .forEach(c -> {
           switch (skillStatistic.getSkillType()){
               case DEBUFF:
               case BUFF:
                   switch (skillStatistic){
                       case ARCHERY:
                           switch (skillStatistic.getSkillLevel()){
                               case BASIC: increaseRangeUnitDamage(c,0.10);
                               case ADVANCED: increaseRangeUnitDamage(c,0.25);
                               case EXPERT: increaseRangeUnitDamage(c,0.5);
                           }
                       case OFFENCE:
                           switch (skillStatistic.getSkillLevel()){
                               case BASIC: increaseMeleeDamage(c,0.10);
                               case ADVANCED: increaseMeleeDamage(c,0.20);
                               case EXPERT: increaseMeleeDamage(c,0.30);
                           }
                       case ARMOURER:
                           switch (skillStatistic.getSkillLevel()){
                               case BASIC: reduceTroopsTakenDamage(c,0.10);
                               case ADVANCED: reduceTroopsTakenDamage(c,0.20);
                               case EXPERT: reduceTroopsTakenDamage(c,0.30);
                           }
                       default:
                           throw new UnsupportedOperationException("not implement yet!");
                   }
           }
       });
    }

    private void increaseRangeUnitDamage(EconomyCreature aC, double aIncrease) {
    }
    private void increaseMeleeDamage(EconomyCreature aC, double aIncrease) {

    }
    private void reduceTroopsTakenDamage(EconomyCreature aC, double aIncrease) {

    }
}
