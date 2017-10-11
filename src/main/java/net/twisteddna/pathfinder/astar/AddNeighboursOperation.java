package net.twisteddna.pathfinder.astar;

import net.twisteddna.heuristics.SyntaxEvaluationUtils;

import java.util.TreeSet;

/**
 * Crafted by TwistedDNA on 10/10/2017.
 */
public class AddNeighboursOperation {
    private Node currentNode;
    private TreeSet<Node> neighbours;

    public AddNeighboursOperation(Node currentNode, TreeSet<Node> set) {
        this.currentNode = currentNode;
        this.neighbours = set;
        currentNode.visited = true;
    }

    public void addIfNeighbour(String potentialNeighbour){
        if (SyntaxEvaluationUtils.isNeighbour(currentNode.value, potentialNeighbour)) {
            neighbours.add(new Node(potentialNeighbour,currentNode));
        }
    }
}
