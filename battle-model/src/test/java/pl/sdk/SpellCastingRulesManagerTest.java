package pl.sdk;

import org.junit.jupiter.api.Test;
import pl.sdk.creatures.AbstractFractionFactory;
import pl.sdk.spells.SpellStatistic;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SpellCastingRulesManagerTest {

    @Test
    void shouldNotAttackWhileBoardIsEmptyInTargetedPoint(){
        SpellCastingRulesManager spellCastingRulesManager = new SpellCastingRulesManager();
        Board board = new Board();
        GameEngine gameEngine = mock(GameEngine.class);
        when(gameEngine.isAllyCreature(any())).thenReturn(true);
        when(gameEngine.isEnemyCreature(any())).thenReturn(false);

        Set<Point> result = spellCastingRulesManager.calc(SpellFactoryForTests.createMagicArrow(), board, new Point(10,10), gameEngine);

        assertTrue(result.isEmpty());
    }

    @Test
    void shouldCastSpellOnlyForTargetPlace(){
        SpellCastingRulesManager spellCastingRulesManager = new SpellCastingRulesManager();
        Board board = new Board();
        GameEngine gameEngine = mock(GameEngine.class);
        when(gameEngine.isAllyCreature(any())).thenReturn(false);
        when(gameEngine.isEnemyCreature(any())).thenReturn(true);
        board.add(new Point(10,10), AbstractFractionFactory.createSkeleton());
        board.add(new Point(11,10), AbstractFractionFactory.createSkeleton());

        Set<Point> result = spellCastingRulesManager.calc(SpellFactoryForTests.createMagicArrow(), board, new Point(10,10), gameEngine);

        assertEquals(1, result.size());
        assertTrue(result.contains(new Point(10,10)));
    }

    @Test
    void shouldCastSpellForAllExistsCreature(){
        SpellCastingRulesManager spellCastingRulesManager = new SpellCastingRulesManager();
        Board board = new Board();
        board.add(new Point(10,10),AbstractFractionFactory.createSkeleton());
        board.add(new Point(9,10), AbstractFractionFactory.createSkeleton());
        board.add(new Point(10,9), AbstractFractionFactory.createSkeleton());
        board.add(new Point(11,10),AbstractFractionFactory.createSkeleton());
        board.add(new Point(10,11),AbstractFractionFactory.createSkeleton());
        board.add(new Point(9,9), AbstractFractionFactory.createSkeleton());
        board.add(new Point(11,11),AbstractFractionFactory.createSkeleton());
        board.add(new Point(9,11), AbstractFractionFactory.createSkeleton());
        board.add(new Point(11,9), AbstractFractionFactory.createSkeleton());
        //shouldn't be attacked
        board.add(new Point(11,12),AbstractFractionFactory.createSkeleton());
        board.add(new Point(12,11),AbstractFractionFactory.createSkeleton());
        board.add(new Point(9,8), AbstractFractionFactory.createSkeleton());
        board.add(new Point(8,9), AbstractFractionFactory.createSkeleton());
        GameEngine gameEngine = mock(GameEngine.class);
        when(gameEngine.isAllyCreature(any())).thenReturn(false);
        when(gameEngine.isEnemyCreature(any())).thenReturn(true);

        Set<Point> result = spellCastingRulesManager.calc(SpellFactoryForTests.createMagicArrowWithSplash(1), board, new Point(10,10), gameEngine);

        assertEquals(9, result.size());
    }

    @Test
    void shouldCastSpellOnlyForAllies(){
        SpellCastingRulesManager spellCastingRulesManager = new SpellCastingRulesManager();
        Board board = new Board();
        board.add(new Point(10,10), AbstractFractionFactory.createSkeleton());
        board.add(new Point(9,9), AbstractFractionFactory.createSkeleton());
        board.add(new Point(11,11), AbstractFractionFactory.createSkeleton());
        GameEngine gameEngine = mock(GameEngine.class);
        when(gameEngine.isAllyCreature(new Point(11,11))).thenReturn(true);
        when(gameEngine.isAllyCreature(new Point(10,10))).thenReturn(true);
        when(gameEngine.isAllyCreature(new Point(9,9))).thenReturn(false);
        when(gameEngine.isEnemyCreature(new Point(11,11))).thenReturn(false);
        when(gameEngine.isEnemyCreature(new Point(10,10))).thenReturn(false);
        when(gameEngine.isEnemyCreature(new Point(9,9))).thenReturn(true);

        Set<Point> result = spellCastingRulesManager.calc(SpellFactoryForTests.createMagicArrowWithSplashAndTargetType(1, SpellStatistic.TargetType.ALLY), board, new Point(10,10),gameEngine);

        assertEquals(2, result.size());
        assertTrue(result.contains(new Point(10,10)));
        assertTrue(result.contains(new Point(11,11)));
    }

    @Test
    void shouldCastSpellOnlyForEnemies(){
        SpellCastingRulesManager spellCastingRulesManager = new SpellCastingRulesManager();
        Board board = new Board();
        board.add(new Point(10,10), AbstractFractionFactory.createSkeleton());
        board.add(new Point(10,11), AbstractFractionFactory.createSkeleton());
        GameEngine gameEngine = mock(GameEngine.class);
        when(gameEngine.isAllyCreature(new Point(11,11))).thenReturn(true);
        when(gameEngine.isAllyCreature(new Point(10,10))).thenReturn(false);
        when(gameEngine.isAllyCreature(new Point(9,9))).thenReturn(false);
        when(gameEngine.isEnemyCreature(new Point(11,11))).thenReturn(false);
        when(gameEngine.isEnemyCreature(new Point(10,10))).thenReturn(true);
        when(gameEngine.isEnemyCreature(new Point(9,9))).thenReturn(true);

        Set<Point> result = spellCastingRulesManager.calc(SpellFactoryForTests.createMagicArrowWithSplash(1), board, new Point(10,10),gameEngine);

        assertEquals(1, result.size());
        assertTrue(result.contains(new Point(10,10)));
    }
}