package net.twisteddna.pathfinder.astar;

import net.twisteddna.heuristics.SyntaxEvaluationUtils;

import java.io.Serializable;
import java.util.Comparator;

class DestinationAwareComparator implements Comparator<Node>, Serializable {
    private String destination;
    private SyntaxEvaluationUtils heuristics;

    public DestinationAwareComparator(String destination, SyntaxEvaluationUtils heuristics) {
        this.destination = destination;
        this.heuristics = heuristics;
    }

    @Override
    public int compare(Node o1, Node o2) {
            int dif = heuristics.distanceBetween(o1.value, destination) - heuristics
            .distanceBetween(o2.value, destination);
            if(dif != 0){
                return dif;
            }
            if(o1.equals(o2)){
                return 0;
            }else {
                return o1.hashCode()-o2.hashCode();
            }
    }
}
