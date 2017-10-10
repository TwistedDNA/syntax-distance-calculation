package net.twisteddna;

import java.util.SortedSet;

/**
 * Crafted by TwistedDNA on 10/10/2017.
 */
public class NeighboursAddingIteration {
    private String currentWord;
    private SortedSet<String> neighbours;

    public NeighboursAddingIteration(String currentWord, SortedSet<String> neighbours) {
        this.currentWord = currentWord;
        this.neighbours = neighbours;
    }

    public void addIfNeighbour(String potentialNeighbour){
        if (Heuristic.isNeighbour(currentWord, potentialNeighbour)) {
            neighbours.add(potentialNeighbour);
        }
    }

    public SortedSet<String> getNeighbours() {
        return neighbours;
    }
}
