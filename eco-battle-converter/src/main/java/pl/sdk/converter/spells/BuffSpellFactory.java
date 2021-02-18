package pl.sdk.converter.spells;

import pl.sdk.converter.SpellMasteries;
import pl.sdk.spells.*;

class BuffSpellFactory extends SpellFactory{

    @Override
    AbstractSpell createInner(EconomySpell aEs, int aHeroPower, SpellMasteries aMasteries) {
        switch (aEs.getSpellStatistic()) {
            case HASTE:
                switch (aMasteries.getAir()){
                    case BASIC:
                        return new BuffSpell(aEs.getManaCost(), aHeroPower, aEs.getElement(), SpellStatistic.TargetType.ALLY, aEs.getName(), new BuffStatistic(3));
                    case ADVANCED:
                        return new BuffSpell(aEs.getManaCost(), aHeroPower, aEs.getElement(), SpellStatistic.TargetType.ALLY, aEs.getName(),  new BuffStatistic(5));
                    case MASTER:
                        return new BuffSpell(aEs.getManaCost(), aHeroPower, aEs.getElement(), SpellStatistic.TargetType.ALL_ALLIES, aEs.getName(),  new BuffStatistic(5));
                    default:
                        throw new UnsupportedOperationException("Cannot recognize mastery level");
                }
            default: throw new UnsupportedOperationException("Cannot recognize spell");
        }
    }
}
