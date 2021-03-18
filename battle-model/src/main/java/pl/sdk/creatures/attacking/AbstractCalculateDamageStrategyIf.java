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

    public int calculateDamage(AttackerStatisticIf aAttackerStats, int aDefenderArmor) {

        int randValue = rand.nextInt(aAttackerStats.getAttackerStatistic().getDamage().upperEndpoint() - aAttackerStats.getAttackerStatistic().getDamage().lowerEndpoint() + 1) + aAttackerStats.getAttackerStatistic().getDamage().lowerEndpoint();

        double oneCreatureDamageToDeal;
        if (aAttackerStats.getAttackerStatistic().getAttack() >= aDefenderArmor.getArmor()){
            int attackPoints = aAttackerStats.getAttackerStatistic().getAttack() - aDefenderArmor.getArmor();
            if (attackPoints > 60){
                attackPoints = 60;
            }
            oneCreatureDamageToDeal = randValue * (1 + (attackPoints)*0.05);
        }else{
            int defencePoints = aDefenderArmor.getArmor() - aAttackerStats.getAttackerStatistic().getAttack();
            if (defencePoints > 12){
                defencePoints = 12;
            }
            oneCreatureDamageToDeal = randValue * (1 - defencePoints *0.025);
        }

        if (oneCreatureDamageToDeal < 0){
            oneCreatureDamageToDeal = 0;
        }
        double wholeStackDamageToDeal = aAttackerStats.getAttackerStatistic().getAmount() * oneCreatureDamageToDeal;
        double wholeStackDamageToDealAfterChange = changeDamageAfter(wholeStackDamageToDeal, aAttackerStats);
        return (int)wholeStackDamageToDealAfterChange;
    }

    abstract double changeDamageAfter(double aWholeStackDamageToDeal, AttackContextIf aAttacker);
}
