package pl.sdk.creatures.attacking;

import pl.sdk.Point;

public class SplashRange {
    final boolean[][] splashDamageTable;

    SplashRange() {
        boolean[][] splashDamageTable = new boolean[3][3];
        splashDamageTable[1][1] = true;
        this.splashDamageTable = splashDamageTable;
    }

    public SplashRange(final boolean[][] aSplashDamageTable) {
        splashDamageTable = aSplashDamageTable;
    }

    public boolean checkSplash(Point aTargetPoint, Point aSplashPoint) {
        return false;
    }

    public boolean[][] getSplashRange() {
        return splashDamageTable;
    }
}