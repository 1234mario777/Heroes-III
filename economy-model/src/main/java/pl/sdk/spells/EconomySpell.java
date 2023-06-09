package pl.sdk.spells;

import pl.sdk.hero.EconomyShopIf;

public class EconomySpell implements EconomyShopIf {

    public static final int SPELL_GROWTH = 1;
    private final SpellStatistic spellStats;

    private final int goldCost;

    public EconomySpell(SpellStatistic aSpellStats) {
        spellStats = aSpellStats;
        goldCost = spellStats.getLevel() * 300;
    }

    public String getName() {
        return spellStats.getName();
    }

    public String getDescription() {
        return spellStats.getDescription();
    }

    public int getLevel() {
        return spellStats.getLevel();
    }

    public SpellStatistic.SpellElement getElement() {
        return spellStats.getElement();
    }

    public SpellStatistic.SpellType getSpellType() {
        return spellStats.getSpellType();
    }

    public SpellStatistic.TargetType getTargetType() {
        return spellStats.getTargetType();
    }

    public int getManaCost() {
        return spellStats.getManaCost();
    }

    public SpellStatistic getSpellStatistic() {
        return spellStats;
    }

    public int getGoldCost()
    {
        return goldCost;
    }

    public int getGrowth()
    {
        return SPELL_GROWTH;
    }
}
