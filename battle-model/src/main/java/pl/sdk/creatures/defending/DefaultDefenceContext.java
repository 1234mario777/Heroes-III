package pl.sdk.creatures.defending;

public class DefaultDefenceContext implements DefenceContextIf {

    private DefaultDamageApplier damageApplier;
    private int armor;
    private int currentHp;
    private int maxHp;
    private int maxAmount;
    private int amount;

    DefaultDefenceContext(DefaultDamageApplier aDamageApplier, int aArmor, int aMaxAmount, int aMaxHp) {
        damageApplier = aDamageApplier;
        armor = aArmor;
        maxHp = aMaxHp;
        currentHp = maxHp;
        maxAmount = aMaxAmount;
        amount = maxAmount;
    }

    @Override
    public boolean canCounterAttack() {
        return true;
    }

    @Override
    public int getArmor() {
        return armor;
    }

    @Override
    public int getCurrentHp() {
        return currentHp;
    }

    @Override
    public int getMaxHp() {
        return maxHp;
    }

    @Override
    public int getCurrentAmount() {
        return amount;
    }

    @Override
    public void applyDamage(int aDamageToDeal) {
        CreatureLifeStats creatureLifeStats = damageApplier.countDamageToApply(this, aDamageToDeal);
        amount = creatureLifeStats.getAmount();
        currentHp = creatureLifeStats.getHp();
    }
}
