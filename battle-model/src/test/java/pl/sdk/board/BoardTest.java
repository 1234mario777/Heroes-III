package pl.sdk.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.creatures.AbstractFractionFactory;
import pl.sdk.creatures.Creature;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest
{
	private BoardManager boardManager;
	private Creature creature;

	@BeforeEach
	void init()
	{
		boardManager = new BoardManager();
		creature = AbstractFractionFactory.createSkeleton();
	}

	@Test
	void shouldAddCreature()
	{
		boardManager.putOnBoard( new Point( 0, 0 ), creature );

		Creature creatureFromBoard = boardManager.getCreatureByPoint( new Point( 0, 0 ) );

		assertEquals( creature, creatureFromBoard );
	}

	@Test
	void shouldReturnNullWhenFiledIsEmpty()
	{
		Creature creatureFromBoard = boardManager.getCreatureByPoint( new Point( 0, 0 ) );

		assertNull( creatureFromBoard );
	}

	@Test
	void shouldThrowIllegalArgumentExceptionWenYouTryAddCreatureToNotEmptyField()
	{
		boardManager.putOnBoard( new Point( 0, 0 ), creature );
		Creature creature2 = AbstractFractionFactory.createSkeleton();

		assertThrows( IllegalArgumentException.class, () -> boardManager.putOnBoard( new Point( 0, 0 ), creature2 ) );

		Creature creatureFromBoard = boardManager.getCreatureByPoint( new Point( 0, 0 ) );
		assertEquals( creature, creatureFromBoard );
	}

	@Test
	void shouldReturnCorrectLocationForByCreature()
	{
		boardManager.putOnBoard( new Point( 5, 5 ), creature );

		Point result = boardManager.getPointByTile( creature );

		assertEquals( new Point( 5, 5 ), result );
	}
}