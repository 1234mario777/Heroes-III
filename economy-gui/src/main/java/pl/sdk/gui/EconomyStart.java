package pl.sdk.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.sdk.Fraction;
import pl.sdk.hero.Player;

public class EconomyStart extends Application {

    @Override
    public void start(Stage aStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("fxml/eco.fxml"));
        loader.setController( new EcoController() );
        Scene scene = new Scene(loader.load());
        aStage.setScene(scene);
        aStage.setX(5);
        aStage.setY(5);
        aStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
