package pl.sdk.hero;

import pl.sdk.Fraction;
import pl.sdk.HeroEnum;
import pl.sdk.creatures.*;

public abstract class AbstractEconomyHeroFactory {
    private static final String INVALID_FRACTION_NAME = "Invalid hero name";

    public static AbstractEconomyHeroFactory getInstance(Fraction aFraction ) {
        switch ( aFraction ) {
            case NECROPOLIS:
            case CASTLE:
            case FORTRESS:
            case INFERNO:
            case TOWER:
            case STRONGHOLD:
            case RAMPART:
            case DUNGEON:
                return new EconomyNecropolisHeroFactory();
            case TEST_FRACTION:
                return new EconomyTestHeroFactory();
            default:
                throw new IllegalArgumentException( INVALID_FRACTION_NAME );
        }
    }

    abstract public HeroStats create(HeroEnum aHero);
}
