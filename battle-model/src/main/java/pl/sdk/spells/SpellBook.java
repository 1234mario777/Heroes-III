package pl.sdk.spells;

import java.util.List;

public class SpellBook {
    private boolean spellWasCastedInThisTurn;

    public List<AbstractSpell> getSpells() {
        return null;
    }

    void cast(AbstractSpell aSpell){
        if (spellWasCastedInThisTurn){
            throw new IllegalStateException("You cannot cast more spells in this turn!");
        }
        spellWasCastedInThisTurn = true;
    }

    boolean canCastSpell() {
        return !spellWasCastedInThisTurn;
    }

    void endOfTurn() {
        spellWasCastedInThisTurn = false;
    }
}
