package pl.sdk.hero;

import pl.sdk.creatures.EconomyCreature;
import pl.sdk.spells.EconomySpell;

import java.util.ArrayList;
import java.util.List;

public class EconomyHero {

    public enum Fraction {
        NECROPOLIS;

    }
    private final Fraction fraction;
    private final HeroStats stats;
    private final List<EconomyCreature> creatureList;

    private final List<EconomySpell> spellList;
    private int gold;
    public EconomyHero(Fraction aFraction, int aGold) {
        this(aFraction, aGold, new HeroStats(0,0,0,0));
    }

    public EconomyHero(Fraction aFraction, int aGold, HeroStats aStats) {
        fraction = aFraction;
        gold = aGold;
        creatureList = new ArrayList<>();
        spellList = new ArrayList<>();
        stats = aStats;
    }
    void addCreature(EconomyCreature aCreature){
        if (creatureList.size()>=7){
            throw new IllegalStateException("Hero has not empty slot for creature");
        }
        creatureList.add(aCreature);
    }

    void addSpell(EconomySpell aEconomySpell) {
        spellList.add(aEconomySpell);
    }

    public int getGold() {
        return gold;
    }

    public void addGold(int aAmount){
        gold += aAmount;
    }

    public List<EconomyCreature> getCreatures() {
        return List.copyOf(creatureList);
    }

    public List<EconomySpell> getSpells() {
        return List.copyOf(spellList);
    }

    public int getPower() {
        return stats.getPower();
    }

    public int getWisdom(){
        return stats.getWisdom();
    }

    void substractGold(int aAmount){
        if (aAmount > gold){
            throw new IllegalStateException("Hero has not enought money");
        }
        gold -= aAmount;
    }
}
