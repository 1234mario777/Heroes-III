package pl.sdk.spells;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class SpellBook implements PropertyChangeListener {
    private boolean spellWasCastedInThisTurn;
    private int currentMana;
    private int maxMana;
    private List<AbstractSpell> spells;

    public SpellBook(int aMana, List<AbstractSpell> aSpells) {
        maxMana = aMana;
        currentMana = maxMana;
        spells = aSpells;
    }

    public List<AbstractSpell> getSpells() {
        return spells;
    }

    public void cast(AbstractSpell aSpell){
        if (!canCastSpell(aSpell)){
            throw new IllegalStateException("You cannot cast more spells in this turn!");
        }
        spellWasCastedInThisTurn = true;
        currentMana = currentMana - aSpell.getManaCost();
    }

    public boolean canCastSpell() {
        return !spellWasCastedInThisTurn;
    }

    public boolean canCastSpell(AbstractSpell aSpell) {
        return currentMana >= aSpell.getManaCost() && canCastSpell();
    }

    void endOfTurn() {
        spellWasCastedInThisTurn = false;
    }

    @Override
    public void propertyChange(PropertyChangeEvent aPropertyChangeEvent) {
        endOfTurn();
    }

    public int getCurrentMana() {
        return currentMana;
    }

    public int getMaxMana()
    {
        return maxMana;
    }
}
