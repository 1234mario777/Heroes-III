package pl.sdk.creatures.moving;

import pl.sdk.creatures.MovementType;

public class MoveContextFactory
{
	public static MoveContextIf create( MovementType aMovementType, int aMoveRange )
	{
		if ( aMovementType.equals( MovementType.FLYING ) )
		{
			return new MoveContext( new FlyMoveStrategy( aMoveRange ), aMoveRange );
		}
		else if ( aMovementType.equals( MovementType.TELEPORT ) )
		{
			return new MoveContext( new TeleportMoveStrategy( aMoveRange ), aMoveRange );
		}
		else
		{
			return new MoveContext( new GroundMoveStrategy( aMoveRange ), aMoveRange );
		}
	}
}
