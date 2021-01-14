package pl.sdk.converter;

import org.junit.jupiter.api.Test;
import pl.sdk.spells.EconomySpell;
import pl.sdk.spells.SingeTargetDamageSpell;
import pl.sdk.spells.SpellStatistic;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DamageSpellFactoryTest {

    @Test
    void shouldConvertMagicArrowSpellsCorrectly(){
        EconomySpell toCovert = new EconomySpell(SpellStatistic.MAGIC_ARROW);

        SingeTargetDamageSpell spell = DamageSpellFactory.create(toCovert, 1);

        assertEquals(20, spell.getDamage());
        assertEquals(0, spell.getSplashRange());
    }

    @Test
    void shouldConvertMagicImplosionSpellsCorrectly(){
        EconomySpell toCovert = new EconomySpell(SpellStatistic.IMPLOSION);

        SingeTargetDamageSpell spell = DamageSpellFactory.create(toCovert, 1);

        assertEquals(175, spell.getDamage());
        assertEquals(0, spell.getSplashRange());
    }
}
