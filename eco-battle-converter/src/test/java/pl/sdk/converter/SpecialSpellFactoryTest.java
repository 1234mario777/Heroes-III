package pl.sdk.converter;

import org.junit.jupiter.api.Test;
import pl.sdk.spells.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpecialSpellFactoryTest {

    @Test
    void shouldConvertDispelSpellsCorrectly(){
        EconomySpell toCovert = new EconomySpell(SpellStatistic.DISPEL);

        DispelSpell spell = (DispelSpell) SpecialSpellFactory.create(toCovert);

        assertEquals(0, spell.getSplashRange());
        assertEquals(5, spell.getManaCost());
        assertEquals(SpellStatistic.TargetType.ALLY, spell.getTargetType());
    }

    @Test
    void shouldConvertTeleportSpellsCorrectly(){
        EconomySpell toCovert = new EconomySpell(SpellStatistic.TELEPORT);

        TeleportSpell spell = (TeleportSpell) SpecialSpellFactory.create(toCovert);

        assertEquals(0, spell.getSplashRange());
        assertEquals(15, spell.getManaCost());
        assertEquals(SpellStatistic.TargetType.ALLY, spell.getTargetType());
    }
}
