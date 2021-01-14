package pl.sdk.spells;


public abstract class AbstractSpell {

    protected final int manaCost;
    protected final SpellStatistic.TargetType targetType;

    public AbstractSpell(int aManaCost, SpellStatistic.TargetType aTargetType) {
        manaCost = aManaCost;
        targetType = aTargetType;
    }

    public int getManaCost() {
        return manaCost;
    }

    public SpellStatistic.TargetType getTargetType() {
        return targetType;
    }

    public abstract int getSplashRange();
}
