package pl.sdk.hero;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.creatures.EconomyTestFractionFactory;

import static org.junit.jupiter.api.Assertions.*;
import static pl.sdk.Fraction.NECROPOLIS;

class EconomyHeroTest {


    private Player player;

    @BeforeEach
    void init(){
        player = new Player(NECROPOLIS, 3000);
    }

    @Test
    void shouldThrowExceptionWhileHeroHas7CreatureAndYoTryToAddNextOne(){
        EconomyTestFractionFactory factory = new EconomyTestFractionFactory();
        player.addCreature(factory.create(true,1,1 ) );
        player.addCreature(factory.create(true,1,1 ) );
        player.addCreature(factory.create(true,1,1 ) );
        player.addCreature(factory.create(true,1,1 ) );
        player.addCreature(factory.create(true,1,1 ) );
        player.addCreature(factory.create(true,1,1 ) );
        player.addCreature(factory.create(true,1,1 ) );

        assertThrows(IllegalStateException.class, () -> player.addCreature(factory.create(true,1,1 ) ) );
    }

    @Test
    void shouldThrowExceptionWhileYouTrySubstractMoreGoldThanHeroHas(){
        assertThrows(IllegalStateException.class, () -> player.substractGold(3001 ) );
    }
}