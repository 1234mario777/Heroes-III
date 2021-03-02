package pl.sdk.spells;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static pl.sdk.spells.SpellStatistic.TEST_HASTE;

class EconomySpellFactoryTest
{
	public static final String HASTE = "Haste";


	@Test
	void factoryShouldCreateSpellCorrectly()
	{
		AbstractEconomySpellFactory factory = AbstractEconomySpellFactory.getInstance( SpellFactoryType.TEST );
		EconomySpell spell = factory.create( TEST_HASTE.getName() );

		assertEquals( HASTE, spell.getName() );
	}
}