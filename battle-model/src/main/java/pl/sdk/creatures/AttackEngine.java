package pl.sdk.creatures;

import com.google.common.base.Preconditions;

public class AttackEngine {

    public void attack(AttackerIf aAttacker, AttackableIf aDefender) {
        if (aAttacker.isAlive()) {
            int damageToDeal = aAttacker.getDamageCalculator().calculateDamage(aAttacker, aDefender);
            aDefender.getDamageApplier().applyDamage(damageToDeal);
            if (aDefender.canCounterAttack()){
                counterAttack(aDefender, aAttacker);
            }
        }
    }

    private void counterAttack(AttackableIf aCounterAttacker, AttackerIf aDefender) {
        Preconditions.checkArgument(aCounterAttacker instanceof CounterAttackerIf);
        Preconditions.checkArgument(aDefender instanceof AttackableIf);
        CounterAttackerIf counterAttacker = ((CounterAttackerIf) aCounterAttacker);
        AttackableIf defender = (AttackableIf)aDefender;
        if (counterAttacker.canCounterAttack()){
            attack(counterAttacker, defender);
        }
    }
}
