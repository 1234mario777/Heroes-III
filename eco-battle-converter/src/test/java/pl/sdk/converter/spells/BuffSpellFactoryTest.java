package pl.sdk.converter.spells;

import org.junit.jupiter.api.Test;
import pl.sdk.converter.spells.BuffSpellFactory;
import pl.sdk.spells.BuffSpell;
import pl.sdk.spells.EconomySpell;
import pl.sdk.spells.SpellStatistic;

import static org.junit.jupiter.api.Assertions.*;

class BuffSpellFactoryTest {

    @Test
    void shouldConvertHasteSpellsCorrectly(){
        EconomySpell toCovert = new EconomySpell(SpellStatistic.HASTE);

        BuffSpell spell = (BuffSpell) new BuffSpellFactory().createInner(toCovert, 1);

        assertEquals(1, spell.getDuration());
        assertEquals(0, spell.getSplashRange());
        assertEquals(6, spell.getManaCost());
        assertEquals(SpellStatistic.TargetType.ALLY, spell.getTargetType());
    }
}