package pl.sdk.hero;

import pl.sdk.Fraction;
import pl.sdk.Shop;
import pl.sdk.spells.EconomySpell;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import static pl.sdk.EconomyEngine.NEXT_ROUND;

public abstract class AbstractShop <T> implements PropertyChangeListener
{
	private AbstractShopCalculator calculator;
	private List<T> shopPopulation;

	AbstractShop(AbstractShopCalculator aCalculator) {
		calculator = aCalculator;
	}

	@Override
	public void propertyChange( PropertyChangeEvent aPropertyChangeEvent )
	{
		if ( aPropertyChangeEvent.getPropertyName().equals( NEXT_ROUND ) )
		{
			calculator.generateRandomFactor();
			handlePopulation();
		}
	}

	protected void buy(){

	}

	AbstractShopCalculator getCalculator() {
		return calculator;
	}

	protected abstract void handlePopulation();
}
