package pl.sdk.converter.spells;

import pl.sdk.spells.AbstractSpell;
import pl.sdk.converter.SpellMasteries;
import pl.sdk.spells.*;

class SpecialSpellFactory extends SpellFactory {

    @Override
    AbstractSpell createInner(EconomySpell aEs, int aHeroPower, SpellMasteries aMasteries) {
        switch (aEs.getSpellStatistic()) {
            case DISPEL:
                switch (aMasteries.getWater()) {
                    case BASIC:
                        return new DispelSpell(SpellStatistic.TargetType.ALLY, aEs.getName());
                    case ADVANCED:
                        return new DispelSpell(SpellStatistic.TargetType.CREATURE, aEs.getName());
                    case MASTER:
                        return new DispelSpell(SpellStatistic.TargetType.ALL_CREATURES, aEs.getName());
                    default:
                        throw new UnsupportedOperationException("Cannot recognize mastery level");
                }
            case TELEPORT:
                switch (aMasteries.getWater()) {
                    case BASIC:
                        return new TeleportSpell(aEs.getName());
                    case ADVANCED:
                        return new TeleportSpell(aEs.getName());
                    case MASTER:
                        return new TeleportSpell(aEs.getName());
                    default:
                        throw new UnsupportedOperationException("Cannot recognize mastery level");
                }

            default:
                throw new UnsupportedOperationException("Cannot recognize spell");
        }
    }
}
