package pl.sdk.creatures.moving;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.Fraction;
import pl.sdk.board.BoardManager;
import pl.sdk.board.Point;
import pl.sdk.creatures.AbstractFractionFactory;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.MovementType;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PathFinderTest
{
	private BoardManager boardManager;
	PathFinder groundPathFinder;
	PathFinder flyingPathFinder;

	@BeforeEach
	void init()
	{
		int maxMoveRange = Integer.MAX_VALUE;
		groundPathFinder = new PathFinder( MovementType.GROUND, maxMoveRange );
		flyingPathFinder = new PathFinder( MovementType.FLYING, maxMoveRange );
		boardManager = new BoardManager();
	}

	@Test
	void manhattanHeuristicShouldReturnCorrectValue()
	{
		ManhattanDistanceHeuristic h = new ManhattanDistanceHeuristic();

		assertEquals( 3, h.getCost( new Point( 0, 0 ), new Point( 1, 2 ) ) );

	}

	@Test
	void euclideanHeuristicShouldReturnCorrectValue()
	{
		EuclideanDistanceHeuristic h = new EuclideanDistanceHeuristic();

		assertEquals( 10, ( int ) h.getCost( new Point( 0, 0 ), new Point( 1, 10 ) ) );

	}

	@Test
	void pathShouldContainCorrectPoints()
	{
		Point sourcePoint = new Point( 0, 0 );
		Point targetPoint = new Point( 8, 0 );

		List<Point> path = groundPathFinder.getPath( boardManager, sourcePoint, targetPoint )
		                                   .getSteps();

		assertTrue( path.contains( new Point( 1, 0 ) ) );
		assertTrue( path.contains( new Point( 2, 0 ) ) );
		assertTrue( path.contains( new Point( 3, 0 ) ) );
		assertTrue( path.contains( new Point( 4, 0 ) ) );
		assertTrue( path.contains( new Point( 5, 0 ) ) );
		assertTrue( path.contains( new Point( 6, 0 ) ) );
		assertTrue( path.contains( new Point( 7, 0 ) ) );
		assertTrue( path.contains( new Point( 8, 0 ) ) );
		assertEquals( 8, path.size() );

	}

	@Test
	void pathFinderShouldReturnEmptyPathWhenMoveRangeIsLowerThanDistance()
	{
		PathFinder specificPathFinder = new PathFinder( MovementType.GROUND, 1 );
		Point sourcePoint = new Point( 0, 0 );
		Point targetPoint = new Point( 3, 0 );
		assertEquals( 0, specificPathFinder.getPath( boardManager, sourcePoint, targetPoint )
		                                   .getSteps()
		                                   .size() );

	}

	@Test
	void pathFinderShouldReturnEmptyPathWhenTargetPointIsNotStandable()
	{
		Point sourcePoint = new Point( 0, 0 );
		Point targetPoint = new Point( 3, 0 );
		Creature creature = AbstractFractionFactory.createSkeleton();
		boardManager.putOnBoard( targetPoint, creature );

		assertEquals( 0, groundPathFinder.getPath( boardManager, sourcePoint, targetPoint )
		                                 .getSteps()
		                                 .size() );

	}

	@Test
	void pathFinderShouldReturnEmptyPathWhenCreatureCannotReachTarget()
	{
		// M - mover, MoveType.GROUND, C - Creature (isMovable return false for MoveType.GROUND), T - Target point
		//    0 1 2 3 4
		//  0 M C x x x
		//  1 C T x x x
		//  2 x x x x x
		//  3 x x x x x
		//  4 x x x x x

		Point sourcePoint = new Point( 0, 0 );
		Point targetPoint = new Point( 1, 1 );
		Point obstacle1 = new Point( 0, 1 );
		Point obstacle2 = new Point( 1, 0 );
		boardManager.putOnBoard( obstacle1, AbstractFractionFactory.createSkeleton() );
		boardManager.putOnBoard( obstacle2, AbstractFractionFactory.createSkeleton() );

		assertEquals( 0, groundPathFinder.getPath( boardManager, sourcePoint, targetPoint )
		                                 .getSteps()
		                                 .size() );

	}

	@Test
	void groundStrategyCanAvoidObstacle()
	{
		// M - mover, MoveType.GROUND, C - Creature (isMovable return false for MoveType.GROUND), T - Target point
		//    0 1 2 3 4
		//  0 M x x x x
		//  1 x C x x x
		//  2 x C x x x
		//  3 C x x x x
		//  4 T x x x x

		Point sourcePoint = new Point( 0, 0 );
		Point targetPoint = new Point( 0, 4 );
		Point obstacle1 = new Point( 1, 1 );
		Point obstacle2 = new Point( 1, 2 );
		Point obstacle3 = new Point( 0, 3 );
		boardManager.putOnBoard( obstacle1, AbstractFractionFactory.createSkeleton() );
		boardManager.putOnBoard( obstacle2, AbstractFractionFactory.createSkeleton() );
		boardManager.putOnBoard( obstacle3, AbstractFractionFactory.createSkeleton() );

		List<Point> path = groundPathFinder.getPath( boardManager, sourcePoint, targetPoint )
		                                   .getSteps();

		assertEquals( 8, path.size() );
		assertTrue( path.contains( new Point( 1, 0 ) ) );
		assertTrue( path.contains( new Point( 2, 0 ) ) );
		assertTrue( path.contains( new Point( 2, 1 ) ) );
		assertTrue( path.contains( new Point( 2, 2 ) ) );
		assertTrue( path.contains( new Point( 2, 3 ) ) );
		assertTrue( path.contains( new Point( 1, 3 ) ) );
		assertTrue( path.contains( new Point( 1, 4 ) ) );
		assertTrue( path.contains( new Point( 0, 4 ) ) );
	}

	@Test
	void flyingStrategyCanOverflyCreatureObstacle()
	{
		// M - mover, MoveType.FLYING, C - Creature (isMovable return true for MoveType.FLYING), T - Target point
		//    0 1 2 3 4
		//  0 M C x x x
		//  1 C T x x x
		//  2 x x x x x
		//  3 x x x x x
		//  4 x x x x x

		Point sourcePoint = new Point( 0, 0 );
		Point targetPoint = new Point( 1, 1 );
		Point obstacle1 = new Point( 0, 1 );
		Point obstacle2 = new Point( 1, 0 );
		boardManager.putOnBoard( obstacle1, AbstractFractionFactory.createSkeleton() );
		boardManager.putOnBoard( obstacle2, AbstractFractionFactory.createSkeleton() );

		List<Point> path = flyingPathFinder.getPath( boardManager, sourcePoint, targetPoint )
		                                   .getSteps();

		assertEquals( 2, path.size() );
		assertTrue( path.contains( new Point( 0, 1 ) ) );
		assertTrue( path.contains( new Point( 1, 1 ) ) );

	}

}