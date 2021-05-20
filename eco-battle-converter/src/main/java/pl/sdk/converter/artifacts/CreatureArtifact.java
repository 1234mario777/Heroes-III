package pl.sdk.converter.artifacts;

import pl.sdk.Hero;
import pl.sdk.creatures.CreatureDynamicStats;
import pl.sdk.spells.UpgradeCreatureStats;


class CreatureArtifact extends AbstractArtifact{

    private final UpgradeCreatureStats upgradeStats;

    CreatureArtifact(String aName, UpgradeCreatureStats aUpgradeStats) {
        super(aName);
        upgradeStats = aUpgradeStats;
    }

    @Override
    public void apply(Hero aHero) {
        aHero.getCreatures().forEach(creature -> creature.upgradeCreatureStatistics(upgradeStats));
    }
}
