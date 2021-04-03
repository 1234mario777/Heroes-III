package pl.sdk.skills;

public enum SkillStatistic {
    ARCHERY("Archery","Very useful to tower, stronghold and dungeon heroes. Unless you plan to take over another town type, Archery is not very useful to fortress, inferno and rampart heroes due to lack of ranged troops.",new SkillIncreaseRangeDamage(),SkillType.BUFF,TargetType.ALLIES);

    private final TargetType targetType;
    private final String name;
    private final String description;
    private final Object effect;
    private final SkillType skillType;

    public enum SkillType {
        BUFF, DEBUFF, EFFECT, MAP_CHANGE;
    }

    public enum TargetType {
        HERO, ALLIES, ENEMY_HERO, ALL_ENEMIES, MAP, TOUR_END;
    }

    SkillStatistic(String aName, String aDescription, Object aSkillEffect, SkillType aSkillType, TargetType aTargetType ) {
        name = aName;
        description = aDescription;
        effect = aSkillEffect;
        skillType = aSkillType;
        targetType = aTargetType;
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
    TargetType getTargetType() {
        return targetType;
    }

    SkillType getSkillType() {
        return skillType;
    }

}
