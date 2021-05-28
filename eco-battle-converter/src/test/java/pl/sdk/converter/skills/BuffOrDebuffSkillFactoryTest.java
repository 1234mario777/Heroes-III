package pl.sdk.converter.skills;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.sdk.converter.SkillMasteries;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.NecropolisFactory;
import pl.sdk.skills.*;
import pl.sdk.hero.Player;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pl.sdk.Fraction.NECROPOLIS;

public class BuffOrDebuffSkillFactoryTest {
    public static final String ARCHERY = "Archery";
    private Player player;
    NecropolisFactory factroy;
    private SkillMasteries skillMasteries;
    private EconomySkill economyArcherySkill;
    private EconomySkill economyArmourSkill;
    private EconomySkill economyOffenceSkill;
    
    private AbstractSkill abstractArcherySkill;
    private AbstractSkill abstractOffenceSkill;
    private AbstractSkill abstractArmourSkill;


    @BeforeEach
    void init(){
        factroy  = new NecropolisFactory();
        economyArcherySkill = new EconomySkillFactory().create(SkillStatistic.ARCHERY);
        economyArmourSkill = new EconomySkillFactory().create(SkillStatistic.ARMOURER);
        economyOffenceSkill = new EconomySkillFactory().create(SkillStatistic.OFFENCE);
        skillMasteries = new SkillMasteries(economyArcherySkill, SkillStatistic.SkillLevel.BASIC);
        skillMasteries.put(economyArmourSkill,SkillStatistic.SkillLevel.BASIC);
        skillMasteries.put(economyOffenceSkill,SkillStatistic.SkillLevel.BASIC);
        abstractArcherySkill = SkillFactory.create(economyArcherySkill,skillMasteries);
        abstractArmourSkill = SkillFactory.create(economyArmourSkill,skillMasteries);
        abstractOffenceSkill = SkillFactory.create(economyOffenceSkill,skillMasteries);
        player = new Player(NECROPOLIS, 3000);
    }
    @Test
    void shouldConvertArcherySkillCorrectly(){
        BuffOrDebuffSkill convSkill = (BuffOrDebuffSkill) new BuffOrDebuffSkillFactory().createInner(economyArcherySkill, new SkillMasteries(economyArcherySkill, SkillStatistic.SkillLevel.BASIC));
        assertEquals(SkillStatistic.TargetType.ALLIES, convSkill.getTargetType());
    }
    @Disabled
    @Test
    void shouldReturnEconomySkillList(){
        player.buySkill(player, economyArcherySkill);
        assertEquals(player.getSkillList().get(0), economyArcherySkill);
    }
    @Test
    void shouldIncreaseDamageForShoutingCreatureBy10(){
        Creature archer = factroy.create(false,5,1);
        assertEquals(archer.getAttackContext().getAttackerStatistic().getDamage().lowerEndpoint(),11);
        assertEquals(archer.getAttackContext().getAttackerStatistic().getDamage().upperEndpoint(),15);
        List<Creature> creatures = new ArrayList<>();
        creatures.add(archer);
        abstractArcherySkill.applyEffect(creatures);
        assertEquals(archer.getAttackContext().getAttackerStatistic().getDamage().lowerEndpoint(),12);
        assertEquals(archer.getAttackContext().getAttackerStatistic().getDamage().upperEndpoint(),16);
    }
    @Test
    void shouldNotIncreaseDamageForShoutingCreatureBy10(){
        Creature notArcher = factroy.create(false,1,1);
        assertEquals(notArcher.getAttackContext().getAttackerStatistic().getDamage().lowerEndpoint(),1);
        assertEquals(notArcher.getAttackContext().getAttackerStatistic().getDamage().upperEndpoint(),3);
        List<Creature> creatures = new ArrayList<>();
        creatures.add(notArcher);
        abstractArcherySkill.applyEffect(creatures);
        assertEquals(notArcher.getAttackContext().getAttackerStatistic().getDamage().lowerEndpoint(),1);
        assertEquals(notArcher.getAttackContext().getAttackerStatistic().getDamage().upperEndpoint(),3);
    }
    @Test
    void shouldIncreaseDamageForShoutingCreatureBy20(){
        SkillMasteries sM = new SkillMasteries(economyArcherySkill, SkillStatistic.SkillLevel.ADVANCED);
        abstractArcherySkill = SkillFactory.create(economyArcherySkill,sM);

        Creature archer = factroy.create(false,5,1);
        assertEquals(archer.getAttackContext().getAttackerStatistic().getDamage().lowerEndpoint(),11);
        assertEquals(archer.getAttackContext().getAttackerStatistic().getDamage().upperEndpoint(),15);
        List<Creature> creatures = new ArrayList<>();
        creatures.add(archer);
        abstractArcherySkill.applyEffect(creatures);
        assertEquals(archer.getAttackContext().getAttackerStatistic().getDamage().lowerEndpoint(),13);
        assertEquals(archer.getAttackContext().getAttackerStatistic().getDamage().upperEndpoint(),18);
    }

}
