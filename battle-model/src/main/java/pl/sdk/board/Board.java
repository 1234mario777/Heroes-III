package pl.sdk.board;

import java.util.*;

import static pl.sdk.GameEngine.BOARD_HEIGHT;
import static pl.sdk.GameEngine.BOARD_WIDTH;

class Board {

    private final Map<Point, TileIf> map;

    Board() {
        map = new HashMap<>();
    }

    void throwExceptionIfTileIsTaken(Point aPoint) {
        if (isTileTaken(aPoint)){
            throw new IllegalArgumentException("Tile isn't empty");
        }
    }

    private boolean isTileTaken( Point aPoint ) {
        return map.containsKey(aPoint);
    }

    void throwExceptionWhenIsOutsideMap(Point aPoint) {
        if (aPoint.getX() < 0 || aPoint.getX() > BOARD_WIDTH || aPoint.getY() < 0 || aPoint.getY() > BOARD_HEIGHT ) {
            throw new IllegalArgumentException("You are trying to works outside the map");
        }
    }

    TileIf get( Point aPoint ) {
        return map.get(aPoint);
    }

    Point get( TileIf aTileIf ){
        return map.keySet().stream().filter(p -> map.get(p).equals(aTileIf)).findAny().get();
    }

    void add( Point aPoint, TileIf aCreature )
    {
        throwExceptionIfTileIsTaken( aPoint );
        throwExceptionWhenIsOutsideMap( aPoint );
        map.put( aPoint, aCreature );
    }

    void remove( Point aSourcePoint )
    {
        map.remove( aSourcePoint );
    }

}
