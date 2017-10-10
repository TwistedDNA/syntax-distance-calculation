package net.twisteddna;

import net.twisteddna.exception.TrailNotFoundException;
import net.twisteddna.pathfinder.Pathfinder;
import net.twisteddna.vocabulary.Vocabulary;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Crafted by TwistedDNA on 10/10/2017.
 */
public class AStar implements Pathfinder {

    private Vocabulary vocabulary;
    private SortedSet<String> neighbours;
    private Set<String> visited;
    private List<String> trail;

    public AStar(Vocabulary vocabulary) {
        this();
        this.vocabulary = vocabulary;
    }

    private AStar() {
        trail = new ArrayList<>();
        visited = new HashSet<>();
    }

    @Override
    public List<String> findTrail(String startingWord, String destinationWord) throws TrailNotFoundException {

        neighbours = new TreeSet<>(new DestinationAwareComparator(destinationWord));
        neighbours.add(startingWord);

        while (true) {
            SortedSet<String> unvisitedNeighbours = new TreeSet<>(neighbours);
            unvisitedNeighbours.removeAll(visited);

            if (unvisitedNeighbours.isEmpty()) {
                throw new TrailNotFoundException("Transformation cannot be found.");
            }
            String currentWord = unvisitedNeighbours.first();
            System.out.println("Current word: "+currentWord);
            visited.add(currentWord);
            trail.add(currentWord);

            if (destinationWord.equals(currentWord)) {
                return trail;
            }

            neighbours.addAll(addNeighbours(currentWord));
        }
    }

    private SortedSet<String> addNeighbours(String currentWord) {
        AddNeighboursOperation op = new AddNeighboursOperation(currentWord,neighbours);
        vocabulary.forEveryWord(op::addIfNeighbour);
        return op.getNeighbours();
    }
}
