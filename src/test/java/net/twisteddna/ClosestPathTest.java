package net.twisteddna;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class ClosestPathTest {
    @Test
    public void shouldReturnClosestPath(){
        ClosestPath path = new ClosestPath();

        List<String> trail = path.findTrail("lead","gold");

        assertNotNull(trail);
        assertEquals(4, trail.size());
        assertEquals("lead",trail.get(0));
        assertEquals("load",trail.get(1));
        assertEquals("goad",trail.get(2));
        assertEquals("gold",trail.get(3));
    }
}