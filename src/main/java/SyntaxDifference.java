public class SyntaxDifference {
    public int calculate(String alfa, String omega) {
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
}
