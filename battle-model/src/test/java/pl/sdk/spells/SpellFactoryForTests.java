package pl.sdk.spells;

public class SpellFactoryForTests {

    public static AbstractSpell createMagicArrow(){
        return new DamageSpell(5, SpellStatistic.TargetType.ENEMY, SpellStatistic.SpellElement.AIR, 10 * 10, 0);
    }
}
