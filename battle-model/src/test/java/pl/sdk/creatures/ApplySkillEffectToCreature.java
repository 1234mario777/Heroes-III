package pl.sdk.creatures;

import com.google.common.collect.Range;
import net.bytebuddy.asm.Advice;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.skills.AbstractSkill;
import pl.sdk.skills.SkillStatistic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class ApplySkillEffectToCreature {
    NecropolisFactory factroy;
    private AbstractSkill skill;
    private Creature archer;

    @BeforeEach
    void init(){
        factroy  = new NecropolisFactory();
        archer = factroy.create(false,5,1);
    }
    @Test
    void shouldReturnTrueWhileTestingIsCreatureIsShoutingUnit(){
        assertTrue(archer.isArcher());
    }
    @Test
    void shouldReturnFalseWhileTestingIsCreatureIsShoutingUnit(){
        Creature notArcher = factroy.create(false,1,1);
        assertFalse(notArcher.isArcher());
    }
    @Test
    void shouldIncreaseCreatureDamageStatistic(){
        assertEquals(archer.getAttackContext().getAttackerStatistic().getDamage().lowerEndpoint(),11);
        assertEquals(archer.getAttackContext().getAttackerStatistic().getDamage().upperEndpoint(),15);
        CreatureDynamicStats s = CreatureDynamicStats.builder().damagePercentage(0.2).build();
        archer.increaseStat(s);
        assertEquals(archer.getAttackContext().getAttackerStatistic().getDamage().lowerEndpoint(),13);
        assertEquals(archer.getAttackContext().getAttackerStatistic().getDamage().upperEndpoint(),18);
    }


}
