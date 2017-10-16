package net.twisteddna;

import net.twisteddna.heuristics.SyntaxEvaluationUtils;
import net.twisteddna.pathfinder.astar.AStar;
import net.twisteddna.vocabulary.BufferedVocabulary;
import net.twisteddna.wordchain.ValidatedArguments;
import net.twisteddna.wordchain.WordsChain;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        WordsChain chain = new WordsChain(new ValidatedArguments(args));
        String result = chain.findClosestPath(new AStar(new BufferedVocabulary(), new SyntaxEvaluationUtils()));
        System.out.println(result);
    }

}
