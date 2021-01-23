package pl.sdk.hero;

import pl.sdk.creatures.EconomyCreature;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class EconomyHero {

    private final Fraction fraction;

    private final List<EconomyCreature> creatureList;
    private int gold;
    EconomyHero(Fraction aFraction, int aGold) {
        fraction = aFraction;
        gold = aGold;
        creatureList = new ArrayList<>();
    }

    void addCreature(EconomyCreature aCreature){
        if (creatureList.size()>=7){
            throw new IllegalStateException("Hero has not empty slot for creature");
        }
        creatureList.add(aCreature);
    }

    int getGold() {
        return gold;
    }

    void addGold(int aAmount){
        gold += aAmount;
    }

    List<EconomyCreature> getCreatures() {
        return List.copyOf(creatureList);
    }

    void substractGold(int aAmount){
        if (aAmount > gold){
            throw new IllegalStateException("Hero has not enought money");
        }
        gold -= aAmount;
    }
}
