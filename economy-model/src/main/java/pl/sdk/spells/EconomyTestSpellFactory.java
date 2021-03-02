package pl.sdk.spells;

import java.util.ArrayList;
import java.util.List;

import static pl.sdk.spells.SpellStatistic.*;

class EconomyTestSpellFactory extends AbstractEconomySpellFactory
{

	private static final String EXCEPTION_MESSAGE = "Invalid spell name";

	@Override
	public EconomySpell create( String aName )
	{
		if ( aName.equals( TEST_HASTE.getName() ) )
		{
			return new EconomySpell( SpellStatistic.TEST_HASTE );
		}
		else if ( aName.equals( TEST_SUMMON_AIR_ELEMENTAL.getName() ) )
		{
			return new EconomySpell( SpellStatistic.TEST_SUMMON_AIR_ELEMENTAL );
		}
		else if ( aName.equals( TEST_DISPEL.getName() ) )
		{
			return new EconomySpell( SpellStatistic.TEST_DISPEL );
		}
		else if ( aName.equals( TEST_TELEPORT.getName() ) )
		{
			return new EconomySpell( SpellStatistic.TEST_TELEPORT );
		}
		else if ( aName.equals( TEST_FIRE_BALL.getName() ) )
		{
			return new EconomySpell( SpellStatistic.TEST_FIRE_BALL );
		}
		else if ( aName.equals( TEST_SLOW.getName() ) )
		{
			return new EconomySpell( SpellStatistic.TEST_SLOW );
		}
		else if ( aName.equals( TEST_IMPLOSION.getName() ) )
		{
			return new EconomySpell( SpellStatistic.TEST_IMPLOSION );
		}
		else if ( aName.equals( TEST_DEATH_RIPPLE.getName() ) )
		{
			return new EconomySpell( SpellStatistic.TEST_DEATH_RIPPLE );
		}
		else if ( aName.equals( TEST_MAGIC_ARROW.getName() ) )
		{
			return new EconomySpell( SpellStatistic.TEST_MAGIC_ARROW );
		}
		else
		{
			throw new IllegalArgumentException( EXCEPTION_MESSAGE );
		}

	}

	@Override
	public List<EconomySpell> getAllSpells()
	{
		List<EconomySpell> spellList = new ArrayList<>();
		List.of( TEST_HASTE.getName(), TEST_MAGIC_ARROW.getName(), TEST_DEATH_RIPPLE.getName(), TEST_IMPLOSION.getName(), TEST_SLOW.getName(), TEST_FIRE_BALL.getName(), TEST_TELEPORT.getName(), TEST_DISPEL.getName(), TEST_SUMMON_AIR_ELEMENTAL.getName() )
		    .forEach( spellName -> spellList.add( create( spellName ) ) );
		return spellList;
	}
}
