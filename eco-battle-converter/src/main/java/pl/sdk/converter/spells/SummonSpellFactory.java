package pl.sdk.converter.spells;

import pl.sdk.converter.SpellMasteries;
import pl.sdk.spells.AbstractSpell;
import pl.sdk.spells.EconomySpell;
import pl.sdk.spells.SummonSpell;

class SummonSpellFactory extends SpellFactory {

    @Override
    AbstractSpell createInner(EconomySpell aEs, int aHeroPower, SpellMasteries aMasteries) {
        switch (aEs.getSpellStatistic()) {
            case SUMMON_AIR_ELEMENTAL:
                switch (aMasteries.getAir()) {
                    case BASIC:
                        return new SummonSpell(25, aHeroPower, 2 * aHeroPower, "Air Elemental", aEs.getElement());
                    case ADVANCED:
                        return new SummonSpell(25, aHeroPower, 3 * aHeroPower, "Air Elemental", aEs.getElement());
                    case MASTER:
                        return new SummonSpell(25, aHeroPower, 4 * aHeroPower, "Air Elemental", aEs.getElement());
                    default:
                        throw new UnsupportedOperationException("Cannot recognize mastery level");
                }
            default:
                throw new UnsupportedOperationException("Cannot recognize spell");
        }
    }
}
