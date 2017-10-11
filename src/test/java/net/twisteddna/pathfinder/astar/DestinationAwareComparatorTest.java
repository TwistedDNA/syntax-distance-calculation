package net.twisteddna.pathfinder.astar;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.TreeSet;

/**
 * Crafted by TwistedDNA on 10/11/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class DestinationAwareComparatorTest {

    private final String destination = "Jabba";
    private TreeSet<Node> set = new TreeSet(new DestinationAwareComparator(destination));


    @Before
    public void init() {
        set.clear();
    }

    @Test
    public void capitalLetterMatters() {
        set.add(new Node("veni", null));
        set.add(new Node("vEni", null));
        assertEquals(2, set.size());
    }

    @Test
    public void originDoesNotMatter(){
        Node father = new Node("Jack", null);
        Node son = new Node("Vence",father);
        Node looksLikeSon = new Node("Vence",null);
        set.add(son);
        set.add(looksLikeSon);
        assertEquals(1, set.size());
    }
}