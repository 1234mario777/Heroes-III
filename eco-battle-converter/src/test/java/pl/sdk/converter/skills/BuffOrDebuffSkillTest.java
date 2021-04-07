package pl.sdk.converter.skills;

import org.junit.jupiter.api.Test;
import pl.sdk.Fraction;
import pl.sdk.GameEngine;
import pl.sdk.Hero;
import pl.sdk.creatures.AbstractFractionFactory;
import pl.sdk.creatures.Creature;
import pl.sdk.skills.AbstractSkill;
import pl.sdk.skills.EconomySkill;
import pl.sdk.skills.SkillBook;
import pl.sdk.skills.SkillStatistic;

import java.util.List;

public class BuffOrDebuffSkillTest {

    @Test
    void  shouldIncreaseRangeUnitAttack(){
        Creature c1 = AbstractFractionFactory.getInstance(Fraction.NECROPOLIS)
                .create(false, 5, 1);
        Creature c2 = AbstractFractionFactory.getInstance(Fraction.NECROPOLIS)
                .create(true, 7, 1);
        AbstractSkill archery = SkillFactory.create(new EconomySkill(SkillStatistic.ARCHERY));

        GameEngine engine = new GameEngine(new Hero(List.of(c1), new SkillBook(List.of(archery))), new Hero(List.of(c2), new SkillBook(List.of(archery))));

    }
}
