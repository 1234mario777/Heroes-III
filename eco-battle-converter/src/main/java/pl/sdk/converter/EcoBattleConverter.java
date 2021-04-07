package pl.sdk.converter;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.sdk.Fraction;
import pl.sdk.Hero;
import pl.sdk.converter.spells.SpellFactory;
import pl.sdk.creatures.AbstractFractionFactory;
import pl.sdk.creatures.Creature;
import pl.sdk.gui.BattleMapController;
import pl.sdk.AbstractSpell;
import pl.sdk.SpellBook;

import pl.sdk.hero.Player;
import pl.sdk.skills.AbstractSkill;
import pl.sdk.skills.EconomySkill;
import pl.sdk.skills.SkillStatistic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static pl.sdk.converter.SpellMasteries.SpellMasterLevel.BASIC;

public class EcoBattleConverter {

    public static void startBattle( Player aPlayer1, Player aPlayer2 ) {
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

    public static Hero convert(Player aPlayer1) {
        List<Creature> creatures = new ArrayList<>();
        AbstractFractionFactory factory = AbstractFractionFactory.getInstance(Fraction.NECROPOLIS);
        aPlayer1.getCreatures().forEach(ecoCreature ->
                creatures.add(factory.create(ecoCreature.isUpgraded(), ecoCreature.getTier(), ecoCreature.getAmount())));

        // -> artefakty
        SpellMasteries masteries = new SpellMasteries(BASIC, BASIC, BASIC, BASIC);
        //Artefacts skills itd.

        List<AbstractSpell> spells = aPlayer1.getSpells().stream()
                .map(es -> SpellFactory.create(es, aPlayer1.getPower(), masteries))
                .collect(Collectors.toList());

        Arrays.asList(aPlayer1.getSkills()).stream().forEach((skill) -> initSkills((EconomySkill) skill,  aPlayer1));

        return new Hero(creatures, new SpellBook(aPlayer1.getWisdom(), spells));
    }
    public static void initSkills(EconomySkill aSkill, Player aPlayer1){
        switch (aSkill.getSkillType()){
            case DEBUFF:
            case BUFF:
                switch (aSkill.getTargetType()){
                    case ALLIES:
                        aSkill.applyEffect(aPlayer1.getCreatures());
                    case HERO:
                        throw new UnsupportedOperationException("not implement yet!");
                    default:
                        throw new UnsupportedOperationException("not implement yet!");
                }
            case EFFECT:
                throw new UnsupportedOperationException("not implement yet!");
            default:
                throw new UnsupportedOperationException("not implement yet!");
        }
    }
}
