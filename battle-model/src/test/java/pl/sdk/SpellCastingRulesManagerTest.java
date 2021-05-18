package pl.sdk;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.board.BoardManager;
import pl.sdk.board.Point;
import pl.sdk.creatures.AbstractFractionFactory;
import pl.sdk.spells.SpellStatistic;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SpellCastingRulesManagerTest {

    BoardManager boardManager;

    @BeforeEach
    void init()
    {
        boardManager = new BoardManager( );
    }
    @Test
    void shouldNotAttackWhileBoardIsEmptyInTargetedPoint(){
        SpellCastingRulesManager spellCastingRulesManager = new SpellCastingRulesManager();
        GameEngine gameEngine = mock(GameEngine.class);
        when(gameEngine.isAllyCreature(any())).thenReturn(true);
        when(gameEngine.isEnemyCreature(any())).thenReturn(false);
        when( gameEngine.getBoardManager() ).thenReturn( boardManager );

        Set<Point> result = spellCastingRulesManager.calc(SpellFactoryForTests.createMagicArrow(), new Point(10,10), gameEngine);

        assertTrue(result.isEmpty());
    }

    @Test
    void shouldCastSpellOnlyForTargetPlace(){
        SpellCastingRulesManager spellCastingRulesManager = new SpellCastingRulesManager();
        GameEngine gameEngine = mock(GameEngine.class);
        when(gameEngine.isAllyCreature(any())).thenReturn(false);
        when(gameEngine.isEnemyCreature(any())).thenReturn(true);
        when( gameEngine.getBoardManager() ).thenReturn( boardManager );
        boardManager.putOnBoard(new Point(10,10), AbstractFractionFactory.createSkeleton() );
        boardManager.putOnBoard(new Point(11,10), AbstractFractionFactory.createSkeleton() );

        Set<Point> result = spellCastingRulesManager.calc(SpellFactoryForTests.createMagicArrow(), new Point(10,10), gameEngine);

        assertEquals(1, result.size());
        assertTrue(result.contains(new Point(10,10)));
    }

    @Test
    void shouldCastSpellForAllExistsCreature(){
        SpellCastingRulesManager spellCastingRulesManager = new SpellCastingRulesManager();
        boardManager.putOnBoard(new Point(10,10),AbstractFractionFactory.createSkeleton() );
        boardManager.putOnBoard(new Point(9,10), AbstractFractionFactory.createSkeleton() );
        boardManager.putOnBoard(new Point(10,9), AbstractFractionFactory.createSkeleton() );
        boardManager.putOnBoard(new Point(11,10),AbstractFractionFactory.createSkeleton() );
        boardManager.putOnBoard(new Point(10,11),AbstractFractionFactory.createSkeleton() );
        boardManager.putOnBoard(new Point(9,9), AbstractFractionFactory.createSkeleton() );
        boardManager.putOnBoard(new Point(11,11),AbstractFractionFactory.createSkeleton() );
        boardManager.putOnBoard(new Point(9,11), AbstractFractionFactory.createSkeleton() );
        boardManager.putOnBoard(new Point(11,9), AbstractFractionFactory.createSkeleton() );
        //shouldn't be attacked
        boardManager.putOnBoard(new Point(11,12),AbstractFractionFactory.createSkeleton() );
        boardManager.putOnBoard(new Point(12,11),AbstractFractionFactory.createSkeleton() );
        boardManager.putOnBoard(new Point(9,8), AbstractFractionFactory.createSkeleton() );
        boardManager.putOnBoard(new Point(8,9), AbstractFractionFactory.createSkeleton() );
        GameEngine gameEngine = mock(GameEngine.class);
        when(gameEngine.isAllyCreature(any())).thenReturn(false);
        when(gameEngine.isEnemyCreature(any())).thenReturn(true);
        when( gameEngine.getBoardManager() ).thenReturn( boardManager );

        Set<Point> result = spellCastingRulesManager.calc(SpellFactoryForTests.createMagicArrowWithSplash(1), new Point(10,10), gameEngine);

        assertEquals(9, result.size());
    }

    @Test
    void shouldCastSpellOnlyForAllies(){
        SpellCastingRulesManager spellCastingRulesManager = new SpellCastingRulesManager();
        boardManager.putOnBoard(new Point(10,10), AbstractFractionFactory.createSkeleton() );
        boardManager.putOnBoard(new Point(9,9), AbstractFractionFactory.createSkeleton() );
        boardManager.putOnBoard(new Point(11,11), AbstractFractionFactory.createSkeleton() );
        GameEngine gameEngine = mock(GameEngine.class);
        when(gameEngine.isAllyCreature(new Point(11,11))).thenReturn(true);
        when(gameEngine.isAllyCreature(new Point(10,10))).thenReturn(true);
        when(gameEngine.isAllyCreature(new Point(9,9))).thenReturn(false);
        when(gameEngine.isEnemyCreature(new Point(11,11))).thenReturn(false);
        when(gameEngine.isEnemyCreature(new Point(10,10))).thenReturn(false);
        when(gameEngine.isEnemyCreature(new Point(9,9))).thenReturn(true);
        when( gameEngine.getBoardManager() ).thenReturn( boardManager );

        Set<Point> result = spellCastingRulesManager.calc(SpellFactoryForTests.createMagicArrowWithSplashAndTargetType(1, SpellStatistic.TargetType.ALLY), new Point(10,10),gameEngine);

        assertEquals(2, result.size());
        assertTrue(result.contains(new Point(10,10) ) );
        assertTrue(result.contains(new Point(11,11)));
    }

    @Test
    void shouldCastSpellOnlyForEnemies(){
        SpellCastingRulesManager spellCastingRulesManager = new SpellCastingRulesManager();
        boardManager.putOnBoard(new Point(10,10), AbstractFractionFactory.createSkeleton() );
        boardManager.putOnBoard(new Point(10,11), AbstractFractionFactory.createSkeleton() );
        GameEngine gameEngine = mock(GameEngine.class);
        when(gameEngine.isAllyCreature(new Point(11,11))).thenReturn(true);
        when(gameEngine.isAllyCreature(new Point(10,10))).thenReturn(false);
        when(gameEngine.isAllyCreature(new Point(9,9))).thenReturn(false);
        when(gameEngine.isEnemyCreature(new Point(11,11))).thenReturn(false);
        when(gameEngine.isEnemyCreature(new Point(10,10))).thenReturn(true);
        when(gameEngine.isEnemyCreature(new Point(9,9))).thenReturn(true);
        when( gameEngine.getBoardManager() ).thenReturn( boardManager );

        Set<Point> result = spellCastingRulesManager.calc(SpellFactoryForTests.createMagicArrowWithSplash(1), new Point(10,10),gameEngine);

        assertEquals(1, result.size());
        assertTrue(result.contains(new Point(10,10)));
    }
}