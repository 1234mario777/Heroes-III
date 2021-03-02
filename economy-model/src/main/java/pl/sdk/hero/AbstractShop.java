package pl.sdk.hero;

import pl.sdk.Fraction;
import pl.sdk.Shop;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static pl.sdk.EconomyEngine.NEXT_ROUND;

public abstract class AbstractShop implements PropertyChangeListener
{
	AbstractShopCalculator calculator;

	@Override
	public void propertyChange( PropertyChangeEvent aPropertyChangeEvent )
	{
		if ( aPropertyChangeEvent.getPropertyName().equals( NEXT_ROUND ) )
		{
			calculator.generateRandomFactor();
			handlePopulation();
		}
	}

	protected abstract void handlePopulation();

}
