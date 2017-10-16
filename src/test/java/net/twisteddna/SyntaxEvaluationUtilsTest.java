package net.twisteddna;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

import net.twisteddna.heuristics.SyntaxEvaluationUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SyntaxEvaluationUtilsTest {

    @Test
    public void shouldCountDifferentLettersInSameLengthWord() {
        assertEquals(1, new SyntaxEvaluationUtils().distanceBetween("pigeon", "pigean"));
    }

    @Test
    public void shouldCountWordLengthTowardsSyntaxDifference() {
        assertEquals(2, new SyntaxEvaluationUtils().distanceBetween("pagan", "paganse"));
    }

    @Test
    public void shouldNotQualifyForNeighbour() {
        assertFalse(new SyntaxEvaluationUtils().isNeighbour("Europe", "Euro"));
    }

    @Test
    public void shouldQualifyForNeighbour() {
        assertTrue(new SyntaxEvaluationUtils().isNeighbour("Joy", "Joe"));
    }

    @Test
    public void shouldProperlyCalculateEndings() {
        assertEquals(1, new SyntaxEvaluationUtils().distanceBetween("pane", "panes"));
    }


}