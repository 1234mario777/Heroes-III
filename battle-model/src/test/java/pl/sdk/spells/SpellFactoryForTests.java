package pl.sdk.spells;

public class SpellFactoryForTests {

    public static AbstractSpell createMagicArrow(){
        return new DamageSpell(5, SpellStatistic.TargetType.ENEMY, SpellStatistic.SpellElement.AIR, 10 * 10, 0);
    }

    public static AbstractSpell createMagicArrowWithSplash(int aSplash){
        return new DamageSpell(5, SpellStatistic.TargetType.ENEMY, SpellStatistic.SpellElement.AIR, 10 * 10, aSplash);
    }

    public static AbstractSpell createMagicArrowWithSplashAndTargetType(int aSplash, SpellStatistic.TargetType aTargetType){
        return new DamageSpell(5, aTargetType, SpellStatistic.SpellElement.AIR, 10 * 10, aSplash);
    }
}
