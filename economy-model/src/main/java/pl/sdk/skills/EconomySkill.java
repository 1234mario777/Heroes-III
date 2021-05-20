package pl.sdk.skills;

import pl.sdk.hero.EconomyShopIf;
import pl.sdk.hero.Player;

public class EconomySkill implements EconomyShopIf {
    private final int goldCost;
    private final SkillStatistic skill;
    public static final int SKILL_GROWTH = 1;
    public EconomySkill(SkillStatistic aSkill) {
        skill = aSkill;
        goldCost = 1000;
    }
    public int getGoldCost() { return goldCost; }
    public SkillStatistic getSkillStatistic() {return skill; }
    public String getName() {return skill.getName(); }
    public String getDescription(){return skill.getDescription();}
    public SkillStatistic.TargetType getTargetType() { return skill.getTargetType(); }
    public SkillStatistic.SkillType getSkillType() { return skill.getSkillType(); }
    public SkillStatistic.SkillLevel getSkillLevel(){ return skill.getSkillLevel(); }
    public int getGrowth()
    {
        return SKILL_GROWTH;
    }
}
