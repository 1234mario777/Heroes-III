package pl.sdk.creatures;

import com.google.common.collect.Range;
import pl.sdk.hero.EconomyShopIf;

public class EconomyCreature implements EconomyShopIf {

    private final CreatureStatistic stats;
    private int amount;
    private final int goldCost;

    EconomyCreature(CreatureStatistic aStats, int aAmount, int aGoldCost) {
        stats = aStats;
        amount = aAmount;
        goldCost = aGoldCost;
    }

    public int getAmount() {
        return amount;
    }

    public int getGoldCost() {
        return goldCost;
    }

    public String getName(){
        return stats.getTranslatedName();
    }

    public boolean isUpgraded() {
        return stats.isUpgraded();
    }
    public boolean isArcher(){
        return  stats.isArcher();
    }
    public int getTier() {
        return stats.getTier();
    }

    public int getAttack() {
        return stats.getAttack();
    }

    public int getArmor() {
        return stats.getArmor();
    }

    public int getMaxHp() {
        return stats.getMaxHp();
    }

    public int getMoveRange() {
        return stats.getMoveRange();
    }

    public Range<Integer> getDamage(){
        return stats.getDamage();
    }

    public String getDescription() {
        return stats.getDescription();
    }

    public int getGrowth()
    {
        return stats.getGrowth();
    }
}
