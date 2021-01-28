package pl.sdk;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.NecropolisFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CreatureTurnQueueTest {

    private Creature a;
    private Creature b;
    private Creature c;
    private Hero hero1;
    private Hero hero2;


    @BeforeEach
    void init(){
        NecropolisFactory necroFactory = new NecropolisFactory();
        a = necroFactory.create(false,3,1);
        b = necroFactory.create(false,1,1);
        c = necroFactory.create(false,7,1);
        hero1 = new Hero(List.of(a,b));
        hero2 = new Hero(List.of(c));
    }

    @Test
    void shouldChangeActiveCreature(){
        TurnQueue creatureTurnQueue = new TurnQueue(hero1, hero2);

        assertEquals(c,creatureTurnQueue.getActiveCreature());
        creatureTurnQueue.next();

        assertEquals(a,creatureTurnQueue.getActiveCreature());
        creatureTurnQueue.next();

        assertEquals(b,creatureTurnQueue.getActiveCreature());
        creatureTurnQueue.next();

        assertEquals(c, creatureTurnQueue.getActiveCreature());
    }

    @Test
    void shouldChangeActiveHero(){
        TurnQueue creatureTurnQueue = new TurnQueue(hero1, hero2);

        assertEquals(hero2,creatureTurnQueue.getActiveHero());
        creatureTurnQueue.next();

        assertEquals(hero1,creatureTurnQueue.getActiveHero());
        creatureTurnQueue.next();

        assertEquals(hero1,creatureTurnQueue.getActiveHero());
        creatureTurnQueue.next();

        assertEquals(hero2, creatureTurnQueue.getActiveHero());
    }
}