package pl.sdk.hero;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.creatures.EconomyTestFractionFactory;

import static org.junit.jupiter.api.Assertions.*;
import static pl.sdk.hero.Fraction.NECROPOLIS;

class EconomyHeroTest {


    private EconomyHero hero;

    @BeforeEach
    void init(){
        hero = new EconomyHero(NECROPOLIS, 3000);
    }

    @Test
    void shouldThrowExceptionWhileHeroHas7CreatureAndYoTryToAddNextOne(){
        EconomyTestFractionFactory factory = new EconomyTestFractionFactory();
        hero.addCreature(factory.create(true,1,1));
        hero.addCreature(factory.create(true,1,1));
        hero.addCreature(factory.create(true,1,1));
        hero.addCreature(factory.create(true,1,1));
        hero.addCreature(factory.create(true,1,1));
        hero.addCreature(factory.create(true,1,1));
        hero.addCreature(factory.create(true,1,1));

        assertThrows(IllegalStateException.class, () -> hero.addCreature(factory.create(true,1,1)));
    }

    @Test
    void shouldThrowExceptionWhileYouTrySubstractMoreGoldThanHeroHas(){
        assertThrows(IllegalStateException.class, () -> hero.substractGold(3001));
    }
}