package pl.sdk.creatures;

import pl.sdk.Fraction;

public abstract class AbstractFractionFactory {

    private static final String INVALID_FRACTION_NAME = "Invalid fraction name";
    protected static final String EXCEPTION_MESSAGE = "We support tiers from 1 to 7";

    public static Creature createSkeleton(){
        return new NecropolisFactory().create(false,1,1);
    }

    public static AbstractFractionFactory getInstance(Fraction aFraction) {
        switch (aFraction) {
            case NECROPOLIS:
                return new NecropolisFactory();
            case CASTLE:
                return new pl.sdk.creatures.CastleFactory();
            case TEST_FRACTION:
                return new TestingFactory();
            default:
                throw new IllegalArgumentException(INVALID_FRACTION_NAME);
        }
    }

    abstract public Creature create(boolean aIsUpgraded, int aTier, int aAmount);

}
