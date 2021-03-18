package pl.sdk;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.creatures.AbstractFractionFactory;
import pl.sdk.creatures.Creature;

import static org.junit.jupiter.api.Assertions.*;

class BoardMovingTest {

    private Board board;
    private Creature creature;

    @BeforeEach
    void init(){
        board = new Board();
        creature = AbstractFractionFactory.createSkeleton();
        board.add(new Point(0,0), creature);
    }

    @Test
    void creatureShouldMoveCorrectly(){
        board.move(new Point(0,0), new Point(0,1));

        Creature creatureFromBoard = board.get(0, 1);

        assertEquals(creature,creatureFromBoard);
        assertNull(board.get(0,0));
    }

    @Test
    void shouldThrowExceptionWhenCreatureTryingToMoveToNotEmptyField(){
        board.add(new Point(0,1), AbstractFractionFactory.createSkeleton());

        assertThrows(IllegalArgumentException.class, () -> board.move(new Point(0,0), new Point(0,1)));

        Creature creatureFromBoard = board.get(0, 0);
        assertEquals(creature,creatureFromBoard);
    }

    @Test
    void canMoveWhenCreatureHasEnoughtMovePoint(){
        creature = AbstractFractionFactory.createSkeleton();;
        board.add(new Point(5,5), creature);

        assertTrue(board.canMove(creature, 6,5 ));
        assertTrue(board.canMove(creature, 4,5 ));
        assertTrue(board.canMove(creature, 5,4 ));
        assertTrue(board.canMove(creature, 5,6 ));
    }

    @Test
    void cannotMoveWhenCreatureHasNotEnoughtMovePoint(){
        Creature creature = AbstractFractionFactory.createSkeleton();;
        board.add(new Point(5,5), creature);

        assertFalse(board.canMove(creature, 6,6 ));
    }

    @Test
    void cannotMoveWhenTileIsTaken(){
        Creature creature = AbstractFractionFactory.createSkeleton();;
        board.add(new Point(5,5), creature);

        assertFalse(board.canMove(creature, 0,0 ));
    }

}