package pl.sdk.gui;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MapTileMovePossibleState extends MapTileState
{
	private final String STATE_NAME = "Move Possible";

	MapTileMovePossibleState( MapTile aMapTile )
	{
		super( aMapTile );
	}

	@Override
	void updateBackground( Rectangle aRec )
	{
		aRec.setFill( Color.GREY );
	}

	@Override
	String currentState()
	{
		return STATE_NAME;
	}
}
