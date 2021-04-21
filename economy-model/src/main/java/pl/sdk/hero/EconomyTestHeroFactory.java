package pl.sdk.hero;

import pl.sdk.HeroEnum;

import java.util.Random;

public class EconomyTestHeroFactory extends AbstractEconomyHeroFactory {
    private static final String EXCEPTION_MESSAGE = "We support tiers from 1 to 7";
    private Random rand = new Random();
    public HeroStats create(HeroEnum aHero) {
        switch (aHero) {
            case WARRIOR:
                return new HeroStats(1,1,1,1);
            case MAG:
                return new HeroStats(rand.nextInt(3)+1,rand.nextInt(3)+1,rand.nextInt(3)+1,rand.nextInt(3)+1);
            default:
                throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }
}
