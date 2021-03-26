package pl.sdk.hero;

import pl.sdk.Fraction;
import pl.sdk.HeroEnum;

public abstract class AbstractEconomyHeroFactory {
    private static final String INVALID_FRACTION_NAME = "Invalid hero name";

    public static AbstractEconomyHeroFactory getInstance(Fraction aFraction ) {
        switch ( aFraction ) {
            case NECROPOLIS:
                return new EconomyNecropolisHeroFactory();
            default:
                throw new IllegalArgumentException( INVALID_FRACTION_NAME );
        }
    }

    abstract public HeroStats create(HeroEnum aHero);
}
