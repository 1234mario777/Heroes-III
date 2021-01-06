package pl.sdk.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import pl.sdk.*;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.NecropolisFactory;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class BattleMapController implements PropertyChangeListener {

    @FXML
    private GridPane gridMap;

    @FXML
    private Button passButton;

    private final GameEngine gameEngine;
    List<Creature> heroOneCreatures;
    List<Creature> heroTwoCreatures;

    public BattleMapController() {
        heroOneCreatures = new ArrayList<>();
        heroTwoCreatures = new ArrayList<>();
        NecropolisFactory factory = new NecropolisFactory();
        for (int i = 1; i <= 7; i++) {
            heroOneCreatures.add(factory.create(false, i, 10));
        }

        for (int i = 1; i <= 7; i++) {
            heroTwoCreatures.add(factory.create(true, i, 10));
        }

        gameEngine = new GameEngine(heroOneCreatures, heroTwoCreatures);
    }

    public BattleMapController(List<Creature> aCreatures1, List<Creature> aCreatures2){
        heroOneCreatures = aCreatures1;
        heroTwoCreatures = aCreatures2;
        gameEngine = new GameEngine(aCreatures1, aCreatures2);
    }

    @FXML
    void initialize() {
        gameEngine.addObserver(GameEngine.CURRENT_CREATURE_CHANGED, this);
        gameEngine.addObserver(GameEngine.CREATURE_MOVED, this);
        gameEngine.addObserver(GameEngine.CREATURE_ATTACKED, this);

        passButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
            gameEngine.pass();
        });

        refreshGui();
    }

    private void refreshGui() {
        for (int x = 0; x < 20; x++) {
            for (int y = 0; y < 15; y++) {
                MapTile rec = new MapTile();
                gridMap.add(rec, x, y);

                Creature c = gameEngine.get(x, y);
                if (c != null) {
                    boolean shouldFlip = heroTwoCreatures.contains( c );
                    rec.addCreature(c.getName(), c.getAmount(), shouldFlip);

                    if (c == gameEngine.getActiveCreature()) {
                        rec.setBackground(Color.GREEN);
                    } else if (gameEngine.canAttack(x, y)) {
                        final int x1 = x;
                        final int y1 = y;
                        rec.setBackground(Color.RED);
                        rec.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> gameEngine.attack(x1, y1));
                    }
                } else if (gameEngine.canMove(x, y)) {
                    final int x1 = x;
                    final int y1 = y;
                    rec.setBackground(Color.GREY);
                    rec.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> gameEngine.move(new Point(x1, y1)));
                }

            }
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent aPropertyChangeEvent) {
        refreshGui();
    }
}
