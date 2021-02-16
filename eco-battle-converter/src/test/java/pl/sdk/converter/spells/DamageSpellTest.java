package pl.sdk.converter.spells;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.Fraction;
import pl.sdk.converter.SpellMasteries;
import pl.sdk.creatures.*;
import pl.sdk.spells.DamageSpell;
import pl.sdk.spells.EconomySpell;
import pl.sdk.spells.SpellStatistic;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DamageSpellTest {

    private Creature creatureForTesting;

    @BeforeEach
    void init(){
        creatureForTesting = prepareCreatureWith1kHP();
    }

    @Test
    void spellShouldDeal20Damage(){
        EconomySpell toCovert = new EconomySpell(SpellStatistic.MAGIC_ARROW);
        DamageSpell spell = (DamageSpell) new DamageSpellFactory().createInner(toCovert, 1, new SpellMasteries());

        spell.cast(creatureForTesting);

        assertEquals(5, creatureForTesting.getAmount());
        assertEquals(180, creatureForTesting.getCurrentHp());
    }






// --------------------------------------------------------------
    private Creature prepareCreatureWith1kHP() {
        // 1 stack == 200HP
        return AbstractFractionFactory.getInstance(Fraction.TEST_FRACTION)
                .create(true,7,5);
    }
}
