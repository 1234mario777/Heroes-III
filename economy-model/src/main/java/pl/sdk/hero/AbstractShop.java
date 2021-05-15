package pl.sdk.hero;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.stream.Collectors;

import static pl.sdk.EconomyEngine.NEXT_ROUND;

public abstract class AbstractShop <T extends EconomyShopIf> implements PropertyChangeListener
{
	private AbstractShopCalculator calculator;
	private List<T> shopPopulation;

	AbstractShop(AbstractShopCalculator aCalculator, List<T> aShopPopulation) {
		calculator = aCalculator;
		shopPopulation = aShopPopulation;
	}

	protected void buy(Player aActivePlayer, T aShopItem){
		subtractGold(aActivePlayer, aShopItem);
		subtractPopulation(aShopItem);
		try{
			addItem(aActivePlayer, aShopItem);
		}catch(Exception e){
			restoreGold(aActivePlayer, aShopItem);
			restorePopulation(aShopItem);
			throw new IllegalStateException(getBuyErrorMessage());
		}
	}

	protected void subtractGold(Player aActivePlayer, T aShopItem) {
		aActivePlayer.substractGold(aShopItem.getGoldCost());
	}

	protected void restoreGold(Player aActivePlayer, T aShopItem) {
		aActivePlayer.addGold(aShopItem.getGoldCost());
	}

	protected void subtractPopulation(T aShopItem) {
		if (!shopPopulation.stream().map(T::getName).collect(Collectors.toList()).contains(aShopItem.getName()))
		{
			throw new IllegalStateException(getSubtractPopulationErrorMessage());
		}
		for (int i = 0; i < shopPopulation.size() ; i++)
		{
			if ( shopPopulation.get(i).getName().equals(aShopItem.getName()))
				shopPopulation.remove(i);
		}
	}

	protected void restorePopulation(T aShopItem) {
		shopPopulation.add(aShopItem);
	}

	protected void handlePopulation() {
		shopPopulation.clear();
		createPopulation();
	}

	protected abstract void createPopulation();

	protected abstract void addItem(Player aActivePlayer, T aShopItem);

	protected abstract String getSubtractPopulationErrorMessage();

	protected abstract String getBuyErrorMessage();

	@Override
	public void propertyChange( PropertyChangeEvent aPropertyChangeEvent )
	{
		if ( aPropertyChangeEvent.getPropertyName().equals( NEXT_ROUND ) )
		{
			calculator.generateRandomFactor();
			handlePopulation();
		}
	}

	AbstractShopCalculator getCalculator() {
		return calculator;
	}

	List<T> getShopPopulation() {
		return shopPopulation;
	}
}
