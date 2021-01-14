package pl.sdk.converter;

import pl.sdk.spells.AbstractSpell;
import pl.sdk.spells.EconomySpell;
import pl.sdk.spells.SplashDamageSpell;

public class SplashDamageSpellFactory {
    static AbstractSpell create(EconomySpell aEs, int aHeroPower) {
        switch (aEs.getSpellStatistic()){
            case FIRE_BALL:
                return new SplashDamageSpell(aHeroPower * 10 + 15,15,3, aEs.getElement());
            default:
                throw new UnsupportedOperationException("Cannot recognize spell");
        }

    }
}
