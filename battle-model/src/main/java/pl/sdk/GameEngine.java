package pl.sdk;

import pl.sdk.board.BoardManager;
import pl.sdk.board.Point;
import pl.sdk.board.TileIf;
import pl.sdk.creatures.attacking.AttackEngine;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.moving.MoveEngine;
import pl.sdk.spells.AbstractSpell;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class GameEngine {

    public final static int BOARD_WIDTH = 20;
    public final static int BOARD_HEIGHT = 15;

    public static final String CURRENT_CREATURE_CHANGED = "CURRENT_CREATURE_CHANGED";
    public static final String CREATURE_MOVED = "CREATURE_MOVED";
    public static final String CREATURE_ATTACKED = "CREATURE_ATTACKED";
    public static final String END_OF_TURN = "END_OF_TURN";
    public static final String AFTER_MOVE = "AFTER_MOVE";
    public static final String AFTER_ATTACK = "AFTER_ATTACK";
    private final TurnQueue queue;
    private final AttackEngine attackEngine;
    private final MoveEngine moveEngine;
    private final PropertyChangeSupport observerSupport;
    private final Hero hero1;
    private final Hero hero2;
    private final BoardManager boardManager;
    private boolean blockMoving;
    private boolean blockAttacking;
    private List<Creature> creatures1;
    private List<Creature> creatures2;

    public GameEngine(Hero aHero1, Hero aHero2 ) {
        attackEngine = new AttackEngine();
        boardManager = new BoardManager();
        moveEngine = new MoveEngine(boardManager);
        hero1 = aHero1;
        hero2 = aHero2;
        queue = new TurnQueue(aHero1, aHero2);
        hero1.toSubscribeEndOfTurn(queue);
        hero2.toSubscribeEndOfTurn(queue);
        creatures1 = aHero1.getCreatures();
        creatures2 = aHero2.getCreatures();
        observerSupport = new PropertyChangeSupport(this);
        boardManager.putCreaturesOnBoard(creatures1, creatures2);
    }

    public void addObserver(String aEventType, PropertyChangeListener aObs) {
        if (END_OF_TURN.equals(aEventType)) {
            queue.addObserver(aObs);
        } else {
            observerSupport.addPropertyChangeListener(aEventType, aObs);
        }
    }

    public void removeObserver(PropertyChangeListener aObs) {
        observerSupport.removePropertyChangeListener(aObs);
    }

    void notifyObservers(PropertyChangeEvent aEvent) {
        observerSupport.firePropertyChange(aEvent);
    }

    public void move(Point aTargetPoint) {
        if (blockMoving) {
            return;
        }
        Point oldPosition = boardManager.getPointByTile(queue.getActiveCreature() );
        List<Point> path = moveEngine.move(queue.getActiveCreature(), aTargetPoint);
        blockMoving = true;
        notifyObservers(new PropertyChangeEvent(this, CREATURE_MOVED, oldPosition, path));
        observerSupport.firePropertyChange( AFTER_MOVE, null, null );
    }

    public void pass() {
        Creature oldActiveCreature = queue.getActiveCreature();
        queue.next();
        blockAttacking = false;
        blockMoving = false;
        Creature newActiveCreature = queue.getActiveCreature();
        notifyObservers(new PropertyChangeEvent(this, CURRENT_CREATURE_CHANGED, oldActiveCreature, newActiveCreature));
    }

    public void attack(int aX, int aY) {
        if (blockAttacking) {
            return;
        }
        Creature activeCreature = queue.getActiveCreature();
        boolean[][] splashRange = activeCreature.getAttackContext().getSplashRange().getSplashRange();
        for (int x = 0; x < splashRange.length; x++) {
            for (int y = 0; y < splashRange.length; y++) {
                if (splashRange[x][y]) {
                    int pointX = aX + x - 1;
                    int pointY = aY + y - 1;
                    Creature attackedCreature = boardManager.getCreatureByPoint( new Point( pointX, pointY ) );
                    if (attackedCreature != null){
                        attackEngine.attack(activeCreature, attackedCreature );
                    }
                }
            }
        }


        blockAttacking = true;
        blockMoving = true;
        notifyObservers(new PropertyChangeEvent(this, CREATURE_ATTACKED, null, null));
        observerSupport.firePropertyChange( AFTER_ATTACK, null, null );
        observerSupport.firePropertyChange( AFTER_MOVE, null, null );
    }

    public Creature get(int aX, int aY) {
        return boardManager.getCreatureByPoint( new Point( aX, aY ) );
    }

    public Creature getActiveCreature() {
        return queue.getActiveCreature();
    }



    public boolean canMove(int aX, int aY) {
        return moveEngine.canMove(getActiveCreature(), new Point( aX, aY ));
    }

    public boolean canAttack(int aX, int aY) {
        boolean isP1Creature = creatures1.contains(getActiveCreature());
        boolean theSamePlayerUnit;
        if (isP1Creature) {
            theSamePlayerUnit = creatures1.contains( boardManager.getCreatureByPoint( new Point( aX, aY ) ) );
        } else {
            theSamePlayerUnit = creatures2.contains( boardManager.getCreatureByPoint( new Point( aX, aY ) ) );
        }

        return !theSamePlayerUnit && boardManager.getPointByTile(getActiveCreature() ).distance(new Point(aX, aY) ) <= getActiveCreature().getAttackContext().getAttackerStatistic().getAttackRange();
    }

    public boolean isHeroTwoCreature( Creature aCreature )
    {
        return creatures2.contains( aCreature );
    }

    public boolean isHeroOneCreature( Creature aCreature )
    {
        return creatures1.contains( aCreature );
    }

    public boolean canCastSpell() {
        return queue.getActiveHero().canCastSpell();
    }

    public boolean canCastSpell(AbstractSpell aSpell, Point aPoint){
        SpellCastingRulesManager calc = new SpellCastingRulesManager();
        return calc.canCast(aSpell, aPoint, this, boardManager.getCreatureByPoint(aPoint ) );
    }


    public void castSpell(AbstractSpell aSpell) {
        queue.getActiveHero().castSpell(aSpell);
        switch (aSpell.getTargetType()){
            case ALL_ALLIES:
                getActiveHero().getCreatures()
                        .stream()
                        .map(c -> boardManager.getPointByTile(c ) )
                        .forEach(p -> innerCastSpell(aSpell,p));
            break;
            case ALL_ENEMIES:
                throw new UnsupportedOperationException("not implement yet!" + aSpell.getTargetType());
            case ALL_CREATURES:
                List<Creature> allCreatures = new ArrayList<>();
                allCreatures.addAll(creatures1);
                allCreatures.addAll(creatures2);

                allCreatures.stream()
                        .map(c -> boardManager.getPointByTile(c ) )
                        .forEach(p -> innerCastSpell(aSpell,p));
            break;
            case ALL:
                throw new UnsupportedOperationException("not implement yet!" + aSpell.getTargetType());
            default:
                throw new IllegalArgumentException("You should use method with concrete point while spell target type is " + aSpell.getTargetType());
        }
    }

    public void castSpell(AbstractSpell aSpell, Point aPoint) {
        queue.getActiveHero().castSpell(aSpell);
        innerCastSpell(aSpell, aPoint);
    }

    private void innerCastSpell(AbstractSpell aSpell, Point aPoint){
        int range = aSpell.getSplashRange();
        for (int i = -range ; i < range+1; i++) {
            for (int j = -range; j < range+1; j++) {
                int x = aPoint.getX() + i;
                int y = aPoint.getY() + j;
                if (x < 0 || x > BOARD_WIDTH || y < 0 || y > BOARD_HEIGHT){
                    continue;
                }

                if ( boardManager.getCreatureByPoint( new Point( x, y ) ) != null )
                {
                    aSpell.cast( boardManager.getCreatureByPoint( new Point( x, y ) ) );
                    aSpell.getSplashRange();
                }
            }
        }
    }

    boolean isAllyCreature(Point aP) {
        return queue.getActiveHero().getCreatures().contains(boardManager.getCreatureByPoint(aP ) );
    }

    boolean isEnemyCreature(Point aP) {
        return boardManager.getCreatureByPoint(aP ) != null && !queue.getActiveHero().getCreatures().contains(boardManager.getCreatureByPoint(aP ) );
    }

    public Hero getActiveHero() {
        return queue.getActiveHero();
    }

    BoardManager getBoardManager()
    {
        return boardManager;
    }
}
