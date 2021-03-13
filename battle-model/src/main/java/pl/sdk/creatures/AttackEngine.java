package pl.sdk.creatures;

import com.google.common.base.Preconditions;

public class AttackEngine {

    public void attack(AttackIf aAttacker, DefenceContextIf aDefender) {
        int damageToDeal = aAttacker.getDamageCalculator().calculateDamage(aAttacker, aDefender);
        aDefender.getDamageApplier().applyDamage(damageToDeal);

//            --

        if (aDefender.canCounterAttack() && aAttacker.canYouCounterAttackMe()) {
            counterAttack(aDefender, aAttacker);
        }
    }

    private void counterAttack(DefenceContextIf aCounterAttacker, AttackIf aDefender) {
        Preconditions.checkArgument(aCounterAttacker instanceof CounterAttackerIf);
        Preconditions.checkArgument(aDefender instanceof DefenceContextIf);
        CounterAttackerIf counterAttacker = ((CounterAttackerIf) aCounterAttacker);
        DefenceContextIf defender = (DefenceContextIf) aDefender;
        if (counterAttacker.canCounterAttack()) {
            attack(counterAttacker, defender);
        }
    }
}
