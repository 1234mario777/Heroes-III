package pl.sdk.skills;

import pl.sdk.Hero;

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
    public void applyEffect(Hero aHero) {
        aHero.getCreatures().stream().forEach(c ->{
            if(c.isArcher()){
//                c.applySkill(this,c);
            }
        });
    }


    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
