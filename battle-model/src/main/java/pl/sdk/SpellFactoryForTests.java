package pl.sdk;

import pl.sdk.spells.AbstractSpell;
import pl.sdk.spells.DamageSpell;
import pl.sdk.spells.SpellStatistic;

public class SpellFactoryForTests {

    public static AbstractSpell createMagicArrow(){
        return new DamageSpell(5, SpellStatistic.TargetType.ENEMY, SpellStatistic.SpellElement.AIR, 10 * 10, 0, "Tests Spell Magic Arrow");
    }

    public static AbstractSpell createMagicArrowWithSplash(int aSplash){
        return new DamageSpell(5, SpellStatistic.TargetType.ENEMY, SpellStatistic.SpellElement.AIR, 10 * 10, aSplash, "Splash: " + aSplash );
    }

    public static AbstractSpell createMagicArrowWithSplashAndTargetType(int aSplash, SpellStatistic.TargetType aTargetType){
        return new DamageSpell(5, aTargetType, SpellStatistic.SpellElement.AIR, 10 * 10, aSplash, "Splash: " + aSplash + " targetType: " + aTargetType);
    }
}
