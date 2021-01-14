package pl.sdk.converter;

import pl.sdk.spells.AbstractSpell;
import pl.sdk.spells.SpellStatistic;
import pl.sdk.spells.SplashDamageSpell;

public class SplashDamageSpellFactory {
    static AbstractSpell create(SpellStatistic aEs, int aHeroPower) {
        switch (aEs){
            case FIRE_BALL:
                return new SplashDamageSpell(aHeroPower * 10 + 15,15,3);
            default:
                throw new UnsupportedOperationException("Cannot recognize spell");
        }

    }
}
