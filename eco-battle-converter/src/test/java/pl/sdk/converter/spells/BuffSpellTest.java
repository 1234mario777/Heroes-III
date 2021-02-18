package pl.sdk.converter.spells;

import org.junit.jupiter.api.Test;
import pl.sdk.Fraction;
import pl.sdk.GameEngine;
import pl.sdk.Hero;
import pl.sdk.Point;
import pl.sdk.converter.SpellMasteries;
import pl.sdk.creatures.AbstractFractionFactory;
import pl.sdk.creatures.Creature;
import pl.sdk.spells.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static pl.sdk.converter.SpellMasteries.SpellMasterLevel.BASIC;
import static pl.sdk.converter.SpellMasteries.SpellMasterLevel.MASTER;

class BuffSpellTest {

    @Test
    void shouldIncreaseMoveRange() {
        Creature c1 = AbstractFractionFactory.getInstance(Fraction.TEST_FRACTION)
                .create(true, 7, 5);
        Creature c2 = AbstractFractionFactory.getInstance(Fraction.TEST_FRACTION)
                .create(true, 7, 5);
        GameEngine engine = new GameEngine(new Hero(List.of(c1)), new Hero(List.of(c2)));
        AbstractSpell haste = SpellFactory
                .create(new EconomySpell(SpellStatistic.HASTE), 1, new SpellMasteries());


        assertEquals(14, c1.getMoveRange());
        engine.castSpell(haste, new Point(0, 1));
        assertEquals(17, c1.getMoveRange());
    }

    @Test
    void shouldEndBuffAfterTwoTurns() {
        Creature c1 = AbstractFractionFactory.getInstance(Fraction.TEST_FRACTION)
                .create(true, 7, 5);
        Creature c2 = AbstractFractionFactory.getInstance(Fraction.TEST_FRACTION)
                .create(true, 7, 5);
        GameEngine engine = new GameEngine(new Hero(List.of(c1)), new Hero(List.of(c2)));
        AbstractSpell spell = SpellFactory.create(new EconomySpell(SpellStatistic.HASTE), 1, new SpellMasteries());


        assertEquals(14, c1.getMoveRange());
        engine.castSpell(spell, new Point(0, 1));
        assertEquals(17, c1.getMoveRange());

        //end two turn
        engine.pass();
        engine.pass();
        engine.pass();
        engine.pass();

        assertEquals(14, c1.getMoveRange());
    }

    @Test
    void shouldIncreaseMoveRangeForAllOurCreatures() {
        Creature c1 = AbstractFractionFactory.getInstance(Fraction.TEST_FRACTION)
                .create(true, 7, 5);
        Creature c2 = AbstractFractionFactory.getInstance(Fraction.TEST_FRACTION)
                .create(true, 7, 5);
        Creature cEnemy = AbstractFractionFactory.getInstance(Fraction.TEST_FRACTION)
                .create(true, 7, 5);
        GameEngine engine = new GameEngine(new Hero(List.of(c1, c2)), new Hero(List.of(cEnemy)));
        AbstractSpell haste = SpellFactory
                .create(new EconomySpell(SpellStatistic.HASTE), 1, new SpellMasteries(MASTER, BASIC, BASIC, BASIC));

        assertEquals(14, c1.getMoveRange());
        engine.castSpell(haste);
        assertEquals(19, c1.getMoveRange());
        assertEquals(19, c2.getMoveRange());
    }

}