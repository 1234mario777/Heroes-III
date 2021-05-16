package pl.sdk.creatures.moving;

import pl.sdk.board.Point;

import static java.lang.Math.abs;

class ManhattanDistanceHeuristic implements DistanceHeuristic
{
	@Override
	public float getCost( Point sourcePoint, Point targetPoint )
	{
		float resultX = abs( targetPoint.getX() - sourcePoint.getX() );
		float resultY = abs( targetPoint.getY() - sourcePoint.getY() );

		return resultX + resultY;
	}
}
