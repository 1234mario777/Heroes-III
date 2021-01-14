package pl.sdk.converter;

import pl.sdk.spells.AbstractSpell;
import pl.sdk.spells.SpellStatistic;
import pl.sdk.spells.SplashDamageSpell;

public class SplashDamageSpellFactory {
    static AbstractSpell create(SpellStatistic aFireBall) {
        return new SplashDamageSpell(1,1,1);
    }
}
