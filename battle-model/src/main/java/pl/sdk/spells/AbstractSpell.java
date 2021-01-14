package pl.sdk.spells;


public abstract class AbstractSpell {

    protected final int manaCost;
    protected final SpellStatistic.TargetType targetType;
    protected final SpellStatistic.SpellElement element;

    public AbstractSpell(int aManaCost, SpellStatistic.TargetType aTargetType, SpellStatistic.SpellElement aElement) {
        manaCost = aManaCost;
        targetType = aTargetType;
        element = aElement;
    }

    public int getManaCost() {
        return manaCost;
    }

    public SpellStatistic.TargetType getTargetType() {
        return targetType;
    }

    public abstract int getSplashRange();
}
