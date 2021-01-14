package pl.sdk.converter;

import pl.sdk.spells.EconomySpell;
import pl.sdk.spells.SingeTargetDamageSpell;

public class DamageSpellFactory {
    static SingeTargetDamageSpell create(EconomySpell aEs, int aHeroPower) {
        switch (aEs.getSpellStatistic()) {
            case IMPLOSION:
                return new SingeTargetDamageSpell(75 * aHeroPower + 100);
            case MAGIC_ARROW:
                return new SingeTargetDamageSpell(10 * aHeroPower + 10);
            default: throw new UnsupportedOperationException("Cannot recognize spell");
        }
    }
}
