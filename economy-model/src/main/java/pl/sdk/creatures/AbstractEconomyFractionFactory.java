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
			case INFERNO:
				return new EconomyInfernoFactory();
			default:
				throw new IllegalArgumentException( INVALID_FRACTION_NAME );
		}

	}

	abstract public EconomyCreature create(boolean aIsUpgraded, int aTier, int aAmount);
}
