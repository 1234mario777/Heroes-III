package pl.sdk.converter.spells;

import pl.sdk.converter.SpellMasteries;
import pl.sdk.spells.*;

class DebuffSpellFactory extends SpellFactory{

    @Override
    AbstractSpell createInner(EconomySpell aEs, int aHeroPower, SpellMasteries aMasteries) {
        switch (aEs.getSpellStatistic()) {
            case SLOW:
                switch (aMasteries.getEarth()){
                    case BASIC:
                        return new DebuffSpell(aEs.getManaCost(), aHeroPower, aEs.getElement(), SpellStatistic.TargetType.ENEMY);
                    case ADVANCED:
                        return new DebuffSpell(aEs.getManaCost(), aHeroPower, aEs.getElement(), SpellStatistic.TargetType.ENEMY);
                    case MASTER:
                        return new DebuffSpell(aEs.getManaCost(), aHeroPower, aEs.getElement(), SpellStatistic.TargetType.ALL_ALLIES);
                    default:
                        throw new UnsupportedOperationException("Cannot recognize mastery level");
                }
            default: throw new UnsupportedOperationException("Cannot recognize spell");
        }
    }
}
