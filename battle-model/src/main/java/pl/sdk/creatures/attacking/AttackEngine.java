package pl.sdk.creatures.attacking;

import com.google.common.base.Preconditions;
import pl.sdk.creatures.defending.DefenceContextIf;

public class AttackEngine {

    public void attack(AttackContextIf aAttacker, DefenceContextIf aDefender) {
        int damageToDeal = aAttacker.getDamageCalculator().calculateDamage(aAttacker, aDefender);
        aDefender.getDamageApplier().applyDamage(damageToDeal);

        if (aDefender.canCounterAttack() && aAttacker.canYouCounterAttackMe()) {
            counterAttack(aDefender, aAttacker);
        }
    }

    private void counterAttack(DefenceContextIf aCounterAttacker, AttackContextIf aDefender) {
        Preconditions.checkArgument(aCounterAttacker instanceof AttackContextIf);
        Preconditions.checkArgument(aDefender instanceof DefenceContextIf);

        DefenceContextIf defender = (DefenceContextIf) aDefender;
        if (aCounterAttacker.canCounterAttack()) {
            attack(((AttackContextIf) aCounterAttacker), defender);
        }
    }
}
