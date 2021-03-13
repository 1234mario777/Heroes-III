package pl.sdk.creatures;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

class RegenerationOnEndOfTurnCreatureDecorator implements PropertyChangeListener {

    private PropertyChangeListener decorated;

    RegenerationOnEndOfTurnCreatureDecorator(PropertyChangeListener aDecorated) {
        decorated = aDecorated;
    }

    @Override
    public void propertyChange(PropertyChangeEvent aPropertyChangeEvent) {
        decorated.propertyChange(aPropertyChangeEvent);
    }

}
