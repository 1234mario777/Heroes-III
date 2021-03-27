package pl.sdk.hero;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.EconomyEngine;
import pl.sdk.Fraction;
import pl.sdk.creatures.EconomyCastleFactory;
import pl.sdk.creatures.EconomyTestFractionFactory;


import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static pl.sdk.Fraction.NECROPOLIS;

public class BuyingCreatureTest {

    private EconomyHero hero1;
    private final EconomyTestFractionFactory creatureFactory = new EconomyTestFractionFactory();
    private final EconomyCastleFactory castleFactory = new EconomyCastleFactory();
    private EconomyEngine economyEngine;
    private EconomyHero hero2;
    private Player player1;
    private Player player2;
    private Fraction fraction = NECROPOLIS;
    @BeforeEach
    void init() {
        Random rand = mock( Random.class );
        when( rand.nextDouble() ).thenReturn( 1.0 );
        CreatureShop shop1 = new CreatureShop(rand, fraction);
        CreatureShop shop2 = new CreatureShop(rand, fraction);
        hero1 = new EconomyHero();
        hero2 = new EconomyHero();
        player1 = new Player( hero1, shop1, 1000 );
        player2 = new Player( hero2, shop2, 1000 );
        economyEngine = new EconomyEngine(player1, player2);
    }

    @Test
    void heroShouldCanBuyCreature() {
        economyEngine.buyCreature(creatureFactory.create(false, 1, 1 ) );

        assertEquals(940, player1.getGold());
    }

    @Test
    void heroShouldCanBuyCreatureFromCastleFactory() {
        economyEngine.buyCreature(castleFactory.create(false, 1, 1 ) );

        assertEquals(940, player1.getGold());
    }

    @Test
    void heroShouldCanBuyMoreThanOneCreatureInOneStack() {
        economyEngine.buyCreature(creatureFactory.create(false, 1, 2 ) );

        assertEquals(880, player1.getGold());
    }

    @Test
    void heroShouldCanBuyMoreThanOneCreatureInFewStack() {
        economyEngine.buyCreature(creatureFactory.create(false, 1, 2 ) );
        economyEngine.buyCreature(creatureFactory.create(true, 2, 2 ) );

        assertEquals(630, player1.getGold());
    }

    @Test
    void heroCannotBuyCreatureWhenHasNotEnoughtGold() {
        assertThrows(IllegalStateException.class, () -> economyEngine.buyCreature(creatureFactory.create(false, 1, 100 ) ) );
        assertEquals(1000, player1.getGold());
        assertEquals(0, player1.getCreatures().size());
    }

    @Test
    void heroCannotBuyCreatureIfHeIsFull() {
        economyEngine.buyCreature(creatureFactory.create(false, 1, 1 ) );
        economyEngine.buyCreature(creatureFactory.create(false, 1, 1 ) );
        economyEngine.buyCreature(creatureFactory.create(false, 1, 1 ) );
        economyEngine.buyCreature(creatureFactory.create(false, 1, 1 ) );
        economyEngine.buyCreature(creatureFactory.create(false, 1, 1 ) );
        economyEngine.buyCreature(creatureFactory.create(false, 1, 1 ) );
        economyEngine.buyCreature(creatureFactory.create(false, 1, 1 ) );
        assertThrows(IllegalStateException.class, () -> economyEngine.buyCreature(creatureFactory.create(false, 1, 1 ) ) );

        assertEquals(580,player1.getGold());
        assertEquals(7,player1.getCreatures().size());
    }
}
