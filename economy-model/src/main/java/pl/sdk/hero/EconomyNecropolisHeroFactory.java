package pl.sdk.hero;

import pl.sdk.HeroEnum;

import java.util.Random;

public class EconomyNecropolisHeroFactory extends AbstractEconomyHeroFactory{
    private static final String EXCEPTION_MESSAGE = "Illegall hero data";
    private Random rand = new Random();
    public HeroStats create(HeroEnum aHero) {
            switch (aHero) {
                case WARRIOR:
                    return new HeroStats(rand.nextInt(5)+1,rand.nextInt(5)+1,rand.nextInt(3)+1,rand.nextInt(3)+1);
                case MAG:
                    return new HeroStats(rand.nextInt(3)+1,rand.nextInt(3)+1,rand.nextInt(5)+1,rand.nextInt(5)+1);
                default:
                    throw new IllegalArgumentException(EXCEPTION_MESSAGE);
            }
    }
}
