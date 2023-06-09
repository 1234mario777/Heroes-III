package pl.sdk.converter;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.sdk.Fraction;
import pl.sdk.Hero;
import pl.sdk.converter.artifacts.AbstractArtifact;
import pl.sdk.converter.artifacts.ArtifactFactory;
import pl.sdk.converter.skills.SkillFactory;
import pl.sdk.converter.spells.SpellFactory;
import pl.sdk.creatures.AbstractFractionFactory;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.CreatureDynamicStats;
import pl.sdk.gui.BattleMapController;
import pl.sdk.skills.AbstractSkill;
import pl.sdk.skills.EconomySkill;
import pl.sdk.skills.SkillStatistic;
import pl.sdk.spells.AbstractSpell;
import pl.sdk.SpellBook;

import pl.sdk.hero.Player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
        SkillMasteries skillMasteries = new SkillMasteries(aPlayer1.getSkillsMap());

        List<AbstractSkill> skills = aPlayer1.getSkillList().stream()
                .map(es -> SkillFactory.create(es, skillMasteries))
                .collect(Collectors.toList());

        List<Creature> creatures = new ArrayList<>();
        AbstractFractionFactory factory = AbstractFractionFactory.getInstance(aPlayer1.getFraction());
        aPlayer1.getCreatures().forEach(ecoCreature ->
                creatures.add(factory.create(ecoCreature.isUpgraded(), ecoCreature.getTier(), ecoCreature.getAmount())));



        // -> artefakty
        SpellMasteries spellMasteries = new SpellMasteries(BASIC, BASIC, BASIC, BASIC);
        //Artefacts skills itd.

        HashMap<EconomySkill, SkillStatistic.SkillLevel> skillsMap = aPlayer1.getSkillsMap();

        List<AbstractSpell> spells = aPlayer1.getSpells().stream()
                .map(es -> SpellFactory.create(es, aPlayer1.getPower(), spellMasteries))
                .collect(Collectors.toList());

//        Arrays.asList(aPlayer1.getSkills()).stream().forEach((skill) -> skill.applyEffect(Hero));

        Hero hero = new Hero(creatures, new SpellBook(aPlayer1.getWisdom(), spells));
        //Applying artifacts
        aPlayer1.getArtifacts().stream()
                .map(ea -> ArtifactFactory.create(ea))
                .forEach(a -> a.apply(hero));
        skills.stream().forEach((skill) -> skill.applyEffect(hero));
        return hero;
    }

}
