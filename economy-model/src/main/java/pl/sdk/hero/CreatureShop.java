package pl.sdk.hero;

import pl.sdk.creatures.EconomyCreature;
import pl.sdk.creatures.EconomyNecropolisFactory;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.Random;

import static pl.sdk.EconomyEngine.ACTIVE_HERO_CHANGED;

public class CreatureShop implements PropertyChangeListener
{

    private CreatureShopCalculator calculator;
    private final HashMap<Integer, Integer> heroOnePopulation;
    private final HashMap<Integer, Integer> heroTwoPopulation;
    private HashMap<Integer, Integer> currentPopulation;
    private final EconomyNecropolisFactory creatureFactory = new EconomyNecropolisFactory();

    public CreatureShop()
    {
        calculator = new CreatureShopCalculator(  );
        heroOnePopulation = new HashMap<>();
        heroTwoPopulation = new HashMap<>();
        currentPopulation = new HashMap<>();
        createPopulation(heroOnePopulation);
        createPopulation(heroTwoPopulation);
        currentPopulation = heroOnePopulation;
    }

    CreatureShop( Random aRand )
    {
        calculator = new CreatureShopCalculator(aRand);
        heroOnePopulation = new HashMap<>();
        heroTwoPopulation = new HashMap<>();
        currentPopulation = new HashMap<>();
        createPopulation(heroOnePopulation);
        createPopulation(heroTwoPopulation);
        currentPopulation = heroOnePopulation;
    }

    private void createPopulation( HashMap<Integer, Integer> aPopulationMap )
    {
        aPopulationMap.put( 1, calculatePopulation(1) );
        aPopulationMap.put( 2, calculatePopulation(2) );
        aPopulationMap.put( 3, calculatePopulation(3) );
        aPopulationMap.put( 4, calculatePopulation(4) );
        aPopulationMap.put( 5, calculatePopulation(5) );
        aPopulationMap.put( 6, calculatePopulation(6) );
        aPopulationMap.put( 7, calculatePopulation(7) );
    }

    private Integer calculatePopulation( int aTier )
    {
        return creatureFactory.create( false, aTier, 1 ).getGrowth();
    }

    public void buy(EconomyHero aHero, EconomyCreature aEconomyCreature) {
        aHero.substractGold(aEconomyCreature.getGoldCost() * aEconomyCreature.getAmount());
        try{
            aHero.addCreature(aEconomyCreature);
        }catch(Exception e){
            aHero.addGold(aEconomyCreature.getGoldCost() * aEconomyCreature.getAmount());
            throw new IllegalStateException("hero cannot consume more creature");
        }
    }

    public int calculateMaxAmount( EconomyHero aHero, EconomyCreature aCreature )
    {
        return calculator.calculateMaxAmount(aHero, aCreature);
    }

    public void generateRandom(){calculator.generateRandomFactor();}

    public int getCurrentPopulation( int aTier )
    {
        return currentPopulation.get( aTier );
    }

    void changeCurrentPopulation()
    {
        if(currentPopulation == heroOnePopulation)
        {
            currentPopulation = heroTwoPopulation;
        }
        else
        {
            currentPopulation = heroOnePopulation;
        }
    }

    @Override
    public void propertyChange( PropertyChangeEvent aPropertyChangeEvent )
    {
        if ( aPropertyChangeEvent.getPropertyName().equals( ACTIVE_HERO_CHANGED ) )
        {
            changeCurrentPopulation();
        }
    }
}
