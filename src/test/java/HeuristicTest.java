import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class HeuristicTest {

    private Heuristic heuristic;

    @Before
    public void init(){
        heuristic = new Heuristic();
    }
    @Test
    public void shouldCountDifferentLettersInSameLengthWord(){
        assertEquals(1, heuristic.calculate("pigeon","pigean"));
    }
    @Test
    public void shouldCountWordLengthTowardsSyntaxDifference(){
        assertEquals(2, heuristic.calculate("pagan","paganse"));
    }
    @Test
    public void shouldNotQualifyForNeighbour(){
        assertFalse(heuristic.isNeighbour("Europe","Euro"));
    }
    @Test
    public void shouldQualifyForNeighbour(){
        assertTrue(heuristic.isNeighbour("Joy","Joe"));
    }
    @Test
    public void shouldProperlyCalculateEndings(){
        assertEquals(1, heuristic.calculate("pane","panes"));
    }
    @Test
    @Ignore //TODO stretch goal
    public void shouldProperlyCalculateAdditionalLettersInTheMiddleOfWord(){
        assertEquals(1, heuristic.calculate("shave","shaove"));
    }
    @Test
    @Ignore //TODO stretch goal
    public void shouldProperlyCalculatePrefixes(){
        assertEquals(1, heuristic.calculate("apane","pane"));
    }

}