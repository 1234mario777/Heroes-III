package pl.sdk.creatures.moving;

import lombok.Getter;

@Getter
public class MoveContext implements MoveContextIf
{
	private final MoveStrategyIf moveStrategyIf;
	private final MoveStatistic moveStatistic;

	public MoveContext( MoveStrategyIf aMoveStrategyIf, int aMoveRange )
	{
		moveStrategyIf = aMoveStrategyIf;
		moveStatistic = new MoveStatistic( aMoveRange );
	}

	@Override
	public MoveStrategyIf getMoveStrategy()
	{
		return moveStrategyIf;
	}
}
