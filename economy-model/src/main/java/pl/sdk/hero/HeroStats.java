package pl.sdk.hero;

public class HeroStats {

    private int attack;
    private int defence;
    private int wisdom;
    private int power;

    public HeroStats(int aAttack, int aDefence, int aWisdom, int aPower) {
        attack = aAttack;
        defence = aDefence;
        wisdom = aWisdom;
        power = aPower;
    }

    public HeroStats(HeroStats aHeroStats) {
        attack = aHeroStats.getAttack();
        defence = aHeroStats.getDefence();
        wisdom = aHeroStats.getWisdom();
        power = aHeroStats.getPower();
    }

    int getAttack() {
        return attack;
    }

    int getDefence() {
        return defence;
    }

    int getWisdom() {
        return wisdom;
    }

    int getPower() {
        return power;
    }
}
