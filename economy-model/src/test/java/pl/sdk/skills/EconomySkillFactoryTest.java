//package pl.sdk.skills;
//
//import org.junit.jupiter.api.Test;
//import pl.sdk.spells.AbstractEconomySpellFactory;
//import pl.sdk.spells.EconomySpell;
//import pl.sdk.spells.SpellFactoryType;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static pl.sdk.spells.SpellStatistic.TEST_HASTE;
//
//public class EconomySkillFactoryTest {
//
//    public static final String ARCHERY = "Archery";
//
//
//    @Test
//    void factoryShouldCreateSpellCorrectly()
//    {
//        AbstractEconomySpellFactory factory = AbstractEconomySkillFactory.getInstance( SpellFactoryType.TEST );
//        EconomySpell skill = factory.create( TEST_HASTE.getName() );
//
//        assertEquals( ARCHERY, skill.getName() );
//    }
//
//}
