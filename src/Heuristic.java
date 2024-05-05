package src;

public class Heuristic {
        // Heuristic function is based on the number of different characters between two words
        public static int heuristic(String start, String end){
            int diff = 0;
            for (int i = 0 ; i < start.length(); i++){
                if (start.charAt(i) != end.charAt(i)){
                    diff++;
                }
            }
            return diff;
        }
}