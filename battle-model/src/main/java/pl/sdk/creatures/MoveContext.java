package pl.sdk.creatures;

import lombok.Getter;

@Getter
public class MoveContext implements MoveContextIf{

    private int moveRange;

    MoveContext(int aMoveRange) {
        moveRange = aMoveRange;
    }

}
