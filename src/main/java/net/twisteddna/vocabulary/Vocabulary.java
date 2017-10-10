package net.twisteddna.vocabulary;

import java.util.function.Consumer;

/**
 * Crafted by TwistedDNA on 10/10/2017.
 */
public interface Vocabulary {
    void forEveryWord(Consumer<String> func);
}
