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
import pl.sdk.HeroEnum;
import pl.sdk.artifacts.EconomyArtifact;
import pl.sdk.artifacts.EconomyArtifactFactory;
import pl.sdk.converter.EcoBattleConverter;
import pl.sdk.creatures.AbstractEconomyFractionFactory;
import pl.sdk.creatures.EconomyCreature;
import pl.sdk.hero.Player;
import pl.sdk.skills.EconomySkill;
import pl.sdk.skills.EconomySkillFactory;
import pl.sdk.spells.AbstractEconomySpellFactory;
import pl.sdk.spells.EconomySpell;
import pl.sdk.spells.SpellFactoryType;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import static pl.sdk.EconomyEngine.END_OF_TURN;
import static pl.sdk.gui.ChooseFractionDialog.chooseFractionDialog;
import static pl.sdk.gui.ChooseHeroDialog.chooseHeroDialog;

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
    @FXML
    Label currentHeroNameLabel;
    private final EconomyEngine economyEngine;

    public EcoController()
    {
        Fraction playerFraction = chooseFractionDialog();
        HeroEnum playerHero = chooseHeroDialog();
        Fraction playerFraction2 = chooseFractionDialog();
        HeroEnum playerHero2 = chooseHeroDialog();

        economyEngine = new EconomyEngine( new Player(playerFraction, 1000, playerHero), new Player(playerFraction2, 1000, playerHero2) );
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
        currentHeroNameLabel.setText(getHeroName());
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
        VBox artifactShop = createArtifactShop();
        VBox skillShop = createSkillShop();

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

        Tab artifactTab = new Tab(  );
        artifactTab.setContent( artifactShop );
        ImageView artifactTabImage = new ImageView(new Image(getClass().getResourceAsStream("/icons/artifact.png" )));
        artifactTabImage.setFitHeight(48);
        artifactTabImage.setFitWidth(48);
        artifactTab.setGraphic( artifactTabImage );
        artifactTab.getStyleClass().add( "tab" );

        Tab skillTab = new Tab();
        skillTab.setContent( skillShop );
        ImageView skillTabImage = new ImageView(new Image(getClass().getResourceAsStream("/icons/skill-star.png" )));
        skillTabImage.setFitHeight(48);
        skillTabImage.setFitWidth(48);
        skillTab.setGraphic( skillTabImage );

        tabPane.getTabs().add( creatureTab );
        tabPane.getTabs().add( spellTab );
        tabPane.getTabs().add(skillTab);
        tabPane.getTabs().add( artifactTab );

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
    private VBox createSkillShop() {
        EconomySkillFactory factory = new EconomySkillFactory();
        VBox skillShop = new VBox();

        List<EconomySkill> skillList = economyEngine.getCurrentSkillPopulation();
        skillList.forEach(s -> skillShop.getChildren().add(new SkillButton(this, factory, s)));
        return skillShop;

    }
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

    private VBox createArtifactShop() {
        EconomyArtifactFactory factory = new EconomyArtifactFactory();
        VBox artifactShop = new VBox( );

        List<EconomyArtifact> artifactList = economyEngine.getCurrentArtifactPopulation();
        artifactList.forEach( artifact -> artifactShop.getChildren().add( new ArtifactButton(this, factory, artifact.getName()) ));
        return artifactShop;
    }

    private VBox createStateBox()
    {
        VBox stateBox = new VBox( );
        VBox spellBox = new VBox( );
        VBox creaturesBox = new VBox();
        VBox skillBox = new VBox();
        VBox artifactBox = new VBox();
        createCreatureStateBox( creaturesBox );
        createSpellStateBox( spellBox );
        createSkillStateBox( skillBox );
        createArtifactStateBox( artifactBox );
        stateBox.getChildren().add( creaturesBox );
        stateBox.getChildren().add( spellBox );
        stateBox.getChildren().add( skillBox );
        stateBox.getChildren().add( artifactBox );
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
    private void createSkillStateBox( VBox aSpellBox )
    {
        economyEngine.getActivePlayer().getSkillList().forEach(s ->
        {
            HBox tempHbox = new HBox();

            ImageView image = new ImageView(new Image(getClass().getResourceAsStream("/graphics/icons/" + s.getName() + ".png" )));
            image.setFitHeight(55);
            image.setFitWidth(55);
            tempHbox.getChildren().add(image);

            Label skillName = new Label(s.getName());
            skillName.getStyleClass().add( "hero-state" );
            tempHbox.getChildren().add(skillName);

            Label skillLevel = new Label("Level: "+ s.getSkillLevel().toString());
            skillLevel.getStyleClass().add( "hero-state" );
            tempHbox.getChildren().add(skillLevel);

            tempHbox.setAlignment( Pos.CENTER_LEFT );
            tempHbox.setPadding( new Insets( 15, 15 ,15,  15 ) );
            aSpellBox.getChildren().add(tempHbox );
            Separator stateSeparator = new Separator(  );
            aSpellBox.getChildren().add( stateSeparator );
        });
    }
    private void createArtifactStateBox( VBox aArtifactBox )
    {
        economyEngine.getActivePlayer().getArtifacts().forEach(a ->
        {
            HBox tempHbox = new HBox();

            ImageView image = new ImageView(new Image(getClass().getResourceAsStream("/graphics/icons/" + a.getName() + ".png" )));
            image.setFitHeight(55);
            image.setFitWidth(55);
            tempHbox.getChildren().add(image);

            Label artifactName = new Label(a.getName());
            artifactName.getStyleClass().add( "hero-state" );
            tempHbox.getChildren().add(artifactName);

            tempHbox.setAlignment( Pos.CENTER_LEFT );
            tempHbox.setPadding( new Insets( 15, 15 ,15,  15 ) );
            aArtifactBox.getChildren().add(tempHbox );
            Separator stateSeparator = new Separator(  );
            aArtifactBox.getChildren().add( stateSeparator );
        });
    }


    public int getGold()
    {
        return economyEngine.getActivePlayer().getGold();
    }
    public String getHeroName()
    {
        return economyEngine.getActivePlayer().getHeroName();
    }

    void buyCreature(EconomyCreature aCreature ) {
        economyEngine.buyCreature(aCreature );
    }

    void buySpell(EconomySpell aSpell ) {
        economyEngine.buySpell(aSpell );
    }

    void buyArtifact(EconomyArtifact aArtifact ) {
        economyEngine.buyArtifact(aArtifact);
    }

    public int calculateCreatureMaxAmount( EconomyCreature aCreature )
    {
        return economyEngine.calculateCreatureMaxAmount( aCreature );
    }

    public boolean canBuySpell(EconomySpell aSpell) {
        return economyEngine.canBuySpell(aSpell);
    }

    public boolean canBuyArtifact(EconomyArtifact aArtifact) {
        return economyEngine.canBuyArtifact(aArtifact);
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

    void buySkill(EconomySkill aSkill) {
        economyEngine.buySkill(aSkill);
    }

    int calculateSkillMaxAmount(EconomySkill aSkill) {
        return economyEngine.calculateSkillMaxAmount( aSkill );

    }

    boolean hasArtifact( String aName )
    {
        return economyEngine.hasArtifact(aName);
    }

    boolean hasEmptySlotForArtifact( String aName )
    {
        return economyEngine.hasEmptySlotForArtifact(aName);
    }

}
