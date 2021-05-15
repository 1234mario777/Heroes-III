package pl.sdk.converter.spells;

import pl.sdk.spells.AbstractSpell;
import pl.sdk.converter.SpellMasteries;
import pl.sdk.spells.*;

class BuffOrDebuffSpellFactory extends SpellFactory {

    @Override
    AbstractSpell createInner(EconomySpell aEs, int aHeroPower, SpellMasteries aMasteries) {
        UpgradeCreatureStats stats;
        switch (aEs.getSpellStatistic()) {
            case HASTE:
                switch (aMasteries.getAir()) {
                    case BASIC:
                        stats = UpgradeCreatureStats.builder().moveRange(3 ).build();
                        return new BuffOrDebuffSpell(aEs.getManaCost(), aHeroPower, aEs.getElement(), SpellStatistic.TargetType.ALLY, aEs.getName(), stats);
                    case ADVANCED:
                        stats = UpgradeCreatureStats.builder().moveRange(5 ).build();
                        return new BuffOrDebuffSpell(aEs.getManaCost(), aHeroPower, aEs.getElement(), SpellStatistic.TargetType.ALLY, aEs.getName(), stats);
                    case MASTER:
                        stats = UpgradeCreatureStats.builder().moveRange(5 ).build();
                        return new BuffOrDebuffSpell(aEs.getManaCost(), aHeroPower, aEs.getElement(), SpellStatistic.TargetType.ALL_ALLIES, aEs.getName(), stats);
                    default:
                        throw new UnsupportedOperationException("Cannot recognize mastery level");
                }
            case SLOW:
                switch (aMasteries.getEarth()) {
                    case BASIC:
                        stats = UpgradeCreatureStats.builder().moveRangePercentage(-0.25 ).build();
                        return new BuffOrDebuffSpell(aEs.getManaCost(), aHeroPower, aEs.getElement(), SpellStatistic.TargetType.ENEMY, aEs.getName(), stats);
                    case ADVANCED:
                        stats = UpgradeCreatureStats.builder().moveRangePercentage(-0.5 ).build();
                        return new BuffOrDebuffSpell(aEs.getManaCost(), aHeroPower, aEs.getElement(), SpellStatistic.TargetType.ENEMY, aEs.getName(), stats);
                    case MASTER:
                        stats = UpgradeCreatureStats.builder().moveRangePercentage(-0.5 ).build();
                        return new BuffOrDebuffSpell(aEs.getManaCost(), aHeroPower, aEs.getElement(), SpellStatistic.TargetType.ALL_ENEMIES, aEs.getName(), stats);
                    default:
                        throw new UnsupportedOperationException("Cannot recognize mastery level");
                }
            default:
                throw new UnsupportedOperationException("Cannot recognize spell");
        }
    }
}
