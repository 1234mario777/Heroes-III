package pl.sdk.creatures;

import java.util.Random;

abstract class AbstractCalculateDamageStrategyIf implements CalculateDamageStrategyIf {

    private final Random rand;

    AbstractCalculateDamageStrategyIf(Random aRand) {
        rand = aRand;
    }

    protected Random getRand() {
        return rand;
    }

    public int calculateDamage(AttackerIf aAttacker, AttackableIf aDefender) {

        int randValue = rand.nextInt(aAttacker.getAttackerStatistic().getDamage().upperEndpoint() - aAttacker.getAttackerStatistic().getDamage().lowerEndpoint() + 1) + aAttacker.getAttackerStatistic().getDamage().lowerEndpoint();

        double oneCreatureDamageToDeal;
        if (aAttacker.getAttackerStatistic().getAttack() >= aDefender.getArmor()){
            int attackPoints = aAttacker.getAttackerStatistic().getAttack() - aDefender.getArmor();
            if (attackPoints > 60){
                attackPoints = 60;
            }
            oneCreatureDamageToDeal = randValue * (1 + (attackPoints)*0.05);
        }else{
            int defencePoints = aDefender.getArmor() - aAttacker.getAttackerStatistic().getAttack();
            if (defencePoints > 12){
                defencePoints = 12;
            }
            oneCreatureDamageToDeal = randValue * (1 - defencePoints *0.025);
        }

        if (oneCreatureDamageToDeal < 0){
            oneCreatureDamageToDeal = 0;
        }
        double wholeStackDamageToDeal = aAttacker.getAttackerStatistic().getAmount() * oneCreatureDamageToDeal;
        double wholeStackDamageToDealAfterChange = changeDamageAfter(wholeStackDamageToDeal, aAttacker);
        return (int)wholeStackDamageToDealAfterChange;
    }

    abstract double changeDamageAfter(double aWholeStackDamageToDeal, AttackerIf aAttacker);
}
