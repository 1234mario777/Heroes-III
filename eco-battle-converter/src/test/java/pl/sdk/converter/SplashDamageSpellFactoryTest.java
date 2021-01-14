package pl.sdk.converter;

import org.junit.jupiter.api.Test;
import pl.sdk.spells.EconomySpell;
import pl.sdk.spells.SpellStatistic;
import pl.sdk.spells.SplashDamageSpell;

import static org.junit.jupiter.api.Assertions.*;

class SplashDamageSpellFactoryTest {

    @Test
    void shouldConvertFireBallCorrectly(){
        EconomySpell toConvert = new EconomySpell(SpellStatistic.FIRE_BALL);
        SplashDamageSpell fireBallSpell = (SplashDamageSpell) SplashDamageSpellFactory.create(toConvert, 1);

        assertEquals(3, fireBallSpell.getSplashRange());
        assertEquals(25, fireBallSpell.getDamage());
        assertEquals(15, fireBallSpell.getManaCost());
    }

}