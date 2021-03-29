package pl.sdk.gui;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import pl.sdk.EconomyEngine;
import pl.sdk.Fraction;
import pl.sdk.converter.EcoBattleConverter;
import pl.sdk.creatures.AbstractEconomyFractionFactory;
import pl.sdk.creatures.EconomyCreature;
import pl.sdk.hero.Player;
import pl.sdk.spells.AbstractEconomySpellFactory;
import pl.sdk.spells.EconomySpell;
import pl.sdk.spells.SpellFactoryType;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import static pl.sdk.EconomyEngine.END_OF_TURN;
import static pl.sdk.gui.ChooseFractionDialog.chooseFractionDialog;

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
    ImageView playerIcon;
    @FXML
    ImageView goldIcon;
    @FXML
    ImageView roundIcon;
    @FXML
    Label currentGoldLabel;
    @FXML
    Label roundNumberLabel;

    private final EconomyEngine economyEngine;

    public EcoController()
    {
        economyEngine = new EconomyEngine( new Player( chooseFractionDialog(), 1000 ), new Player( chooseFractionDialog(), 1000 ) );
    }

    @FXML
    void initialize(){
        refreshGui();
        economyEngine.addObserver(EconomyEngine.ACTIVE_PLAYER_CHANGED,this);
        economyEngine.addObserver(EconomyEngine.PLAYER_BOUGHT_ITEM,this );
        economyEngine.addObserver(EconomyEngine.NEXT_ROUND,this);
        economyEngine.addObserver( END_OF_TURN,this );

        readyButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> economyEngine.pass() );
    }

    private void goToBattle() {
        EcoBattleConverter.startBattle(economyEngine.getPlayer1(), economyEngine.getPlayer2());
    }

    void refreshGui() {
        playerLabel.setText(economyEngine.playerToString() );
        currentGoldLabel.setText(String.valueOf( getGold() ) );
        roundNumberLabel.setText(String.valueOf(economyEngine.getRoundNumber()));
        shopsBox.getChildren().clear();
        heroStateHBox.getChildren().clear();

        TabPane tabPane = createTabs();
        shopsBox.getChildren().add(tabPane);
        shopsBox.setAlignment( Pos.CENTER );

        VBox stateBox = createStateBox();
        heroStateHBox.getChildren().add(stateBox);
    }

    private TabPane createTabs()
    {
        HBox creatureShop = createCreatureShop();
        VBox spellShop = createSpellShop();

        TabPane tabPane = new TabPane(  );
        Tab creatureTab = new Tab();
        creatureTab.setContent( creatureShop );
        ImageView creatureTabImage = new ImageView(new Image(getClass().getResourceAsStream("/icons/sword.png" )));
        creatureTabImage.setFitHeight(48);
        creatureTabImage.setFitWidth(48);
        creatureTab.setGraphic( creatureTabImage );
        Tab spellTab = new Tab(  );
        spellTab.setContent( spellShop );
        ImageView spellTabImage = new ImageView(new Image(getClass().getResourceAsStream("/icons/magic-book.png" )));
        spellTabImage.setFitHeight(48);
        spellTabImage.setFitWidth(48);
        spellTab.setGraphic( spellTabImage );
        spellTab.getStyleClass().add( "tab" );

        tabPane.getTabs().add( creatureTab );
        tabPane.getTabs().add( spellTab );

        tabPane.getTabs().forEach( tab -> tab.setClosable( false ) );
        return tabPane;
    }

    private VBox createSpellShop()
    {
        AbstractEconomySpellFactory factory = AbstractEconomySpellFactory.getInstance( SpellFactoryType.DEFAULT );
        VBox spellShop = new VBox( );

        List<EconomySpell> spellList = economyEngine.getCurrentSpellPopulation();
        spellList.forEach( s -> spellShop.getChildren().add( new SpellButton(this, factory, s.getName()) ));
        return spellShop;
    }
