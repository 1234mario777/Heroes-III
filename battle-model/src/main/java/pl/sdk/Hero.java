package pl.sdk;

import pl.sdk.creatures.Creature;
import pl.sdk.spells.AbstractSpell;
import pl.sdk.spells.SpellBook;

import java.util.ArrayList;
import java.util.List;

public class Hero {

    private final List<Creature> creatures;
    private final SpellBook spellBook;
    private boolean spellWasCastedInThisTurn;

    public Hero(List<Creature> aCreatures) {
        this(aCreatures, new SpellBook());
    }

    public Hero(List<Creature> aCreatures, SpellBook aSpellBook) {
        creatures = aCreatures;
        spellBook = aSpellBook;
    }

    public List<Creature> getCreatures() {
        return creatures;
    }

    public List<AbstractSpell> getSpells() {
        return spellBook.getSpells();
    }

    boolean canCastSpell() {
        return false;
    }
}
