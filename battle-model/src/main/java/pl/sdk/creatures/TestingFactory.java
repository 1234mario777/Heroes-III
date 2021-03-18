package pl.sdk.creatures;

import pl.sdk.creatures.attacking.AttackContextFactory;
import pl.sdk.creatures.defending.DefenceContextFactory;

public class TestingFactory extends AbstractFractionFactory {

    public Creature create(boolean aIsUpgraded, int aTier, int aAmount) {
        if (!aIsUpgraded) {
            switch (aTier) {
                case 1:
                    return new Creature
                            (CreatureStatistic.TEST_TIER_1_NOT_UPGRADED,
                                    aAmount,
                                    DefenceContextFactory.create(CreatureStatistic.TEST_TIER_1_NOT_UPGRADED),
                                    AttackContextFactory.create(CreatureStatistic.TEST_TIER_1_NOT_UPGRADED, aAmount));

                case 2:
                    return new Creature
                            (CreatureStatistic.TEST_TIER_2_NOT_UPGRADED,
                                    aAmount,
                                    DefenceContextFactory.create(CreatureStatistic.TEST_TIER_2_NOT_UPGRADED),
                                    AttackContextFactory.create(CreatureStatistic.TEST_TIER_2_NOT_UPGRADED, aAmount));

                case 3:
                    return new Creature
                            (CreatureStatistic.TEST_TIER_3_NOT_UPGRADED,
                                    aAmount,
                                    DefenceContextFactory.create(CreatureStatistic.TEST_TIER_3_NOT_UPGRADED),
                                    AttackContextFactory.create(CreatureStatistic.TEST_TIER_3_NOT_UPGRADED, aAmount));
                case 4:
                    return new Creature
                            (CreatureStatistic.TEST_TIER_4_NOT_UPGRADED,
                                    aAmount,
                                    DefenceContextFactory.create(CreatureStatistic.TEST_TIER_4_NOT_UPGRADED),
                                    AttackContextFactory.create(CreatureStatistic.TEST_TIER_4_NOT_UPGRADED, aAmount));
                case 5:
                    return new Creature
                            (CreatureStatistic.TEST_TIER_5_NOT_UPGRADED,
                                    aAmount,
                                    DefenceContextFactory.create(CreatureStatistic.TEST_TIER_5_NOT_UPGRADED),
                                    AttackContextFactory.create(CreatureStatistic.TEST_TIER_5_NOT_UPGRADED, aAmount));
                case 6:
                    return new Creature
                            (CreatureStatistic.TEST_TIER_6_NOT_UPGRADED,
                                    aAmount,
                                    DefenceContextFactory.create(CreatureStatistic.TEST_TIER_6_NOT_UPGRADED),
                                    AttackContextFactory.create(CreatureStatistic.TEST_TIER_6_NOT_UPGRADED, aAmount));
                case 7:
                    return new Creature
                            (CreatureStatistic.TEST_TIER_7_NOT_UPGRADED,
                                    aAmount,
                                    DefenceContextFactory.create(CreatureStatistic.TEST_TIER_7_NOT_UPGRADED),
                                    AttackContextFactory.create(CreatureStatistic.TEST_TIER_7_NOT_UPGRADED, aAmount));
                default:
                    throw new IllegalArgumentException(EXCEPTION_MESSAGE);
            }
        } else {
            switch (aTier) {
                case 1:
                    return new Creature
                            (CreatureStatistic.TEST_TIER_1_UPGRADED,
                                    aAmount,
                                    DefenceContextFactory.create(CreatureStatistic.TEST_TIER_1_UPGRADED),
                                    AttackContextFactory.create(CreatureStatistic.TEST_TIER_1_UPGRADED, aAmount));
                case 2:
                    return new Creature
                            (CreatureStatistic.TEST_TIER_2_UPGRADED,
                                    aAmount,
                                    DefenceContextFactory.create(CreatureStatistic.TEST_TIER_2_UPGRADED),
                                    AttackContextFactory.create(CreatureStatistic.TEST_TIER_2_UPGRADED, aAmount));
                case 3:
                    return new Creature
                            (CreatureStatistic.TEST_TIER_3_UPGRADED,
                                    aAmount,
                                    DefenceContextFactory.create(CreatureStatistic.TEST_TIER_3_UPGRADED),
                                    AttackContextFactory.create(CreatureStatistic.TEST_TIER_3_UPGRADED, aAmount));
                case 4:
                    return new Creature
                            (CreatureStatistic.TEST_TIER_4_UPGRADED,
                                    aAmount,
                                    DefenceContextFactory.create(CreatureStatistic.TEST_TIER_4_UPGRADED),
                                    AttackContextFactory.create(CreatureStatistic.TEST_TIER_4_UPGRADED, aAmount));
                case 5:
                    return new Creature
                            (CreatureStatistic.TEST_TIER_5_UPGRADED,
                                    aAmount,
                                    DefenceContextFactory.create(CreatureStatistic.TEST_TIER_5_UPGRADED),
                                    AttackContextFactory.create(CreatureStatistic.TEST_TIER_5_UPGRADED, aAmount));
                case 6:
                    return new Creature
                            (CreatureStatistic.TEST_TIER_6_UPGRADED,
                                    aAmount,
                                    DefenceContextFactory.create(CreatureStatistic.TEST_TIER_6_UPGRADED),
                                    AttackContextFactory.create(CreatureStatistic.TEST_TIER_6_UPGRADED, aAmount));
                case 7:
                    return new Creature
                            (CreatureStatistic.TEST_TIER_7_UPGRADED,
                                    aAmount,
                                    DefenceContextFactory.create(CreatureStatistic.TEST_TIER_7_UPGRADED),
                                    AttackContextFactory.create(CreatureStatistic.TEST_TIER_7_UPGRADED, aAmount));
                default:
                    throw new IllegalArgumentException(EXCEPTION_MESSAGE);
            }
        }
    }
}
