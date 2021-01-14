package pl.sdk.converter;

import org.junit.jupiter.api.Test;
import pl.sdk.spells.DebuffSpell;
import pl.sdk.spells.EconomySpell;
import pl.sdk.spells.SpellStatistic;

import static org.junit.jupiter.api.Assertions.*;

class DebuffSpellFactoryTest {

    @Test
    void shouldConvertSlowSpellsCorrectly(){
        EconomySpell toCovert = new EconomySpell(SpellStatistic.SLOW);

        DebuffSpell spell = (DebuffSpell) DebuffSpellFactory.create(toCovert, 1);

        assertEquals(1, spell.getDuration());
        assertEquals(0, spell.getSplashRange());
        assertEquals(6, spell.getManaCost());
        assertEquals(SpellStatistic.TargetType.ENEMY, spell.getTargetType());
    }
}