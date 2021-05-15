package pl.sdk.hero;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.artifacts.*;

import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static pl.sdk.artifacts.ArtifactStatistic.*;

class ArtifactListTest {

    private ArtifactList artifactList;
    private EconomyArtifactFactory factory = new EconomyArtifactFactory();
    private EconomyArtifact artifact;

    @BeforeEach
    void init() {
        artifactList = new ArtifactList();
        artifact = factory.create(STATEMANS_MEDAL.getName());
    }

    @Test
    void shouldCorrectlyAddArtifact() {
        //when
        artifactList.add(artifact);
        //then
        assertTrue(artifactList.contains(artifact));
    }

    @Test
    void shouldCorrectlyRemoveArtifact() {
        artifactList.add(artifact);
        //when
        artifactList.remove(artifact);
        //then
        assertFalse(artifactList.contains(artifact));
    }

    @Test
    void shouldNotAddArtifactWithTheSameSlot() {
        EconomyArtifact secondArtifactWithTheSameSlot = factory.create(COLLAR_OF_CONJURING.getName());
        artifactList.add(artifact);

        assertThrows(IllegalStateException.class, () -> artifactList.add(secondArtifactWithTheSameSlot));
    }

    @Test
    void shouldReturnListOfAllArtifacts() {
        EconomyArtifact artifact2 = factory.create(GOLDEN_BOW.getName());
        //when
        artifactList.add(artifact);
        artifactList.add(artifact2);
        //then
        assertEquals(2, artifactList.getArtifacts().size());
        assertTrue(artifactList.getArtifacts().stream().map(a -> a.getName()).collect(Collectors.toList()).contains(artifact.getName()));
        assertTrue(artifactList.getArtifacts().stream().map(a -> a.getName()).collect(Collectors.toList()).contains(artifact2.getName()));
    }

}