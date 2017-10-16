package net.twisteddna.wordchain;

import static org.junit.Assert.*;

import net.twisteddna.exception.TrailNotFoundException;
import net.twisteddna.pathfinder.Pathfinder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Crafted by TwistedDNA on 10/16/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class WordsChainTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldThrowExceptionOnNullParametersForConstructor(){
        exception.expect(IllegalArgumentException.class);
        new WordsChain(null);
    }

    @Test
    public void shouldReturnErrorMessageOnExceptionFromAlgorithm(){
        WordsChain withErrorInside = new WordsChain(new ValidatedArguments(new String[]{"one","two"}));
        String result = withErrorInside.findClosestPath(new ExceptionThrowingPathfindingAlgorithm());
        assertEquals("Because I can!", result);
    }

    @Test
    public void shouldReturnPermutationAsOneString(){
        WordsChain withErrorInside = new WordsChain(new ValidatedArguments(new String[]{"one","two"}));
        String result = withErrorInside.findClosestPath(new WorkingPermutationAlgorithm());
        assertEquals("lead,leld,lold,gold", result);
    }
}

class ExceptionThrowingPathfindingAlgorithm implements Pathfinder{
    @Override
    public List<String> findTrail(String startingWord, String destinationWord) throws TrailNotFoundException {
        throw new TrailNotFoundException("Because I can!");
    }
}
class WorkingPermutationAlgorithm implements Pathfinder{
    @Override
    public List<String> findTrail(String startingWord, String destinationWord) throws TrailNotFoundException {
       return Arrays.asList("lead","leld","lold","gold");
    }
}