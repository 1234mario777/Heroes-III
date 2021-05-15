package pl.sdk.converter.spells;

import pl.sdk.spells.AbstractSpell;
import pl.sdk.converter.SpellMasteries;
import pl.sdk.spells.*;

class DamageSpellFactory extends SpellFactory{

    AbstractSpell createInner(EconomySpell aEs, int aHeroPower, SpellMasteries aMasteries) {
        switch (aEs.getSpellStatistic()) {
            case FIRE_BALL:
                switch (aMasteries.getFire()){
                    case BASIC:
                        return new DamageSpell(15, SpellStatistic.TargetType.MAP, aEs.getElement(), aHeroPower * 10 + 15, 3, aEs.getName());
                    case ADVANCED:
                        return new DamageSpell(15, SpellStatistic.TargetType.MAP, aEs.getElement(), aHeroPower * 10 + 30, 3, aEs.getName());
                    case MASTER:
                        return new DamageSpell(15, SpellStatistic.TargetType.MAP, aEs.getElement(), aHeroPower * 10 + 60, 3, aEs.getName());
                    default:
                        throw new UnsupportedOperationException("Cannot recognize mastery level");
                }

            case IMPLOSION:
                switch (aMasteries.getEarth()){
                    case BASIC:
                        return new DamageSpell(aEs.getManaCost(), SpellStatistic.TargetType.ENEMY, aEs.getElement(), 75 * aHeroPower + 100, 0, aEs.getName());
                    case ADVANCED:
                        return new DamageSpell(aEs.getManaCost(), SpellStatistic.TargetType.ENEMY, aEs.getElement(), 75 * aHeroPower + 200, 0, aEs.getName());
                    case MASTER:
                        return new DamageSpell(aEs.getManaCost(), SpellStatistic.TargetType.ENEMY, aEs.getElement(), 75 * aHeroPower + 300, 0, aEs.getName());
                    default:
                        throw new UnsupportedOperationException("Cannot recognize mastery level");
                }

            case MAGIC_ARROW:
                switch (aMasteries.findMaxLevel()){
                    case BASIC:
                        return new DamageSpell(aEs.getManaCost(), SpellStatistic.TargetType.ENEMY, aEs.getElement(), 10 * aHeroPower + 10, 0, aEs.getName());
                    case ADVANCED:
                        return new DamageSpell(aEs.getManaCost(), SpellStatistic.TargetType.ENEMY, aEs.getElement(), 10 * aHeroPower + 20, 0, aEs.getName());
                    case MASTER:
                        return new DamageSpell(aEs.getManaCost(), SpellStatistic.TargetType.ENEMY, aEs.getElement(), 10 * aHeroPower + 30, 0, aEs.getName());
                    default:
                        throw new UnsupportedOperationException("Cannot recognize mastery level");
                }
            case DEATH_RIPPLE:
                switch (aMasteries.getEarth()){
                    case BASIC:
                        return new DamageSpell(aEs.getManaCost(), SpellStatistic.TargetType.ALL, aEs.getElement(), 5 * aHeroPower + 10, 0, aEs.getName());
                    case ADVANCED:
                        return new DamageSpell(aEs.getManaCost(), SpellStatistic.TargetType.ALL, aEs.getElement(), 5 * aHeroPower + 20, 0, aEs.getName());
                    case MASTER:
                        return new DamageSpell(aEs.getManaCost(), SpellStatistic.TargetType.ALL, aEs.getElement(), 5 * aHeroPower + 30, 0, aEs.getName());
                    default:
                        throw new UnsupportedOperationException("Cannot recognize mastery level");
                }
            default:
                throw new UnsupportedOperationException("Cannot recognize spell");
        }
    }
}
