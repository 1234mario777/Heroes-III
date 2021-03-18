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
        Board board = new Board();
        board.add(1,1,attacker);
        board.add(1,2,defender);

        GameEngine engine = new GameEngine(new Hero(List.of(attacker)), new Hero(List.of(defender)),board);

        assertEquals(true, defender.canCounterAttack());

        engine.attack(1,2);
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
