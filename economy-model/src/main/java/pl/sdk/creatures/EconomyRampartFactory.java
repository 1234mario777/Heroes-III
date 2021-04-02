package pl.sdk.creatures;


public class EconomyRampartFactory extends AbstractEconomyFractionFactory {

    private static final String EXCEPTION_MESSAGE = "We support tiers from 1 to 7";

    public EconomyCreature create(boolean aIsUpgraded, int aTier, int aAmount) {
        if (!aIsUpgraded) {
            switch (aTier) {
                case 1:
                    return new EconomyCreature(CreatureStatistic.CENTAUR, aAmount, 70);
                case 2:
                    return new EconomyCreature(CreatureStatistic.DWARF, aAmount, 120);
                case 3:
                    return new EconomyCreature(CreatureStatistic.WOOD_ELF, aAmount, 200);
                case 4:
                    return new EconomyCreature(CreatureStatistic.PEGASUS, aAmount, 250);
                case 5:
                    return new EconomyCreature(CreatureStatistic.DENDROID_GUARD, aAmount, 350);
                case 6:
                    return new EconomyCreature(CreatureStatistic.UNICORN, aAmount, 850);
                case 7:
                    return new EconomyCreature(CreatureStatistic.GREEN_DRAGON, aAmount, 2400);
                default:
                    throw new IllegalArgumentException(EXCEPTION_MESSAGE);
            }
        } else {
            switch (aTier) {
                case 1:
                    return new EconomyCreature(CreatureStatistic.CENTAUR_CAPTAIN, aAmount, 90);
                case 2:
                    return new EconomyCreature(CreatureStatistic.BATTLE_DWARF, aAmount, 150);
                case 3:
                    return new EconomyCreature(CreatureStatistic.GRAND_ELF, aAmount, 225);
                case 4:
                    return new EconomyCreature(CreatureStatistic.SILVER_PEGASUS, aAmount, 275);
                case 5:
                    return new EconomyCreature(CreatureStatistic.DENDROID_SOLDIER, aAmount, 425);
                case 6:
                    return new EconomyCreature(CreatureStatistic.WAR_UNICORN, aAmount, 950);
                case 7:
                    return new EconomyCreature(CreatureStatistic.GOLD_DRAGON, aAmount, 4000);
                default:
                    throw new IllegalArgumentException(EXCEPTION_MESSAGE);
            }
        }
    }
}