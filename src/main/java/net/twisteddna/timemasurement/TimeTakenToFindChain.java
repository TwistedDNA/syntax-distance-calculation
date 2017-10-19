package net.twisteddna.timemasurement;

import net.twisteddna.heuristics.SyntaxEvaluationUtils;
import net.twisteddna.pathfinder.Pathfinder;
import net.twisteddna.pathfinder.astar.AStar;
import net.twisteddna.vocabulary.TextFileVocabulary;
import net.twisteddna.wordchain.ValidatedArguments;
import net.twisteddna.wordchain.WordsChain;

/**
 * Crafted by TwistedDNA on 10/17/2017.
 */
public class TimeTakenToFindChain {

    public TimeTakenToFindChain(WordsChain chain) {
        this.chain = chain;
    }

    private WordsChain chain;

    public long registerTimeToFindPermutation(Pathfinder algorithm, long repeatTimes) {
        long timeBefore = System.currentTimeMillis();
        for (int i = 0; i < repeatTimes; i++) {
            chain.findClosestPath(algorithm);
        }
        return System.currentTimeMillis() - timeBefore;
    }

    public static long checkAStar(String from, String to, long times) {
        TimeTakenToFindChain
            clock =
            new TimeTakenToFindChain(new WordsChain(new ValidatedArguments(new String[]{from, to})));
        return clock
            .registerTimeToFindPermutation(new AStar(new TextFileVocabulary(), new SyntaxEvaluationUtils()), times);
    }

}
