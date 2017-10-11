package net.twisteddna;

import net.twisteddna.heuristics.SyntaxEvaluationUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class SyntaxEvaluationUtilsTest {
    @Test
    public void shouldCountDifferentLettersInSameLengthWord(){
        assertEquals(1, SyntaxEvaluationUtils.distanceBetween("pigeon", "pigean"));
    }
    @Test
    public void shouldCountWordLengthTowardsSyntaxDifference(){
        assertEquals(2, SyntaxEvaluationUtils.distanceBetween("pagan", "paganse"));
    }
    @Test
    public void shouldNotQualifyForNeighbour(){
        assertFalse(SyntaxEvaluationUtils.isNeighbour("Europe", "Euro"));
    }
    @Test
    public void shouldQualifyForNeighbour(){
        assertTrue(SyntaxEvaluationUtils.isNeighbour("Joy", "Joe"));
    }
    @Test
    public void shouldProperlyCalculateEndings(){
        assertEquals(1, SyntaxEvaluationUtils.distanceBetween("pane", "panes"));
    }


}