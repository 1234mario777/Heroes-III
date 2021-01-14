package pl.sdk.converter;

import pl.sdk.spells.BuffSpell;
import pl.sdk.spells.EconomySpell;
import pl.sdk.spells.SingeTargetDamageSpell;
import pl.sdk.spells.SpellStatistic;

import static org.junit.jupiter.api.Assertions.*;

class BuffSpellFactoryTest {

    void shouldConvertHasteSpellsCorrectly(){
        EconomySpell toCovert = new EconomySpell(SpellStatistic.HASTE);

        BuffSpell spell = (BuffSpell) BuffSpellFactory.create(toCovert, 1);

        assertEquals(1, spell.getDuration());
        assertEquals(0, spell.getSplashRange());
        assertEquals(6, spell.getManaCost());
        assertEquals(SpellStatistic.TargetType.ALLY, spell.getTargetType());
    }
}