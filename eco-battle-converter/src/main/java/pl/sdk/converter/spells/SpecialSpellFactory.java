package pl.sdk.converter.spells;

import pl.sdk.converter.SpellMasteries;
import pl.sdk.spells.*;

class SpecialSpellFactory extends SpellFactory {

    @Override
    AbstractSpell createInner(EconomySpell aEs, int aHeroPower, SpellMasteries aMasteries) {
        switch (aEs.getSpellStatistic()) {
            case DISPEL:
                return new DispelSpell();
            case TELEPORT:
                return new TeleportSpell();
            default: throw new UnsupportedOperationException("Cannot recognize spell");
        }
    }
}
