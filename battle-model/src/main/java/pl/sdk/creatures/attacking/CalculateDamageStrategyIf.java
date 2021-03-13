package pl.sdk.creatures.attacking;

import pl.sdk.creatures.defending.DefenceContextIf;

interface CalculateDamageStrategyIf {

    int calculateDamage(AttackContextIf attacker, DefenceContextIf aDefender);
}
