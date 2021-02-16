package pl.sdk.converter.spells;

import com.google.common.collect.Range;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.sdk.Hero;
import pl.sdk.converter.SpellMasteries;
import pl.sdk.creatures.*;
import pl.sdk.spells.DamageSpell;
import pl.sdk.spells.EconomySpell;
import pl.sdk.spells.SpellStatistic;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DamageSpellTest {

    private EconomyTestFractionFactory creatureFactory;
    private EconomyCreature creatureForTesting;

    @BeforeAll
    void init(){
        creatureFactory = new EconomyTestFractionFactory();
        EconomyCreature ecoCreature = prepareCreatureWith1kHP();
        Hero hero = new Hero( List.of(ecoCreature) );
        creatureForTesting
    }

    @Test
    void shouldConvertMagicArrowSpellsCorrectly(){
        EconomySpell toCovert = new EconomySpell(SpellStatistic.MAGIC_ARROW);

        DamageSpell spell = (DamageSpell) new DamageSpellFactory().createInner(toCovert, 1, new SpellMasteries());

        creatureForTesting.cast(spell);

    }






// --------------------------------------------------------------
    private EconomyCreature prepareCreatureWith1kHP() {
        return creatureFactory.create(true,7,5);
    }
}
