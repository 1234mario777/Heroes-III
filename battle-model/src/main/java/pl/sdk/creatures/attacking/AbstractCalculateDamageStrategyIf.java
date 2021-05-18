package pl.sdk.creatures.attacking;

import java.util.Random;

abstract class AbstractCalculateDamageStrategyIf implements CalculateDamageStrategyIf {

    private final Random rand;

    AbstractCalculateDamageStrategyIf(Random aRand) {
        rand = aRand;
    }

    protected Random getRand() {
        return rand;
    }

    public int calculateDamage(AttackStatistic aAttackerStats, int aDefenderArmor) {

        int randValue = rand.nextInt(aAttackerStats.getDamage().upperEndpoint() - aAttackerStats.getDamage().lowerEndpoint() + 1) + aAttackerStats.getDamage().lowerEndpoint();

        double oneCreatureDamageToDeal;
        if (aAttackerStats.getAttack() >= aDefenderArmor){
            int attackPoints = aAttackerStats.getAttack() - aDefenderArmor;
            if (attackPoints > 60){
                attackPoints = 60;
            }
            oneCreatureDamageToDeal = randValue * (1 + (attackPoints)*0.05);
        }else{
            int defencePoints = aDefenderArmor - aAttackerStats.getAttack();
            if (defencePoints > 12){
                defencePoints = 12;
            }
            oneCreatureDamageToDeal = randValue * (1 - defencePoints *0.025);
        }

        if (oneCreatureDamageToDeal < 0){
            oneCreatureDamageToDeal = 0;
        }
        double wholeStackDamageToDeal = aAttackerStats.getAmount() * oneCreatureDamageToDeal;
        double wholeStackDamageToDealAfterChange = changeDamageAfter(wholeStackDamageToDeal, aAttackerStats);
        return (int)wholeStackDamageToDealAfterChange;
    }

    abstract double changeDamageAfter(double aWholeStackDamageToDeal, AttackStatistic aAttacker);
}
