package pl.sdk.converter.spells;

import pl.sdk.converter.SpellMasteries;
import pl.sdk.AbstractSpell;
import pl.sdk.spells.EconomySpell;

public abstract class SpellFactory {

    public static AbstractSpell create(EconomySpell aEs, int aHeroPower, SpellMasteries aMasteries){
        switch (aEs.getSpellType()){
            case DAMAGE:
                return new DamageSpellFactory().createInner(aEs, aHeroPower, aMasteries);
            case BUFF:
                return new BuffOrDebuffSpellFactory().createInner(aEs, aHeroPower, aMasteries);
            case DEBUFF:
                return new BuffOrDebuffSpellFactory().createInner(aEs, aHeroPower, aMasteries);
            case SUMMON:
                return new SummonSpellFactory().createInner(aEs, aHeroPower, aMasteries);
            case SPECIAL:
                return new SpecialSpellFactory().createInner(aEs, aHeroPower, aMasteries);
            case MAP_CHANGE:
                throw new UnsupportedOperationException("not implemented YET: " + aEs.getSpellType());
            default:
                throw new UnsupportedOperationException("Cannot recognize type: " + aEs.getSpellType());
        }
    }

    abstract AbstractSpell createInner(EconomySpell aEs, int aHeroPower, SpellMasteries aMasteries);
}
