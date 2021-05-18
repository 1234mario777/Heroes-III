package pl.sdk.hero;

import pl.sdk.Fraction;
import pl.sdk.HeroEnum;
import pl.sdk.artifacts.EconomyArtifact;
import pl.sdk.creatures.EconomyCreature;
import pl.sdk.skills.EconomySkill;
import pl.sdk.skills.SkillStatistic;
import pl.sdk.spells.EconomySpell;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Player
{
	EconomyHero hero;
	CreatureShop creatureShop;
	SpellShop spellShop;
	ArtifactShop artifactShop;
	List<AbstractShop> shops;
	private int gold;
	Fraction fraction;
	String heroName;
	SkillShop skillShop;

	public Player(Fraction aFraction, int aGold , HeroEnum aHero)
	{
		this(aFraction,aGold,new EconomyHero(new HeroStats(AbstractEconomyHeroFactory.getInstance(aFraction).create(aHero))));
		heroName = aHero.toString();
	}

	public Player(Fraction aFraction, int aGold )
	{
		this(aFraction, aGold, new EconomyHero(new HeroStats(5,5,15,3)));
		skillShop = new SkillShop();
	}

	public Player( Fraction aFraction, int aGold, EconomyHero aEconomyHero )
	{
		hero = aEconomyHero;
		creatureShop = new CreatureShop( aFraction );
		spellShop = new SpellShop();
		artifactShop = new ArtifactShop();
		shops = List.of(creatureShop, spellShop, artifactShop);
		skillShop = new SkillShop();
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

	Player( EconomyHero aHero, ArtifactShop aShop, int aGold )
	{
		hero = aHero;
		artifactShop = aShop;
		shops = List.of(artifactShop);
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

	public void buyArtifact(Player aActivePlayer, EconomyArtifact aEconomyArtifact) {
		artifactShop.buy(aActivePlayer, aEconomyArtifact);
	}

	public int calculateMaxAmount( EconomyCreature aCreature )
	{
		return creatureShop.calculateMaxAmount(this, aCreature );
	}

	public boolean canBuySpell(EconomySpell aSpell) {
		return spellShop.canBuySpell(this, aSpell);
	}

	public boolean canBuyArtifact(EconomyArtifact aArtifact) {
		return artifactShop.canBuyArtifact(this, aArtifact);
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

	public HashMap<EconomySkill, SkillStatistic.SkillLevel> getSkillsMap() {
		return hero.getSkillsMap();
	}

	public boolean hasSkill(EconomySkill aSkill){
		return hero.hasSkill(aSkill);
	}
	void addSkill(EconomySkill aSkill) { hero.addSkill(aSkill); }
	void upgradeSkill(EconomySkill aSkill) { hero.upgradeSkill(aSkill); }
	public List<EconomySkill> getSkillList(){
		return hero.getSkillList();
	}
	public void buySkill(Player aActivePlayer, EconomySkill aSkill) {
		skillShop.buy(aActivePlayer,aSkill);
	}

	public List<EconomySkill> getCurrentSkillPopulation() {
		return skillShop.getCurrentSkillPopulation();
	}

	public int calculateSkillMaxAmount(EconomySkill aSkill) {
		return skillShop.calculateMaxAmount(this, aSkill);
	}


	void addArtifact(EconomyArtifact aEconomyArtifact) {
		hero.addArtifact(aEconomyArtifact);
	}

	public List<EconomyArtifact> getCurrentArtifactPopulation() {
		return artifactShop.getCurrentArtifactPopulation();
	}

	public List<EconomyArtifact> getArtifacts() {
		return hero.getArtifacts();
	}

	public boolean hasArtifact(String aName) {
		return getArtifacts().stream().map(EconomyArtifact::getName).collect(Collectors.toList()).contains(aName);
	}

	public boolean hasEmptySlotForArtifact(String aName) {
		return hero.hasEmptySlotForArtifact(aName);
	}

}
