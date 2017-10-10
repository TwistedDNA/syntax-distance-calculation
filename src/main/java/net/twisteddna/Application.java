package net.twisteddna;

import net.twisteddna.vocabulary.BufferedVocabulary;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        //ClosestPath path = new ClosestPath();
        //System.out.println(path.findTrail(startingWord,targetWord).stream().reduce((a,b)->a+","+b).get());
        WordsChain chain = new WordsChain(new ValidatedArguments(args));
        String result = chain.findClosestPath(new AStar(new BufferedVocabulary()));
        System.out.println(result);
    }

}
