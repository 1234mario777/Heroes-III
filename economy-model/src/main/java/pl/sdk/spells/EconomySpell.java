package pl.sdk.spells;

public class EconomySpell {

    private final SpellStatistic spellStats;
    private final int goldCost;

    EconomySpell(SpellStatistic aSpellStats, int aGoldCost) {
        spellStats = aSpellStats;
        goldCost = aGoldCost;
    }
}
