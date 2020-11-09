package pl.sdk;

class CreatureStatistic {

    private final String name;
    private final int attack;
    private final int armor;
    private final int maxHp;
    private final int moveRange;
    private final int damage;

    CreatureStatistic(String aName, int aAttack, int aArmor, int aMaxHp, int aMoveRange, int aDamage) {
        name = aName;
        attack = aAttack;
        armor = aArmor;
        maxHp = aMaxHp;
        moveRange = aMoveRange;
        damage = aDamage;
    }

    String getName() {
        return name;
    }

    int getAttack() {
        return attack;
    }

    int getArmor() {
        return armor;
    }

    int getMaxHp() {
        return maxHp;
    }

    int getMoveRange() {
        return moveRange;
    }
}
