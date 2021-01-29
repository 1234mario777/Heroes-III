package pl.sdk;

import pl.sdk.creatures.Creature;
import pl.sdk.spells.AbstractSpell;
import pl.sdk.spells.SpellBook;
import pl.sdk.spells.SpellStatistic;

import java.util.ArrayList;
import java.util.List;

public class Hero {

    private final List<Creature> creatures;
    private final SpellBook spellBook;

    public Hero(List<Creature> aCreatures) {
        this(aCreatures, new SpellBook(15, List.of(SpellFactoryForTests.createMagicArrow(),
                SpellFactoryForTests.createMagicArrowWithSplashAndTargetType(2, SpellStatistic.TargetType.ALLY),
                SpellFactoryForTests.createMagicArrowWithSplash(2))));
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
        return spellBook.canCastSpell();
    }

    boolean canCastSpell(AbstractSpell aSpell){
        return spellBook.canCastSpell(aSpell);
    }

    void castSpell(AbstractSpell aMagicArrow) {
        spellBook.cast(aMagicArrow);
    }

    void toSubscribeEndOfTurn(TurnQueue aQueue) {
        aQueue.addObserver(spellBook);
    }

    public int getMana() {
        return spellBook.getMana();
    }
}
