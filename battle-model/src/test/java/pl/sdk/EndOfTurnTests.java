package pl.sdk;

import org.junit.jupiter.api.Test;
import pl.sdk.board.Point;
import pl.sdk.creatures.AbstractFractionFactory;
import pl.sdk.creatures.Creature;

import java.beans.PropertyChangeEvent;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class EndOfTurnTests {

    @Test
    void shouldResetCounterAttackFlagAfterEndOfTurn(){
        Creature attacker = AbstractFractionFactory.getInstance(Fraction.TEST_FRACTION).create(false,3,1);
        Creature defender = AbstractFractionFactory.createSkeleton();

        GameEngine engine = new GameEngine(new Hero(List.of(attacker)), new Hero(List.of(defender)));
        engine.getBoardManager().putOnBoard(new Point( 1, 1 ),attacker );
        engine.getBoardManager().putOnBoard(new Point( 1, 2 ),defender );

        assertEquals(true, defender.canRetaliate());

        engine.attack(1,2);
        assertEquals(false, defender.canRetaliate());

        engine.pass();
        engine.pass();
        assertEquals(true, defender.canRetaliate());
    }

    @Test
    void shouldCallPropertyChangeAfterEndOfTurn(){
        Creature attacker = spy(AbstractFractionFactory.createSkeleton());
        Creature defender = AbstractFractionFactory.createSkeleton();
        GameEngine engine = new GameEngine(new Hero(List.of(attacker)), new Hero(List.of(defender)));

        engine.pass();
        engine.pass();
        verify(attacker).propertyChange(any(PropertyChangeEvent.class));
    }
}
