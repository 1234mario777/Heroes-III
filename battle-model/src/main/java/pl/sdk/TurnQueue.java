package pl.sdk;

import pl.sdk.creatures.Creature;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.*;

class TurnQueue {


    private final Collection<Creature> creatures;
    private final Queue<Creature> creaturesQueue;
    private Creature activeCreature;
    private final PropertyChangeSupport observerSupport;

    public TurnQueue(Hero aHero1, Hero aHero2) {
        observerSupport = new PropertyChangeSupport(this);
        creaturesQueue = new LinkedList<>();
        List<Creature> twoSidesCreatures = new ArrayList<>();
        twoSidesCreatures.addAll(aHero1.getCreatures());
        twoSidesCreatures.addAll(aHero2.getCreatures());
        twoSidesCreatures.sort((c1, c2) -> c2.getMoveRange() - c1.getMoveRange());
        twoSidesCreatures.forEach(this::addObserver);
        creatures = twoSidesCreatures;
        initQueue();
        next();
    }

    void addObserver(PropertyChangeListener aObserver){
        observerSupport.addPropertyChangeListener(GameEngine.END_OF_TURN, aObserver);
    }

    void removeObserver(PropertyChangeListener aObserver){
        observerSupport.addPropertyChangeListener(aObserver);
    }

    void notifyObservers(){
        observerSupport.firePropertyChange(new PropertyChangeEvent( this, GameEngine.END_OF_TURN, null, null));
    }

    private void initQueue() {
        creaturesQueue.addAll(creatures);
    }

    Creature getActiveCreature() {
        return activeCreature;
    }

    void next() {
        if (creaturesQueue.isEmpty()){
            initQueue();
            notifyObservers();
        }
        activeCreature = creaturesQueue.poll();
    }

    Hero getActiveHero() {
        return null;
    }
}