//    private HBox createSkillShop(){
//        AbstractEconomyFractionFactory factory = AbstractEconomyFractionFactory.getInstance( economyEngine.getActivePlayer().getFraction() );
//        HBox creatureShop = new HBox( );
//        VBox creatureNotUpgraded = new VBox();
//        VBox creatureUpgraded = new VBox();
//        for (int i = 1; i < 8; i++) {
//            creatureNotUpgraded.getChildren().add(new CreatureButton(this, factory, false,i) );
//            creatureUpgraded.getChildren().add(new CreatureButton(this, factory, true,i));
//        }
//        creatureShop.getChildren().add( creatureNotUpgraded );
//        Separator separator = new Separator(  );
//        creatureShop.getChildren().add( separator );
//        creatureShop.getChildren().add( creatureUpgraded );
//        return creatureShop;
//
//    }
    private HBox createCreatureShop()
    {
        AbstractEconomyFractionFactory factory = AbstractEconomyFractionFactory.getInstance( economyEngine.getActivePlayer().getFraction() );
        HBox creatureShop = new HBox( );
        VBox creatureNotUpgraded = new VBox();
        VBox creatureUpgraded = new VBox();
        for (int i = 1; i < 8; i++) {
            creatureNotUpgraded.getChildren().add(new CreatureButton(this, factory, false,i) );
            creatureUpgraded.getChildren().add(new CreatureButton(this, factory, true,i));
        }
        creatureShop.getChildren().add( creatureNotUpgraded );
        Separator separator = new Separator(  );
        creatureShop.getChildren().add( separator );
        creatureShop.getChildren().add( creatureUpgraded );
        return creatureShop;
    }

    private VBox createStateBox()
    {
        VBox stateBox = new VBox( );
        VBox spellBox = new VBox( );
        VBox creaturesBox = new VBox();
        createCreatureStateBox( creaturesBox );
        createSpellStateBox( spellBox );
        stateBox.getChildren().add( creaturesBox );
        stateBox.getChildren().add( spellBox );
        return stateBox;
    }

    private void createCreatureStateBox( VBox aCreaturesBox )
    {
        economyEngine.getActivePlayer().getCreatures().forEach(c ->
        {
            HBox tempHbox = new HBox();

            ImageView image = new ImageView(new Image(getClass().getResourceAsStream("/graphics/creatures/" + c.getName() + ".png" )));
            image.setFitHeight(80);
            image.setFitWidth(80);
            tempHbox.getChildren().add(image);

            Label creatureName = new Label(c.getName());
            creatureName.getStyleClass().add( "hero-state" );
            tempHbox.getChildren().add(creatureName);


            Label creatureAmount = new Label(String.valueOf( c.getAmount()));
            tempHbox.getChildren().add(creatureAmount);
            creatureAmount.getStyleClass().add( "hero-state" );

            tempHbox.setAlignment( Pos.CENTER_LEFT );
            aCreaturesBox.getChildren().add(tempHbox );
            Separator stateSeparator = new Separator(  );
            aCreaturesBox.getChildren().add( stateSeparator );
        });
    }

    private void createSpellStateBox( VBox aSpellBox )
    {
        economyEngine.getActivePlayer().getSpells().forEach(c ->
        {
            HBox tempHbox = new HBox();

            ImageView image = new ImageView(new Image(getClass().getResourceAsStream("/graphics/icons/" + c.getElement().name() + ".png" )));
            image.setFitHeight(55);
            image.setFitWidth(55);
            tempHbox.getChildren().add(image);

            Label spellName = new Label(c.getName());
            spellName.getStyleClass().add( "hero-state" );
            tempHbox.getChildren().add(spellName);

            tempHbox.setAlignment( Pos.CENTER_LEFT );
            tempHbox.setPadding( new Insets( 15, 15 ,15,  15 ) );
            aSpellBox.getChildren().add(tempHbox );
            Separator stateSeparator = new Separator(  );
            aSpellBox.getChildren().add( stateSeparator );
        });
    }

    public int getGold()
    {
        return economyEngine.getActivePlayer().getGold();
    }

    void buyCreature(EconomyCreature aCreature ) {
        economyEngine.buyCreature(aCreature );
    }

    void buySpell(EconomySpell aSpell ) {
        economyEngine.buySpell(aSpell );
    }

    public int calculateCreatureMaxAmount( EconomyCreature aCreature )
    {
        return economyEngine.calculateCreatureMaxAmount( aCreature );
    }

    public int calculateSpellMaxAmount( EconomySpell aSpell )
    {
        return economyEngine.calculateSpellMaxAmount( aSpell );
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

    boolean hasSpell( String aName )
    {
        return economyEngine.hasSpell(aName);
    }
}
