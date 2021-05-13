package pl.sdk.converter.skills;

import org.junit.jupiter.api.BeforeEach;
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
    private EconomySkill economyArcherySkill;
    private Player player;
    NecropolisFactory factroy;
    private SkillMasteries skillMasteries;
    private AbstractSkill abstractArcherySkill;

    @BeforeEach
    void init(){
        factroy  = new NecropolisFactory();
        economyArcherySkill = new EconomySkillFactory().create(SkillStatistic.ARCHERY);
        skillMasteries = new SkillMasteries(economyArcherySkill, SkillStatistic.SkillLevel.BASIC);
        abstractArcherySkill = SkillFactory.create(economyArcherySkill,skillMasteries);
        player = new Player(NECROPOLIS, 3000);
    }
    @Test
    void shouldConvertArcherySkillCorrectly(){
        BuffOrDebuffSkill convSkill = (BuffOrDebuffSkill) new BuffOrDebuffSkillFactory().createInner(economyArcherySkill, new SkillMasteries(economyArcherySkill, SkillStatistic.SkillLevel.BASIC));
        assertEquals(SkillStatistic.TargetType.ALLIES, convSkill.getTargetType());
    }
    @Test
    void shouldReturnEconomySkillList(){
        player.buySkill(player, economyArcherySkill);
        assertEquals(player.getSkillList().get(0), economyArcherySkill);
    }
    @Test
    void shouldIncreaseDamageForShoutingCreature(){
        Creature archer = factroy.create(false,5,1);
        assertEquals(archer.getAttackContext().getAttackerStatistic().getDamage().lowerEndpoint(),11);
        assertEquals(archer.getAttackContext().getAttackerStatistic().getDamage().upperEndpoint(),15);
        List<Creature> creatures = new ArrayList<>();
        creatures.add(archer);
        abstractArcherySkill.applyEffect(creatures);
        assertEquals(archer.getAttackContext().getAttackerStatistic().getDamage().lowerEndpoint(),12);
        assertEquals(archer.getAttackContext().getAttackerStatistic().getDamage().upperEndpoint(),16);
    }

}
