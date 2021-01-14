package pl.sdk.converter;

import pl.sdk.spells.EconomySpell;
import pl.sdk.spells.Spell;

public class DamageSpellFactory {
    static Spell create(EconomySpell aEs) {
        return new Spell();
    }
}
