package pl.sdk.creatures;


import pl.sdk.creatures.attacking.*;
import pl.sdk.creatures.defending.DefenceContextFactory;

class NecropolisFactory extends AbstractFractionFactory {

    public Creature create(boolean aIsUpgraded, int aTier, int aAmount) {
        if (!aIsUpgraded) {
            switch (aTier) {
                case 1:
                    return new Creature
                            (CreatureStatistic.SKELETON,
                                    aAmount,
                                    DefenceContextFactory.create(CreatureStatistic.SKELETON),
                                    AttackContextFactory.create(CreatureStatistic.SKELETON, aAmount));

                case 2:
                    return new Creature
                            (CreatureStatistic.WALKING_DEAD,
                                    aAmount,
                                    DefenceContextFactory.create(CreatureStatistic.WALKING_DEAD),
                                    AttackContextFactory.create(CreatureStatistic.WALKING_DEAD, aAmount));

                case 3:
                    return new Creature
                            (CreatureStatistic.WIGHT,
                                    aAmount,
                                    DefenceContextFactory.create(CreatureStatistic.WIGHT),
                                    AttackContextFactory.create(CreatureStatistic.WIGHT, aAmount));
                case 4:
                    return new Creature
                            (CreatureStatistic.VAMPIRE,
                                    aAmount,
                                    DefenceContextFactory.create(CreatureStatistic.VAMPIRE),
                                    AttackContextFactory.create(CreatureStatistic.VAMPIRE, aAmount));
                case 5:
                    return new Creature
                            (CreatureStatistic.LICH,
                                    aAmount,
                                    DefenceContextFactory.create(CreatureStatistic.LICH),
                                    AttackContextFactory.create(CreatureStatistic.LICH, aAmount));
                case 6:
                    return new Creature
                            (CreatureStatistic.DREAD_KNIGHT,
                                    aAmount,
                                    DefenceContextFactory.create(CreatureStatistic.DREAD_KNIGHT),
                                    AttackContextFactory.create(CreatureStatistic.DREAD_KNIGHT, aAmount));
                case 7:
                    return new Creature
                            (CreatureStatistic.BONE_DRAGON,
                                    aAmount,
                                    DefenceContextFactory.create(CreatureStatistic.BONE_DRAGON),
                                    AttackContextFactory.create(CreatureStatistic.BONE_DRAGON, aAmount));
                default:
                    throw new IllegalArgumentException(EXCEPTION_MESSAGE);
            }
        } else {
            switch (aTier) {
                case 1:
                    return new Creature
                            (CreatureStatistic.SKELETON_WARRIOR,
                                    aAmount,
                                    DefenceContextFactory.create(CreatureStatistic.SKELETON_WARRIOR),
                                    AttackContextFactory.create(CreatureStatistic.SKELETON_WARRIOR, aAmount));
                case 2:
                    return new Creature
                            (CreatureStatistic.ZOMBIE,
                                    aAmount,
                                    DefenceContextFactory.create(CreatureStatistic.ZOMBIE),
                                    AttackContextFactory.create(CreatureStatistic.ZOMBIE, aAmount));
                case 3:
                    return new Creature
                            (CreatureStatistic.WRAITH,
                                    aAmount,
                                    DefenceContextFactory.create(CreatureStatistic.WRAITH),
                                    AttackContextFactory.create(CreatureStatistic.WRAITH, aAmount));
                case 4:
                    return new Creature
                            (CreatureStatistic.VAMPIRE_LORD,
                                    aAmount,
                                    DefenceContextFactory.create(CreatureStatistic.VAMPIRE_LORD),
                                    AttackContextFactory.create(CreatureStatistic.VAMPIRE_LORD, aAmount));
                case 5:
                    return new Creature
                            (CreatureStatistic.POWER_LICH,
                                    aAmount,
                                    DefenceContextFactory.create(CreatureStatistic.POWER_LICH),
                                    AttackContextFactory.create(CreatureStatistic.POWER_LICH, aAmount));
                case 6:
                    return new Creature
                            (CreatureStatistic.BLACK_KNIGHT,
                                    aAmount,
                                    DefenceContextFactory.create(CreatureStatistic.BLACK_KNIGHT),
                                    AttackContextFactory.create(CreatureStatistic.BLACK_KNIGHT, aAmount));
                case 7:
                    return new Creature
                            (CreatureStatistic.GHOST_DRAGON,
                                    aAmount,
                                    DefenceContextFactory.create(CreatureStatistic.GHOST_DRAGON),
                                    AttackContextFactory.create(CreatureStatistic.GHOST_DRAGON, aAmount));
                default:
                    throw new IllegalArgumentException(EXCEPTION_MESSAGE);
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
