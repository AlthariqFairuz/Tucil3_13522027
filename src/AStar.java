package src;
import java.util.*;

public class AStar {

    public static int heuristic(String start, String end){
        int diff = 0;
        for (int i = 0 ; i < start.length(); i++){
            if (start.charAt(i) != end.charAt(i)){
                diff++;
            }
        }
        return diff;
    }

    // A* algorithm is based on the cost and its heuristic value (cost + heuristic)
    public static List<String> findLadderAStar(String start, String end, Set<String> dictionary) {
        PriorityQueue<NodeAStar> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.getCost() + a.getHeuristic()));
        queue.add(new src.NodeAStar(start, null, 0, heuristic(start, end)));

        // Save the cost and heuristic value of each word
        Map<String, Integer> costs = new HashMap<>();
        Set<String> visited = new HashSet<>();
        costs.put(start, 0);
        visited.add(start);
        int totalNodeVisited = 0;

        while (!queue.isEmpty()) {
            NodeAStar node = queue.poll();
            totalNodeVisited++;
            String word = node.getWord();

            // Check whether the word is the end word
            if (word.equals(end)) {
                List<String> path = new ArrayList<>();
                while (node != null) {
                    path.add(node.getWord());
                    node = node.getParent();
                }
                System.out.println("===== Total nodes visited: " + totalNodeVisited + " ======");
                Collections.reverse(path);
                return path;
            }

            // Generate all possible words from the current word
            for (int i = 0; i < word.length(); i++) {
                // Change one letter at a time
                char[] chars = word.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    chars[i] = c;
                    String newWord = new String(chars);
                    // Check whether the new word is in the dictionary and not visited
                    if (dictionary.contains(newWord)  && !visited.contains(newWord)) {
                        int newCost = costs.get(word) + 1;
                        // Check whether the new word is not in the costs map or the new cost is less than the previous cost
                        if (!costs.containsKey(newWord) || newCost < costs.get(newWord)) {
                            queue.add(new NodeAStar(newWord,node, newCost, heuristic(newWord, end)));
                            visited.add(newWord);
                            costs.put(newWord, newCost);
                        }
                    }
                }
            }
        }
        return null;
    }
}

