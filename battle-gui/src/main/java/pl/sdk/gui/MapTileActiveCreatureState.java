package pl.sdk.gui;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MapTileActiveCreatureState extends MapTileState
{
	private final String STATE_NAME = "Active Creature";

	@Override
	void updateBackground( Rectangle aRec )
	{
		aRec.setFill( Color.GREEN );
	}

	@Override
	String currentState()
	{
		return STATE_NAME;
	}
}
