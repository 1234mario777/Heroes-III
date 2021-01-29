package pl.sdk.gui;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MapTileDefaultState extends MapTileState
{
	private final String STATE_NAME = "Default";

	@Override
	void updateBackground( Rectangle aRec )
	{
		aRec.setFill( Color.WHITE );
	}

	@Override
	String currentState()
	{
		return STATE_NAME;
	}
}
