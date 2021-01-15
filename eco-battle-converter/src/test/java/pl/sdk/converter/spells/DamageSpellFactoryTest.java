package pl.sdk.converter.spells;

import org.junit.jupiter.api.Test;
import pl.sdk.converter.SpellMasteries;
import pl.sdk.converter.spells.DamageSpellFactory;
import pl.sdk.spells.DamageSpell;
import pl.sdk.spells.EconomySpell;
import pl.sdk.spells.SpellStatistic;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DamageSpellFactoryTest {

    @Test
    void shouldConvertMagicArrowSpellsCorrectly(){
        EconomySpell toCovert = new EconomySpell(SpellStatistic.MAGIC_ARROW);

        DamageSpell spell = (DamageSpell) new DamageSpellFactory().createInner(toCovert, 1, new SpellMasteries());

        assertEquals(20, spell.getDamage());
        assertEquals(0, spell.getSplashRange());
        assertEquals(5, spell.getManaCost());
        assertEquals(SpellStatistic.TargetType.ENEMY, spell.getTargetType());
    }

    @Test
    void shouldConvertMagicImplosionSpellsCorrectly(){
        EconomySpell toCovert = new EconomySpell(SpellStatistic.IMPLOSION);

        DamageSpell spell = (DamageSpell) new DamageSpellFactory().createInner(toCovert, 1, new SpellMasteries());

        assertEquals(175, spell.getDamage());
        assertEquals(0, spell.getSplashRange());
        assertEquals(30, spell.getManaCost());
        assertEquals(SpellStatistic.TargetType.ENEMY, spell.getTargetType());
    }

    @Test
    void shouldConvertFireBallCorrectly(){
        EconomySpell toConvert = new EconomySpell(SpellStatistic.FIRE_BALL);
        DamageSpell fireBallSpell = (DamageSpell) new DamageSpellFactory().createInner(toConvert, 1, new SpellMasteries());

        assertEquals(3, fireBallSpell.getSplashRange());
        assertEquals(25, fireBallSpell.getDamage());
        assertEquals(15, fireBallSpell.getManaCost());
    }

    @Test
    void shouldConvertDeathRipplelCorrectly(){
        EconomySpell toConvert = new EconomySpell(SpellStatistic.DEATH_RIPPLE);
        DamageSpell deathRiple = (DamageSpell) new DamageSpellFactory().createInner(toConvert, 1, new SpellMasteries());

        assertEquals(0, deathRiple.getSplashRange());
        assertEquals(SpellStatistic.TargetType.ALL, deathRiple.getTargetType());
        assertEquals(15, deathRiple.getDamage());
        assertEquals(10, deathRiple.getManaCost());
    }
}
