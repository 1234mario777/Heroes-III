package pl.sdk.skills;

public enum SkillStatisticTest {
    TEST("Test","Test Description", new SkillIncreaseRangeDamage());

    private String name;
    private String description;
    private SkillIncreaseRangeDamage effect;


    SkillStatisticTest(String aName, String aDescription, SkillIncreaseRangeDamage aSkill) {
        name = aName;
        description = aDescription;
        effect = aSkill;
    }

    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public SkillIncreaseRangeDamage getEffect(){
        return effect;
    }
}
