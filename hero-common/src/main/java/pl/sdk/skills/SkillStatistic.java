package pl.sdk.skills;

public enum SkillStatistic {
    ARCHERY("Archery","Very useful to tower, stronghold and dungeon heroes. Unless you plan to take over another town type, Archery is not very useful to fortress, inferno and rampart heroes due to lack of ranged troops.",new SkillIncreaseRangeDamage(),SkillType.BUFF,TargetType.ALLIES,SkillLevel.BASIC);

    private final TargetType targetType;
    private final String name;
    private final String description;
    private final Object effect;
    private final SkillType skillType;
    private final SkillLevel skillLevel;

    public enum SkillType {
        BUFF, DEBUFF, EFFECT, MAP_CHANGE;
    }
    public enum SkillLevel{
        BASIC, ADVANCED, EXPERT;
    }
    public enum TargetType {
        HERO, ALLIES, ENEMY_HERO, ALL_ENEMIES, MAP, TOUR_END;
    }

    SkillStatistic(String aName, String aDescription, Object aSkillEffect, SkillType aSkillType, TargetType aTargetType, SkillLevel aLevel) {
        name = aName;
        description = aDescription;
        effect = aSkillEffect;
        skillType = aSkillType;
        targetType = aTargetType;
        skillLevel = aLevel;
    }

    public SkillLevel getSkillLevel() { return skillLevel; }
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public Object getEffect(){
        return effect;
    }
    public TargetType getTargetType() {
        return targetType;
    }
    public SkillType getSkillType() {
        return skillType;
    }

}
