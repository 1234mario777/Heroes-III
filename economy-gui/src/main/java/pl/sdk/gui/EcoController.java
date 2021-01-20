package pl.sdk.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import pl.sdk.EconomyEngine;
import pl.sdk.converter.EcoBattleConverter;
import pl.sdk.creatures.EconomyCreature;
import pl.sdk.creatures.EconomyNecropolisFactory;
import pl.sdk.hero.Player;

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

    public EcoController( Player aPlayer1, Player aPlayer2 ) {
        economyEngine = new EconomyEngine(aPlayer1, aPlayer2);
    }

    @FXML
    void initialize(){
        refreshGui();
        economyEngine.addObserver(EconomyEngine.ACTIVE_PLAYER_CHANGED,this);
        economyEngine.addObserver(EconomyEngine.PLAYER_BOUGHT_CREATURE,this );
        economyEngine.addObserver(EconomyEngine.NEXT_ROUND,this);
        economyEngine.addObserver( END_OF_TURN,this );

        readyButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> economyEngine.pass() );
    }

    private void goToBattle() {
        EcoBattleConverter.startBattle(economyEngine.getPlayer1(), economyEngine.getPlayer2());
    }

    void refreshGui() {
        playerLabel.setText(economyEngine.getActivePlayer().toString() );
        currentGoldLabel.setText(String.valueOf( getGold() ) );
        roundNumberLabel.setText(String.valueOf(economyEngine.getRoundNumber()));
        shopsBox.getChildren().clear();
        heroStateHBox.getChildren().clear();

        EconomyNecropolisFactory factory = new EconomyNecropolisFactory();
        VBox creatureShop = new VBox();
        for (int i = 1; i < 8; i++) {
            creatureShop.getChildren().add(new CreatureButton(this, factory, false,i));
            creatureShop.getChildren().add(new CreatureButton(this, factory, true,i));
        }
        shopsBox.getChildren().add(creatureShop);

        VBox creaturesBox = new VBox();
        economyEngine.getActivePlayer().getCreatures().forEach(c ->
        {
            HBox tempHbox = new HBox();
            tempHbox.getChildren().add(new Label(String.valueOf(c.getAmount())));
            tempHbox.getChildren().add(new Label(c.getName()));
            creaturesBox.getChildren().add(tempHbox);
        } );
        heroStateHBox.getChildren().add(creaturesBox);
    }

    public int getGold()
    {
        return economyEngine.getActivePlayer().getGold();
    }

    void buy(EconomyCreature aCreature) {
        economyEngine.buy(aCreature);
    }

    public int calculateMaxAmount( EconomyCreature aCreature )
    {
        return economyEngine.calculateMaxAmount(economyEngine.getActivePlayer(), aCreature );
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
}
