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

        Set<Point> result = spellSplashCalculator.calc(SpellFactoryForTests.createMagicArrow(), board, new Point(10,10));

        assertEquals(1, result.size());
        assertTrue(result.contains(new Point(10,10)));
    }
}