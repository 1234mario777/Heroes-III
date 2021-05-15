package pl.sdk.skills;

import pl.sdk.Hero;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.CreatureDynamicStats;

import java.util.List;
import java.util.Objects;

public class BuffOrDebuffSkill extends AbstractSkill {

    private final CreatureDynamicStats buffStats;
    private final SkillStatistic.TargetType targetType;

    public BuffOrDebuffSkill(String aName, SkillStatistic.TargetType aTargetType, CreatureDynamicStats aSkillStats) {
        super(aName, aTargetType);
        buffStats = aSkillStats;
        targetType = aTargetType;
    }

    public CreatureDynamicStats getBuffStats() { return buffStats; }

    @Override
    public SkillStatistic.TargetType getTargetType() {
        return targetType;
    }

    @Override
    public void applyEffect(Hero aHero) {
//        aHero.getCreatures().stream().forEach(c ->{
//            if(c.isArcher()){
//                c.increaseDamagePercentage(buffStats.getAttackPercentage());
//            }
//        });
    }
    @Override
    public void applyEffect(List<Creature> aC) {
        aC.stream().forEach(c-> c.increaseStat(buffStats));
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
