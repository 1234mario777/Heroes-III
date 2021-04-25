package pl.sdk.converter.skills;

import pl.sdk.creatures.Creature;
import pl.sdk.hero.Player;
import pl.sdk.skills.SkillStatistic;
import pl.sdk.spells.BuffOrDebuffSpell;

import java.util.Objects;

public class BuffOrDebuffSkill extends AbstractSkill {

    private final BuffStatistic buffStats;
    private final SkillStatistic.TargetType targetType;

    public BuffOrDebuffSkill(String aName, SkillStatistic.TargetType aTargetType, BuffStatistic aSkillStats) {
        super(aName, aTargetType);
        buffStats = aSkillStats;
        targetType = aTargetType;
    }

    public BuffStatistic getBuffStats() { return buffStats; }

    @Override
    public SkillStatistic.TargetType getTargetType() {
        return targetType;
    }

    @Override
    void applyEffect(Player aPLayer,double aI) {
        aPLayer.getCreatures().stream().forEach(c ->{
            if(c.isArcher()){
                this.applyEffect(aPLayer,aI);
            }
        });
    }


    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
