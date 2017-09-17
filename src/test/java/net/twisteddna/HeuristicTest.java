package net.twisteddna;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class HeuristicTest {
    @Test
    public void shouldCountDifferentLettersInSameLengthWord(){
        assertEquals(1, Heuristic.distanceBetween("pigeon","pigean"));
    }
    @Test
    public void shouldCountWordLengthTowardsSyntaxDifference(){
        assertEquals(2, Heuristic.distanceBetween("pagan","paganse"));
    }
    @Test
    public void shouldNotQualifyForNeighbour(){
        assertFalse(Heuristic.isNeighbour("Europe","Euro"));
    }
    @Test
    public void shouldQualifyForNeighbour(){
        assertTrue(Heuristic.isNeighbour("Joy","Joe"));
    }
    @Test
    public void shouldProperlyCalculateEndings(){
        assertEquals(1, Heuristic.distanceBetween("pane","panes"));
    }
    @Test
    @Ignore //TODO stretch goal
    public void shouldProperlyCalculateAdditionalLettersInTheMiddleOfWord(){
        assertEquals(1, Heuristic.distanceBetween("shave","shaove"));
    }
    @Test
    @Ignore //TODO stretch goal
    public void shouldProperlyCalculatePrefixes(){
        assertEquals(1, Heuristic.distanceBetween("apane","pane"));
    }

}