package pl.sdk.converter.spells;

import pl.sdk.converter.SpellMasteries;
import pl.sdk.spells.*;

class DamageSpellFactory extends SpellFactory{

    AbstractSpell createInner(EconomySpell aEs, int aHeroPower, SpellMasteries aMasteries) {
        switch (aEs.getSpellStatistic()) {
            case FIRE_BALL:
                return new DamageSpell(15, SpellStatistic.TargetType.MAP, aEs.getElement(), aHeroPower * 10 + 15, 3);
            case IMPLOSION:
                return new DamageSpell(aEs.getManaCost(), SpellStatistic.TargetType.ENEMY, aEs.getElement(), 75 * aHeroPower + 100, 0);
            case MAGIC_ARROW:
                return new DamageSpell(aEs.getManaCost(), SpellStatistic.TargetType.ENEMY, aEs.getElement(), 10 * aHeroPower + 10, 0);
            case DEATH_RIPPLE:
                return new DamageSpell(aEs.getManaCost(), SpellStatistic.TargetType.ALL, aEs.getElement(), 5 * aHeroPower + 10, 0);
            default:
                throw new UnsupportedOperationException("Cannot recognize spell");
        }
    }
}
