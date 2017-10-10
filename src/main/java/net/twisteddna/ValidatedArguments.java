package net.twisteddna;

/**
 * Crafted by TwistedDNA on 10/9/2017.
 */
public class ValidatedArguments {

    private String startingWord;
    private String destinationWord;

    public ValidatedArguments(String[] args) {
        validate(args);
            startingWord = args[0];
            destinationWord = args[1];
    }

    private void validate(String[] args) {
        if (args.length < 2) {
            throw new IllegalArgumentException("Two arguments needed. First is starting word, and second is destination word.");
        }
    }

    public String getStartingWord() {
        return startingWord;
    }

    public String getDestinationWord() {
        return destinationWord;
    }
}
