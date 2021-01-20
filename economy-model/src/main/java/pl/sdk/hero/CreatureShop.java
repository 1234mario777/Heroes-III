package pl.sdk.hero;

import pl.sdk.creatures.EconomyCreature;
import pl.sdk.creatures.EconomyNecropolisFactory;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.Random;

import static pl.sdk.EconomyEngine.*;

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

    private int calculatePopulation( int aTier )
    {
        return calculator.randomize( creatureFactory.create( false, aTier, 1 ).getGrowth() );
    }

    public void buy(Player aPlayer, EconomyCreature aEconomyCreature) {
        aPlayer.substractGold(aEconomyCreature.getGoldCost() * aEconomyCreature.getAmount());
        subtractPopulation(aEconomyCreature.getTier(), aEconomyCreature.getAmount());
        try{
            aPlayer.addCreature(aEconomyCreature);
        }catch(Exception e){
            aPlayer.addGold(aEconomyCreature.getGoldCost() * aEconomyCreature.getAmount());
            restorePopulation( aEconomyCreature.getTier(), aEconomyCreature.getAmount() );
            throw new IllegalStateException("hero cannot consume more creature");
        }
    }

    private void subtractPopulation( int aTier, int aAmount )
    {
        if(currentPopulation.get( aTier ) >= aAmount)
        {
            currentPopulation.put( aTier, currentPopulation.get( aTier ) - aAmount );
        }
        else
        {
            throw new IllegalStateException("hero cannot buy more creatures than population is");
        }
    }

    private void restorePopulation( int aTier, int aAmount )
    {
        currentPopulation.put( aTier, currentPopulation.get( aTier ) + aAmount );
    }

    public int calculateMaxAmount( Player aHero, EconomyCreature aCreature )
    {
        return calculator.calculateMaxAmount(aHero.getGold(), currentPopulation.get( aCreature.getTier() ), aCreature.getGoldCost());
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
        if ( aPropertyChangeEvent.getPropertyName().equals( ACTIVE_PLAYER_CHANGED ) )
        {
            changeCurrentPopulation();
        }
        else if ( aPropertyChangeEvent.getPropertyName().equals( NEXT_ROUND ) )
        {
            generateRandom();
            addPopulation(heroTwoPopulation);
            addPopulation(heroOnePopulation);
        }
    }

    private void addPopulation( HashMap<Integer, Integer> aPopulationMap )
    {
        aPopulationMap.put( 1, aPopulationMap.get( 1 ) + calculatePopulation(1) );
        aPopulationMap.put( 2,  aPopulationMap.get( 2 ) + calculatePopulation(2) );
        aPopulationMap.put( 3,  aPopulationMap.get( 3 ) + calculatePopulation(3) );
        aPopulationMap.put( 4,  aPopulationMap.get( 4 ) + calculatePopulation(4) );
        aPopulationMap.put( 5,  aPopulationMap.get( 5 ) + calculatePopulation(5) );
        aPopulationMap.put( 6,  aPopulationMap.get( 6 ) + calculatePopulation(6) );
        aPopulationMap.put( 7,  aPopulationMap.get( 7 ) + calculatePopulation(7) );
    }
}
