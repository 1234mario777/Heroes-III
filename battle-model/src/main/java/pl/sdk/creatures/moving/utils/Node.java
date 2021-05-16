package pl.sdk.creatures.moving.utils;

import pl.sdk.board.Point;

import java.util.Objects;

public class Node implements Comparable<Node>
{
	private final Point point;
	private int depth;
	private final Node parent;
	private final float heuristic;
	private final float cost;

	public Node( Point aPoint, float aCost, int aDepth, Node aParent, float aHeuristic )
	{
		point = aPoint;
		cost = aCost;
		depth = aDepth;
		parent = aParent;
		heuristic = aHeuristic;
	}

	@Override
	public int compareTo( Node aNode )
	{

		float f = heuristic + cost;
		float of = aNode.getHeuristic() + aNode.getCost();

		if ( f < of )
		{
			return -1;
		}
		else if ( f > of )
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}

	public int increaseDepth( Node aParent )
	{
		if ( aParent != null )
		{
			depth = aParent.getDepth() + 1;
		}

		return depth;
	}

	public Point getPoint()
	{
		return point;
	}

	public Node getParent()
	{
		return parent;
	}

	private int getDepth()
	{
		return depth;
	}

	float getHeuristic()
	{
		return heuristic;
	}

	public float getCost()
	{
		return cost;
	}

	@Override
	public boolean equals( Object aO )
	{
		if ( this == aO )
		{
			return true;
		}
		if ( aO == null || getClass() != aO.getClass() )
		{
			return false;
		}
		Node node = ( Node ) aO;
		return depth == node.depth && Float.compare( node.heuristic, heuristic ) == 0 && Float.compare( node.cost, cost ) == 0 && Objects.equals( point, node.point ) && Objects.equals( parent, node.parent );
	}

	@Override
	public int hashCode()
	{
		return Objects.hash( point, depth, parent, heuristic, cost );
	}
}
