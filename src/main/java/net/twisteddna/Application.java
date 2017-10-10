package net.twisteddna;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        String startingWord = args[0];
        String targetWord = args[1];

        ClosestPath path = new ClosestPath();
        System.out.println(path.findTrail(startingWord,targetWord).stream().reduce((a,b)->a+","+b).get());
        //WordsChain chain = new WordsChain(new ValidatedArguments(args));
        //chain.display();
    }

}
