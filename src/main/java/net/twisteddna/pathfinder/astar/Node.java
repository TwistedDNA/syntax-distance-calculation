package net.twisteddna.pathfinder.astar;

/**
 * Crafted by TwistedDNA on 10/11/2017.
 */
public class Node {
    public String value;
    public boolean visited;
    public Node origin;

    public Node(String value, Node origin) {
        this.value = value;
        visited=false;
        this.origin = origin;
    }

    @Override
    public boolean equals(Object o) {
        //comparing values only
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Node node = (Node) o;

        return value.equals(node.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
