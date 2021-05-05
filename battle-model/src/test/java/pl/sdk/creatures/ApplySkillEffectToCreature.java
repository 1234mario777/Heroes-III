package pl.sdk.creatures;

import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.skills.AbstractSkill;
import pl.sdk.skills.SkillStatistic;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApplySkillEffectToCreature {
    NecropolisFactory factroy;
    private AbstractSkill skill;

    @BeforeEach
    void init(){
        factroy  = new NecropolisFactory();
    }
    @Test
    void shouldReturnTrueWhileTestingIsCreatureIsShoutingUnit(){
        Creature archer = factroy.create(false,5,1);
        assertTrue(archer.isArcher());
    }
    @Test
    void shouldReturnFalseWhileTestingIsCreatureIsShoutingUnit(){
        Creature archer = factroy.create(false,1,1);
        assertFalse(archer.isArcher());
    }

}
