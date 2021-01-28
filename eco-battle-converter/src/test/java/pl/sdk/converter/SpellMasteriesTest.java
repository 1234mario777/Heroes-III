package pl.sdk.converter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pl.sdk.converter.SpellMasteries.SpellMasterLevel.*;


class SpellMasteriesTest {

    @Test
    void shouldFindingMaxCorrectly(){
        SpellMasteries b4 = new SpellMasteries(BASIC, BASIC, BASIC, BASIC);
        assertEquals(BASIC, b4.findMaxLevel());

        SpellMasteries a4 = new SpellMasteries(ADVANCED, ADVANCED, ADVANCED, ADVANCED);
        assertEquals(ADVANCED, a4.findMaxLevel());

        SpellMasteries m4 = new SpellMasteries(MASTER, MASTER, MASTER, MASTER);
        assertEquals(MASTER, m4.findMaxLevel());

        SpellMasteries b3a1 = new SpellMasteries(BASIC, ADVANCED, BASIC, BASIC);
        assertEquals(ADVANCED, b3a1.findMaxLevel());

        SpellMasteries b3m1 = new SpellMasteries(BASIC, BASIC, BASIC, MASTER);
        assertEquals(MASTER, b3m1.findMaxLevel());

        SpellMasteries b2a1m1 = new SpellMasteries(MASTER, BASIC, ADVANCED, BASIC);
        assertEquals(MASTER, b2a1m1.findMaxLevel());

        SpellMasteries b2m2 = new SpellMasteries(BASIC, MASTER, BASIC, MASTER);
        assertEquals(MASTER, b2m2.findMaxLevel());
    }


}