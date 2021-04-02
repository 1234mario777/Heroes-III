package pl.sdk.artifacts;

import java.util.List;

public abstract class AbstractEconomyArtifactFactory {

    private static final String INVALID_FACTORY_NAME = "Invalid artifact type name";

    public static AbstractEconomyArtifactFactory getInstance(ArtifactFactoryType aFactory ) {
        switch (aFactory) {
            case DEFAULT:
                return new EconomyArtifactFactory();
            case TEST:
                return new EconomyTestArtifactFactory();
            default:
                throw new IllegalArgumentException( INVALID_FACTORY_NAME );
        }
    }

    public abstract EconomyArtifact create( String aName );

    public abstract List<EconomyArtifact> getAllArtifacts();
}
