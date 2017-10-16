package net.twisteddna.pathfinder.astar;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import net.twisteddna.heuristics.SyntaxEvaluationUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.TreeSet;

/**
 * Crafted by TwistedDNA on 10/16/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class AddNeighboursOperationTest {


    @Test
    public void shouldAddTwoNodesToSet(){
        SyntaxEvaluationUtils heuristicsMock = mock(SyntaxEvaluationUtils.class);
        when(heuristicsMock.isNeighbour(any(), any())).thenReturn(true);
        when(heuristicsMock.distanceBetween(any(), any())).thenCallRealMethod();
        Node starting = new Node("someVal", null);
        TreeSet<Node> set = new TreeSet<>(new DestinationAwareComparator("some", heuristicsMock));

        AddNeighboursOperation op = new AddNeighboursOperation(heuristicsMock, starting, set);

        op.addIfNeighbour("firstCome");
        op.addIfNeighbour("secondCome");

        assertEquals(2, set.size());
    }

}