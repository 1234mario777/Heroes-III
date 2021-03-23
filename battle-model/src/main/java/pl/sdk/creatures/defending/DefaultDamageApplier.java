package pl.sdk.creatures.defending;

public class DefaultDamageApplier {


    CreatureLifeStats countDamageToApply(DefenceContextIf aDefender, int aDamageToApply) {
        int amount = aDefender.getCurrentAmount();
        int currentHp = aDefender.getCurrentHp();
        int maxHp = aDefender.getMaxHp();
        int fullCurrentHp = (maxHp * (amount - 1)) + currentHp - aDamageToApply;
        if (fullCurrentHp <= 0) {
            amount = 0;
            currentHp = 0;
        } else {
            if (fullCurrentHp % maxHp == 0) {
                currentHp = maxHp;
                amount = fullCurrentHp / maxHp;
            } else {
                currentHp = fullCurrentHp % maxHp;
                if (aDamageToApply >= 0) {
                    amount = (fullCurrentHp / maxHp) + 1;
                } else {
                    amount = (fullCurrentHp / maxHp);
                }
            }
        }

        return new CreatureLifeStats(currentHp, amount);
    }
}
