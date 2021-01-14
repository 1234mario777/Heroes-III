package pl.sdk.converter;

import pl.sdk.spells.AbstractSpell;
import pl.sdk.spells.EconomySpell;
import pl.sdk.spells.SingeTargetDamageSpell;

public class DamageSpellFactory {
    static AbstractSpell create(EconomySpell aEs, int aHeroPower) {
        switch (aEs.getSpellStatistic()) {
            case IMPLOSION:
                return new SingeTargetDamageSpell(75 * aHeroPower + 100, aEs.getManaCost(), aEs.getElement());
            case MAGIC_ARROW:
                return new SingeTargetDamageSpell(10 * aHeroPower + 10, aEs.getManaCost(), aEs.getElement());
            default: throw new UnsupportedOperationException("Cannot recognize spell");
        }
    }
}
