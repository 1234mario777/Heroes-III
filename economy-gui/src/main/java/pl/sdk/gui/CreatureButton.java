package pl.sdk.gui;

import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import pl.sdk.creatures.EconomyNecropolisFactory;


public class CreatureButton extends Button {

    private final String creatureName;
    public CreatureButton(EcoController aEcoController, EconomyNecropolisFactory aFactory, boolean aUpgraded, int aTier) {
        super(aFactory.create(aUpgraded,aTier,1).getName());
        creatureName = aFactory.create(aUpgraded,aTier,1).getName();
        getStyleClass().add("creatureButton");

        addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
            if(e.getButton() == MouseButton.PRIMARY)
            {
                BuyCreatureDialog buyCreatureDialog = new BuyCreatureDialog( creatureName, aEcoController.calculateMaxAmount( aFactory.create(aUpgraded,aTier,1) ) );
                buyCreatureDialog.startDialog();
                int amount = buyCreatureDialog.getCreatureAmount();
                if(amount != 0){
                    aEcoController.buy(aFactory.create(aUpgraded,aTier,amount));
                }
                aEcoController.refreshGui();
            }
            else if(e.getButton() == MouseButton.SECONDARY)
            {
                StatisticCreatureDialog statisticCreatureDialog = new StatisticCreatureDialog( this, aFactory.create(aUpgraded,aTier,1) );
                statisticCreatureDialog.startDialog();
            }

        });
    }

}
