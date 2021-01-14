package pl.sdk.converter;

import pl.sdk.spells.AbstractSpell;
import pl.sdk.spells.EconomySpell;
import pl.sdk.spells.SummonSpell;

public class SummonSpellFactory {

    static AbstractSpell create(EconomySpell aEs, int aHeroPower) {
        switch (aEs.getSpellStatistic()) {
            case SUMMON_AIR_ELEMENTAL:
                return new SummonSpell(25, aHeroPower, 2 * aHeroPower, "Air Elemental", aEs.getElement());
            default:
                throw new UnsupportedOperationException("Cannot recognize spell");
        }
    }
}
