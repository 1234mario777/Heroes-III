package pl.sdk.converter.spells;

import pl.sdk.converter.SpellMasteries;
import pl.sdk.spells.*;

class SpecialSpellFactory extends SpellFactory {

    @Override
    AbstractSpell createInner(EconomySpell aEs, int aHeroPower, SpellMasteries aMasteries) {
        switch (aEs.getSpellStatistic()) {
            case DISPEL:
                switch (aMasteries.getWater()) {
                    case BASIC:
                        return new DispelSpell(SpellStatistic.TargetType.ALLY);
                    case ADVANCED:
                        return new DispelSpell(SpellStatistic.TargetType.CREATURE);
                    case MASTER:
                        return new DispelSpell(SpellStatistic.TargetType.ALL_CREATURES);
                    default:
                        throw new UnsupportedOperationException("Cannot recognize mastery level");
                }
            case TELEPORT:
                switch (aMasteries.getWater()) {
                    case BASIC:
                        return new TeleportSpell();
                    case ADVANCED:
                        return new TeleportSpell();
                    case MASTER:
                        return new TeleportSpell();
                    default:
                        throw new UnsupportedOperationException("Cannot recognize mastery level");
                }

            default:
                throw new UnsupportedOperationException("Cannot recognize spell");
        }
    }
}
