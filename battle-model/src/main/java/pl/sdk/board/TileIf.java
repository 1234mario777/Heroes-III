package pl.sdk.board;

import pl.sdk.creatures.MovementType;

public interface TileIf
{
	boolean isStandable();

	boolean isCrossable( MovementType aMovementType );
}
