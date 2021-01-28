package pl.sdk.spells;

public class EconomySpell {

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
}
