package pl.sdk;

import pl.sdk.board.Point;
import pl.sdk.creatures.Creature;
import pl.sdk.spells.AbstractSpell;
import pl.sdk.spells.SpellStatistic;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class SpellCastingRulesManager {
    Set<Point> calc(AbstractSpell aSpell, Point aTargetPoint, GameEngine aGameEngine ) {
        Set<Point> ret = new HashSet<>();
        if (isTileTargetSpell(aTargetPoint)){
            int splash = aSpell.getSplashRange();
            for (int x = aTargetPoint.getX()-splash; x <= aTargetPoint.getX()+splash; x++) {
                for (int y = aTargetPoint.getY()-splash; y <= aTargetPoint.getY()+splash; y++) {
                    ret.add(new Point(x,y) );
                }
            }

            ret = ret.stream().filter(p -> aGameEngine.getBoardManager().getCreatureByPoint(p ) != null ).collect(Collectors.toSet() );

            if (shouldCastOnlyForAllyCreatures(aSpell)){
                ret = ret.stream().filter(aGameEngine::isAllyCreature).collect(Collectors.toSet());
            }

            if (shouldCastOnlyForEnemyCreatures(aSpell)){
                ret = ret.stream().filter(aGameEngine::isEnemyCreature).collect(Collectors.toSet());
            }
        }

        return ret;
    }

    boolean canCast(AbstractSpell aSpell, Point aPoint, GameEngine aGameEngine, Creature aCreature ) {
        if (shouldCastOnlyForEnemyCreatures(aSpell)){
            return aGameEngine.isEnemyCreature(aPoint);
        }
        if (shouldCastOnlyForAllyCreatures(aSpell)){
            return aGameEngine.isAllyCreature(aPoint);
        }
        if (shouldCastForAnyCreature(aSpell)){
            return aCreature != null;
        }
        return false;
    }

    private boolean shouldCastForAnyCreature(AbstractSpell aSpell) {
        return aSpell.getTargetType() == SpellStatistic.TargetType.CREATURE || aSpell.getTargetType() == SpellStatistic.TargetType.ALL_CREATURES;
    }

    private boolean shouldCastOnlyForEnemyCreatures(AbstractSpell aSpell) {
        return aSpell.getTargetType() == SpellStatistic.TargetType.ENEMY || aSpell.getTargetType() == SpellStatistic.TargetType.ALL_ENEMIES;
    }

    private boolean shouldCastOnlyForAllyCreatures(AbstractSpell aSpell) {
        return aSpell.getTargetType() == SpellStatistic.TargetType.ALLY || aSpell.getTargetType() == SpellStatistic.TargetType.ALL_ALLIES;
    }

    private boolean isTileTargetSpell(Point aTargetPoint) {
        return aTargetPoint != null;
    }


}
