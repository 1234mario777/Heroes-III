package pl.sdk.hero;

import pl.sdk.skills.EconomySkill;
import pl.sdk.skills.EconomySkillFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class SkillShop extends AbstractShop<EconomySkill>{
    public static final String EXCEPTION_MESSAGE = "hero cannot consume more spells";
    public static final String PLAYER_HAS_ALREADY_BOUGHT_THIS_SPELL = "Player has already bought this spell!";
    private final EconomySkillFactory skillFactory;
    private List<EconomySkill> skillPopulation;

    SkillShop() {
        super(new SkillShopCalculator());
        skillFactory = new EconomySkillFactory();
        skillPopulation = new ArrayList<>();
        createPopulation();
    }

    private void createPopulation() {
        List<EconomySkill> allSkills = skillFactory.getAllSkills();
        int populationSize = calculatePopulation( allSkills.size() );
        Random rand = new Random();

        for (int i = 0; i < populationSize; i++) {
            int randomIndex = rand.nextInt(allSkills.size());
            skillPopulation.add( allSkills.get( randomIndex ) );
            allSkills.remove(randomIndex);
        }
    }

    List<EconomySkill> getCurrentSkillPopulation() { return skillPopulation; }

    private int calculatePopulation( int aSize )
    {
        return getCalculator().randomize( aSize );
    }

    void buy(Player aActivePlayer, EconomySkill aSkill) {
        aActivePlayer.substractGold(aSkill.getGoldCost());
        subtractPopulation(aSkill);
        try{
            aActivePlayer.addSkill(aSkill);
        }catch(Exception e){
            aActivePlayer.addGold(aSkill.getGoldCost());
            restorePopulation( aSkill );
            throw new IllegalStateException( EXCEPTION_MESSAGE );
        }
    }

    private void restorePopulation(EconomySkill aSkill) { skillPopulation.add( aSkill ); }

    private void subtractPopulation(EconomySkill aSkill) {
        if ( !skillPopulation.stream().map( EconomySkill::getName ).collect( Collectors.toList() ).contains( aSkill.getName() ))
        {
            throw new IllegalStateException( PLAYER_HAS_ALREADY_BOUGHT_THIS_SPELL );

        }
        for ( int i = 0; i < skillPopulation.size() ; i++ )
        {
            if ( skillPopulation.get( i ).getName().equals( aSkill.getName() ) )
                skillPopulation.remove( i );
        }

    }

    @Override
    protected void handlePopulation()
    {
        skillPopulation = new ArrayList<>();
        createPopulation();
    }

    int calculateMaxAmount( Player aPlayer, EconomySkill aSkill )
    {
        return getCalculator().calculateMaxAmount(aPlayer.getGold(), aSkill.getGrowth(), aSkill.getGoldCost());
    }
}
