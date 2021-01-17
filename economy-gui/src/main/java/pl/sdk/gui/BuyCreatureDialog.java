package pl.sdk.gui;

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
	private Stage dialog;

	public BuyCreatureDialog( String aCreatureName, int aMaxValue )
	{
		creatureName = aCreatureName;
		creatureSlider = new CreatureSlider( aMaxValue );
	}

	void startDialog() {
		VBox centerPane = new VBox();
		HBox bottomPane = new HBox();
		VBox topPane = new VBox();
		Stage dialog = prepareWindow(centerPane, bottomPane, topPane);
		Slider slider = creatureSlider.createSlider();
		prepareConfirmAndCancelButton(bottomPane, slider);
		prepareTop(topPane, slider);
		centerPane.getChildren().add(slider);

		dialog.showAndWait();
	}

	int getCreatureAmount()
	{
		return creatureSlider.getCreatureAmount();
	}

	private void prepareTop(VBox aTopPane, Slider aSlider) {

		Label recruitLabel = new Label("Recruit " + creatureName );
		recruitLabel.getStyleClass().add("buy-creature-text");
		aTopPane.getChildren().add(recruitLabel);

		ImageView image = new ImageView(new Image(getClass().getResourceAsStream("/graphics/creatures/" + creatureName + ".png" )));
		image.setFitHeight(200);
		image.setFitWidth(200);
		aTopPane.getChildren().add(image);
		aTopPane.setAlignment( Pos.CENTER );
//		//TODO creature cops should be visible here
//		aTopPane.getChildren().add(new Label("Single Cost: " + "0") );
//		Label slideValueLabel = new Label("0");
//		aSlider.valueProperty().addListener((slider, aOld, aNew) -> slideValueLabel.setText(String.valueOf(aNew.intValue())));
//		aTopPane.getChildren().add(slideValueLabel);
//		aTopPane.getChildren().add(new Label ("Purchase Cost: "));
	}

	private Stage prepareWindow( Pane aCenter, Pane aBottom, Pane aTop ) {
		dialog = new Stage();
		BorderPane pane = new BorderPane();
		Scene scene = new Scene(pane, 700,700);
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
	}

}
