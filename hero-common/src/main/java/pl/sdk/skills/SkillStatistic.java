package pl.sdk.skills;

public enum SkillStatistic {
    //    BUFF DEBUFF
    ARCHERY("Archery","Very useful to tower, stronghold and dungeon heroes. Unless you plan to take over another town type, Archery is not very useful to fortress, inferno and rampart heroes due to lack of ranged troops.",SkillType.BUFF,TargetType.ALLIES,SkillLevel.BASIC, 0.1,0.2,0.5),
    OFFENCE("Offence","Definitely a good skill to have, Offense increases the amount of damage that your creatures do in combat. For example, with expert Offence 10 Thunderbirds will do 143 - 195 points of damage as opposed to 110 - 150 and that's a nice thought. This skill goes hand in hand with the Barbarians' great attack, amplifying it further. Offense also enables magic heroes to compensate for their obsession with brains and neglect of muscle :)",SkillType.BUFF,TargetType.ALLIES,SkillLevel.BASIC,0.1,0.2,0.5 ),
    ARMOURER("Armourer","A nice skill you will want to have for advanced protection. This skill basically modifies the defense of all of your units. This skill is very powerful with a Beastmaster who already happens to have a great well rounded defense. Creatures with weaker defense, especially those of the Stronghold or Inferno, will want this skill to raise the poor protection of their units. This skill is a major want if you desire one of those buff super heroes. Best Heroes for Skill - Heretic, Barbarian, Beastmaster, and Alchemist.",SkillType.DEBUFF,TargetType.ALL_ENEMIES,SkillLevel.BASIC,0.1,0.2,0.5 ),
    LEADERSHIP("Leadership","With this skill your army rarely freezes in panic, and with an expert level often at least one of your units has the ability to attack the opposing force twice, very nice if the extra attack is given to a Pack of Arch Angels. High morale has the ability to turn the tides of the battle in your favor. Low morale also has the ability to turn the tides, just not in your favor... See primary skills page for more details. Undead don't have morale - they fear nothing, but they ain't too keen either :) If you plan to mix creatures from more than two towns in your army, you need this skill.", SkillType.BUFF,TargetType.HERO,SkillLevel.BASIC,1,2,3),
    RESISTANCE("Resistance","A great skill for all heroes, but most important for heroes lacking in the magic department, such as the Barbarian. This skill increases your chance of resisting spells, such as implosion, which in the hands of a powerful Warlock could destroy the strongest group of creatures in your army with one strike. Resisting curses and slow is also important. This could easily turn the outcome of the battle in your favor. Likely Students: Barbarians, Battle Mages, Beastmasters and Overlords.",SkillType.DEBUFF,TargetType.ENEMY_HERO,SkillLevel.BASIC,0.1,0.2,0.5),
    LUCK("Luck","Adds a chance of increased damage to all troops. Useful to all. See primary skills page for more details.",SkillType.BUFF,TargetType.HERO,SkillLevel.BASIC,1,2,3);

    private final TargetType targetType;
    private final String name;
    private final String description;
    private final SkillType skillType;
    private final SkillLevel skillLevel;
    private final double basicIncreaseFactor;
    private final double advanceIncreaseFactor;
    private final double expertIncreaseFactor;

    public enum SkillType {
        BUFF, DEBUFF, EFFECT, MAP_CHANGE;
    }
    public enum SkillLevel{
        BASIC, ADVANCED, EXPERT;
    }
    public enum TargetType {
        HERO, ALLIES, ENEMY_HERO, ALL_ENEMIES, MAP, TOUR_END;
    }

    SkillStatistic(String aName, String aDescription, SkillType aSkillType, TargetType aTargetType, SkillLevel aLevel) {
        name = aName;
        description = aDescription;
        skillType = aSkillType;
        targetType = aTargetType;
        skillLevel = aLevel;
        basicIncreaseFactor = 0.1;
        advanceIncreaseFactor = 0.2;
        expertIncreaseFactor = 0.5;
    }
    SkillStatistic(String aName, String aDescription, SkillType aSkillType, TargetType aTargetType, SkillLevel aLevel,double aBIF,double aAIF,double aEIF) {
        name = aName;
        description = aDescription;
        skillType = aSkillType;
        targetType = aTargetType;
        skillLevel = aLevel;
        basicIncreaseFactor = aBIF;
        advanceIncreaseFactor = aAIF;
        expertIncreaseFactor = aEIF;
    }
    public SkillLevel getSkillLevel() { return skillLevel; }
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public TargetType getTargetType() {
        return targetType;
    }
    public SkillType getSkillType() {
        return skillType;
    }

}
