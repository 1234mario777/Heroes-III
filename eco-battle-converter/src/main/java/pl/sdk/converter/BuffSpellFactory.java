package pl.sdk.converter;

import pl.sdk.spells.AbstractSpell;
import pl.sdk.spells.BuffSpell;
import pl.sdk.spells.EconomySpell;

public class BuffSpellFactory {

    static AbstractSpell create(EconomySpell aEs, int aHeroPower) {
        switch (aEs.getSpellStatistic()) {
            case HASTE:
                return new BuffSpell(aEs.getManaCost(), aHeroPower, aEs.getElement());
            default: throw new UnsupportedOperationException("Cannot recognize spell");
        }
    }
}
