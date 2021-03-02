package pl.sdk.spells;

public enum SpellStatistic {
    TEST_HASTE("Haste", "Increases the speed of the selected unit.", 1 , SpellElement.AIR, SpellType.BUFF, TargetType.ALLY,6),
    TEST_SUMMON_AIR_ELEMENTAL("Summon Air Elemental", "Allows you to summon elementals. Once cast, no other elemental types may be summoned.", 5 , SpellElement.AIR, SpellType.SUMMON, TargetType.MAP,6),
    TEST_DISPEL("Dispel", "Protects the selected unit from all low level spells.", 1 , SpellElement.WATER, SpellType.SPECIAL, TargetType.CREATURE,5),
    TEST_TELEPORT("Teleport", "Teleports any friendly unit to any unoccupied spot on the battlefield.", 5 , SpellElement.WATER, SpellType.SPECIAL, TargetType.ALLY,15),
    TEST_FIRE_BALL("Fire Ball", "Causes the selected target to burst into flames, inflicting fire damage to the target and any adjacent units.", 3 , SpellElement.FIRE, SpellType.DAMAGE, TargetType.SPLASH_MAP,15),
    TEST_IMPLOSION("Implosion", "Inflicts massive damage to a single creature stack.", 5 , SpellElement.EARTH, SpellType.DAMAGE, TargetType.ENEMY,30),
    TEST_SLOW("Slow", "Reduces the speed of the selected enemy unit.", 1 , SpellElement.EARTH, SpellType.DEBUFF, TargetType.ENEMY,6),
    TEST_DEATH_RIPPLE("Death Ripple", "Sends a wave of death across the battlefield which damages all non-undead units.", 2 , SpellElement.EARTH, SpellType.DAMAGE, TargetType.SPECIAL,10),
    TEST_MAGIC_ARROW("Magic Arrow", "Causes a bolt of magical energy to strike the selected unit.", 1 , SpellElement.ALL, SpellType.DAMAGE, TargetType.ENEMY,5),

    HASTE("Haste", "Increases the speed of the selected unit.", 1 , SpellElement.AIR, SpellType.BUFF, TargetType.ALLY,6),
    SUMMON_AIR_ELEMENTAL("Summon Air Elemental", "Allows you to summon elementals. Once cast, no other elemental types may be summoned.", 5 , SpellElement.AIR, SpellType.SUMMON, TargetType.MAP,6),
    DISPEL("Dispel", "Protects the selected unit from all low level spells.", 1 , SpellElement.WATER, SpellType.SPECIAL, TargetType.CREATURE,5),
    TELEPORT("Teleport", "Teleports any friendly unit to any unoccupied spot on the battlefield.", 5 , SpellElement.WATER, SpellType.SPECIAL, TargetType.ALLY,15),
    FIRE_BALL("Fire Ball", "Causes the selected target to burst into flames, inflicting fire damage to the target and any adjacent units.", 3 , SpellElement.FIRE, SpellType.DAMAGE, TargetType.SPLASH_MAP,15),
    IMPLOSION("Implosion", "Inflicts massive damage to a single creature stack.", 5 , SpellElement.EARTH, SpellType.DAMAGE, TargetType.ENEMY,30),
    SLOW("Slow", "Reduces the speed of the selected enemy unit.", 1 , SpellElement.EARTH, SpellType.DEBUFF, TargetType.ENEMY,6),
    DEATH_RIPPLE("Death Ripple", "Sends a wave of death across the battlefield which damages all non-undead units.", 2 , SpellElement.EARTH, SpellType.DAMAGE, TargetType.SPECIAL,10),
    MAGIC_ARROW("Magic Arrow", "Causes a bolt of magical energy to strike the selected unit.", 1 , SpellElement.ALL, SpellType.DAMAGE, TargetType.ENEMY,5),
    ;

    public enum SpellElement {
        AIR, FIRE, WATER, EARTH, ALL;
    }

    public enum SpellType {
        BUFF, DEBUFF, DAMAGE, SPECIAL, SUMMON, MAP_CHANGE;
    }

    public enum TargetType {
        ALLY, ALL_ALLIES, ENEMY, ALL_ENEMIES, CREATURE, ALL_CREATURES, MAP, SPLASH_MAP, ALL, SPECIAL;
    }

    SpellStatistic(String aName, String aDescription, int aLevel, SpellElement aElement, SpellType aSpellType, TargetType aTargetType, int aManaCost) {
        name = aName;
        description = aDescription;
        level = aLevel;
        element = aElement;
        spellType = aSpellType;
        targetType = aTargetType;
        manaCost = aManaCost;
    }

    private final String name;
    private final String description;
    private final int level;
    private final SpellElement element;
    private final SpellType spellType;
    private final TargetType targetType;
    private final int manaCost;

    public String getName() {
        return name;
    }

    String getDescription() {
        return description;
    }

    int getLevel() {
        return level;
    }

    SpellElement getElement() {
        return element;
    }

    SpellType getSpellType() {
        return spellType;
    }

    TargetType getTargetType() {
        return targetType;
    }

    int getManaCost() {
        return manaCost;
    }
}
