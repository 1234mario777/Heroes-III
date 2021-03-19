package pl.sdk.creatures;


public class EconomyInfernoFactory extends AbstractEconomyFractionFactory {

    private static final String EXCEPTION_MESSAGE = "We support tiers from 1 to 7";

    public EconomyCreature create(boolean aIsUpgraded, int aTier, int aAmount) {
        if (!aIsUpgraded) {
            switch (aTier) {
                case 1:
                    return new EconomyCreature(CreatureStatistic.IMP, aAmount, 50);
                case 2:
                    return new EconomyCreature(CreatureStatistic.GOG, aAmount, 125);
                case 3:
                    return new EconomyCreature(CreatureStatistic.HELL_HOUND, aAmount, 200);
                case 4:
                    return new EconomyCreature(CreatureStatistic.DEMON, aAmount, 250);
                case 5:
                    return new EconomyCreature(CreatureStatistic.PIT_FIEND, aAmount, 500);
                case 6:
                    return new EconomyCreature(CreatureStatistic.EFREETI, aAmount, 900);
                case 7:
                    return new EconomyCreature(CreatureStatistic.DEVIL, aAmount, 2700);
                default:
                    throw new IllegalArgumentException(EXCEPTION_MESSAGE);
            }
        } else {
            switch (aTier) {
                case 1:
                    return new EconomyCreature(CreatureStatistic.FAMILIAR, aAmount, 60);
                case 2:
                    return new EconomyCreature(CreatureStatistic.MAGOG, aAmount, 175);
                case 3:
                    return new EconomyCreature(CreatureStatistic.CERBERUS, aAmount, 250);
                case 4:
                    return new EconomyCreature(CreatureStatistic.HORNED_DEMON, aAmount, 270);
                case 5:
                    return new EconomyCreature(CreatureStatistic.PIT_LORD, aAmount, 700);
                case 6:
                    return new EconomyCreature(CreatureStatistic.EFREET_SULTAN, aAmount, 1100);
                case 7:
                    return new EconomyCreature(CreatureStatistic.ARCH_DEVIL, aAmount, 4500);
                default:
                    throw new IllegalArgumentException(EXCEPTION_MESSAGE);
            }
        }
    }
}
