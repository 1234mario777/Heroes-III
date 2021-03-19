package pl.sdk.creatures.movingContext;

import lombok.Getter;

@Getter
public class MoveContext implements MoveContextIf{

    private int moveRange;

    public MoveContext(int aMoveRange) {
        moveRange = aMoveRange;
    }

}
