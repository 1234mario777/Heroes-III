package pl.sdk.creatures;

import pl.sdk.Fraction;

public abstract class AbstractEconomyFractionFactory
{
	private static final String INVALID_FRACTION_NAME = "Invalid fraction name";

	public static AbstractEconomyFractionFactory getInstance( Fraction aFraction )
	{
		switch ( aFraction )
		{
			case NECROPOLIS:
				return new EconomyNecropolisFactory();
			case TEST_FRACTION	:
				return new EconomyTestFractionFactory();
			case FORTRESS:
				return new EconomyFortressFactory();
			case INFERNO:
				return new EconomyInfernoFactory();
			case TOWER:
				return new EconomyTowerFactory();
			case CASTLE:
				return new EconomyCastleFactory();
			case STRONGHOLD:
				return new EconomyStrongholdFactory();
			case DUNGEON:
				return new EconomyDungeonFactory();
			default:
				throw new IllegalArgumentException( INVALID_FRACTION_NAME );
		}

	}

	abstract public EconomyCreature create(boolean aIsUpgraded, int aTier, int aAmount);
}
