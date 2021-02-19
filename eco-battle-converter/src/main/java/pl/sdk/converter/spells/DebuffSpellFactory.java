package pl.sdk.converter.spells;

import pl.sdk.converter.SpellMasteries;
import pl.sdk.spells.*;

class DebuffSpellFactory extends SpellFactory{

    @Override
    AbstractSpell createInner(EconomySpell aEs, int aHeroPower, SpellMasteries aMasteries) {
        switch (aEs.getSpellStatistic()) {

            default: throw new UnsupportedOperationException("Cannot recognize spell");
        }
    }
}
