package pl.sdk.creatures;


public class EconomyFortressFactory extends AbstractEconomyFractionFactory {

    private static final String EXCEPTION_MESSAGE = "We support tiers from 1 to 7";

    public EconomyCreature create(boolean aIsUpgraded, int aTier, int aAmount) {
        if (!aIsUpgraded) {
            switch (aTier) {
                case 1:
                    return new EconomyCreature(CreatureStatistic.GNOLL, aAmount, 50);
                case 2:
                    return new EconomyCreature(CreatureStatistic.LIZARDMAN, aAmount, 110);
                case 3:
                    return new EconomyCreature(CreatureStatistic.SERPENT_FLY, aAmount, 220);
                case 4:
                    return new EconomyCreature(CreatureStatistic.BASILISK, aAmount, 325);
                case 5:
                    return new EconomyCreature(CreatureStatistic.GORGON, aAmount, 525);
                case 6:
                    return new EconomyCreature(CreatureStatistic.WYVERN, aAmount, 800);
                case 7:
                    return new EconomyCreature(CreatureStatistic.HYDRA, aAmount, 2200);
                default:
                    throw new IllegalArgumentException(EXCEPTION_MESSAGE);
            }
        } else {
            switch (aTier) {
                case 1:
                    return new EconomyCreature(CreatureStatistic.GNOLL_MARADEUR, aAmount, 70);
                case 2:
                    return new EconomyCreature(CreatureStatistic.LIZARD_WARRIOR, aAmount, 140);
                case 3:
                    return new EconomyCreature(CreatureStatistic.DRAGON_FLY, aAmount, 240);
                case 4:
                    return new EconomyCreature(CreatureStatistic.GREATER_BASILISK, aAmount, 400);
                case 5:
                    return new EconomyCreature(CreatureStatistic.MIGHTY_GORGON, aAmount, 600);
                case 6:
                    return new EconomyCreature(CreatureStatistic.WYVERN_MONARCH, aAmount, 1100);
                case 7:
                    return new EconomyCreature(CreatureStatistic.CHAOS_HYDRA, aAmount, 3500);
                default:
                    throw new IllegalArgumentException(EXCEPTION_MESSAGE);
            }
        }
    }
}
