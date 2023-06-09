package pl.sdk.hero;


import org.junit.jupiter.api.Test;
import pl.sdk.Fraction;
import pl.sdk.converter.EcoBattleConverter;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.EconomyNecropolisFactory;
import pl.sdk.spells.DamageSpell;
import pl.sdk.spells.EconomySpell;
import pl.sdk.spells.SpellStatistic;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EcoBattleConverterTest {

    @Test
    void shouldConvertCreaturesCorrectly(){
        Player ecoHero = new Player(Fraction.NECROPOLIS, 1000);
        EconomyNecropolisFactory factory = new EconomyNecropolisFactory();
        ecoHero.addCreature(factory.create(false,1,1));
        ecoHero.addCreature(factory.create(false,2,2));
        ecoHero.addCreature(factory.create(false,3,3));
        ecoHero.addCreature(factory.create(false,4,4));
        ecoHero.addCreature(factory.create(false,5,5));
        ecoHero.addCreature(factory.create(false,6,6));
        ecoHero.addCreature(factory.create(false,7,7));

        List<Creature> convertedCreatures = EcoBattleConverter.convert(ecoHero).getCreatures();

        assertEquals(7,convertedCreatures.size());

        assertEquals("Skeleton",convertedCreatures.get(0).getName());
        assertEquals(1,convertedCreatures.get(0).getAmount());

        assertEquals("Walking Dead",convertedCreatures.get(1).getName());
        assertEquals(2,convertedCreatures.get(1).getAmount());

        assertEquals("Wight",convertedCreatures.get(2).getName());
        assertEquals(3,convertedCreatures.get(2).getAmount());

        assertEquals("Vampire",convertedCreatures.get(3).getName());
        assertEquals(4,convertedCreatures.get(3).getAmount());

        assertEquals("Lich",convertedCreatures.get(4).getName());
        assertEquals(5,convertedCreatures.get(4).getAmount());

        assertEquals("Black Knight",convertedCreatures.get(5).getName());
        assertEquals(6,convertedCreatures.get(5).getAmount());

        assertEquals("Bone Dragon",convertedCreatures.get(6).getName());
        assertEquals(7,convertedCreatures.get(6).getAmount());
    }

    @Test
    void shouldConvertImplosionSpellsCorrectly(){
        Player ecoHero = new Player( Fraction.NECROPOLIS, 1000, new EconomyHero( new HeroStats( 1, 1, 1, 1 ) ) );
        ecoHero.addSpell(new EconomySpell(SpellStatistic.IMPLOSION));

        DamageSpell spell = (DamageSpell) EcoBattleConverter.convert(ecoHero).getSpells().get(0);

        assertEquals(175, spell.getDamage());
        assertEquals(0, spell.getSplashRange());
    }
}