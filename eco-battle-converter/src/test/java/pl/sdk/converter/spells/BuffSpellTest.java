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

class BuffSpellTest {

    @Test
    void shouldIncreaseMoveRange() {
        AbstractSpell haste = SpellFactory
                .create(new EconomySpell(SpellStatistic.HASTE), 1, new SpellMasteries());
        Creature creature = AbstractFractionFactory.getInstance(Fraction.TEST_FRACTION)
                .create(true, 7, 5);


        assertEquals(14, creature.getMoveRange());
        haste.cast(creature);
        assertEquals(17, creature.getMoveRange());
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

}