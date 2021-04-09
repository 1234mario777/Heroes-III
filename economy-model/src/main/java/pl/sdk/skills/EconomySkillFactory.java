package pl.sdk.skills;

public class EconomySkillFactory {
    private static final String EXCEPTION_MESSAGE = "Invalid skill name";

    public CreatureEconomySkill create(SkillStatistic aName) {
        switch (aName.getTargetType()){
            case ALLIES:
                return new CreatureEconomySkill(aName);
            case HERO:
                return new HeroEconomySkill(aName);
            default:
                throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }


}
