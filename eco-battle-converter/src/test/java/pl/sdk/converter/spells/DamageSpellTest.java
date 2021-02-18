package pl.sdk.converter.spells;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.anyInt;

import pl.sdk.Fraction;
import pl.sdk.GameEngine;
import pl.sdk.Hero;
import pl.sdk.Point;
import pl.sdk.converter.SpellMasteries;
import pl.sdk.creatures.*;
import pl.sdk.spells.DamageSpell;
import pl.sdk.spells.EconomySpell;
import pl.sdk.spells.SpellStatistic;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static pl.sdk.creatures.TestingFactory.FOR_MAGIC_RESISTANCE;

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

        spell.cast(creatureForTesting, null);

        assertEquals(5, creatureForTesting.getAmount());
        assertEquals(180, creatureForTesting.getCurrentHp());
    }

    @Test
    void spellShouldDeal10DamageBecauseHas50PercentResistance(){
        EconomySpell toCovert = new EconomySpell(SpellStatistic.MAGIC_ARROW);
        DamageSpell spell = (DamageSpell) new DamageSpellFactory().createInner(toCovert, 1, new SpellMasteries());
        creatureForTesting = AbstractFractionFactory.getInstance(Fraction.TEST_FRACTION)
                .create(true,FOR_MAGIC_RESISTANCE,5);

        spell.cast(creatureForTesting, null);

        assertEquals(5, creatureForTesting.getAmount());
        assertEquals(90, creatureForTesting.getCurrentHp());
    }

    @Test
    void spellShouldDealDamageIfCreatureIsInRange(){
        Creature c1 = spy(Creature.class);
        Creature c2 = spy(Creature.class);
        Creature c3 = spy(Creature.class);
        Creature c4 = spy(Creature.class);
        GameEngine engine = new GameEngine(new Hero(List.of(c1,c2,c3,c4)), new Hero(new ArrayList<>()));
        EconomySpell toCovert = new EconomySpell(SpellStatistic.FIRE_BALL);
        DamageSpell spell = (DamageSpell) new DamageSpellFactory().createInner(toCovert, 1, new SpellMasteries());

        engine.castSpell(spell,new Point(0,3));

        verify(c2).applyDamage(anyInt());
        verify(c1).applyDamage(anyInt());
        verify(c3).applyDamage(anyInt());
        verify(c4, never()).applyDamage(anyInt());
    }

    @Test
    void spellShouldDealDamageIfCreatureIsInRange2(){
        Creature c1 = spy(Creature.class);
        Creature c2 = spy(Creature.class);
        Creature c3 = spy(Creature.class);
        Creature c4 = spy(Creature.class);
        GameEngine engine = new GameEngine(new Hero(List.of(c1,c2,c3,c4)), new Hero(new ArrayList<>()));
        EconomySpell toCovert = new EconomySpell(SpellStatistic.FIRE_BALL);
        DamageSpell spell = (DamageSpell) new DamageSpellFactory().createInner(toCovert, 1, new SpellMasteries());

        engine.castSpell(spell,new Point(2,2));

        verify(c1).applyDamage(anyInt());
        verify(c2).applyDamage(anyInt());
        verify(c3).applyDamage(anyInt());
        verify(c4, never()).applyDamage(anyInt());
    }






// --------------------------------------------------------------
    private Creature prepareCreatureWith1kHP() {
        // 1 stack == 200HP
        return AbstractFractionFactory.getInstance(Fraction.TEST_FRACTION)
                .create(true,7,5);
    }
}
