package pl.sdk.skills;

import pl.sdk.creatures.EconomyCreature;
import pl.sdk.hero.Player;

public class CreatureEconomySkill extends AbstractEconomySkill {
    public CreatureEconomySkill(SkillStatistic aSkills) {
        super(aSkills);
    }

    @Override
    public void applyEffect(Player aPlayer){
       aPlayer.getCreatures().stream().forEach(c -> initSkills(c, this));
    }

    public void initSkills(EconomyCreature aC, CreatureEconomySkill aS){
            switch (aS.skillStatistic){
                case ARCHERY:
                    IncreaseRangeUnitDamage(aC);
                default:
                    throw new UnsupportedOperationException("not implement yet!");
            }
    }
    private void IncreaseRangeUnitDamage(EconomyCreature aC) {

    }

}
