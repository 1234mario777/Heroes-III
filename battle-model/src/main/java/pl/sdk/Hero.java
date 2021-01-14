package pl.sdk;

import pl.sdk.creatures.Creature;
import pl.sdk.spells.Spell;

import java.util.List;

public class Hero {

    private final List<Creature> creatures;

    public Hero(List<Creature> aCreatures) {
        creatures = aCreatures;
    }

    public List<Creature> getCreatures() {
        return creatures;
    }

    public List<Spell> getSpells() {
        return List.of(new Spell());
    }
}
