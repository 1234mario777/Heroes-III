package pl.sdk.creatures.attacking;

import pl.sdk.creatures.Creature;
import pl.sdk.creatures.defending.DefenceContextIf;

public class AttackEngine {

    public void attack(Creature aAttacker, Creature aDefender){
        attack(aAttacker.getAttackContext(), aDefender.getDefenceContext());
        if (aDefender.canRetaliate() && aAttacker.getAttackContext().canYouCounterAttackMe()) {
            aDefender.updateRetaliateCounter();
            attack(aDefender.getAttackContext(), aAttacker.getDefenceContext());
        }
    }

    void attack(AttackContextIf aAttacker, DefenceContextIf aDefender) {
        int damageToDeal = aAttacker.getDamageCalculator().calculateDamage(aAttacker.getAttackerStatistic(), aDefender.getDefenceStatistic().getArmor());
        aDefender.applyDamage(damageToDeal);
    }
}
