package net.twisteddna;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        checkRequiredArguments(args);
        String startingWord = args[0];
        String targetWord = args[1];

        ClosestPath path = new ClosestPath();
        System.out.println(path.findTrail(startingWord,targetWord).stream().reduce((a,b)->a+","+b).get());
    }

    private static void checkRequiredArguments(String[] args) {
        if(args.length == 0){
            System.err.println("Two arguments needed. First is starting word, and second is destination word.");
            System.exit(0);
        }
    }
}
