package pl.sdk.converter;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.sdk.Hero;
import pl.sdk.converter.spells.SpellFactory;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.NecropolisFactory;
import pl.sdk.gui.BattleMapController;
import pl.sdk.hero.EconomyHero;
import pl.sdk.spells.AbstractSpell;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static pl.sdk.converter.SpellMasteries.SpellMasterLevel.BASIC;

public class EcoBattleConverter {

    public static void startBattle(EconomyHero aPlayer1, EconomyHero aPlayer2) {
        Scene scene = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(EcoBattleConverter.class.getClassLoader().getResource("fxml/battleMap.fxml"));
            loader.setController(new BattleMapController(convert(aPlayer1), convert(aPlayer2)));
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

    public static Hero convert(EconomyHero aPlayer1) {
        List<Creature> creatures = new ArrayList<>();
        NecropolisFactory factory = new NecropolisFactory();
        aPlayer1.getCreatures().forEach(ecoCreature ->
                creatures.add(factory.create(ecoCreature.isUpgraded(), ecoCreature.getTier(), ecoCreature.getAmount())));

        // -> artefakty
        SpellMasteries masteries = new SpellMasteries(BASIC, BASIC, BASIC, BASIC);
        //Artefacts skills itd.

        List<AbstractSpell> spells = aPlayer1.getSpells().stream()
                .map(es -> SpellFactory.create(es, aPlayer1.getPower(), masteries))
                .collect(Collectors.toList());
        return new Hero(creatures, spells);
    }
}
