package pl.sdk.creatures.spells;

import pl.sdk.spells.BuffOrDebuffSpell;
import pl.sdk.spells.UpgradeCreatureStats;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class BuffContainer extends HashMap<BuffOrDebuffSpell, Integer> implements PropertyChangeListener{

    Consumer<UpgradeCreatureStats> buffCreatureConsumer;

    public BuffContainer( Consumer<UpgradeCreatureStats> aConsumer )
    {
        buffCreatureConsumer = aConsumer;
    }

    public List<UpgradeCreatureStats> getAllBuffStats() {
        return keySet().stream().map(BuffOrDebuffSpell::getBuffStats).collect(Collectors.toList());
    }

    public void add(BuffOrDebuffSpell aBuff) {
        boolean shouldBuff = !containsKey( aBuff );
        put( aBuff, aBuff.getDuration() );
        if ( shouldBuff ){
            buffCreatureConsumer.accept( aBuff.getBuffStats() );
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent aPropertyChangeEvent) {
        final List<BuffOrDebuffSpell> toRemove= new ArrayList<>();
        keySet().stream().forEach(buff -> {
            if (!get(buff).equals(0)){
                put(buff, get(buff)-1);
            }
            else {
                toRemove.add(buff);
            }
        });
        toRemove.forEach( b ->
        {
            remove( b );
            buffCreatureConsumer.accept( b.getBuffStats().reverse() );
        } );
    }
}
