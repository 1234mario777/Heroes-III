package pl.sdk.gui;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import pl.sdk.creatures.EconomyNecropolisFactory;


public class CreatureButton extends Button {

    private final String creatureName;
    private BuyCreatureDialog buyCreatureDialog;

    public CreatureButton(EcoController aEcoController, EconomyNecropolisFactory aFactory, boolean aUpgraded, int aTier) {
        super(aFactory.create(aUpgraded,aTier,1).getName());
        creatureName = aFactory.create(aUpgraded,aTier,1).getName();
        getStyleClass().add("creatureButton");

        addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
            buyCreatureDialog = new BuyCreatureDialog( this );
            buyCreatureDialog.startDialog();
            int amount = buyCreatureDialog.getCreatureAmount();
            if(amount != 0){
                aEcoController.buy(aFactory.create(aUpgraded,aTier,amount));
            }
            aEcoController.refreshGui();
        });
    }

    String getCreatureName()
    {
        return creatureName;
    }
}
