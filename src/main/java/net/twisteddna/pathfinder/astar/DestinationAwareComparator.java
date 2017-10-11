package net.twisteddna.pathfinder.astar;

import net.twisteddna.heuristics.SyntaxEvaluationUtils;

import java.util.Comparator;

public class DestinationAwareComparator implements Comparator<Node> {
    private String destination;

    public DestinationAwareComparator(String destination) {
        this.destination = destination;
    }

    @Override
    public int compare(Node o1, Node o2) {
            int dif = SyntaxEvaluationUtils.distanceBetween(o1.value, destination) - SyntaxEvaluationUtils
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
