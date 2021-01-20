package pl.sdk;

import pl.sdk.creatures.EconomyCreature;
import pl.sdk.hero.CreatureShop;
import pl.sdk.hero.EconomyHero;
import pl.sdk.hero.Player;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class EconomyEngine {
    public static final String PLAYER_BOUGHT_CREATURE = "PLAYER_BOUGHT_CREATURE";
    public static final String ACTIVE_PLAYER_CHANGED = "ACTIVE_PLAYER_CHANGED";
    public static final String NEXT_ROUND = "NEXT_ROUND";
    public static final String END_OF_TURN = "END_OF_TURN";
    private final Player player1;
    private final Player player2;
    private Player activePlayer;
    private final CreatureShop creatureShop;
    private int roundNumber;
    private final PropertyChangeSupport observerSupport;
    private int turnNumber;

    public EconomyEngine(Player aPlayer1, Player aPlayer2) {
        player1 = aPlayer1;
        player2 = aPlayer2;
        activePlayer = player1;
        roundNumber = 1;
        turnNumber = 1;
        creatureShop = new CreatureShop();
        observerSupport = new PropertyChangeSupport(this);
        addObserver(EconomyEngine.ACTIVE_PLAYER_CHANGED,creatureShop);
        addObserver(EconomyEngine.NEXT_ROUND,creatureShop);
    }

    public EconomyEngine( Player aPlayer1, Player aPlayer2, CreatureShop aShop )
    {
        player1 = aPlayer1;
        player2 = aPlayer2;
        activePlayer = player1;
        roundNumber = 1;
        turnNumber = 1;
        creatureShop = aShop;
        observerSupport = new PropertyChangeSupport(this);
        addObserver(EconomyEngine.ACTIVE_PLAYER_CHANGED,creatureShop);
        addObserver(EconomyEngine.NEXT_ROUND,creatureShop);
    }

    public void buy(EconomyCreature aEconomyCreature) {
        creatureShop.buy(activePlayer,aEconomyCreature);
        observerSupport.firePropertyChange( PLAYER_BOUGHT_CREATURE, null, null );
    }

    public int calculateMaxAmount( Player aPlayer, EconomyCreature aCreature )
    {
        return creatureShop.calculateMaxAmount(aPlayer, aCreature);
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    public void pass() {
        if (activePlayer == player1){
            activePlayer = player2;
            observerSupport.firePropertyChange(ACTIVE_PLAYER_CHANGED, player1, activePlayer);
        }
        else{
            activePlayer = player1;
            observerSupport.firePropertyChange(ACTIVE_PLAYER_CHANGED, player2, activePlayer);
            nextRound();
        }
    }

    private void nextRound() {
        roundNumber += 1;
        if(roundNumber == 4)
        {
            endTurn();
        }
        else
        {
            player1.addGold(2000*roundNumber);
            player2.addGold(2000*roundNumber);
            observerSupport.firePropertyChange(NEXT_ROUND, roundNumber - 1, roundNumber);
        }
    }

    private void endTurn()
    {
        turnNumber += 1;
        roundNumber = 1;
        observerSupport.firePropertyChange( END_OF_TURN, turnNumber - 1, turnNumber );
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public void addObserver(String aPropertyName, PropertyChangeListener aObserver) {
        observerSupport.addPropertyChangeListener(aPropertyName, aObserver);
    }

    public Player getPlayer1() {
        //TODO make copy
        return player1;
    }

    public Player getPlayer2() {
        //TODO make copy
        return player2;
    }

    int getTurnNumber()
    {
        return turnNumber;
    }

    public int getCurrentPopulation( int aTier )
    {
        return creatureShop.getCurrentPopulation(aTier);
    }
}
