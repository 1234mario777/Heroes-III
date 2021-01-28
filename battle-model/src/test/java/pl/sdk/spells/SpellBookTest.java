package pl.sdk.spells;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpellBookTest {

    @Test
    void shouldNotAllowToCastMoreThanOneSpellInRound(){
        SpellBook spellBook = new SpellBook(10);
        assertTrue(spellBook.canCastSpell());

        spellBook.cast(SpellFactoryForTests.createMagicArrow());
        assertFalse(spellBook.canCastSpell());
    }

    @Test
    void shouldAllowToCastSecondSpellAfterEndOfTurn(){
        SpellBook spellBook = new SpellBook(10);
        assertTrue(spellBook.canCastSpell());
        spellBook.cast(SpellFactoryForTests.createMagicArrow());
        assertFalse(spellBook.canCastSpell());

        spellBook.endOfTurn();

        assertTrue(spellBook.canCastSpell());
    }

    @Test
    void shouldCanCastSpellIfHasEnoughtMana(){
        SpellBook spellBook = new SpellBook(10);
        assertTrue(spellBook.canCastSpell(SpellFactoryForTests.createMagicArrow()));
    }

    @Test
    void shouldCannotCastSpellIfHasNotEnoughtMana(){
        SpellBook spellBook = new SpellBook(2);
        assertFalse(spellBook.canCastSpell(SpellFactoryForTests.createMagicArrow()));
    }
}