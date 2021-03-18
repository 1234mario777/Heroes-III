package pl.sdk.creatures;


public class EconomyTowerFactory extends AbstractEconomyFractionFactory{

    private static final String EXCEPTION_MESSAGE = "We support tiers from 1 to 7";

    public EconomyCreature create(boolean aIsUpgraded, int aTier, int aAmount){
        if(!aIsUpgraded){
            switch (aTier){
                case 1:
                    return new EconomyCreature( CreatureStatistic.GREMLIN, aAmount, 30);
                case 2:
                    return new EconomyCreature(CreatureStatistic.STONE_GARGOYLE,aAmount,130);
                case 3:
                    return new EconomyCreature(CreatureStatistic.STONE_GOLEM,aAmount,150);
                case 4:
                    return new EconomyCreature(CreatureStatistic.MAGE,aAmount,350);
                case 5:
                    return new EconomyCreature(CreatureStatistic.GENIE,aAmount,550);
                case 6:
                    return new EconomyCreature(CreatureStatistic.NAGA,aAmount,1100);
                case 7:
                    return new EconomyCreature(CreatureStatistic.GIANT,aAmount,2000);
                default:
                    throw new IllegalArgumentException(EXCEPTION_MESSAGE);
            }
        } else{
            switch (aTier){
                case 1:
                    return new EconomyCreature( CreatureStatistic.TEST_TIER_1_UPGRADED, aAmount, 60 );
                case 2:
                    return new EconomyCreature(CreatureStatistic.TEST_TIER_2_UPGRADED,aAmount,130);
                case 3:
                    return new EconomyCreature(CreatureStatistic.TEST_TIER_3_UPGRADED,aAmount,150);
                case 4:
                    return new EconomyCreature(CreatureStatistic.TEST_TIER_4_UPGRADED,aAmount,350);
                case 5:
                    return new EconomyCreature(CreatureStatistic.TEST_TIER_5_UPGRADED,aAmount,550);
                case 6:
                    return new EconomyCreature(CreatureStatistic.TEST_TIER_6_UPGRADED,aAmount,1100);
                case 7:
                    return new EconomyCreature(CreatureStatistic.TEST_TIER_7_UPGRADED,aAmount,2000);
                default:
                    throw new IllegalArgumentException(EXCEPTION_MESSAGE);
            }
        }
    }
}
