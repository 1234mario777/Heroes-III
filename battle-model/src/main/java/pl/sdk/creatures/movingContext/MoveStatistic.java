package pl.sdk.creatures.movingContext;

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
