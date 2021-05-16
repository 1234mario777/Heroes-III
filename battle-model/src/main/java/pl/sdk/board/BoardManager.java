package pl.sdk.board;

import pl.sdk.GameEngine;
import pl.sdk.creatures.Creature;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardManager
{
	Board board = new Board();

	public void checkPreconditions( Point aTargetPoint )
	{
		board.throwExceptionIfTileIsTaken( aTargetPoint );
		board.throwExceptionWhenIsOutsideMap( aTargetPoint );
	}

	public void putOnBoard( Point aPoint, TileIf aCreature )
	{
		checkPreconditions( aPoint );
		board.add( aPoint, aCreature );
	}

	public void putCreaturesOnBoard( List<Creature> aCreatures1, List<Creature> aCreatures2 )
	{
		putCreaturesFromOneSideToBoard( aCreatures1, 0 );
		putCreaturesFromOneSideToBoard( aCreatures2, GameEngine.BOARD_WIDTH - 1 );
	}

	private void putCreaturesFromOneSideToBoard( List<Creature> aCreatures, int aX )
	{
		for ( int i = 0; i < aCreatures.size(); i++ )
		{
			putOnBoard( new Point( aX, i * 2 + 1 ), aCreatures.get( i ) );
		}
	}

	public boolean canStand( Point aTargetPoint )
	{
		if ( getTileByPoint( aTargetPoint ) != null )
		{
			return getTileByPoint( aTargetPoint ).isStandable();
		}

		return true;
	}

	public Point getPointByTile( TileIf aTileIf )
	{
		return board.get( aTileIf );
	}

	public TileIf getTileByPoint( Point aP )
	{
		return board.get( aP );
	}

	public void removeFromBoard( Point aSourcePoint )
	{
		board.remove( aSourcePoint );
	}

	public Creature getCreatureByPoint( Point aPoint )
	{
		if ( board.get( aPoint ) instanceof Creature )
		{
			return ( Creature ) board.get( aPoint );

		}
		else
		{
			return null;
		}

	}
}
