package net.twisteddna;

public class Heuristic {

    public static int distanceBetween(String alfa, String omega) {
        char[] first = alfa.toCharArray();
        char[] second = omega.toCharArray();
        int diff = Math.abs(first.length-second.length);
        for (int i=0; i<Math.min(first.length, second.length);i++){
            if(first[i] != second[i]){
                diff++;
            }
        }
        return diff;
    }

    public static boolean isNeighbour(String target, String potentialNeighbour){
        char[] first = target.toCharArray();
        char[] second = potentialNeighbour.toCharArray();
        int diff = Math.abs(first.length-second.length);
        for (int i=0; i<Math.min(first.length, second.length);i++){
            if (diff>2){
                return false;
            }
            if(first[i] != second[i]){
                diff++;
            }
        }
        return diff == 1;
    }
}
