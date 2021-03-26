package pl.sdk.hero;

import pl.sdk.HeroEnum;

public class EconomyNecropolisHeroFactory extends AbstractEconomyHeroFactory{
    private static final String EXCEPTION_MESSAGE = "We support tiers from 1 to 7";
    public HeroStats create(HeroEnum aHero) {
            switch (aHero) {
                case WARRIOR:
                    return new HeroStats(1,1,1,1);
                case MAG:
                    return new HeroStats(2,2,2,2);
                default:
                    throw new IllegalArgumentException(EXCEPTION_MESSAGE);
            }
    }

}
