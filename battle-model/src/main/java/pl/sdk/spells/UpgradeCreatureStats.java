package pl.sdk.spells;

import com.google.common.collect.Range;
import lombok.Builder;
import lombok.Getter;

@Builder
//@AllArgsConstructor
@Getter
public class UpgradeCreatureStats
{

    private int moveRange;
    private int attack;
    private int armor;
    private int maxHp;
    private int maxAmount;
    private Range<Integer> damage;

    private double moveRangePercentage;
    private double attackPercentage;
    private double armorPercentage;
    private double maxHpPercentage;
    private double damagePercentage;
    private double maxAmountPercentage;

    UpgradeCreatureStats( int aMoveRange, int aAttack, int aArmor, int aMaxHp, int aMaxAmount, Range<Integer> aDamage, double aMoveRangePercentage, double aAttackPercentage, double aArmorPercentage, double aMaxHpPercentage, double aDamagePercentage, double aMaxAmountPercentage )
    {
        moveRange = aMoveRange;
        attack = aAttack;
        armor = aArmor;
        maxHp = aMaxHp;
        maxAmount = aMaxAmount;
        if (damage == null){
            damage = Range.closed( 0,0 );
        }
        else
        {
            damage = aDamage;
        }
        moveRangePercentage = aMoveRangePercentage;
        attackPercentage = aAttackPercentage;
        armorPercentage = aArmorPercentage;
        maxHpPercentage = aMaxHpPercentage;
        damagePercentage = aDamagePercentage;
        maxAmountPercentage = aMaxAmountPercentage;
    }

    public UpgradeCreatureStats reverse()
    {
        return UpgradeCreatureStats.builder()
                                   .moveRange(-moveRange)
                                   .attack(-attack)
                                   .armor(-armor)
                                   .maxHp(-maxHp)
                                   .damage(Range.closed( -damage.lowerEndpoint(), -damage.upperEndpoint() ))
                                   .moveRangePercentage(-moveRangePercentage)
                                   .attackPercentage(-attackPercentage)
                                   .armorPercentage(-armorPercentage)
                                   .maxHpPercentage(-maxHpPercentage)
                                   .damagePercentage(-damagePercentage)
                                   .build();
    }
}
