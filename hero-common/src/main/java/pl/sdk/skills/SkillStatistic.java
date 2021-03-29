package pl.sdk.skills;

import pl.sdk.spells.SpellStatistic;

public enum SkillStatistic {
    ARCHERY("Archery","Very useful to tower, stronghold and dungeon heroes. Unless you plan to take over another town type, Archery is not very useful to fortress, inferno and rampart heroes due to lack of ranged troops.",new SkillIncreaseRangeDamage()),
    TEST("Test","Test Description");

    SkillStatistic(String aName, String aDescription) {
    }
}
