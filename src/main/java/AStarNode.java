import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
class AStarNode implements Comparable{
    private Node node;
    private int estimatedSteps;
    private List<AStarNode> track;

    public  AStarNode(Node core, Node destination, List<AStarNode> previousTrack, SyntaxDifference heuristic){
        this.node = core;
        this.track = new LinkedList<>();
        this.track.addAll(previousTrack);
        this.track.add(this);
        this.estimatedSteps = heuristic.calculate(this.node.getValue(), destination.getValue());
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof AStarNode){
            AStarNode other = (AStarNode)o;
            int thisScore = estimatedSteps+track.size();
            int otherScore = other.estimatedSteps + other.track.size();
            return thisScore-otherScore;
        }
        return 0;
    }
}