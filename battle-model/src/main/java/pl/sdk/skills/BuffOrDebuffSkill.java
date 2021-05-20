package pl.sdk.skills;

import pl.sdk.Hero;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.CreatureDynamicStats;
import pl.sdk.spells.UpgradeCreatureStats;

import java.util.List;
import java.util.Objects;

public class BuffOrDebuffSkill extends AbstractSkill {

    private final UpgradeCreatureStats buffStats;
    private final SkillStatistic.TargetType targetType;

    public BuffOrDebuffSkill(String aName, SkillStatistic.TargetType aTargetType, UpgradeCreatureStats aSkillStats) {
        super(aName, aTargetType);
        buffStats = aSkillStats;
        targetType = aTargetType;
    }

    public UpgradeCreatureStats getBuffStats() { return buffStats; }

    @Override
    public SkillStatistic.TargetType getTargetType() {
        return targetType;
    }

    @Override
    public void applyEffect(Hero aHero) {
        aHero.getCreatures().stream().forEach(c ->{
            c.upgradeCreatureStatistics(buffStats);
        });
    }
    @Override
    public void applyEffect(List<Creature> aC) {
        aC.stream().forEach(c-> c.upgradeCreatureStatistics(buffStats));
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
