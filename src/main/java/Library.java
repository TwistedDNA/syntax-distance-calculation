import java.util.*;
import java.util.stream.Collectors;

public class Library {
    private List<Node> nodes;
    private SyntaxDifference syntaxDifference;

    public Library(SyntaxDifference syntaxDifference) {
        this.nodes = new LinkedList<>();
        this.syntaxDifference = syntaxDifference;
    }

    public void addWordToStorage(String word) {
        Node current = new Node(word);
        for (Node potentialNeighbour : nodes) {
            if (1 == syntaxDifference.calculate(current.getValue(), potentialNeighbour.getValue())) {
                current.addNeighbour(potentialNeighbour);
                potentialNeighbour.addNeighbour(current);
            }
        }
        nodes.add(current);
    }

    public List<String> closetsPath(String source, String destination) {
        Node sourceNode = locateNode(source);
        Node destinationNode = locateNode(destination);
        SyntaxDifference syntaxDistance = new SyntaxDifference();
        SortedSet<AStarNode> tree = new TreeSet<>();
        tree.add(new AStarNode(sourceNode, destinationNode, Collections.EMPTY_LIST, syntaxDistance));
        while (true) {
            AStarNode current = tree.last();
            if (current.getNode().equals(destinationNode)) {
                return current.getTrack().stream().map(n -> n.getNode().getValue()).collect(Collectors.toList());
            } else {
                for (Node neighbour : current.getNode().getNeighbours()) {
                    tree.add(new AStarNode(neighbour, destinationNode, current.getTrack(), syntaxDistance));
                }
            }
        }
    }

    private Node locateNode(String word) {
        for (Node node : nodes) {
            if (word.equals(node.getValue())) {
                return node;
            }
        }
        throw new RuntimeException("Was not able to locate these words in library");
    }
}
