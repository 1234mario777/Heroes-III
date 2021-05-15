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
                               case BASIC: IncreaseRangeUnitDamage(c,0.10);
                               case ADVANCED: IncreaseRangeUnitDamage(c,0.25);
                               case EXPERT: IncreaseRangeUnitDamage(c,0.5);
                           }
                       case OFFENCE:
                           switch (skillStatistic.getSkillLevel()){
                               case BASIC: IncreaseMeleeDamage(c,0.10);
                               case ADVANCED: IncreaseMeleeDamage(c,0.20);
                               case EXPERT: IncreaseMeleeDamage(c,0.30);
                           }
                       case ARMOURER:
                           switch (skillStatistic.getSkillLevel()){
                               case BASIC: ReduceTroopsTakenDamage(c,0.10);
                               case ADVANCED: ReduceTroopsTakenDamage(c,0.20);
                               case EXPERT: ReduceTroopsTakenDamage(c,0.30);
                           }
                       default:
                           throw new UnsupportedOperationException("not implement yet!");
                   }
           }
       });
    }

    private void IncreaseRangeUnitDamage(EconomyCreature aC, double aIncrease) {

    }
    private void IncreaseMeleeDamage(EconomyCreature aC, double aIncrease) {

    }
    private void ReduceTroopsTakenDamage(EconomyCreature aC, double aIncrease) {

    }
}
