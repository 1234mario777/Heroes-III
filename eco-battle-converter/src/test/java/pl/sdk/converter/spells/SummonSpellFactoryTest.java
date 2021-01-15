package pl.sdk.converter.spells;

import org.junit.jupiter.api.Test;
import pl.sdk.converter.spells.SummonSpellFactory;
import pl.sdk.spells.EconomySpell;
import pl.sdk.spells.SpellStatistic;
import pl.sdk.spells.SummonSpell;

import static org.junit.jupiter.api.Assertions.*;

class SummonSpellFactoryTest {

    @Test
    void shouldConvertSlowSpellsCorrectly(){
        EconomySpell toCovert = new EconomySpell(SpellStatistic.SUMMON_AIR_ELEMENTAL);

        SummonSpell spell = (SummonSpell) new SummonSpellFactory().createInner(toCovert, 1);

        assertEquals(1, spell.getDuration());
        assertEquals("Air Elemental", spell.getSummoningCreatureAmount());
        assertEquals(0, spell.getSplashRange());
        assertEquals(25, spell.getManaCost());
        assertEquals(SpellStatistic.TargetType.MAP, spell.getTargetType());
    }
}