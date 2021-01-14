package pl.sdk.converter;

import org.junit.jupiter.api.Test;
import pl.sdk.spells.SpellStatistic;
import pl.sdk.spells.SplashDamageSpell;

import static org.junit.jupiter.api.Assertions.*;

class SplashDamageSpellFactoryTest {

    @Test
    void shouldConvertFireBallCorrectly(){
        SplashDamageSpell fireBallSpell = (SplashDamageSpell) SplashDamageSpellFactory.create(SpellStatistic.FIRE_BALL,1);

        assertEquals(3, fireBallSpell.getSplashRange());
        assertEquals(25, fireBallSpell.getDamage());
        assertEquals(15, fireBallSpell.getManaCost());
    }

}