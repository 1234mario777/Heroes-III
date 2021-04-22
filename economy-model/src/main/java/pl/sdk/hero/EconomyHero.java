package pl.sdk.hero;

import pl.sdk.artifacts.EconomyArtifact;
import pl.sdk.creatures.EconomyCreature;
import pl.sdk.skills.EconomySkill;
import pl.sdk.skills.SkillStatistic;
import pl.sdk.spells.EconomySpell;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class EconomyHero {

    private final List<EconomyCreature> creatureList;
    private final HeroStats stats;
    private final List<EconomySpell> spellList;
    private final HashMap<EconomySkill, SkillStatistic.SkillLevel> skillMap;
    private final ArtifactList artifactList;

    public EconomyHero() {
        this(new HeroStats(0,0,0,0));
    }

    public EconomyHero(HeroStats aStats) {
        creatureList = new ArrayList<>();
        spellList = new ArrayList<>();
        artifactList = new ArtifactList();
        skillMap = new HashMap<>();
        stats = aStats;
    }
    void addCreature(EconomyCreature aCreature){
        if (creatureList.size()>=7){
            throw new IllegalStateException("Hero has not empty slot for creature");
        }
        creatureList.add(aCreature);
    }

    List<EconomyCreature> getCreatures() {
        return List.copyOf(creatureList);
    }

    void addSpell(EconomySpell aEconomySpell) {
        spellList.add(aEconomySpell);
    }

    void addSkill(EconomySkill aSkill) { skillMap.put(aSkill,aSkill.getSkillLevel()); }

    HashMap<EconomySkill, SkillStatistic.SkillLevel> getSkillsMap() {
        return skillMap;
    }

    boolean hasSkill(EconomySkill aSkill) {
        for ( EconomySkill key : skillMap.keySet() ) {
           return aSkill.equals(key);
        }
        return false;
    }
    List<EconomySpell> getSpells() {
        return List.copyOf(spellList);
    }

    void addArtifact(EconomyArtifact aEconomyArtifact) {
        artifactList.add(aEconomyArtifact);
    }

    List<EconomyArtifact> getArtifacts() {
        return artifactList.getArtifacts();
    }

    boolean hasEmptySlotForArtifact(String aName) {
        return artifactList.hasEmptySlot(aName);
    }

    int getPower() {
        return stats.getPower();
    }
    int getAttack(){
        return stats.getAttack();
    }
    int getDefence(){
        return stats.getDefence();
    }

    int getWisdom(){
        return stats.getWisdom();
    }

    HashMap<EconomySkill, SkillStatistic.SkillLevel> getSkillMap(){ return skillMap; }
    void upgradeSkill(EconomySkill aSkill) {
        skillMap.put(aSkill, skillMap.get(aSkill).equals(SkillStatistic.SkillLevel.BASIC) ? SkillStatistic.SkillLevel.ADVANCED : SkillStatistic.SkillLevel.EXPERT);
    }

    List<EconomySkill> getSkillList() {
        return new ArrayList<>(skillMap.keySet());
    }
}
