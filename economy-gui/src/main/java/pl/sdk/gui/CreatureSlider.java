package pl.sdk.gui;

import javafx.scene.control.Slider;

class CreatureSlider
{
	private final int heroGold;
	private final int creatureGold;
	private Slider slider;

	public CreatureSlider( int aGold, int aGoldCost )
	{
		heroGold = aGold;
		creatureGold = aGoldCost;
	}

	Slider createSlider() {
	slider = new Slider();
	slider.setMin(0);
	slider.setMax(heroGold/creatureGold);
	slider.setValue(0);
	slider.setShowTickLabels(true);
	slider.setShowTickMarks(true);
	slider.setMajorTickUnit(10);
	slider.setMinorTickCount(5);
	slider.setBlockIncrement(10);
	return slider;
}

	public int getCreatureAmount()
	{
		return (int)slider.getValue();
	}
}
