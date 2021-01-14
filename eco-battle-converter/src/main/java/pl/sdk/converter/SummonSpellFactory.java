package pl.sdk.converter;

import pl.sdk.spells.AbstractSpell;
import pl.sdk.spells.SpellStatistic;
import pl.sdk.spells.SummonSpell;

public class SummonSpellFactory {

    static AbstractSpell create(SpellStatistic aEs, int aHeroPower) {
        switch (aEs) {
            case SUMMON_AIR_ELEMENTAL:
                return new SummonSpell(25, aHeroPower, 2 * aHeroPower, "Air Elemental");
            default:
                throw new UnsupportedOperationException("Cannot recognize spell");
        }
    }
}
