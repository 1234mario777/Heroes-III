package pl.sdk.hero;

import pl.sdk.artifacts.AbstractEconomyArtifactFactory;
import pl.sdk.artifacts.EconomyArtifact;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static pl.sdk.artifacts.ArtifactFactoryType.DEFAULT;
import static pl.sdk.artifacts.ArtifactFactoryType.TEST;

public class ArtifactShop extends AbstractShop
{
	public static final String EXCEPTION_MESSAGE = "Hero cannot consume more artifacts";
	public static final String PLAYER_HAS_ALREADY_BOUGHT_THIS_ARTIFACT = "Player has already bought this artifact!";
	private final AbstractEconomyArtifactFactory artifactFactory;
	private List<EconomyArtifact> artifactPopulation;

	ArtifactShop( ) {
		super(new ArtifactShopCalculator( ));
		artifactFactory = AbstractEconomyArtifactFactory.getInstance(DEFAULT);
		artifactPopulation = new ArrayList<>();
		createPopulation();
	}

	ArtifactShop(Random aRand, AbstractEconomyArtifactFactory aFactory ) {
		super(new ArtifactShopCalculator(aRand));
		artifactFactory = aFactory;
		artifactPopulation = new ArrayList<>();
		createPopulation();
	}

	ArtifactShop(AbstractEconomyArtifactFactory aFactory) {
		super(new ArtifactShopCalculator( ));
		artifactFactory = aFactory;
		artifactPopulation = new ArrayList<>();
		createPopulation();
	}

	private void createPopulation( ) {
		List<EconomyArtifact> allArtifacts = artifactFactory.getAllArtifacts();
		int populationSize = calculatePopulation(allArtifacts.size());
		Random rand = new Random();

		for (int i = 0; i < populationSize; i++) {
			int randomIndex = rand.nextInt(allArtifacts.size());
			artifactPopulation.add(allArtifacts.get(randomIndex));
			allArtifacts.remove(randomIndex);
		}
	}

	private int calculatePopulation(int aSize) {
		return getCalculator().randomize( aSize );
	}

	List<EconomyArtifact> getCurrentArtifactPopulation() {
		return artifactPopulation;
	}

	@Override
	protected void handlePopulation() {
		artifactPopulation = new ArrayList<>();
		createPopulation();
	}

	void buy( Player aActivePlayer, EconomyArtifact aEconomyArtifact) {
		aActivePlayer.substractGold(aEconomyArtifact.getGoldCost());
		subtractPopulation(aEconomyArtifact);
		try{
			aActivePlayer.addArtifact(aEconomyArtifact);
		}catch(Exception e){
			aActivePlayer.addGold(aEconomyArtifact.getGoldCost());
			restorePopulation(aEconomyArtifact);
			throw new IllegalStateException(EXCEPTION_MESSAGE);
		}
	}

	private void restorePopulation(EconomyArtifact aEconomyArtifact) {
		artifactPopulation.add(aEconomyArtifact);
	}

	private void subtractPopulation(EconomyArtifact aEconomyArtifact) {
		if ( !artifactPopulation.stream().map( EconomyArtifact::getName ).collect( Collectors.toList() ).contains( aEconomyArtifact.getName() ))
		{
			throw new IllegalStateException(PLAYER_HAS_ALREADY_BOUGHT_THIS_ARTIFACT);
		}
		for ( int i = 0; i < artifactPopulation.size() ; i++ )
		{
			if ( artifactPopulation.get( i ).getName().equals( aEconomyArtifact.getName() ) )
				artifactPopulation.remove( i );
		}
	}

	int calculateMaxAmount( Player aPlayer, EconomyArtifact aArtifact ) {
		return getCalculator().calculateMaxAmount(aPlayer.getGold(), aArtifact.getGrowth(), aArtifact.getGoldCost());
	}

}
