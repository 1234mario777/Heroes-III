package pl.sdk.creatures.moving;

import pl.sdk.board.BoardManager;
import pl.sdk.board.Point;

import java.util.List;

class TeleportMoveStrategy implements MoveStrategyIf
{
	private final DistanceHeuristic heuristic;
	private final int moveRange;

	TeleportMoveStrategy( int aMoveRange )
	{
		moveRange = aMoveRange;
		heuristic = new EuclideanDistanceHeuristic();
	}

	@Override
	public List<Point> move( Point aSourcePoint, Point aTargetPoint, BoardManager aBoardManager )
	{
		return List.of( aTargetPoint );
	}

	@Override
	public boolean isMovePossible( Point aSourcePoint, Point aTargetPoint, BoardManager aBoardManager )
	{
		return ( heuristic.getCost( aSourcePoint, aTargetPoint ) <= moveRange ) && aBoardManager.canStand( aTargetPoint );
	}
}
