package pl.sdk.creatures.moving.utils;

import java.util.ArrayList;
import java.util.Collections;

public class SortedList
{
	private final ArrayList<Node> list;

	public SortedList()
	{
		this.list = new ArrayList<>();
	}

	public Node first()
	{
		return this.list.get( 0 );
	}

	public void add( Node aNode )
	{
		this.list.add( aNode );
		Collections.sort( this.list );
	}

	public void remove( Node aNode )
	{
		this.list.remove( aNode );
	}

	public int size()
	{
		return this.list.size();
	}

	public boolean contains( Node aNode )
	{
		return this.list.contains( aNode );
	}
}
