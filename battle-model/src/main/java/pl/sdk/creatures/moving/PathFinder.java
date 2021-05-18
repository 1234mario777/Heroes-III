package pl.sdk.creatures.moving;

import pl.sdk.board.BoardManager;
import pl.sdk.board.Point;
import pl.sdk.creatures.MovementType;
import pl.sdk.creatures.moving.utils.Node;
import pl.sdk.creatures.moving.utils.Path;
import pl.sdk.creatures.moving.utils.SortedList;

import java.util.*;

import static pl.sdk.GameEngine.BOARD_HEIGHT;
import static pl.sdk.GameEngine.BOARD_WIDTH;

class PathFinder
{
	private final MovementType movementType;
	private final int maxSearchDistance;
	private final DistanceHeuristic heuristic;
	private Node[][] nodes;

	PathFinder( MovementType aMovementType, int aMaxSearchDistance )
	{
		this( aMovementType, aMaxSearchDistance, new ManhattanDistanceHeuristic() );
	}

	private PathFinder( MovementType aMovementType, int aMaxSearchDistance, DistanceHeuristic aDistanceHeuristic )
	{
		movementType = aMovementType;
		maxSearchDistance = aMaxSearchDistance;
		heuristic = aDistanceHeuristic;
	}

	Path getPath( BoardManager aBoardManager, Point aSourcePoint, Point aTargetPoint )
	{
		Path path = new Path();
		fillBoardWithNodes();

		int sourceX = aSourcePoint.getX();
		int sourceY = aSourcePoint.getY();
		int targetX = aTargetPoint.getX();
		int targetY = aTargetPoint.getY();

		if ( !aBoardManager.canStand( aTargetPoint ) )
		{
			return path;
		}
		else
		{
			ArrayList<Node> closed = new ArrayList<>();
			SortedList open = new SortedList();
			int maxDepth = 0;

			open.add( nodes[sourceX][sourceY] );

			while ( maxDepth < maxSearchDistance && open.size() != 0 )
			{
				Node current = open.first();

				if ( current.equals( nodes[targetX][targetY] ) )
				{
					break;
				}

				open.remove( current );
				closed.add( current );

				for ( int x = -1; x < 2; x++ )
				{
					for ( int y = -1; y < 2; y++ )
					{
						if ( ( x == 0 ) || ( y == 0 ) )
						{
							int candidateX = x + current.getPoint()
							                            .getX();
							int candidateY = y + current.getPoint()
							                            .getY();

							if ( isValidLocation( aSourcePoint, new Point( candidateX, candidateY ), aBoardManager ) )
							{
								Node candidateNode = nodes[candidateX][candidateY];

								float nextStepCost = current.getCost() + heuristic.getCost( current.getPoint(), candidateNode.getPoint() );

								if ( nextStepCost < candidateNode.getCost() )
								{
									if ( open.contains( candidateNode ) )
									{
										open.remove( candidateNode );
									}

									closed.remove( candidateNode );

								}

								if ( !open.contains( candidateNode ) && !closed.contains( candidateNode ) )
								{
									float newHeuristic = heuristic.getCost( candidateNode.getPoint(), nodes[targetX][targetY].getPoint() );
									maxDepth = Math.max( maxDepth, candidateNode.increaseDepth( current ) );
									Node newNode = new Node( candidateNode.getPoint(), nextStepCost, maxDepth, current, newHeuristic );

									nodes[candidateX][candidateY] = newNode;
									open.add( newNode );
								}
							}
						}

					}
				}
			}
		}

		if ( nodes[targetX][targetY].getParent() != null )
		{
			Node target = nodes[targetX][targetY];
			while ( !target.equals( nodes[sourceX][sourceY] ) )
			{
				path.prependStep( target.getPoint() );
				target = target.getParent();
			}
		}

		return path;

	}

	private void fillBoardWithNodes()
	{
		nodes = new Node[BOARD_WIDTH][BOARD_HEIGHT];
		for ( int x = 0; x < BOARD_WIDTH; x++ )
		{
			for ( int y = 0; y < BOARD_HEIGHT; y++ )
			{
				nodes[x][y] = new Node( new Point( x, y ), 0.0F, 0, null, 0 );
			}
		}
	}

	private boolean isValidLocation( Point aSourcePoint, Point aNeighbourPoint, BoardManager aBoardManager )
	{
		boolean validation = ( aNeighbourPoint.getX() < 0 ) || ( aNeighbourPoint.getY() < 0 ) || ( aNeighbourPoint.getX() >= BOARD_WIDTH ) || ( aNeighbourPoint.getY() >= BOARD_HEIGHT );
		if ( ( !validation ) && ( ( aSourcePoint.getX() != aNeighbourPoint.getX() ) || ( aSourcePoint.getY() != aNeighbourPoint.getY() ) ) )
		{
			if ( aBoardManager.getTileByPoint( aNeighbourPoint ) != null )
			{
				validation = !aBoardManager.getTileByPoint( aNeighbourPoint )
				                           .isCrossable( movementType );
			}
		}
		return !validation;
	}
}
