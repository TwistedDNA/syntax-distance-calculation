package net.twisteddna.wordchain;

import net.twisteddna.exception.TrailNotFoundException;
import net.twisteddna.pathfinder.Pathfinder;

import java.util.List;

/**
 * Crafted by TwistedDNA on 10/10/2017.
 */
public class WordsChain {

    private List<String> trail = null;
    private ValidatedArguments args;
    private String errorMessage;

    public WordsChain(ValidatedArguments args) {
        this.args = args;
    }

    public String findClosestPath(Pathfinder pathfinder) {
            errorMessage = "";
        try {
            this.trail = pathfinder.findTrail(args.getStartingWord(), args.getDestinationWord());
        } catch (TrailNotFoundException ex) {
            this.errorMessage = ex.getMessage();
        }
        return stringifyChain();
    }

    private String stringifyChain() {
        return errorMessage.isEmpty() ? trail.stream().reduce("",(a, b) -> a + "," + b) : errorMessage;
    }

}
