package pl.sdk.spells;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpellBookTest {

    @Test
    void shouldNotAllowToCastMoreThanOneSpellInRound(){
        SpellBook spellBook = new SpellBook();
        assertTrue(spellBook.canCastSpell());

        spellBook.cast(SpellFactoryForTests.createMagicArrow());
        assertFalse(spellBook.canCastSpell());
    }

    @Test
    void shouldAllowToCastSecondSpellAfterEndOfTurn(){
        SpellBook spellBook = new SpellBook();
        assertTrue(spellBook.canCastSpell());
        spellBook.cast(SpellFactoryForTests.createMagicArrow());
        assertFalse(spellBook.canCastSpell());

        spellBook.endOfTurn();

        assertTrue(spellBook.canCastSpell());
    }
}