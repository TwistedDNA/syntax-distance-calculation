package net.twisteddna.pathfinder;

import net.twisteddna.exception.TrailNotFoundException;

import java.util.List;

/**
 * Crafted by TwistedDNA on 10/10/2017.
 */
public interface Pathfinder {

    List<String> findTrail(String startingWord, String destinationWord) throws TrailNotFoundException;
}
