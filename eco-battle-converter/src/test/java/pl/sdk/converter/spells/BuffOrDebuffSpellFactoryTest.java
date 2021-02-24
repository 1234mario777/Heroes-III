package pl.sdk.converter.spells;

import org.junit.jupiter.api.Test;
import pl.sdk.converter.SpellMasteries;
import pl.sdk.spells.BuffOrDebuffSpell;
import pl.sdk.spells.EconomySpell;
import pl.sdk.spells.SpellStatistic;

import static org.junit.jupiter.api.Assertions.*;

class BuffOrDebuffSpellFactoryTest {

    @Test
    void shouldConvertHasteSpellsCorrectly(){
        EconomySpell toCovert = new EconomySpell(SpellStatistic.HASTE);

        BuffOrDebuffSpell spell = (BuffOrDebuffSpell) new BuffOrDebuffSpellFactory().createInner(toCovert, 1, new SpellMasteries());

        assertEquals(1, spell.getDuration());
        assertEquals(0, spell.getSplashRange());
        assertEquals(6, spell.getManaCost());
        assertEquals(SpellStatistic.TargetType.ALLY, spell.getTargetType());
    }

    void shouldConvertSlowSpellsCorrectly(){
        EconomySpell toCovert = new EconomySpell(SpellStatistic.SLOW);

        BuffOrDebuffSpell spell = (BuffOrDebuffSpell) new BuffOrDebuffSpellFactory().createInner(toCovert, 1, new SpellMasteries());

        assertEquals(1, spell.getDuration());
        assertEquals(0, spell.getSplashRange());
        assertEquals(6, spell.getManaCost());
        assertEquals(SpellStatistic.TargetType.ENEMY, spell.getTargetType());
    }
}