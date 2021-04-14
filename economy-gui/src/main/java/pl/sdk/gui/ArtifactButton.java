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
import pl.sdk.artifacts.AbstractEconomyArtifactFactory;
import pl.sdk.artifacts.EconomyArtifact;


class ArtifactButton extends Button {
    public ArtifactButton(EcoController aEcoController, AbstractEconomyArtifactFactory aFactory, String aName) {
        super();
        EconomyArtifact artifact = aFactory.create( aName );

        addEventHandler( MouseEvent.MOUSE_CLICKED, (e ) ->
        {
            if ( e.getButton() == MouseButton.PRIMARY )
            {
                aEcoController.buyArtifact( aFactory.create( aName ) );
                aEcoController.refreshGui();
            }
        } );

        HBox topPane = new HBox( );
        ImageView image = new ImageView(new Image(getClass().getResourceAsStream("/graphics/icons/" + artifact.getName() + ".png" )));
        image.setFitHeight(20);
        image.setFitWidth(20);
        topPane.getChildren().add(image);
        javafx.scene.control.Label spellName = new javafx.scene.control.Label( artifact.getName() );
        spellName.getStyleClass().add( "buy-creature-text" );
        topPane.getChildren().add( spellName );
        topPane.setAlignment( Pos.CENTER );

        VBox borderPane = new VBox( );
        HBox statisticBox = new HBox(  );
        javafx.scene.control.Label goldCost = new javafx.scene.control.Label("Gold: " + artifact.getGoldCost());
        goldCost.getStyleClass().add( "creature-button-statistic" );
        statisticBox.getChildren().add(goldCost );
        javafx.scene.control.Label targetLabel = new javafx.scene.control.Label("Slot:: " + artifact.getArtifactStats().getArtifactSlot());
        targetLabel.getStyleClass().add( "creature-button-statistic" );
        statisticBox.getChildren().add(targetLabel );
        statisticBox.setAlignment( Pos.CENTER );
        borderPane.getChildren().add( statisticBox );

        javafx.scene.control.Label descriptionLabel = new javafx.scene.control.Label( artifact.getArtifactStats().getDescription());
        descriptionLabel.getStyleClass().add( "creature-button-statistic" );
        borderPane.getChildren().add( descriptionLabel );
        borderPane.setAlignment( Pos.CENTER );
        borderPane.getStyleClass().add( "border" );

        VBox buttonContent = new VBox(  );
        buttonContent.getChildren().add( topPane );
        buttonContent.getChildren().add( borderPane );
        this.setGraphic( buttonContent );
        if ( aEcoController.calculateArtifactMaxAmount(artifact ) <= 0  || !aEcoController.hasEmptySlotForArtifact(artifact.getName()))
            setDisable( true );
        getStyleClass().add("creatureButton");
    }
}
