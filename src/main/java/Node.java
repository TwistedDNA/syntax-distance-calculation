import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Node {
    private String value;
    private Set<Node> neighbours;

    public Node(String value) {
        if (value == null) {
            throw new RuntimeException("Node with null value is invalid!");
        }
        this.value = value;
        neighbours = new HashSet<>();
    }

    public void addNeighbour(Node neighbour) {
        this.neighbours.add(neighbour);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Node node = (Node) o;

        return value != null ? value.equals(node.value) : node.value == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
