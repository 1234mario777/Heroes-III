package pl.sdk.gui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import pl.sdk.skills.EconomySkill;
import pl.sdk.skills.EconomySkillFactory;


public class SkillButton extends Button {
    public SkillButton(EcoController aEcoController, EconomySkillFactory aFactory, EconomySkill aName )
    {
        super();
        EconomySkill skill = aFactory.create( aName.getSkillStatistic() );

        addEventHandler( MouseEvent.MOUSE_CLICKED, (e ) ->
        {
            if ( e.getButton() == MouseButton.PRIMARY )
            {
                aEcoController.buySkill( aFactory.create( aName.getSkillStatistic() ) );
                aEcoController.refreshGui();
            }
        } );

        HBox topPane = new HBox( );
        ImageView image = new ImageView(new Image(getClass().getResourceAsStream("/graphics/icons/" + skill.getName() + ".png" )));
        image.setFitHeight(20);
        image.setFitWidth(20);
        topPane.getChildren().add(image);
        Label spellName = new Label( skill.getName() );
        spellName.getStyleClass().add( "buy-creature-text" );
        topPane.getChildren().add( spellName );
        topPane.setAlignment( Pos.CENTER );

        VBox borderPane = new VBox( );
        HBox statisticBox = new HBox(  );
        Label goldCost = new Label("Gold: " + skill.getGoldCost());
        goldCost.getStyleClass().add( "creature-button-statistic" );
        statisticBox.getChildren().add(goldCost );
        Label levelLabel = new Label("Level: " + skill.getSkillLevel());
        levelLabel.getStyleClass().add( "creature-button-statistic" );
        statisticBox.getChildren().add(levelLabel );
        Label targetLabel = new Label("Target: " + skill.getTargetType());
        targetLabel.getStyleClass().add( "creature-button-statistic" );
        statisticBox.getChildren().add(targetLabel );
        statisticBox.setAlignment( Pos.CENTER );
        borderPane.getChildren().add( statisticBox );

        Label descriptionLabel = new Label( skill.getDescription());
        descriptionLabel.getStyleClass().add( "creature-button-statistic" );
        borderPane.getChildren().add( descriptionLabel );
        borderPane.setAlignment( Pos.CENTER );
        borderPane.getStyleClass().add( "border" );

        VBox buttonContent = new VBox(  );
        buttonContent.getChildren().add( topPane );
        buttonContent.getChildren().add( borderPane );
        this.setGraphic( buttonContent );
//            if ( aEcoController.hasSkill(skill))
        if ( aEcoController.calculateSkillMaxAmount(skill) <= 0) setDisable( true );
        getStyleClass().add("creatureButton");
    }
}
