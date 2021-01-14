package pl.sdk.converter;

import org.junit.jupiter.api.Test;
import pl.sdk.spells.DamageSpell;
import pl.sdk.spells.EconomySpell;
import pl.sdk.spells.SpellStatistic;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DamageSpellFactoryTest {

    @Test
    void shouldConvertMagicArrowSpellsCorrectly(){
        EconomySpell toCovert = new EconomySpell(SpellStatistic.MAGIC_ARROW);

        DamageSpell spell = (DamageSpell) DamageSpellFactory.create(toCovert, 1);

        assertEquals(20, spell.getDamage());
        assertEquals(0, spell.getSplashRange());
        assertEquals(5, spell.getManaCost());
        assertEquals(SpellStatistic.TargetType.ENEMY, spell.getTargetType());
    }

    @Test
    void shouldConvertMagicImplosionSpellsCorrectly(){
        EconomySpell toCovert = new EconomySpell(SpellStatistic.IMPLOSION);

        DamageSpell spell = (DamageSpell) DamageSpellFactory.create(toCovert, 1);

        assertEquals(175, spell.getDamage());
        assertEquals(0, spell.getSplashRange());
        assertEquals(30, spell.getManaCost());
        assertEquals(SpellStatistic.TargetType.ENEMY, spell.getTargetType());
    }

    @Test
    void shouldConvertFireBallCorrectly(){
        EconomySpell toConvert = new EconomySpell(SpellStatistic.FIRE_BALL);
        DamageSpell fireBallSpell = (DamageSpell) DamageSpellFactory.create(toConvert, 1);

        assertEquals(3, fireBallSpell.getSplashRange());
        assertEquals(25, fireBallSpell.getDamage());
        assertEquals(15, fireBallSpell.getManaCost());
    }

    @Test
    void shouldConvertDeathRipplelCorrectly(){
        EconomySpell toConvert = new EconomySpell(SpellStatistic.DEATH_RIPPLE);
        DamageSpell deathRiple = (DamageSpell) DamageSpellFactory.create(toConvert, 1);

        assertEquals(0, deathRiple.getSplashRange());
        assertEquals(SpellStatistic.TargetType.ALL, deathRiple.getTargetType());
        assertEquals(15, deathRiple.getDamage());
        assertEquals(10, deathRiple.getManaCost());
    }
}
