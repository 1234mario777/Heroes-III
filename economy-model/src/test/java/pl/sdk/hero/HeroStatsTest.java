package pl.sdk.hero;

import org.junit.jupiter.api.Test;
import pl.sdk.Fraction;
import pl.sdk.HeroEnum;
import pl.sdk.spells.SpellFactoryType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HeroStatsTest {

    @Test
    public void shouldCreateHeroWithALLOneLevelStats(){
        EconomyHero hero = new EconomyHero(new HeroStats(new EconomyTestHeroFactory().create(HeroEnum.WARRIOR)));
        assertEquals(hero.getWisdom(),1);
        assertEquals(hero.getPower(),1);
        assertEquals(hero.getAttack(),1);
        assertEquals(hero.getDefence(),1);
    }

    @Test
    public void shouldCreateHeroWithRandomStats(){
        EconomyHero hero = new EconomyHero(new HeroStats(new EconomyTestHeroFactory().create(HeroEnum.WARRIOR)));
        assertTrue(1 <= hero.getPower() && hero.getPower() <= 3);
        assertTrue(1 <= hero.getWisdom() && hero.getWisdom() <= 3);
        assertTrue(1 <= hero.getAttack() && hero.getWisdom() <= 5);
        assertTrue(1 <= hero.getDefence() && hero.getWisdom() <= 5);
    }
}
