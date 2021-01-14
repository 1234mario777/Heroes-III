package pl.sdk;

import pl.sdk.creatures.Creature;
import pl.sdk.spells.SingeTargetDamageSpell;

import java.util.ArrayList;
import java.util.List;

public class Hero {

    private final List<Creature> creatures;
    private final List<SingeTargetDamageSpell> spells;

    public Hero(List<Creature> aCreatures) {
        this(aCreatures, new ArrayList<>());
    }

    public Hero(List<Creature> aCreatures, List<SingeTargetDamageSpell> aSpells) {
        creatures = aCreatures;
        spells = aSpells;
    }

    public List<Creature> getCreatures() {
        return creatures;
    }

    public List<SingeTargetDamageSpell> getSpells() {
        return spells;
    }

}
