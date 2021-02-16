package pl.sdk.spells;


import pl.sdk.creatures.Creature;

public abstract class AbstractSpell {

    protected final int manaCost;
    protected final String name;
    protected final SpellStatistic.TargetType targetType;
    protected final SpellStatistic.SpellElement element;

    public AbstractSpell(int aManaCost, SpellStatistic.TargetType aTargetType, SpellStatistic.SpellElement aElement, String aName) {
        manaCost = aManaCost;
        targetType = aTargetType;
        element = aElement;
        name = aName;
    }

    public int getManaCost() {
        return manaCost;
    }

    public SpellStatistic.TargetType getTargetType() {
        return targetType;
    }

    public abstract int getSplashRange();

    public String getName(){
        return name;
    }

    public abstract void cast(Creature aCreature);
}
