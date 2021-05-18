package pl.sdk.skills;

import pl.sdk.hero.EconomyShopIf;

public class EconomySkill implements EconomyShopIf {
    private final int goldCost;
    private final AbstractEconomySkill skill;
    public static final int SKILL_GROWTH = 1;
    public EconomySkill(SkillStatistic aSkill, int aGoldCost) {
        skill = ;
        goldCost = aGoldCost;
    }

    public int getGoldCost() { return goldCost; }
    public AbstractEconomySkill getAbstractEconomySkill() {return skill; }
    public SkillStatistic getSkillStatistic() {return skill.getSkillStatistic(); }
    public String getName() {return skill.getName(); }
    public String getDescription(){return skill.getDescription();}
    public SkillStatistic.TargetType getTargetType() { return skill.getTargetType(); }
    public SkillStatistic.SkillType getSkillType() { return skill.getSkillType(); }
    public SkillStatistic.SkillLevel getSkillLevel(){ return skill.getSkillLevel(); }
    String getName(EconomySkill aSkill) { return aSkill.getName(); }
    public int getGrowth()
    {
        return SKILL_GROWTH;
    }
}
