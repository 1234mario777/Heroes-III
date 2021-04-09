package pl.sdk.hero;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.creatures.EconomyTestFractionFactory;
import pl.sdk.skills.AbstractEconomySkill;
import pl.sdk.skills.EconomySkillFactory;
import pl.sdk.skills.SkillStatistic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static pl.sdk.Fraction.NECROPOLIS;

public class EconomySkillHeroTest {
    public static final String ARCHERY = "Archery";
    private Player player;
    private AbstractEconomySkill skill;
    @BeforeEach
    void init(){
        skill = new EconomySkillFactory().create(SkillStatistic.ARCHERY);
        player = new Player(NECROPOLIS, 3000);
    }

//    @Test
//    void factoryShouldAddMethodIncreaseRangeUnitDamageReturningTrue(){
//        EconomyTestFractionFactory factory = new EconomyTestFractionFactory();
//        player.addCreature(factory.create(true,1,1 ) );
//        skill.applyEffect(player);
//    }
    @Test
    void shouldAddNewSkillForHero(){
        EconomyTestFractionFactory factory = new EconomyTestFractionFactory();
        player.addCreature(factory.create(true,1,1 ) );
        player.addSkill(skill);
        assertTrue(player.hasSkill(skill));
    }
    @Test
    void shouldUpgradeSkillLevelForHero(){
        EconomyTestFractionFactory factory = new EconomyTestFractionFactory();
        player.addCreature(factory.create(true,1,1 ) );
        player.addSkill(skill);
        player.upgradeSkill(skill);
        assertEquals(player.getSkillsMap().get(skill),SkillStatistic.SkillLevel.ADVANCED);
        player.upgradeSkill(skill);
        assertEquals(player.getSkillsMap().get(skill),SkillStatistic.SkillLevel.EXPERT);
        player.upgradeSkill(skill);
        assertEquals(player.getSkillsMap().get(skill),SkillStatistic.SkillLevel.EXPERT);
    }
}
