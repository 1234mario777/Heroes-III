package pl.sdk;

import org.junit.jupiter.api.Test;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.NecropolisFactory;
import pl.sdk.spells.SpellBook;
import pl.sdk.spells.SpellFactoryForTests;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;

class GameEngineTest {

    @Test
    void shouldRecognizeFriendlyCreatureAndDoNotAttackHer(){
        NecropolisFactory factory = new NecropolisFactory();
        List<Creature> l1 = List.of(factory.create(true, 5,1), spy(Creature.class));
        List<Creature> l2 = List.of(spy(Creature.class));

        GameEngine engine = new GameEngine(new Hero(l1),new Hero(l2));
        assertTrue(engine.canAttack(GameEngine.BOARD_WIDTH-1, 1));
        assertFalse(engine.canAttack(0,1));
        assertFalse(engine.canAttack(0,1));
    }

    @Test
    void shouldAllowToCastSecondSpellAfterEndOfTurn(){
        NecropolisFactory factory = new NecropolisFactory();
        GameEngine engine = new GameEngine(new Hero(List.of(factory.create(false,7,1)))
                ,new Hero(List.of(factory.create(false,1,1), factory.create(false,1,1))));

        //hero1 is active
        assertTrue(engine.canCastSpell());
        engine.cast(SpellFactoryForTests.createMagicArrow());
        assertFalse(engine.canCastSpell());
        engine.pass();

        //hero2 is active
        assertTrue(engine.canCastSpell());
        engine.cast(SpellFactoryForTests.createMagicArrow());
        assertFalse(engine.canCastSpell());
        engine.pass();
        assertFalse(engine.canCastSpell());
        engine.pass();

        //hero1 is active
        assertTrue(engine.canCastSpell());
    }

}