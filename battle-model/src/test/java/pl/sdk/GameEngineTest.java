package pl.sdk;

import org.junit.jupiter.api.Test;
import pl.sdk.creatures.AbstractFractionFactory;
import pl.sdk.creatures.Creature;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;

class GameEngineTest {

    @Test
    void shouldRecognizeFriendlyCreatureAndDoNotAttackHer(){
        AbstractFractionFactory factory = AbstractFractionFactory.getInstance(Fraction.TEST_FRACTION);
        List<Creature> l1 = List.of(factory.create(true, 5,1), spy(AbstractFractionFactory.createSkeleton()));
        List<Creature> l2 = List.of(spy(AbstractFractionFactory.createSkeleton()));

        GameEngine engine = new GameEngine(new Hero(l1),new Hero(l2));
        assertFalse(engine.canAttack(0,1));
        assertFalse(engine.canAttack(0,1));
    }

    @Test
    void shouldAllowToCastSecondSpellAfterEndOfTurn(){
        AbstractFractionFactory factory = AbstractFractionFactory.getInstance(Fraction.TEST_FRACTION);
        GameEngine engine = new GameEngine(new Hero(List.of(factory.create(false,7,1)))
                ,new Hero(List.of(factory.create(false,1,1), factory.create(false,1,1))));

        //hero1 is active
        assertTrue(engine.canCastSpell());
        engine.castSpell(SpellFactoryForTests.createMagicArrow(), new Point(0,1));
        assertFalse(engine.canCastSpell());
        engine.pass();

        //hero2 is active
        assertTrue(engine.canCastSpell());
        engine.castSpell(SpellFactoryForTests.createMagicArrow(), new Point(19,1));
        assertFalse(engine.canCastSpell());
        engine.pass();
        assertFalse(engine.canCastSpell());
        engine.pass();

        //hero1 is active
        assertTrue(engine.canCastSpell());
    }

    @Test
    void shouldCorrectRecognizeIfHeroHasCreature()
    {
        //given
        AbstractFractionFactory factory = AbstractFractionFactory.getInstance(Fraction.NECROPOLIS);
        Creature creature = factory.create( false, 1, 1 );
        GameEngine engine = new GameEngine(new Hero(List.of( )), new Hero(List.of( creature )));

        //when && then
        assertFalse( engine.isHeroOneCreature( creature ) );
        assertTrue( engine.isHeroTwoCreature( creature ) );
    }
}