package pl.sdk.spells;

public class EconomySpell {

    private final SpellStatistic spellStats;
    private final int goldCost;

    public EconomySpell(SpellStatistic aSpellStats) {
        spellStats = aSpellStats;
        goldCost = spellStats.getLevel() * 300;
    }
}
