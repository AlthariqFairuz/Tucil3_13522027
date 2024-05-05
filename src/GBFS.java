package src;

import java.util.*;

public class GBFS {

    public static List<String> findLadderGBFS(String start, String end, Set<String> dictionary) {
        // Greedy Best First Search algorithm is based on the heuristic value
        PriorityQueue<NodeGBFS> queue = new PriorityQueue<>(Comparator.comparingInt(a -> Heuristic.heuristic(a.getWord(), end)));
        queue.add(new src.NodeGBFS(start, null));

    
        Set<String> visited = new HashSet<>();
        visited.add(start); 

        int totalNodeVisited = 0;

        while (!queue.isEmpty()) {
            NodeGBFS node = queue.poll();
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
                    if (dictionary.contains(newWord) && !visited.contains(newWord)) {
                        queue.add(new NodeGBFS(newWord, node));
                        visited.add(newWord);
                    }
                }
            }
        }
        return null;
    }
}
