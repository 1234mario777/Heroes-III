package pl.sdk.skills;

public enum SkillStatistic {
    ARCHERY("Archery","Very useful to tower, stronghold and dungeon heroes. Unless you plan to take over another town type, Archery is not very useful to fortress, inferno and rampart heroes due to lack of ranged troops.",new SkillIncreaseRangeDamage());

    private String name;
    private String description;
    private Object effect;
    SkillStatistic(String aName, String aDescription, Object aSkillIncreaseRangeDamage) {
        name = aName;
        description = aDescription;
        effect = aSkillIncreaseRangeDamage;
    }

    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public Object getEffect(){
        return effect;
    }

}
