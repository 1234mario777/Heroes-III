package pl.sdk.creatures.defending;

import lombok.Getter;

@Getter
public class CreatureLifeStats {

    private final int hp;
    private final int amount;

    CreatureLifeStats(int aHp, int aAmount) {
        hp = aHp;
        amount = aAmount;
    }
}
