package edu.pitt.se;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
public class PlaylistRecommenderTest {

    @Test
    public void testClassifyEnergy() {
        assertEquals("HIGH", PlaylistRecommender.classifyEnergy(List.of(140, 140, 140)));
        assertEquals("MEDIUM", PlaylistRecommender.classifyEnergy(List.of(100, 100, 100)));
        assertEquals("LOW", PlaylistRecommender.classifyEnergy(List.of(99, 99, 99)));
        assertThrows(IllegalArgumentException.class, () -> PlaylistRecommender.classifyEnergy(null));
        assertThrows(IllegalArgumentException.class, () -> PlaylistRecommender.classifyEnergy(List.of()));
    }
    @Test
    public void testIsValidTrackTitle() {
        assertEquals(false, PlaylistRecommender.isValidTrackTitle(null));
        assertEquals(false, PlaylistRecommender.isValidTrackTitle(""));
        assertEquals(false, PlaylistRecommender.isValidTrackTitle("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        assertEquals(false, PlaylistRecommender.isValidTrackTitle("a1a"));
        assertEquals(false, PlaylistRecommender.isValidTrackTitle("a@a"));
        assertEquals(true, PlaylistRecommender.isValidTrackTitle("a"));
        assertEquals(true, PlaylistRecommender.isValidTrackTitle("a a"));
        assertEquals(true, PlaylistRecommender.isValidTrackTitle("A a A b B"));
    }
    @Test
    public void testNormalizeVolume() {
        assertEquals(0, PlaylistRecommender.normalizeVolume(-10));
        assertEquals(100, PlaylistRecommender.normalizeVolume(120));
        assertEquals(50, PlaylistRecommender.normalizeVolume(50));
    }
}
