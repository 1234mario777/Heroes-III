package pl.sdk.spells;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class SpellBook implements PropertyChangeListener {
    private boolean spellWasCastedInThisTurn;
    private int mana;

    public SpellBook(int aMana) {
        mana = aMana;
    }

    public List<AbstractSpell> getSpells() {
        return null;
    }

    public void cast(AbstractSpell aSpell){
        if (spellWasCastedInThisTurn){
            throw new IllegalStateException("You cannot cast more spells in this turn!");
        }
        spellWasCastedInThisTurn = true;
    }

    public boolean canCastSpell() {
        return !spellWasCastedInThisTurn;
    }

    public boolean canCastSpell(AbstractSpell aSpell) {
        return false;
    }

    void endOfTurn() {
        spellWasCastedInThisTurn = false;
    }

    @Override
    public void propertyChange(PropertyChangeEvent aPropertyChangeEvent) {
        endOfTurn();
    }
}
