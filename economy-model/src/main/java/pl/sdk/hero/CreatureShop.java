package pl.sdk.hero;

import pl.sdk.Fraction;
import pl.sdk.creatures.AbstractEconomyFractionFactory;
import pl.sdk.creatures.EconomyCreature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

class CreatureShop extends AbstractShop<EconomyCreature>
{

    public static final int TIER_AMOUNT = 7;
    public static final String HERO_CANNOT_BUY_MORE_CREATURES_THAN_POPULATION_IS = "Hero cannot buy more creatures than population is";
    public static final String HERO_CANNOT_CONSUME_MORE_CREATURES = "Hero cannot consume more creatures";
    private final AbstractEconomyFractionFactory creatureFactory;

    CreatureShop(Fraction aFraction)
    {
        super(new CreatureShopCalculator(), new ArrayList<>());
        creatureFactory = AbstractEconomyFractionFactory.getInstance( aFraction );
        createPopulation();
    }

    CreatureShop( Random aRand, Fraction aFraction )
    {
        super(new CreatureShopCalculator(aRand), new ArrayList<>());
        creatureFactory = AbstractEconomyFractionFactory.getInstance( aFraction );
        createPopulation();
    }

    @Override
    protected void handlePopulation()
    {
        addPopulation();
    }

    @Override
    protected void subtractGold(Player aActivePlayer, EconomyCreature aShopItem) {
        aActivePlayer.substractGold(aShopItem.getGoldCost() * aShopItem.getAmount());
    }

    @Override
    protected void restoreGold(Player aActivePlayer, EconomyCreature aShopItem) {
        aActivePlayer.addGold(aShopItem.getAmount() * aShopItem.getGoldCost());
    }

    @Override
    protected void subtractPopulation(EconomyCreature aShopItem) {
        int currentPopulation = getShopPopulation().get(aShopItem.getTier() - 1).getAmount();
        int populationToSubstract = aShopItem.getAmount();

        if(currentPopulation >= populationToSubstract)
        {
            getShopPopulation().remove(aShopItem.getTier() - 1);
            getShopPopulation().add(aShopItem.getTier() - 1, creatureFactory.create(false, aShopItem.getTier(), currentPopulation - populationToSubstract));
        }
        else
        {
            throw new IllegalStateException(getSubtractPopulationErrorMessage());
        }
    }

    @Override
    protected void restorePopulation(EconomyCreature aShopItem) {
        int currentPopulation = getShopPopulation().get(aShopItem.getTier() - 1).getAmount();
        int populationToRestore = aShopItem.getAmount();
        getShopPopulation().remove(aShopItem.getTier() - 1);
        getShopPopulation().add(aShopItem.getTier() - 1, creatureFactory.create(false, aShopItem.getTier(), currentPopulation + populationToRestore));
    }

    @Override
    protected void addItem(Player aActivePlayer, EconomyCreature aShopItem) {
        aActivePlayer.addCreature(aShopItem);
    }

    @Override
    protected void createPopulation(  )
    {
        for (int i = 0; i < TIER_AMOUNT; i++) {
            getShopPopulation().add(i, creatureFactory.create(false, i + 1, calculatePopulation(i + 1)));
        }
    }

    @Override
    protected String getSubtractPopulationErrorMessage() {
        return HERO_CANNOT_BUY_MORE_CREATURES_THAN_POPULATION_IS;
    }

    @Override
    protected String getBuyErrorMessage() {
        return HERO_CANNOT_CONSUME_MORE_CREATURES;
    }

    private int calculatePopulation( int aTier )
    {
        return getCalculator().randomize( creatureFactory.create( false, aTier, 1 ).getGrowth() );
    }

    public int calculateMaxAmount( Player aHero, EconomyCreature aCreature )
    {
        return getCalculator().calculateMaxAmount(aHero.getGold(), getShopPopulation().get(aCreature.getTier() - 1).getAmount(), aCreature.getGoldCost());
    }

    public int getCurrentPopulation( int aTier )
    {
        return getShopPopulation().get(aTier - 1).getAmount();
    }

    private void addPopulation()
    {
        for (int i = 0; i < TIER_AMOUNT; i++) {
            int currentPopulation = getShopPopulation().get(i).getAmount();
            getShopPopulation().remove(i);
            getShopPopulation().add(i, creatureFactory.create(false, i + 1, currentPopulation + calculatePopulation(i + 1)));
        }
    }
}
