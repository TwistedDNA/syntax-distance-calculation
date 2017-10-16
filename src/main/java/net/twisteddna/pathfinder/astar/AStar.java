package net.twisteddna.pathfinder.astar;

import net.twisteddna.exception.TrailNotFoundException;
import net.twisteddna.heuristics.SyntaxEvaluationUtils;
import net.twisteddna.pathfinder.Pathfinder;
import net.twisteddna.vocabulary.Vocabulary;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

/**
 * Crafted by TwistedDNA on 10/10/2017.
 */
public class AStar implements Pathfinder {

    private Vocabulary vocabulary;
    private TreeSet<Node> words;
    private SyntaxEvaluationUtils heuristics;

    public AStar(Vocabulary vocabulary, SyntaxEvaluationUtils heuristics) {
        this.vocabulary = vocabulary;
        this.heuristics = heuristics;
    }


    @Override
    public List<String> findTrail(String startingWord, String destinationWord) throws TrailNotFoundException {
        words = new TreeSet<>(new DestinationAwareComparator(destinationWord, heuristics));
        words.add(new Node(startingWord,null));

        while (true) {
            Node current = firstUnvisited();
            if(destinationWord.equals(current.value)){
                List<String> trail = new LinkedList<>();
                extractTrail(current,trail);
                return trail;
            }

            addNeighbours(current);
        }
    }

    private Node firstUnvisited() throws TrailNotFoundException {
        return words.stream().filter(node -> !node.visited).findFirst().orElseThrow(()->new TrailNotFoundException("Transformation cannot be found."));
    }
    private void extractTrail(Node node, List<String> listToFill){
        listToFill.add(node.value);
        if(node.origin == null) {
            return;
        }else{
            extractTrail(node.origin,listToFill);
        }
    }

    private void addNeighbours(Node currentNode) {
        AddNeighboursOperation op = new AddNeighboursOperation(heuristics,currentNode, words);
        vocabulary.forEveryWord(op::addIfNeighbour);
    }

}
