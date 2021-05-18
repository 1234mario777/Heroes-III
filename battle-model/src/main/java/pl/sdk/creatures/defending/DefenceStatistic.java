package pl.sdk.creatures.defending;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter( AccessLevel.PACKAGE)
public class DefenceStatistic
{
	private int armor;
	private int currentHp;
	private int maxHp;
	private int amount;
	private int maxAmount;

	public DefenceStatistic( int aArmor, int aMaxAmount, int aMaxHp )
	{
		armor = aArmor;
		maxHp = aMaxHp;
		currentHp = maxHp;
		maxAmount = aMaxAmount;
		amount = maxAmount;
	}

	public void setArmor( int aArmor )
	{
		armor = aArmor;
	}

	public void setMaxHp( int aMaxHp )
	{
		maxHp = aMaxHp;
		currentHp = aMaxHp;
	}

	public void setMaxAmount( int aMaxAmount )
	{
		maxAmount = aMaxAmount;
		amount = aMaxAmount;
	}
}
