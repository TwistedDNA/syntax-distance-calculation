package net.twisteddna;

import net.twisteddna.heuristics.SyntaxEvaluationUtils;
import net.twisteddna.pathfinder.astar.AStar;
import net.twisteddna.timemasurement.TimeTakenToFindChain;
import net.twisteddna.vocabulary.TextFileVocabulary;
import net.twisteddna.wordchain.ValidatedArguments;
import net.twisteddna.wordchain.WordsChain;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        //WordsChain chain = new WordsChain(new ValidatedArguments(new String[]{"goody", "ambos"}));
        //String result = chain.findClosestPath(new AStar(new TextFileVocabulary(), new SyntaxEvaluationUtils()));
        //System.out.println(result);
        System.out.println(TimeTakenToFindChain.checkAStar("goody","ambos",1));
    }
}
