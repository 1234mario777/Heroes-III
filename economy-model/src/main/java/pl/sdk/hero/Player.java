package pl.sdk.hero;

import pl.sdk.Fraction;
import pl.sdk.HeroEnum;
import pl.sdk.creatures.EconomyCreature;
import pl.sdk.spells.EconomySpell;

import java.util.List;
import java.util.stream.Collectors;

public class Player
{
	EconomyHero hero;
	CreatureShop creatureShop;
	SpellShop spellShop;
	List<AbstractShop> shops;
	private int gold;
	Fraction fraction;
	String heroName;

	public Player(Fraction aFraction, int aGold , HeroEnum aHero)
	{
		this(aFraction,aGold,new EconomyHero(new HeroStats(AbstractEconomyHeroFactory.getInstance(aFraction).create(aHero))));
		heroName = aHero.toString();
	}

	public Player(Fraction aFraction, int aGold )
	{
		hero = new EconomyHero(new HeroStats(5,5,15,3));
		creatureShop = new CreatureShop( aFraction );
		spellShop = new SpellShop();
		shops = List.of(creatureShop, spellShop );
		gold = aGold;
		fraction = aFraction;
	}

	public Player( Fraction aFraction, int aGold, EconomyHero aEconomyHero )
	{
		hero = aEconomyHero;
		creatureShop = new CreatureShop( aFraction );
		spellShop = new SpellShop();
		shops = List.of(creatureShop, spellShop );
		gold = aGold;
		fraction = aFraction;

	}

	Player( EconomyHero aHero, CreatureShop aCreatureShop, int aGold )
	{
		hero = aHero;
		creatureShop = aCreatureShop;
		shops = List.of(creatureShop);
		gold = aGold;

	}

	Player( EconomyHero aHero, SpellShop aShop, int aGold )
	{
		hero = aHero;
		spellShop = aShop;
		shops = List.of(spellShop);
		gold = aGold;

	}

	void substractGold(int aAmount){
		if (aAmount > gold){
			throw new IllegalStateException("Player has not enought money");
		}
		gold -= aAmount;
	}

	public void addGold(int aAmount){
		gold += aAmount;
	}

	void addCreature( EconomyCreature aEconomyCreature )
	{
		hero.addCreature( aEconomyCreature );
	}

	public List<EconomyCreature> getCreatures()
	{
		return hero.getCreatures();
	}

	public int getGold()
	{
		return gold;
	}

	public String getHeroName() {
		return heroName;
	}
	public void buyCreature( Player aActivePlayer, EconomyCreature aEconomyCreature )
	{
		creatureShop.buy( aActivePlayer, aEconomyCreature );
	}

	public void buySpell( Player aActivePlayer, EconomySpell aEconomySpell )
	{
		spellShop.buy( aActivePlayer, aEconomySpell );
	}

	public int calculateMaxAmount( EconomyCreature aCreature )
	{
		return creatureShop.calculateMaxAmount(this, aCreature );
	}

	public int calculateSpellMaxAmount( EconomySpell aSpell )
	{
		return spellShop.calculateMaxAmount(this, aSpell );
	}

	public int getCurrentPopulation( int aTier )
	{
		return creatureShop.getCurrentPopulation( aTier );
	}

	void addSpell( EconomySpell aEconomySpell ) { hero.addSpell( aEconomySpell ); }

	public List<EconomySpell> getSpells() {
		return hero.getSpells();
	}

	public int getPower() {
		return hero.getPower();
	}

	public int getWisdom(){
		return hero.getWisdom();
	}

	public Fraction getFraction()
	{
		return fraction;
	}

	public List<EconomySpell> getCurrentSpellPopulation()
	{
		return spellShop.getCurrentSpellPopulation();
	}

	public List<AbstractShop> getShops(){ return shops;}

	public boolean hasSpell( String aName )
	{
		return getSpells().stream().map( EconomySpell::getName ).collect( Collectors.toList() ).contains( aName );
	}
}
