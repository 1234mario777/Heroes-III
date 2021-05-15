package pl.sdk.hero;

import pl.sdk.artifacts.EconomyArtifact;
import pl.sdk.artifacts.EconomyArtifactFactory;

import java.util.*;

public class ArtifactShop extends AbstractShop<EconomyArtifact>
{
	public static final String PLAYER_HAS_ALREADY_BOUGHT_THIS_ARTIFACT = "Player has already bought this artifact!";
	public static final String HERO_CANNOT_CONSUME_MORE_ARTIFACTS = "Hero cannot consume more artifacts";
	private final EconomyArtifactFactory artifactFactory;
	private final Random rand;

	ArtifactShop( ) {
		super(new DefaultShopCalculator(), new ArrayList<>());
		artifactFactory = new EconomyArtifactFactory();
		rand = new Random();
		createPopulation();
	}

	ArtifactShop(Random aRand, EconomyArtifactFactory aFactory ) {
		super(new DefaultShopCalculator(aRand), new ArrayList<>());
		artifactFactory = aFactory;
		rand = aRand;
		createPopulation();
	}

	@Override
	protected void createPopulation() {
		List<EconomyArtifact> allArtifacts = artifactFactory.getAllArtifacts();
		int artifactAmount = getArtifactAmount(allArtifacts);
		Collections.shuffle(allArtifacts);
		allArtifacts.subList(0, artifactAmount).forEach(a -> getShopPopulation().add(a));
	}

	@Override
	protected void addItem(Player aActivePlayer, EconomyArtifact aShopItem) {
		aActivePlayer.addArtifact(aShopItem);
	}

	@Override
	protected String getSubtractPopulationErrorMessage() {
		return PLAYER_HAS_ALREADY_BOUGHT_THIS_ARTIFACT;
	}

	@Override
	protected String getBuyErrorMessage() {
		return HERO_CANNOT_CONSUME_MORE_ARTIFACTS;
	}

	boolean canBuyArtifact(Player aPlayer, EconomyArtifact aArtifact) {
		return getCalculator().calculateMaxAmount(aPlayer.getGold(), aArtifact.getGrowth(), aArtifact.getGoldCost()) == 1;
	}

	private int getArtifactAmount(List<EconomyArtifact> allArtifacts) {
		int amount = allArtifacts.size()/2;
		return 1 + amount + rand.nextInt(amount/2);
	}

	List<EconomyArtifact> getCurrentArtifactPopulation() {
		return List.copyOf(getShopPopulation());
	}
}
