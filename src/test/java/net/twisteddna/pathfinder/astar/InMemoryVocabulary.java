package net.twisteddna.pathfinder.astar;

import net.twisteddna.vocabulary.Vocabulary;

import java.util.List;
import java.util.function.Consumer;

/**
 * Crafted by TwistedDNA on 10/16/2017.
 */
public class InMemoryVocabulary implements Vocabulary {
    private List<String> words;

    public InMemoryVocabulary(List<String> words) {
        this.words = words;
    }

    @Override
    public void forEveryWord(Consumer<String> func) {
            words.forEach(w -> func.accept(w));
    }
}
