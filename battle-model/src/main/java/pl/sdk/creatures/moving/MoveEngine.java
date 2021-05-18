package pl.sdk.creatures.moving;

import pl.sdk.board.Point;
import pl.sdk.board.BoardManager;
import pl.sdk.creatures.Creature;

import java.util.List;

public class MoveEngine
{
	private final BoardManager boardManager;
	List<Point> path;

	public MoveEngine( BoardManager aBoardManager )
	{
		boardManager = aBoardManager;
	}

	public List<Point> move( Creature aMover, Point aTargetPoint )
	{
		Point sourcePoint = boardManager.getPointByTile( aMover );

		if ( canMove( aMover, sourcePoint, aTargetPoint ) )
		{
			boardManager.removeFromBoard( sourcePoint );
			boardManager.putOnBoard( aTargetPoint, aMover );

			return path;
		}

		return path;
	}


	public boolean canMove( Creature aMover, Point aTargetPoint )
	{
		return aMover.getMoveContext()
		             .getMoveStrategy()
		             .isMovePossible( boardManager.getPointByTile( aMover ), aTargetPoint, boardManager );
	}

	private boolean canMove( Creature aMover, Point aSourcePoint, Point aTargetPoint )
	{
		path = aMover.getMoveContext()
		             .getMoveStrategy()
		             .move( aSourcePoint, aTargetPoint, boardManager );
		return path.contains( aTargetPoint );
	}
}
