package pl.sdk.creatures.movingContext;

import lombok.Getter;

@Getter
public class MoveContext implements MoveContextIf{


    private final MoveStatistic moveStatistic;

    public MoveContext(int aMoveRange ) {
        moveStatistic = new MoveStatistic( aMoveRange );
    }
}
