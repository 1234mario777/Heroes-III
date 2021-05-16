package pl.sdk.creatures.moving;

import pl.sdk.board.Point;

public interface DistanceHeuristic
{
	float getCost( Point sourcePoint, Point targetPoint );
}
