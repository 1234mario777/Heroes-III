package pl.sdk.skills;

import pl.sdk.spells.SpellStatistic;

public enum SkillStatistic {
    ARCHERY("Archery","Very useful to tower, stronghold and dungeon heroes. Unless you plan to take over another town type, Archery is not very useful to fortress, inferno and rampart heroes due to lack of ranged troops.",new SkillIncreaseRangeDamage()),
    TEST("Test","Test Description");

    private String name;
    private String description;
    SkillStatistic(String aName, String aDescription) {
        name = aName;
        description = aDescription;
    }

    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
}
