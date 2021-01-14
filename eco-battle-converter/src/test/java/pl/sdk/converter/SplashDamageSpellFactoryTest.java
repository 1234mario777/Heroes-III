package pl.sdk.converter;

import org.junit.jupiter.api.Test;
import pl.sdk.spells.SpellStatistic;

import static org.junit.jupiter.api.Assertions.*;

class SplashDamageSpellFactoryTest {

    @Test
    void shouldConvertFireBallCorrectly(){
        SplashDamageSpellFactory.create(SpellStatistic.FIRE_BALL);
    }

}