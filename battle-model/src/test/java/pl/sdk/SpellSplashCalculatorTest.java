package pl.sdk;

import org.junit.jupiter.api.Test;
import pl.sdk.creatures.NecropolisFactory;
import pl.sdk.spells.SpellFactoryForTests;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SpellSplashCalculatorTest {

    @Test
    void shouldNotAttackWhileBoardIsEmptyInTargetedPoint(){
        SpellSplashCalculator spellSplashCalculator = new SpellSplashCalculator();
        Board board = new Board();

        Set<Point> result = spellSplashCalculator.calc(SpellFactoryForTests.createMagicArrow(), board, new Point(10,10));

        assertTrue(result.isEmpty());
    }

    @Test
    void shouldCastSpellOnlyForTargetPlace(){
        SpellSplashCalculator spellSplashCalculator = new SpellSplashCalculator();
        Board board = new Board();
        board.add(new Point(10,10), NecropolisFactory.createDefaultForTests());
        board.add(new Point(11,10), NecropolisFactory.createDefaultForTests());

        Set<Point> result = spellSplashCalculator.calc(SpellFactoryForTests.createMagicArrow(), board, new Point(10,10));

        assertEquals(1, result.size());
        assertTrue(result.contains(new Point(10,10)));
    }

    @Test
    void shouldCastSpellForAllExistsCreature(){
        SpellSplashCalculator spellSplashCalculator = new SpellSplashCalculator();
        Board board = new Board();
        board.add(new Point(10,10), NecropolisFactory.createDefaultForTests());
        board.add(new Point(9,10), NecropolisFactory.createDefaultForTests());
        board.add(new Point(10,9), NecropolisFactory.createDefaultForTests());
        board.add(new Point(11,10), NecropolisFactory.createDefaultForTests());
        board.add(new Point(10,11), NecropolisFactory.createDefaultForTests());
        board.add(new Point(9,9), NecropolisFactory.createDefaultForTests());
        board.add(new Point(11,11), NecropolisFactory.createDefaultForTests());
        board.add(new Point(9,11), NecropolisFactory.createDefaultForTests());
        board.add(new Point(11,9), NecropolisFactory.createDefaultForTests());
        //shouldn't be attacked
        board.add(new Point(11,12), NecropolisFactory.createDefaultForTests());
        board.add(new Point(12,11), NecropolisFactory.createDefaultForTests());
        board.add(new Point(9,8), NecropolisFactory.createDefaultForTests());
        board.add(new Point(8,9), NecropolisFactory.createDefaultForTests());

        Set<Point> result = spellSplashCalculator.calc(SpellFactoryForTests.createMagicArrowWithSplash(1), board, new Point(10,10));

        assertEquals(9, result.size());
    }

    @Test
    void shouldCastSpellOnlyForAllies(){
        SpellSplashCalculator spellSplashCalculator = new SpellSplashCalculator();
        Board board = new Board();
        board.add(new Point(10,10), NecropolisFactory.createDefaultForTests());
        board.add(new Point(10,10), NecropolisFactory.createDefaultForTests());
        board.add(new Point(10,11), NecropolisFactory.createDefaultForTests());

        Set<Point> result = spellSplashCalculator.calc(SpellFactoryForTests.createMagicArrow(), board, new Point(10,10));

        assertEquals(1, result.size());
        assertTrue(result.contains(new Point(10,10)));
    }

    @Test
    void shouldCastSpellOnlyForEnemies(){
        SpellSplashCalculator spellSplashCalculator = new SpellSplashCalculator();
        Board board = new Board();
        board.add(new Point(10,10), NecropolisFactory.createDefaultForTests());
        board.add(new Point(10,11), NecropolisFactory.createDefaultForTests());

        Set<Point> result = spellSplashCalculator.calc(SpellFactoryForTests.createMagicArrow(), board, new Point(10,10));

        assertEquals(1, result.size());
        assertTrue(result.contains(new Point(10,10)));
    }
}