package pl.sdk;

import pl.sdk.spells.AbstractSpell;
import pl.sdk.spells.SpellStatistic;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class SpellSplashCalculator {
    Set<Point> calc(AbstractSpell aSpell, Board aBoard, Point aTargetPoint) {
        Set<Point> ret = new HashSet<>();
        if (isTileTargetSpell(aTargetPoint)){
            int splash = aSpell.getSplashRange();
            for (int x = aTargetPoint.getX()-splash; x <= aTargetPoint.getX()+splash; x++) {
                for (int y = aTargetPoint.getY()-splash; y <= aTargetPoint.getY()+splash; y++) {
                    ret.add(new Point (x,y));
                }
            }

            ret = ret.stream().filter(p -> aBoard.get(p) != null).collect(Collectors.toSet());
            Z
            if (aSpell.getTargetType() == SpellStatistic.TargetType.ENEMY || aSpell.getTargetType() == SpellStatistic.TargetType.ALL_ENEMIES{
                ret = ret.stream().filter(p -> aBoard);
            }
        }

        return ret;
    }

    private boolean isTileTargetSpell(Point aTargetPoint) {
        return aTargetPoint != null;
    }
}
