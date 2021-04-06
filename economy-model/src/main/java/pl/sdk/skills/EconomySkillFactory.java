package pl.sdk.skills;

public class EconomySkillFactory extends AbstractEconomySkillFactory {
    private static final String EXCEPTION_MESSAGE = "Invalid skill name";

    @Override
    public EconomySkill create(SkillStatistic aName) {
        switch (aName){
            case ARCHERY:
                return new EconomySkill(SkillStatistic.ARCHERY);
            default:
                throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }

}
