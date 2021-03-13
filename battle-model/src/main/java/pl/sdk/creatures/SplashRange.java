package pl.sdk.creatures;

import pl.sdk.Point;

public class SplashRange {
    final boolean[][] splashDamageTable;

    public SplashRange(final boolean[][] aSplashDamageTable) {
        splashDamageTable = aSplashDamageTable;
    }

    public boolean checkSplash(Point aTargetPoint, Point aSplashPoint){
        return false;
    }

    boolean[][] getSplashRange() {
        return splashDamageTable;
    }
}