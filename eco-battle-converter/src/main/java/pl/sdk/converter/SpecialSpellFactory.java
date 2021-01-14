package pl.sdk.converter;

import pl.sdk.spells.*;

public class SpecialSpellFactory {

    static AbstractSpell create(EconomySpell aEs) {
        switch (aEs.getSpellStatistic()) {
            case DISPEL:
                return new DispelSpell();
            case TELEPORT:
                return new TeleportSpell();
            default: throw new UnsupportedOperationException("Cannot recognize spell");
        }
    }
}
