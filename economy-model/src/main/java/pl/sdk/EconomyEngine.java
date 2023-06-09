package pl.sdk;

import pl.sdk.artifacts.EconomyArtifact;
import pl.sdk.creatures.EconomyCreature;
import pl.sdk.hero.Player;
import pl.sdk.skills.EconomySkill;
import pl.sdk.spells.EconomySpell;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Collection;
import java.util.List;

public class EconomyEngine {
    public static final String PLAYER_BOUGHT_ITEM = "PLAYER_BOUGHT_ITEM";
    public static final String ACTIVE_PLAYER_CHANGED = "ACTIVE_PLAYER_CHANGED";
    public static final String NEXT_ROUND = "NEXT_ROUND";
    public static final String END_OF_TURN = "END_OF_TURN";
    private final Player player1;
    private final Player player2;
    private Player activePlayer;
    private int roundNumber;
    private final PropertyChangeSupport observerSupport;
    private int turnNumber;

    public EconomyEngine(Player aPlayer1, Player aPlayer2) {
        player1 = aPlayer1;
        player2 = aPlayer2;
        activePlayer = player1;
        roundNumber = 1;
        turnNumber = 1;

        observerSupport = new PropertyChangeSupport(this);
        player1.getShops()
               .forEach( shop -> addObserver( EconomyEngine.NEXT_ROUND, shop ) );
        player2.getShops()
               .forEach( shop -> addObserver( EconomyEngine.NEXT_ROUND, shop ) );
    }

    public void buyCreature(EconomyCreature aEconomyCreature ) {
        activePlayer.buyCreature(activePlayer,aEconomyCreature );
        observerSupport.firePropertyChange( PLAYER_BOUGHT_ITEM, null, null );
    }

    public void buySpell( EconomySpell aEconomySpell )
    {
        activePlayer.buySpell(activePlayer, aEconomySpell );
        observerSupport.firePropertyChange( PLAYER_BOUGHT_ITEM, null, null );
    }

    public void buyArtifact(EconomyArtifact aEconomyArtifact) {
        activePlayer.buyArtifact(activePlayer, aEconomyArtifact);
        observerSupport.firePropertyChange( PLAYER_BOUGHT_ITEM, null, null );
    }

    public int calculateCreatureMaxAmount( EconomyCreature aCreature )
    {
        return activePlayer.calculateMaxAmount(aCreature);
    }

    public boolean canBuySpell(EconomySpell aSpell) {
        return activePlayer.canBuySpell(aSpell);
    }

    public int calculateSkillMaxAmount( EconomySkill aSkill)
    {
        return activePlayer.calculateSkillMaxAmount(aSkill);
    }

    public boolean canBuyArtifact(EconomyArtifact aArtifact) {
        return activePlayer.canBuyArtifact(aArtifact);
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
        return activePlayer.getCurrentPopulation(aTier);
    }

    public String playerToString()
    {
        if(activePlayer == player1)
        {
            return "Hero I";
        }
        else
        {
            return "Hero II";
        }
    }

    public List<EconomySpell> getCurrentSpellPopulation()
    {
        return activePlayer.getCurrentSpellPopulation();
    }

	public boolean hasSpell( String aName )
	{
	    return activePlayer.hasSpell(aName);
	}

    public List<EconomyArtifact> getCurrentArtifactPopulation() {
        return activePlayer.getCurrentArtifactPopulation();
    }

    public boolean hasArtifact(String aName) {
        return activePlayer.hasArtifact(aName);
    }

    public boolean hasEmptySlotForArtifact(String aName) {
        return activePlayer.hasEmptySlotForArtifact(aName);
    }

    public void buySkill(EconomySkill aSkill) {
        activePlayer.buySkill(activePlayer,aSkill);
        observerSupport.firePropertyChange(PLAYER_BOUGHT_ITEM,null,null);
    }

    public List<EconomySkill> getCurrentSkillPopulation() {
        return activePlayer.getCurrentSkillPopulation();
    }

    public boolean hasSkill(EconomySkill aSkill) {
        return activePlayer.hasSkill(aSkill);
    }
}
