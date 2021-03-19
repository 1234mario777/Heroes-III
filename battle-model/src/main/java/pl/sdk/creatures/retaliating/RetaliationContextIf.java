package pl.sdk.creatures.retaliating;

import java.beans.PropertyChangeEvent;

public interface RetaliationContextIf {
    void retaliate();
    boolean canRetaliate();

    void endTurnEvent(PropertyChangeEvent aPropertyChangeEvent);
}
