package pl.sdk;

import pl.sdk.AbstractSpell;
import pl.sdk.spells.SpellStatistic;

public class SummonSpell extends AbstractSpell {

    private final int duration;
    private final int creatureAmount;
    private final String creatureName;


    public SummonSpell(int aManaCost, int aDuration, int aCreatureAmount, String aCreatureName, SpellStatistic.SpellElement aElement, String aName) {
        super(aManaCost, SpellStatistic.TargetType.MAP, aElement, aName);
        duration = aDuration;
        creatureAmount = aCreatureAmount;
        creatureName = aCreatureName;
    }

    public int getDuration() {
        return duration;
    }

    public int getCreatureAmount() {
        return creatureAmount;
    }

    public String getSummoningCreatureAmount() {
        return creatureName;
    }

    @Override
    public int getSplashRange() {
        return 0;
    }
}
