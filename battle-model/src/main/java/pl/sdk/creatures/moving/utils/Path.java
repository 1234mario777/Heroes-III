package pl.sdk.creatures.moving.utils;

import pl.sdk.board.Point;

import java.util.ArrayList;

public class Path
{
	private final ArrayList<Point> steps = new ArrayList();

	public void prependStep( Point aPoint )
	{
		steps.add( 0, aPoint );
	}

	public boolean contains( Point aPoint )
	{
		return steps.contains( aPoint );
	}

	public ArrayList<Point> getSteps()
	{
		return new ArrayList<>(steps);
	}
}
