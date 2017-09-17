package net.twisteddna;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class ClosestPath {

    private String vocabularyQualifiedFileName;
    private final String DEFAULT_VOCABULARY_FILENAME = "wordlist.txt";
    private final int MAX_TRIES = 1000;

    public ClosestPath() {
        this.vocabularyQualifiedFileName = DEFAULT_VOCABULARY_FILENAME;
    }

    public List<String> findTrail(String from, String to) throws IOException {
        TreeSet<String> set = new TreeSet<>(new DestinationAwareComparator(to));
        List<String> trail = new ArrayList<>();
        set.add(from);
        for (int tries = 0; tries < MAX_TRIES; tries++) {
            if (stepCloserToDestination(set, trail, to))
                return trail;
        }
        throw new RuntimeException("Was not able to find path within "+ MAX_TRIES+ " tries." );
    }

    private boolean stepCloserToDestination(TreeSet<String> set, List<String> trail, String destination) throws IOException {
        String closestToDestinationNeighbour = set.first();
        if (closestToDestinationNeighbour == null){
            throw new RuntimeException("Transformation cannot be found. Vocabulary is exhausted");
        }
        trail.add(closestToDestinationNeighbour);
        set.remove(closestToDestinationNeighbour);
        if (closestToDestinationNeighbour.equals(destination))
            return true;
        addNeighboursToSet(closestToDestinationNeighbour, set);
        return false;
    }

    private void addNeighboursToSet(String node, SortedSet<String> set) throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream in = classloader.getResourceAsStream(vocabularyQualifiedFileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;
        while ((line = reader.readLine()) != null) {
            if (Heuristic.isNeighbour(node, line)) {
                set.add(line);
            }
        }
    }
}
