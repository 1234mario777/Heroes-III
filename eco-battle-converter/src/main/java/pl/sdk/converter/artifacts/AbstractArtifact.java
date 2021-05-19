package pl.sdk.converter.artifacts;

import pl.sdk.Hero;

public  abstract class AbstractArtifact {

    protected String name;

    public AbstractArtifact(String aName) {
        name = aName;
    }

    public String getName() {
        return name;
    }

    public abstract void apply(Hero aHero);
}
