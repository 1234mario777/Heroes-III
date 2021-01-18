package pl.sdk.gui;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import pl.sdk.EconomyEngine;
import pl.sdk.converter.EcoBattleConverter;
import pl.sdk.creatures.EconomyCreature;
import pl.sdk.creatures.EconomyNecropolisFactory;
import pl.sdk.hero.EconomyHero;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static pl.sdk.EconomyEngine.END_OF_TURN;

public class EcoController implements PropertyChangeListener {
    @FXML
    HBox heroStateHBox;
    @FXML
    HBox shopsBox;
    @FXML
    Button readyButton;
    @FXML
    Label playerLabel;
    @FXML
    Label currentGoldLabel;
    @FXML
    Label roundNumberLabel;

    private final EconomyEngine economyEngine;

    public EcoController(EconomyHero aHero1, EconomyHero aHero2) {
        economyEngine = new EconomyEngine(aHero1, aHero2);
    }

    @FXML
    void initialize(){
        refreshGui();
        economyEngine.addObserver(EconomyEngine.ACTIVE_HERO_CHANGED,this);
        economyEngine.addObserver(EconomyEngine.HERO_BOUGHT_CREATURE,this);
        economyEngine.addObserver(EconomyEngine.NEXT_ROUND,this);
        economyEngine.addObserver( END_OF_TURN,this );

        readyButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> economyEngine.pass() );
    }

    private void goToBattle() {
        EcoBattleConverter.startBattle(economyEngine.getPlayer1(), economyEngine.getPlayer2());
    }

    void refreshGui() {
        playerLabel.setText(economyEngine.getActiveHero().toString());
        currentGoldLabel.setText(String.valueOf( getGold() ) );
        roundNumberLabel.setText(String.valueOf(economyEngine.getRoundNumber()));
        shopsBox.getChildren().clear();
        heroStateHBox.getChildren().clear();

        EconomyNecropolisFactory factory = new EconomyNecropolisFactory();
        HBox creatureShop = new HBox( );
        VBox creatureNotUpgraded = new VBox();
        VBox creatureUpgraded = new VBox();
        for (int i = 1; i < 8; i++) {
            creatureNotUpgraded.getChildren().add(new CreatureButton(this, factory, false,i));
            creatureUpgraded.getChildren().add(new CreatureButton(this, factory, true,i));
        }
        creatureShop.getChildren().add( creatureNotUpgraded );
        Separator separator = new Separator(  );
        creatureShop.getChildren().add( separator );
        creatureShop.getChildren().add( creatureUpgraded );
        shopsBox.getChildren().add(creatureShop);
        shopsBox.setAlignment( Pos.CENTER );

        VBox creaturesBox = new VBox();
        economyEngine.getActiveHero().getCreatures().forEach(c ->
        {
            HBox tempHbox = new HBox();
            tempHbox.getChildren().add(new Label(String.valueOf(c.getAmount())));
            tempHbox.getChildren().add(new Label(c.getName()));
            creaturesBox.getChildren().add(tempHbox);
        });
        heroStateHBox.getChildren().add(creaturesBox);
    }

    public int getGold()
    {
        return economyEngine.getActiveHero().getGold();
    }

    void buy(EconomyCreature aCreature) {
        economyEngine.buy(aCreature);
    }

    public int calculateMaxAmount( EconomyCreature aCreature )
    {
        return economyEngine.calculateMaxAmount(economyEngine.getActiveHero(), aCreature);
    }

    @Override
    public void propertyChange(PropertyChangeEvent aPropertyChangeEvent) {
        if (aPropertyChangeEvent.getPropertyName().equals( END_OF_TURN ))
        {
            goToBattle();
        }
        else
        {
            refreshGui();

        }
    }

	int getCurrentPopulation( int aTier )
	{
	    return economyEngine.getCurrentPopulation( aTier );
	}
}
