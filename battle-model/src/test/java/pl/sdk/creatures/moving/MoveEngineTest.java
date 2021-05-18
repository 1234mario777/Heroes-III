package pl.sdk.creatures.moving;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.Fraction;
import pl.sdk.board.Point;
import pl.sdk.board.BoardManager;
import pl.sdk.creatures.AbstractFractionFactory;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.MovementType;

import static org.junit.jupiter.api.Assertions.*;

class MoveEngineTest
{

	private MoveEngine moveEngine;
	private BoardManager boardManager;
	private Creature groundCreature;
	Creature flyingCreature;
	Creature teleportCreature;

	@BeforeEach
	void init()
	{
		boardManager = new BoardManager();
		moveEngine = new MoveEngine( boardManager );
		groundCreature = AbstractFractionFactory.createSkeleton();
		flyingCreature = AbstractFractionFactory.getInstance( Fraction.NECROPOLIS )
		                                        .create( false, 7, 1 );
		teleportCreature = new Creature.Builder().moveRange( 5 )
		                                         .moveStrategy( MovementType.TELEPORT )
		                                         .build();
	}

	@Test
	void groundCreatureShouldMoveCorrectly()
	{
		Point sourcePoint = new Point( 0, 0 );
		Point targetPoint = new Point( 0, 1 );
		boardManager.putOnBoard( new Point( 0, 0 ), groundCreature );


		moveEngine.move( groundCreature, targetPoint );
		Creature creatureFromBoard =  boardManager.getCreatureByPoint( targetPoint );

		assertEquals( groundCreature, creatureFromBoard );
		assertNull( boardManager.getCreatureByPoint( sourcePoint ) );
	}

	@Test
	void flyingCreatureShouldMoveCorrectly()
	{
		Point sourcePoint = new Point( 0, 0 );
		Point targetPoint = new Point( 0, 1 );
		boardManager.putOnBoard( new Point( 0, 0 ), flyingCreature );

		moveEngine.move( flyingCreature, targetPoint );
		Creature creatureFromBoard = boardManager.getCreatureByPoint( targetPoint );

		assertEquals( flyingCreature, creatureFromBoard );
		assertNull( boardManager.getCreatureByPoint( sourcePoint ) );
	}

	@Test
	void teleportCreatureShouldMoveCorrectly()
	{
		Point sourcePoint = new Point( 0, 0 );
		Point targetPoint = new Point( 0, 1 );
		boardManager.putOnBoard( new Point( 0, 0 ), teleportCreature );

		moveEngine.move( teleportCreature, targetPoint );
		Creature creatureFromBoard = boardManager.getCreatureByPoint( targetPoint );

		assertEquals( teleportCreature, creatureFromBoard );
		assertNull( boardManager.getCreatureByPoint( sourcePoint ) );
	}

	@Test
	void cannotMoveWhenTileIsTaken()
	{
		Creature notStandable = AbstractFractionFactory.createSkeleton();

		boardManager.putOnBoard( new Point( 0, 0 ), notStandable );
		boardManager.putOnBoard( new Point( 1, 0 ), groundCreature );
		boardManager.putOnBoard( new Point( 2, 0 ), flyingCreature );
		boardManager.putOnBoard( new Point( 3, 0 ), teleportCreature );

		assertFalse( moveEngine.canMove( groundCreature, new Point( 0, 0 ) ) );
		assertFalse( moveEngine.canMove( flyingCreature, new Point( 0, 0 ) ) );
		assertFalse( moveEngine.canMove( teleportCreature, new Point( 0, 0 ) ) );

		assertEquals( groundCreature, boardManager.getCreatureByPoint( new Point( 1, 0 ) ) );
		assertEquals( flyingCreature, boardManager.getCreatureByPoint( new Point( 2, 0 ) ) );
		assertEquals( teleportCreature, boardManager.getCreatureByPoint( new Point( 3, 0 ) ) );
	}

	@Test
	void canMoveWhenCreatureHasEnoughMovePoint()
	{
		boardManager.putOnBoard( new Point( 5, 5 ), groundCreature );

		assertTrue( moveEngine.canMove( groundCreature, new Point( 6, 5 ) ) );
		assertTrue( moveEngine.canMove( groundCreature, new Point( 4, 5 ) ) );
		assertTrue( moveEngine.canMove( groundCreature, new Point( 5, 4 ) ) );
		assertTrue( moveEngine.canMove( groundCreature, new Point( 5, 6 ) ) );
	}

	@Test
	void cannotMoveWhenCreatureHasNotEnoughMovePoint()
	{
		boardManager.putOnBoard( new Point( 5, 5 ), groundCreature );
		boardManager.putOnBoard( new Point( 4, 5 ), flyingCreature );
		boardManager.putOnBoard( new Point( 3, 5 ), teleportCreature );

		assertFalse( moveEngine.canMove( groundCreature, new Point( 13, 6 ) ) );
		assertFalse( moveEngine.canMove( flyingCreature, new Point( 13, 6 ) ) );
		assertFalse( moveEngine.canMove( teleportCreature, new Point( 13, 6 ) ) );
	}

}