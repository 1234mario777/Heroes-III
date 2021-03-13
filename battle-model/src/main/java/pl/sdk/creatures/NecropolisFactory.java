package pl.sdk.creatures;


public class NecropolisFactory extends AbstractFractionFactory {

    private static final String EXCEPTION_MESSAGE = "We support tiers from 1 to 7";

//    public static Creature createDefaultForTests() {
//        return Creature.Builder()
//                .statistic(CreatureStatistic.TEST)
//                .build();
//    }

    public Creature create(boolean aIsUpgraded, int aTier, int aAmount) {
        if (!aIsUpgraded) {
            switch (aTier) {
                case 1:
                    return new Creature
                            (CreatureStatistic.SKELETON,
                                    aAmount,
                                    new DefaultDefenceContext(new DefaultDamageApplier(), CreatureStatistic.SKELETON.getArmor()),
                                            new DefaultAttackContext(new DefaultCalculateStrategyIf(), mapStatsToAttackContextStats(aAmount, CreatureStatistic.SKELETON)));

                case 2:
                    return new Creature
                            (CreatureStatistic.WALKING_DEAD,
                                    aAmount,
                                    new DefaultDefenceContext(new DefaultDamageApplier(), CreatureStatistic.WALKING_DEAD.getArmor()),
                                    new DefaultAttackContext(new DefaultCalculateStrategyIf(), mapStatsToAttackContextStats(aAmount, CreatureStatistic.WALKING_DEAD)));

                case 3:
                    return new Creature
                            (CreatureStatistic.WIGHT,
                                    aAmount,
                                    new DefaultDefenceContext(new DefaultDamageApplier(), CreatureStatistic.WIGHT.getArmor()),
                                    new DefaultAttackContext(new DefaultCalculateStrategyIf(), mapStatsToAttackContextStats(aAmount, CreatureStatistic.WIGHT)));
                case 4:
                    return new Creature
                            (CreatureStatistic.VAMPIRE,
                                    aAmount,
                                    new DefaultDefenceContext(new DefaultDamageApplier(), CreatureStatistic.VAMPIRE.getArmor()),
                                    new DefaultAttackContext(new DefaultCalculateStrategyIf(), mapStatsToAttackContextStats(aAmount, CreatureStatistic.VAMPIRE)));
                case 5:
                    return new Creature
                            (CreatureStatistic.LICH,
                                    aAmount,
                                    new DefaultDefenceContext(new DefaultDamageApplier(), CreatureStatistic.LICH.getArmor()),
                                    new DefaultAttackContext(new DefaultCalculateStrategyIf(), mapStatsToAttackContextStats(aAmount, CreatureStatistic.LICH)));
                case 6:
                    return new Creature
                            (CreatureStatistic.DREAD_KNIGHT,
                                    aAmount,
                                    new DefaultDefenceContext(new DefaultDamageApplier(), CreatureStatistic.DREAD_KNIGHT.getArmor()),
                                    new DefaultAttackContext(new DefaultCalculateStrategyIf(), mapStatsToAttackContextStats(aAmount, CreatureStatistic.DREAD_KNIGHT)));
                case 7:
                    return new Creature
                            (CreatureStatistic.BONE_DRAGON,
                                    aAmount,
                                    new DefaultDefenceContext(new DefaultDamageApplier(), CreatureStatistic.BONE_DRAGON.getArmor()),
                                    new DefaultAttackContext(new DefaultCalculateStrategyIf(), mapStatsToAttackContextStats(aAmount, CreatureStatistic.BONE_DRAGON)));
                default:
                    throw new IllegalArgumentException(EXCEPTION_MESSAGE);
            }
        } else {
            switch (aTier) {
                case 1:
                    return new Creature
                            (CreatureStatistic.SKELETON_WARRIOR,
                                    aAmount,
                                    new DefaultDefenceContext(new DefaultDamageApplier(), CreatureStatistic.SKELETON_WARRIOR.getArmor()),
                                    new DefaultAttackContext(new DefaultCalculateStrategyIf(), mapStatsToAttackContextStats(aAmount, CreatureStatistic.SKELETON_WARRIOR)));

                case 2:
                    return new Creature
                            (CreatureStatistic.ZOMBIE,
                                    aAmount,
                                    new DefaultDefenceContext(new DefaultDamageApplier(), CreatureStatistic.ZOMBIE.getArmor()),
                                    new DefaultAttackContext(new DefaultCalculateStrategyIf(), mapStatsToAttackContextStats(aAmount, CreatureStatistic.ZOMBIE)));

                case 3:
                    return new Creature
                            (CreatureStatistic.WRAITH,
                                    aAmount,
                                    new DefaultDefenceContext(new DefaultDamageApplier(), CreatureStatistic.WRAITH.getArmor()),
                                    new DefaultAttackContext(new DefaultCalculateStrategyIf(), mapStatsToAttackContextStats(aAmount, CreatureStatistic.WRAITH)));
                case 4:
                    return new Creature
                            (CreatureStatistic.VAMPIRE_LORD,
                                    aAmount,
                                    new DefaultDefenceContext(new DefaultDamageApplier(), CreatureStatistic.VAMPIRE_LORD.getArmor()),
                                    new DefaultAttackContext(new DefaultCalculateStrategyIf(), mapStatsToAttackContextStats(aAmount, CreatureStatistic.VAMPIRE_LORD)));
                case 5:
                    return new Creature
                            (CreatureStatistic.POWER_LICH,
                                    aAmount,
                                    new DefaultDefenceContext(new DefaultDamageApplier(), CreatureStatistic.POWER_LICH.getArmor()),
                                    new DefaultAttackContext(new DefaultCalculateStrategyIf(), mapStatsToAttackContextStats(aAmount, CreatureStatistic.POWER_LICH)));
                case 6:
                    return new Creature
                            (CreatureStatistic.BLACK_KNIGHT,
                                    aAmount,
                                    new DefaultDefenceContext(new DefaultDamageApplier(), CreatureStatistic.BLACK_KNIGHT.getArmor()),
                                    new DefaultAttackContext(new DefaultCalculateStrategyIf(), mapStatsToAttackContextStats(aAmount, CreatureStatistic.BLACK_KNIGHT)));
                case 7:
                    return new Creature
                            (CreatureStatistic.GHOST_DRAGON,
                                    aAmount,
                                    new DefaultDefenceContext(new DefaultDamageApplier(), CreatureStatistic.GHOST_DRAGON.getArmor()),
                                    new DefaultAttackContext(new DefaultCalculateStrategyIf(), mapStatsToAttackContextStats(aAmount, CreatureStatistic.GHOST_DRAGON)));
                default:
                    throw new IllegalArgumentException(EXCEPTION_MESSAGE);
            }
        }
    }

    private AttackerStatisticIf mapStatsToAttackContextStats(int aAmount, CreatureStatistic aStatistic) {
        return AttackerWithBuffEtcStatistic.builder()
                .amount(aAmount)
                .attack(aStatistic.getAttack())
                .attackRange(1)
                .damage(aStatistic.getDamage())
                .build();
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
