package net.twisteddna;

import java.util.SortedSet;

/**
 * Crafted by TwistedDNA on 10/10/2017.
 */
public class AddNeighboursOperation {
    private String currentWord;
    private SortedSet<String> neighbours;

    public AddNeighboursOperation(String currentWord, SortedSet<String> neighbours) {
        this.currentWord = currentWord;
        this.neighbours = neighbours;
    }

    public void addIfNeighbour(String potentialNeighbour){
        //System.out.println("checkForNeborhood: "+potentialNeighbour);
        if (SyntaxEvaluationUtils.isNeighbour(currentWord, potentialNeighbour)) {
            neighbours.add(potentialNeighbour);
        }
    }

    public SortedSet<String> getNeighbours() {
        return neighbours;
    }
}
