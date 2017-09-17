package net.twisteddna;

import java.util.Comparator;

public class DestinationAwareComparator implements Comparator<String> {
    private String destination;

    public DestinationAwareComparator(String destination) {
        this.destination = destination;
    }

    @Override
    public int compare(String o1, String o2) {
        return Heuristic.distanceBetween(o1, destination) - Heuristic.distanceBetween(o2, destination);
    }

}
