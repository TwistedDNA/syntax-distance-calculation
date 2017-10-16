package net.twisteddna.pathfinder.astar;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

import net.twisteddna.exception.TrailNotFoundException;
import net.twisteddna.heuristics.SyntaxEvaluationUtils;
import net.twisteddna.vocabulary.Vocabulary;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Crafted by TwistedDNA on 10/16/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class AStarTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    public AStar buildAlgorithm(List<String> wordsForVocabulary) {
        InMemoryVocabulary vocabulary = new InMemoryVocabulary(wordsForVocabulary);
        return new AStar(vocabulary, new SyntaxEvaluationUtils());
    }

    @Test
    public void shouldFindPermutation() throws TrailNotFoundException {
        AStar algorithm = buildAlgorithm(Arrays.asList("dog", "tag", "dag"));

        List<String> trail = algorithm.findTrail("tag", "dog");

        assertTrue(trail.size() == 3);
        assertEquals("tag", trail.get(0));
        assertEquals("dag", trail.get(1));
        assertEquals("dog", trail.get(2));
    }

    @Test
    public void shouldThrowExceptionOnNotAbleToFindPermutations() throws TrailNotFoundException {
        AStar algorithm = buildAlgorithm(Arrays.asList("dog", "tag", "dag", "lizard"));

        thrown.expect(TrailNotFoundException.class);

        algorithm.findTrail("dog", "lizard");
    }
}

class InMemoryVocabulary implements Vocabulary {

    private List<String> words;

    public InMemoryVocabulary(List<String> words) {
        this.words = words;
    }

    @Override
    public void forEveryWord(Consumer<String> func) {
        words.forEach(w -> func.accept(w));
    }
}
