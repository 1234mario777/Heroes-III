package pl.sdk.hero;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.EconomyEngine;
import pl.sdk.creatures.EconomyNecropolisFactory;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BuyingCreatureTest {

    private EconomyHero hero1;
    private final EconomyNecropolisFactory creatureFactory = new EconomyNecropolisFactory();
    private EconomyEngine economyEngine;
    private EconomyHero hero2;
    private Player player1;
    private Player player2;

    @BeforeEach
    void init() {

        Random rand = mock( Random.class );
        when( rand.nextDouble() ).thenReturn( 1.0 );
        CreatureShop shop = new CreatureShop(rand);
        hero1 = new EconomyHero(EconomyHero.Fraction.NECROPOLIS, 1000);
        hero2 = new EconomyHero(EconomyHero.Fraction.NECROPOLIS, 1000);
        player1 = new Player( hero1 );
        player2 = new Player( hero2 );
        economyEngine = new EconomyEngine(player1, player2, shop);
    }

    @Test
    void heroShouldCanBuyCreature() {
        economyEngine.buy(creatureFactory.create(false, 1, 1));

        assertEquals(940, player1.getGold());
    }

    @Test
    void heroShouldCanBuyMoreThanOneCreatureInOneStack() {
        economyEngine.buy(creatureFactory.create(false, 1, 2));

        assertEquals(880, player1.getGold());
    }

    @Test
    void heroShouldCanBuyMoreThanOneCreatureInFewStack() {
        economyEngine.buy(creatureFactory.create(false, 1, 2));
        economyEngine.buy(creatureFactory.create(true, 2, 2));

        assertEquals(630, player1.getGold());
    }

    @Test
    void heroCannotBuyCreatureWhenHasNotEnoughtGold() {
        assertThrows(IllegalStateException.class, () -> economyEngine.buy(creatureFactory.create(false, 1, 100)));
        assertEquals(1000, player1.getGold());
        assertEquals(0, player1.getCreatures().size());
    }

    @Test
    void heroCannotBuyCreatureIfHeIsFull() {
        economyEngine.buy(creatureFactory.create(false, 1, 1));
        economyEngine.buy(creatureFactory.create(false, 1, 1));
        economyEngine.buy(creatureFactory.create(false, 1, 1));
        economyEngine.buy(creatureFactory.create(false, 1, 1));
        economyEngine.buy(creatureFactory.create(false, 1, 1));
        economyEngine.buy(creatureFactory.create(false, 1, 1));
        economyEngine.buy(creatureFactory.create(false, 1, 1));
        assertThrows(IllegalStateException.class, () -> economyEngine.buy(creatureFactory.create(false, 1, 1)));

        assertEquals(580,player1.getGold());
        assertEquals(7,player1.getCreatures().size());
    }
}
