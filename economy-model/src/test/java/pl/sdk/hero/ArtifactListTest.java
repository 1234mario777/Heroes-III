package pl.sdk.hero;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.artifacts.*;

import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static pl.sdk.artifacts.ArtifactStatistic.*;

class ArtifactListTest {

    private ArtifactList artifactList;
    private AbstractEconomyArtifactFactory factory = AbstractEconomyArtifactFactory.getInstance(ArtifactFactoryType.TEST);
    private EconomyArtifact artifact;

    @BeforeEach
    void init() {
        artifactList = new ArtifactList();
        artifact = factory.create(TEST_RING_OF_VITALITY.getName());
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
        EconomyArtifact secondArtifactWithTheSameSlot = factory.create(TEST_RING_OF_LIFE.getName());
        EconomyArtifact thirdArtifactWithTheSameSlot = factory.create(TEST_RING_OF_CONJURING.getName());
        artifactList.add(artifact);
        artifactList.add(secondArtifactWithTheSameSlot);

        assertThrows(IllegalStateException.class, () -> artifactList.add(thirdArtifactWithTheSameSlot));
    }

    @Test
    void shouldReturnListOfAllArtifacts() {
        EconomyArtifact artifact2 = factory.create(TEST_RING_OF_LIFE.getName());
        //when
        artifactList.add(artifact);
        artifactList.add(artifact2);
        //then
        assertEquals(2, artifactList.getArtifacts().size());
        assertTrue(artifactList.getArtifacts().stream().map(a -> a.getName()).collect(Collectors.toList()).contains(artifact.getName()));
        assertTrue(artifactList.getArtifacts().stream().map(a -> a.getName()).collect(Collectors.toList()).contains(artifact2.getName()));
    }

}