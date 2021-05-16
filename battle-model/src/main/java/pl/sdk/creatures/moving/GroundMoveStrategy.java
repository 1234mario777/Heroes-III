package pl.sdk.creatures.moving;

import pl.sdk.board.BoardManager;
import pl.sdk.board.Point;
import pl.sdk.board.TileIf;
import pl.sdk.creatures.MovementType;

import java.util.List;

class GroundMoveStrategy implements MoveStrategyIf
{
	private final PathFinder pathFinder;

	GroundMoveStrategy( int aMoveRange )
	{
		pathFinder = new PathFinder( MovementType.GROUND, aMoveRange );
	}

	@Override
	public List<Point> move( Point aSourcePoint, Point aTargetPoint, BoardManager aBoardManager )
	{
		return pathFinder.getPath( aBoardManager, aSourcePoint, aTargetPoint )
		                 .getSteps();
	}

	@Override
	public boolean isMovePossible( Point aSourcePoint, Point aTargetPoint, BoardManager aBoardManager )
	{
		return pathFinder.getPath( aBoardManager, aSourcePoint, aTargetPoint )
		                 .contains( aTargetPoint );
	}
}
