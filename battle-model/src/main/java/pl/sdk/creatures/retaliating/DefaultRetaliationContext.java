package pl.sdk.creatures.retaliating;

import java.beans.PropertyChangeEvent;

public class DefaultRetaliationContext implements RetaliationContextIf{
    int turnRetaliationCounter;
    int maxRetaliateOnRound;

    DefaultRetaliationContext(int aMaxRetaliateOnRound) {
        maxRetaliateOnRound = aMaxRetaliateOnRound;
    }

    @Override
    public void updateRetaliateCounter() {
        if (maxRetaliateOnRound == turnRetaliationCounter){
            throw new IllegalStateException("You trying to retaliate more that round counter");
        }
        turnRetaliationCounter++;
    }

    @Override
    public boolean canRetaliate() {
        return turnRetaliationCounter < maxRetaliateOnRound;
    }

    @Override
    public void endTurnEvent(PropertyChangeEvent aPropertyChangeEvent) {
        turnRetaliationCounter = 0;
    }
}
