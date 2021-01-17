package pl.sdk.gui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;


class BuyCreatureDialog
{
	private final CreatureSlider creatureSlider;
	private String creatureName;
	private int goldCost;
	private int maxValue;
	private Stage dialog;

	public BuyCreatureDialog( String aCreatureName, int aMaxValue, int aGoldCost)
	{
		creatureName = aCreatureName;
		creatureSlider = new CreatureSlider( aMaxValue );
		goldCost = aGoldCost;
		maxValue = aMaxValue;
	}

	void startDialog() {
		HBox centerPane = new HBox();
		HBox bottomPane = new HBox();
		VBox topPane = new VBox();
		Stage dialog = prepareWindow(centerPane, bottomPane, topPane);
		Slider slider = creatureSlider.createSlider();

		prepareConfirmAndCancelButton(bottomPane, slider);
		prepareTop(topPane);
		prepareCenter(centerPane, slider);


		dialog.showAndWait();
	}

	private void prepareCenter( HBox aCenterPane, Slider aSlider )
	{
		Slider slider = aSlider;

		VBox leftPane = new VBox();
		leftPane.getChildren().add(new Label("Cost Per Troop") );
		ImageView image = new ImageView(new Image(getClass().getResourceAsStream("/icons/gold-bars.png" )));
		image.setFitHeight(50);
		image.setFitWidth(50);
		leftPane.getChildren().add(image);
		leftPane.getChildren().add(new Label(String.valueOf( goldCost ) ));
		leftPane.getStyleClass().add( "vbox" );

		VBox centerPane = new VBox();
		HBox statePane = new HBox();
		VBox availablePane = new VBox( );
		VBox recruitPane = new VBox( );

		availablePane.getChildren().add(new Label("Available") );
		availablePane.getChildren().add(new Label(String.valueOf( maxValue )) );
		statePane.getChildren().add( availablePane );

		recruitPane.getChildren().add(new Label("Recruit") );
		Label recruitValue = new Label( String.valueOf( 0 ) );
		recruitPane.getChildren().add(recruitValue );
		statePane.getChildren().add( recruitPane );

		centerPane.getChildren().add( statePane );

		centerPane.getChildren().add( slider );

		centerPane.getStyleClass().add( "vbox" );

		VBox rightPane = new VBox();
		Label totalCostText = new Label("Total Cost");
		rightPane.getChildren().add(totalCostText );
		VBox.setMargin(totalCostText, new Insets(0, 0, 0, 20) );
		ImageView image2 = new ImageView(new Image(getClass().getResourceAsStream("/icons/gold-bars.png" )));
		image2.setFitHeight(50);
		image2.setFitWidth(50);
		VBox.setMargin(image2, new Insets(0, 0, 0, 45) );
		rightPane.getChildren().add(image2);
		Label totalCost = new Label(String.valueOf( 0 ));
		rightPane.getChildren().add(totalCost);
		VBox.setMargin(totalCost, new Insets(0, 0, 0, 50) );
		rightPane.getStyleClass().add( "vbox" );

		slider.valueProperty()
		      .addListener( new ChangeListener<Number>()
		      {

			      @Override
			      public void changed( ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue )
			      {
				      totalCost.setText( String.valueOf( newValue.intValue() * goldCost ) );
				      recruitValue.setText( String.valueOf( newValue.intValue() ) );
			      }
		      } );


		aCenterPane.getChildren().add( leftPane );
		aCenterPane.getChildren().add( centerPane );
		aCenterPane.getChildren().add( rightPane );
		aCenterPane.setMargin( rightPane, new Insets(0, 0, 0, 40) );
	}

	int getCreatureAmount()
	{
		return creatureSlider.getCreatureAmount();
	}

	private void prepareTop(VBox aTopPane) {

		Label recruitLabel = new Label("Recruit " + creatureName );
		recruitLabel.getStyleClass().add("buy-creature-text");
		aTopPane.getChildren().add(recruitLabel);

		ImageView image = new ImageView(new Image(getClass().getResourceAsStream("/graphics/creatures/" + creatureName + ".png" )));
		image.setFitHeight(200);
		image.setFitWidth(200);
		aTopPane.getChildren().add(image);
		aTopPane.setAlignment( Pos.CENTER );
	}

	private Stage prepareWindow( Pane aCenter, Pane aBottom, Pane aTop ) {
		dialog = new Stage();
		BorderPane pane = new BorderPane();
		Scene scene = new Scene(pane, 700,550);
		scene.getStylesheets().add("fxml/main.css");
		dialog.setScene(scene);
		dialog.initModality( Modality.APPLICATION_MODAL );
		dialog.setTitle("Recruit " + creatureName );

		pane.setTop(aTop);
		pane.setCenter(aCenter);
		pane.setBottom(aBottom);
		return dialog;
	}

	private void prepareConfirmAndCancelButton(HBox aBottomPane, Slider aSlider) {
		Button okButton = new Button("OK");
		aBottomPane.setAlignment( Pos.CENTER );
		okButton.addEventHandler( MouseEvent.MOUSE_CLICKED, (e) -> dialog.close() );
		okButton.setPrefWidth(200);

		Button maxButton = new Button("MAX");
		maxButton.setPrefWidth(200);
		maxButton.addEventHandler( MouseEvent.MOUSE_CLICKED, (e) -> aSlider.setValue( maxValue ) );

		Button cancelButton = new Button("CLOSE");
		cancelButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) ->
		{
			aSlider.setValue(0);
			dialog.close();
		});
		cancelButton.setPrefWidth(200);
		HBox.setHgrow(okButton, Priority.ALWAYS );
		HBox.setHgrow(maxButton, Priority.ALWAYS );
		HBox.setHgrow(cancelButton, Priority.ALWAYS);
		aBottomPane.getChildren().add(okButton);
		aBottomPane.getChildren().add(maxButton);
		aBottomPane.getChildren().add(cancelButton);
		HBox.setMargin( okButton, new Insets(0, 10, 70, 0) );
		HBox.setMargin( maxButton, new Insets(0, 10, 70, 10) );
		HBox.setMargin( cancelButton, new Insets(0, 0, 70, 10) );
	}

}
