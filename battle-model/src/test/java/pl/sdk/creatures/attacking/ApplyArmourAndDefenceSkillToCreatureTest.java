package pl.sdk.creatures.attacking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.CreatureDynamicStats;
import pl.sdk.creatures.NecropolisFactory;
import pl.sdk.skills.AbstractSkill;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApplyArmourAndDefenceSkillToCreatureTest {
//    NecropolisFactory factroy;
//    private AbstractSkill skill;
//    private Creature basicArcher;
//
//    @BeforeEach
//    void init(){
//        factroy  = new NecropolisFactory();
//        basicArcher = factroy.create(false,5,1);
//    }
//    @Test
//    void shouldReduceIncomingDamageToCreature(){
//        Creature attacker = factroy.create(false,5,1);
//        Creature defenderWithSkill = factroy.create(false,5,1);
//        Creature defenderWithoutSkill = factroy.create(false,5,1);
//
//        CreatureDynamicStats s = CreatureDynamicStats.builder().damageReduction(0.5).build();
//        defenderWithSkill.increaseStat(s);
//
//        AttackEngine attackEngine = new AttackEngine();
//        attackEngine.attack(attacker.getAttackContext(),defenderWithSkill.getDefenceContext());
//        attackEngine.attack(attacker.getAttackContext(),defenderWithoutSkill.getDefenceContext());
//        assertTrue((int)(defenderWithoutSkill.getDefenceContext().getCurrentHp() * 0.5) == defenderWithSkill.getDefenceContext().getCurrentHp());
//    }
//    @Test
//    void shouldDealIncreasedDamage(){
//        Creature attacker = factroy.create(false,5,1);
//        Creature defenderWithSkill = factroy.create(false,5,1);
//        Creature defenderWithoutSkill = factroy.create(false,5,1);
//
//        CreatureDynamicStats s = CreatureDynamicStats.builder().damagePercentage(0.5).build();
//        defenderWithSkill.increaseStat(s);
//
//        AttackEngine attackEngine = new AttackEngine();
//        attackEngine.attack(attacker.getAttackContext(),defenderWithSkill.getDefenceContext());
//        attackEngine.attack(attacker.getAttackContext(),defenderWithoutSkill.getDefenceContext());
//        assertTrue((int)(defenderWithoutSkill.getDefenceContext().getCurrentHp() * 0.5) == defenderWithSkill.getDefenceContext().getCurrentHp());
//    }
}
