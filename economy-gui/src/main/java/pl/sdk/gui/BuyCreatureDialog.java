package pl.sdk.gui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
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
		Separator separator1 = new Separator(  );
		leftPane.getChildren().add( separator1 );
		ImageView image = new ImageView(new Image(getClass().getResourceAsStream("/icons/gold-bars.png" )));
		image.setFitHeight(50);
		image.setFitWidth(50);
		leftPane.getChildren().add(image);
		VBox.setMargin(image, new Insets(0, 0, 0, 65) );
		Separator separator2 = new Separator(  );
		leftPane.getChildren().add( separator2 );

		Label goldCostLabel = new Label(String.valueOf( goldCost ) );
		leftPane.getChildren().add(goldCostLabel);
		VBox.setMargin(goldCostLabel, new Insets(0, 0, 0, 60) );
		leftPane.getStyleClass().add( "border" );
		VBox centerPane = new VBox();
		HBox statePane = new HBox();
		VBox availablePane = new VBox( );
		VBox recruitPane = new VBox( );

		Label availableText = new Label("Available");
		availablePane.getChildren().add(availableText );
		Separator separator3 = new Separator(  );
		availablePane.getChildren().add( separator3 );
		Label maxValueLabel = new Label(String.valueOf( maxValue ));
		availablePane.getChildren().add(maxValueLabel );
		VBox.setMargin(maxValueLabel, new Insets(0, 0, 0, 40) );
		availablePane.getStyleClass().add( "border" );
		statePane.getChildren().add( availablePane );

		Label recruitTextLabel = new Label("Recruit");
		recruitPane.getChildren().add(recruitTextLabel);
		Separator separator4 = new Separator(  );
		recruitPane.getChildren().add( separator4 );
		Label recruitValue = new Label( String.valueOf( 0 ) );
		recruitPane.getChildren().add(recruitValue );
		VBox.setMargin(recruitValue, new Insets(0, 0, 0, 30) );;
		recruitPane.getStyleClass().add( "border" );
		statePane.getChildren().add( recruitPane );

		centerPane.getChildren().add( statePane );

		VBox sliderPane = new VBox(  );
		sliderPane.getChildren().add( slider );
		sliderPane.setMargin( slider, new Insets(0, 0, 0 ,0) );
		Button maxButton = new Button("MAX");
		maxButton.setPrefWidth(150);
		maxButton.addEventHandler( MouseEvent.MOUSE_CLICKED, (e) -> aSlider.setValue( maxValue ) );
		sliderPane.getChildren().add( maxButton );
		sliderPane.setMargin( maxButton, new Insets(0, 10, 10 ,40) );
		centerPane.getChildren().add( sliderPane );

		VBox rightPane = new VBox();
		Label totalCostText = new Label("Total Cost");
		rightPane.getChildren().add(totalCostText );
		VBox.setMargin(totalCostText, new Insets(0, 30, 0 ,30));
		Separator separator5 = new Separator(  );
		rightPane.getChildren().add( separator5 );
		ImageView image2 = new ImageView(new Image(getClass().getResourceAsStream("/icons/gold-bars.png" )));
		image2.setFitHeight(50);
		image2.setFitWidth(50);
		VBox.setMargin(image2, new Insets(0, 0, 0, 65) );
		rightPane.getChildren().add(image2);
		Separator separator6 = new Separator(  );
		rightPane.getChildren().add( separator6 );
		rightPane.getStyleClass().add( "border" );
		Label totalCost = new Label(String.valueOf( 0 ));
		rightPane.getChildren().add(totalCost);
		VBox.setMargin(totalCost, new Insets(0, 0, 0, 75) );
		rightPane.getStyleClass().add( "border" );
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
		aCenterPane.setMargin( rightPane, new Insets(0, 0, 100, 40) );
		aCenterPane.setMargin( leftPane, new Insets(0, 40, 100, 0) );
		aCenterPane.setPadding( new Insets(0, 0, 0, 25) );
		aCenterPane.getStyleClass().add("border");
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
		Scene scene = new Scene(pane, 790,650);
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
		HBox.setHgrow(cancelButton, Priority.ALWAYS);
		aBottomPane.getChildren().add(okButton);
		aBottomPane.getChildren().add(cancelButton);
		HBox.setMargin( okButton, new Insets(10, 10, 150, 0) );
		HBox.setMargin( cancelButton, new Insets(10, 0, 150, 10) );
	}

}
