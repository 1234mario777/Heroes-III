package pl.sdk;

import org.junit.jupiter.api.Test;
import pl.sdk.creatures.AbstractFractionFactory;
import pl.sdk.creatures.Creature;

import java.beans.PropertyChangeEvent;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class EndOfTurnTests {

    @Test
    void shouldResetCounterAttackFlagAfterEndOfTurn(){
        Creature attacker = AbstractFractionFactory.getInstance(Fraction.TEST_FRACTION).create(false,3,1);
        Creature defender = AbstractFractionFactory.createSkeleton();
        new Board();

        GameEngine engine = new GameEngine(new Hero(List.of(attacker)), new Hero(List.of(defender)));

        assertEquals(true, defender.canCounterAttack());

        attacker.attack(defender);
        assertEquals(false, defender.canCounterAttack());

        engine.pass();
        engine.pass();
        assertEquals(true, defender.canCounterAttack());
    }

    @Test
    void shouldCallPropertyChangeAfterEndOfTurn(){
        Creature attacker = spy(Creature.class);
        Creature defender = AbstractFractionFactory.createSkeleton();
        GameEngine engine = new GameEngine(new Hero(List.of(attacker)), new Hero(List.of(defender)));

        engine.pass();
        engine.pass();
        verify(attacker).propertyChange(any(PropertyChangeEvent.class));
    }
}
