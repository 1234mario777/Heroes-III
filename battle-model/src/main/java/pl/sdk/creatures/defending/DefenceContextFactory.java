package pl.sdk.creatures.defending;


public class DefenceContextFactory {
    public static DefenceContextIf create(int aArmor, int aMaxAmount, int aMaxHp) {
        return new DefaultDefenceContext(new DefaultDamageApplier(), aArmor, aMaxAmount, aMaxHp);
    }
//    public static DefenceContextIf create(CreatureStatistic aStats) {
//        switch (aStats) {
//            default:
//                return new DefaultDefenceContext(new DefaultDamageApplier(), aStats.getArmor(), null, aStats.getMaxHp());
//        }
//    }
}
