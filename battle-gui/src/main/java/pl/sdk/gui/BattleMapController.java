package pl.sdk.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import pl.sdk.*;
import pl.sdk.Point;
import pl.sdk.creatures.AbstractFractionFactory;
import pl.sdk.creatures.Creature;
import pl.sdk.spells.*;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import static pl.sdk.GameEngine.AFTER_ATTACK;
import static pl.sdk.GameEngine.AFTER_MOVE;

public class BattleMapController implements PropertyChangeListener {

    @FXML
    private GridPane gridMap;

    @FXML
    private Button passButton;

    @FXML
    private Button spellBookButton;

    private final GameEngine gameEngine;

    public BattleMapController() {
        List<Creature> notUpgradedCreatures = new ArrayList<>();
        List<Creature> upgradedCreatures = new ArrayList<>();

        AbstractFractionFactory factory = AbstractFractionFactory.getInstance(Fraction.NECROPOLIS);
        for (int i = 1; i <= 7; i++) {
            notUpgradedCreatures.add(factory.create(false, i, 10));
        }

        for (int i = 1; i <= 7; i++) {
            upgradedCreatures.add(factory.create(true, i, 10));
        }

        SpellBook spellBook = new SpellBook(15, List.of(SpellFactoryForTests.createMagicArrow(),
                SpellFactoryForTests.createMagicArrowWithSplashAndTargetType(2, SpellStatistic.TargetType.ALLY),
                SpellFactoryForTests.createMagicArrowWithSplash(2),
                new BuffOrDebuffSpell(1, 2, SpellStatistic.SpellElement.AIR, SpellStatistic.TargetType.ALL_ALLIES, "HASTE", new BuffStatistic(5))));

        gameEngine = new GameEngine(new Hero(notUpgradedCreatures, spellBook), new Hero(upgradedCreatures));
    }

    public BattleMapController(Hero aHero1, Hero aHero2) {
        gameEngine = new GameEngine(aHero1, aHero2);
    }

    @FXML
    void initialize() {
        gameEngine.addObserver(GameEngine.CURRENT_CREATURE_CHANGED, this);
        gameEngine.addObserver(GameEngine.CREATURE_MOVED, this);
        gameEngine.addObserver(GameEngine.CREATURE_ATTACKED, this);

        passButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
            gameEngine.pass();
        });

        spellBookButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
            SpellChooserDialog spellChooser = new SpellChooserDialog(gameEngine.getActiveHero().getSpells(), gameEngine.getActiveHero().getCurrentMana(), gameEngine.getActiveHero().getMaxMana());
            spellChooser.startDialog(this::prepareToCastSpell);
        });

        refreshGui(null);
    }

    private void refreshGui(AbstractSpell spellToCast) {
        gridMap.getChildren().clear();
        spellBookButton.setDisable(!gameEngine.canCastSpell());

        if (spellToCast !=null && spellToCast.getTargetType().equals(SpellStatistic.TargetType.ALL_ALLIES)){
            gameEngine.castSpell(spellToCast);
        }

        for (int x = 0; x < 20; x++) {
            for (int y = 0; y < 15; y++) {
                MapTile rec = new MapTile();
                gridMap.add(rec, x, y);
                Creature c = gameEngine.get(x, y);
                if (c != null) {
                    boolean shouldFlip = gameEngine.isHeroTwoCreature(c);
                    rec.addCreature(c.getName(), c.getAmount(), shouldFlip);
                }

                if (spellToCast == null || spellToCast.getTargetType().equals(SpellStatistic.TargetType.ALL_ALLIES)) {
                    prepareTile(x, y, rec);
                } else {
                    prepareTileWithSpells(x, y, rec, spellToCast);
                }
            }
        }
    }

    private void prepareTileWithSpells(int aX, int aY, MapTile aRec, AbstractSpell aSpellToCast) {
        if (gameEngine.canCastSpell(aSpellToCast, new Point(aX, aY))) {
            aRec.changeState(new MapTileCastSpellPossibleState());
            aRec.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
                gameEngine.castSpell(aSpellToCast, new Point(aX, aY));
                refreshGui(null);
            });
        }
    }

    private void prepareTile(int aX, int aY, MapTile aRec) {
        gameEngine.addObserver(AFTER_MOVE, aRec);
        gameEngine.addObserver(AFTER_ATTACK, aRec);
        Creature c = gameEngine.get(aX, aY);
        if (c != null) {
            if (c == gameEngine.getActiveCreature()) {
                aRec.changeState(new MapTileActiveCreatureState());
            } else if (gameEngine.canAttack(aX, aY)) {
                final int x1 = aX;
                final int y1 = aY;
                aRec.changeState(new MapTileAttackPossibleState());
                aRec.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> gameEngine.attack(x1, y1));
            }
        } else if (gameEngine.canMove(aX, aY)) {
            final int x1 = aX;
            final int y1 = aY;
            aRec.changeState(new MapTileMovePossibleState());
            aRec.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> gameEngine.move(new Point(x1, y1)));
        }
    }

    void prepareToCastSpell(AbstractSpell aChosenSpell) {
        //time to change refresh method ;).
        refreshGui(aChosenSpell);
    }

    @Override
    public void propertyChange(PropertyChangeEvent aPropertyChangeEvent) {
        refreshGui(null);
    }


}
