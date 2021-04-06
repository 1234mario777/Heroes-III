package pl.sdk;

import pl.sdk.creatures.Creature;
import pl.sdk.skills.AbstractSkill;
import pl.sdk.skills.SkillBook;
import pl.sdk.spells.SpellStatistic;

import java.util.List;

public class Hero {

    private final List<Creature> creatures;
    private final SpellBook spellBook;
    private final SkillBook skillBook;

    public Hero(List<Creature> aCreatures) {
        this(aCreatures, new SpellBook(15, List.of(SpellFactoryForTests.createMagicArrow(),
                SpellFactoryForTests.createMagicArrowWithSplashAndTargetType(2, SpellStatistic.TargetType.ALLY),
                SpellFactoryForTests.createMagicArrowWithSplash(2))));
    }

    public Hero(List<Creature> aCreatures, SpellBook aSpellBook) {
        creatures = aCreatures;
        spellBook = aSpellBook;
        skillBook = new SkillBook(List.of(SkillFactoryForTests.createArchery()));
    }

    public Hero(List<Creature> aCreatures, SkillBook aSkillBook) {
        creatures = aCreatures;
        skillBook = aSkillBook;
        spellBook = new SpellBook(15, List.of(SpellFactoryForTests.createMagicArrow()));
    }
    public List<Creature> getCreatures() {
        return creatures;
    }

    public List<AbstractSpell> getSpells() {
        return spellBook.getSpells();
    }

    public List<AbstractSkill> getSkills() {
        return skillBook.getSkills();
    }

    boolean canCastSpell() {
        return spellBook.canCastSpell();
    }

    boolean canCastSpell(AbstractSpell aSpell){
        return spellBook.canCastSpell(aSpell);
    }

    void castSpell(AbstractSpell aSpell) {
        spellBook.cast(aSpell);
    }

    void toSubscribeEndOfTurn(TurnQueue aQueue) {
        aQueue.addObserver(spellBook);
    }

    public int getCurrentMana() {
        return spellBook.getCurrentMana();
    }

    public int getMaxMana()
    {
        return spellBook.getMaxMana();
    }
}
