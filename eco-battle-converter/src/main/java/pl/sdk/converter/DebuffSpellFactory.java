package pl.sdk.converter;

import pl.sdk.spells.AbstractSpell;
import pl.sdk.spells.DebuffSpell;
import pl.sdk.spells.EconomySpell;

public class DebuffSpellFactory{

    static AbstractSpell create(EconomySpell aEs, int aHeroPower) {
        switch (aEs.getSpellStatistic()) {
            case SLOW:
                return new DebuffSpell(aEs.getManaCost(), aHeroPower, aEs.getElement());
            default: throw new UnsupportedOperationException("Cannot recognize spell");
        }
    }
}
