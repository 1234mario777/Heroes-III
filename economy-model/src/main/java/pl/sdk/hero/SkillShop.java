package pl.sdk.hero;

import pl.sdk.skills.EconomySkill;
import pl.sdk.skills.EconomySkillFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class SkillShop extends AbstractShop<EconomySkill>{
    public static final String HERO_CANNOT_CONSUME_MORE_SKILLS = "Hero cannot consume more skills";
    public static final String PLAYER_HAS_ALREADY_BOUGHT_THIS_SKILL = "Player has already bought this skill!";
    private final EconomySkillFactory skillFactory;

    SkillShop() {
        super(new DefaultShopCalculator(), new ArrayList<>());
        skillFactory = new EconomySkillFactory();
        createPopulation();
    }

    @Override
    protected void createPopulation() {
        List<EconomySkill> allSkills = skillFactory.getAllSkills();
        int populationSize = calculatePopulation( allSkills.size() );
        Random rand = new Random();

        for (int i = 0; i < populationSize; i++) {
            int randomIndex = rand.nextInt(allSkills.size());
            getShopPopulation().add( allSkills.get( randomIndex ) );
            allSkills.remove(randomIndex);
        }
    }

    @Override
    protected void addItem(Player aActivePlayer, EconomySkill aShopItem) {
        aActivePlayer.addSkill(aShopItem);
    }

    @Override
    protected String getSubtractPopulationErrorMessage() {
        return PLAYER_HAS_ALREADY_BOUGHT_THIS_SKILL;
    }

    @Override
    protected String getBuyErrorMessage() {
        return HERO_CANNOT_CONSUME_MORE_SKILLS;
    }

    List<EconomySkill> getCurrentSkillPopulation() { return List.copyOf(getShopPopulation()); }

    int calculateMaxAmount( Player aPlayer, EconomySkill aSkill )
    {
        return getCalculator().calculateMaxAmount(aPlayer.getGold(), aSkill.getGrowth(), aSkill.getGoldCost());
    }

    private int calculatePopulation( int aSize )
    {
        return getCalculator().randomize( aSize );
    }
}
