package pl.sdk.creatures;

import pl.sdk.creatures.Creature;

public class DefaultDamageApplier {

    //TODO change to command pattern
    final Creature creature;

    public DefaultDamageApplier() {
        creature = null;
    }

    public void applyDamage(int aDamageToApply) {
        int amount = creature.getAmount();
        int currentHp = creature.getCurrentHp();
        int maxHp = creature.getMaxHp();
        int fullCurrentHp = (maxHp * (amount - 1)) + currentHp - aDamageToApply;
        if (fullCurrentHp <= 0) {
            amount = 0;
            currentHp = 0;
        }
        else
        {
            if(fullCurrentHp % maxHp==0)
            {
                currentHp=maxHp;
                amount=fullCurrentHp/maxHp;
            }
            else
            {
                currentHp = fullCurrentHp % maxHp;
                if (aDamageToApply >= 0){
                    amount = (fullCurrentHp/maxHp) + 1;
                }else{
                    amount = (fullCurrentHp/maxHp);
                }
            }
        }

        creature.setCurrentHp(currentHp);
        creature.setAmount(amount);
    }
}
