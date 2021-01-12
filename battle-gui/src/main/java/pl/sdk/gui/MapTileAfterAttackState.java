package pl.sdk.gui;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MapTileAfterAttackState extends MapTileState
{
	private final String STATE_NAME = "After Attack";

	MapTileAfterAttackState( MapTile aMapTile )
	{
		super( aMapTile );
	}

	@Override
	void updateBackground( Rectangle aRec )
	{
		aRec.setFill( Color.LIGHTCORAL );
	}

	@Override
	String currentState()
	{
		return STATE_NAME;
	}
}
