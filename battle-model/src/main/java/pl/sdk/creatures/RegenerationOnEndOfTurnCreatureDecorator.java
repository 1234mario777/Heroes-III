package pl.sdk.creatures;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

class RegenerationOnEndOfTurnCreatureDecorator implements PropertyChangeListener {

    private Creature decorated;

    RegenerationOnEndOfTurnCreatureDecorator(Creature aDecorated) {
        decorated = aDecorated;
    }

    @Override
    public void propertyChange(PropertyChangeEvent aPropertyChangeEvent) {
        decorated.propertyChange(aPropertyChangeEvent);
        decorated.setCurrentHpToMaximum();
    }

}
