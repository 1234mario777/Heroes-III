package pl.sdk.converter;

import org.junit.jupiter.api.Test;
import pl.sdk.spells.SpellStatistic;
import pl.sdk.spells.SummonSpell;

import static org.junit.jupiter.api.Assertions.*;

class SummonSpellFactoryTest {

    @Test
    void shouldConvertSlowSpellsCorrectly(){
        SpellStatistic toCovert = SpellStatistic.SUMMON_AIR_ELEMENTAL;

        SummonSpell spell = (SummonSpell) SummonSpellFactory.create(toCovert, 1);

        assertEquals(1, spell.getDuration());
        assertEquals("Air Elemental", spell.getSummoningCreatureAmount());
        assertEquals(0, spell.getSplashRange());
        assertEquals(25, spell.getManaCost());
        assertEquals(SpellStatistic.TargetType.MAP, spell.getTargetType());
    }
}