package net.twisteddna.pathfinder.astar;

import net.twisteddna.heuristics.SyntaxEvaluationUtils;

import java.util.TreeSet;

/**
 * Crafted by TwistedDNA on 10/10/2017.
 */
class AddNeighboursOperation {
    private Node currentNode;
    private TreeSet<Node> neighbours;
    private SyntaxEvaluationUtils heuristics;

    public AddNeighboursOperation(SyntaxEvaluationUtils heuristics, Node currentNode, TreeSet<Node> set) {
        this.currentNode = currentNode;
        this.neighbours = set;
        this.heuristics = heuristics;
        currentNode.visited = true;
    }

    public void addIfNeighbour(String potentialNeighbour){
        if (heuristics.isNeighbour(currentNode.value, potentialNeighbour)) {
            neighbours.add(new Node(potentialNeighbour,currentNode));
        }
    }
}
