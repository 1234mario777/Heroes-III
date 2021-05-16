package pl.sdk.creatures.moving;

import pl.sdk.board.Point;

class EuclideanDistanceHeuristic implements DistanceHeuristic
{
	@Override
	public float getCost( Point sourcePoint, Point targetPoint )
	{
		float resultX = ( targetPoint.getX() - sourcePoint.getX() ) * ( targetPoint.getX() - sourcePoint.getX() );
		float resultY = ( targetPoint.getY() - sourcePoint.getY() ) * ( targetPoint.getY() - sourcePoint.getY() );
		return ( float ) Math.sqrt( resultY + resultX );
	}
}
