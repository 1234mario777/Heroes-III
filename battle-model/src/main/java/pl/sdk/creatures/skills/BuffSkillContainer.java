package pl.sdk.creatures.skills;

import pl.sdk.spells.BuffOrDebuffSpell;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BuffSkillContainer extends ArrayList<BuffOrDebuffSkill> implements PropertyChangeListener {

    public List<BuffStatistic> getAllBuffStats() {
        return stream().map(BuffOrDebuffSkill::getBuffStats).collect(Collectors.toList());
    }

    public boolean add(BuffOrDebuffSkill aBuffStatistic) {
        add(aBuffStatistic);
        return false;
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
        toRemove.forEach(this::remove);
    }

    public void endTurnEvent(PropertyChangeEvent aPropertyChangeEvent) {

    }
}
