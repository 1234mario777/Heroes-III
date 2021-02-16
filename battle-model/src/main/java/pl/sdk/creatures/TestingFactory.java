package pl.sdk.creatures;

public class TestingFactory extends AbstractFractionFactory {
    @Override
    public Creature create(boolean aIsUpgraded, int aTier, int aAmount) {
        if (!aIsUpgraded) {
            switch (aTier) {
//                case 1:
//                    return new Creature.Builder()
//                            .statistic(CreatureStatistic.SKELETON)
//                            .amount(aAmount)
//                            .build();
//                case 2:
//                    return new Creature.Builder()
//                            .statistic(CreatureStatistic.WALKING_DEAD)
//                            .amount(aAmount)
//                            .build();
//                case 3:
//                    return new Creature.Builder()
//                            .statistic(CreatureStatistic.WIGHT)
//                            .amount(aAmount)
//                            .build();
//                case 4:
//                    return new Creature.Builder()
//                            .statistic(CreatureStatistic.VAMPIRE)
//                            .amount(aAmount)
//                            .build();
//                case 5:
//                    Creature lich = new Creature.Builder()
//                            .statistic(CreatureStatistic.LICH)
//                            .amount(aAmount)
//                            .build();
//                    return new BlockCounterAttackCreatureDecorator(new ShootingCreatureDecorator(new SplashDamageCreatureDecorator(lich, getSplashForLich())));
//                case 6:
//                    return new Creature.Builder()
//                            .statistic(CreatureStatistic.BLACK_KNIGHT)
//                            .amount(aAmount)
//                            .build();
//                case 7:
//                    return new Creature.Builder()
//                            .statistic(CreatureStatistic.BONE_DRAGON)
//                            .amount(aAmount)
//                            .build();
                default:
                    throw new IllegalArgumentException("XX");
            }
        } else {
            switch (aTier) {
//                case 1:
//                    return new Creature.Builder()
//                            .statistic(CreatureStatistic.SKELETON_WARRIOR)
//                            .amount(aAmount)
//                            .build();
//                case 2:
//                    return new Creature.Builder()
//                            .statistic(CreatureStatistic.ZOMBIE)
//                            .amount(aAmount)
//                            .build();
//                case 3:
//                    return new RegenerationOnEndOfTurnCreatureDecorator(new Creature.Builder()
//                            .statistic(CreatureStatistic.WRAITH)
//                            .amount(aAmount)
//                            .build());
//                case 4:
//                    return new Creature.Builder()
//                            .statistic(CreatureStatistic.VAMPIRE_LORD)
//                            .amount(aAmount)
//                            .build();
//                case 5:
//                    Creature c = new Creature.Builder()
//                            .statistic(CreatureStatistic.POWER_LICH)
//                            .amount(aAmount)
//                            .build();
//                    boolean[][] splashDamageTable = getSplashForLich();
//                    return new SplashDamageCreatureDecorator(new BlockCounterAttackCreatureDecorator(new ShootingCreatureDecorator(c)), splashDamageTable);
//                case 6:
//                    return new Creature.Builder()
//                            .statistic(CreatureStatistic.DREAD_KNIGHT)
//                            .amount(aAmount)
//                            .build();
                case 7:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.TEST_TIER_7_UPGRADED)
                            .amount(aAmount)
                            .build();
                default:
                    throw new IllegalArgumentException("XX");
            }
        }
    }


    private boolean[][] getSplashForLich() {
        boolean[][] splashDamageTable = new boolean[3][3];
        splashDamageTable[0][1] = true;
        splashDamageTable[2][1] = true;
        splashDamageTable[1][1] = true;
        splashDamageTable[1][2] = true;
        splashDamageTable[1][0] = true;
        return splashDamageTable;
    }
}
