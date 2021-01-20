package pl.sdk.converter;

import javafx.fxml.FXMLLoader;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.NecropolisFactory;
import pl.sdk.gui.BattleMapController;
import pl.sdk.hero.EconomyHero;
import pl.sdk.hero.Player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EcoBattleConverter {

    public static void startBattle( Player aPlayer1, Player aPlayer2 ) {
        Scene scene = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(EcoBattleConverter.class.getClassLoader().getResource("fxml/battleMap.fxml"));
            loader.setController(new BattleMapController(convert(aPlayer1),convert(aPlayer2)));
            scene = new Scene(loader.load());
            Stage aStage = new Stage();
            aStage.setScene(scene);
            aStage.setX(5);
            aStage.setY(5);
            aStage.show();
        } catch (IOException aE) {
            aE.printStackTrace();
        }
    }

    public static List<Creature> convert(Player aPlayer) {
        List<Creature>ret = new ArrayList<>();
        NecropolisFactory factory = new NecropolisFactory();
        aPlayer.getCreatures().forEach(ecoCreature ->
                ret.add(factory.create(ecoCreature.isUpgraded(),ecoCreature.getTier(),ecoCreature.getAmount())));
        return ret;
    }
}
