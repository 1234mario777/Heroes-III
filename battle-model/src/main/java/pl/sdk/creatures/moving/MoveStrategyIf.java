package pl.sdk.creatures.moving;

import pl.sdk.board.BoardManager;
import pl.sdk.board.Point;

import java.util.List;

interface MoveStrategyIf
{
	List<Point> move( Point aSourcePoint, Point aTargetPoint, BoardManager aBoardManager );

	boolean isMovePossible( Point aSourcePoint, Point aTargetPoint, BoardManager aBoardManager );

}
