package pl.sdk.creatures.retaliating;

import java.beans.PropertyChangeEvent;

public interface RetaliationContextIf {
    void updateRetaliateCounter();
    boolean canRetaliate();

    void endTurnEvent(PropertyChangeEvent aPropertyChangeEvent);
}
