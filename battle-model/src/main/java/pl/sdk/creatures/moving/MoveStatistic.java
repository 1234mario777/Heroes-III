package pl.sdk.creatures.moving;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MoveStatistic
{
	private int moveRange;

	public MoveStatistic( int aMoveRange )
	{
		moveRange = aMoveRange;
	}
}
