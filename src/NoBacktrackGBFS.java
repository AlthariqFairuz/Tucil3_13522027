package src;

import java.util.*;

public class NoBacktrackGBFS {
        // Greedy Best First Search algorithm is based on the heuristic value
        public static List<String> findLadderNoBacktrackGBFS(String start, String end, Set<String> dictionary) {
        NodeGBFS node = new NodeGBFS(start, null);
        Set<String> visited = new HashSet<>();
        int totalNodeVisited = 0;
    
        while (true) {
            totalNodeVisited++;
            String word = node.getWord();
            visited.add(word);
    
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
    
            // Generate all possible words from the current word and select the one with the smallest heuristic value
            NodeGBFS nextNode = null;
            int minHeuristic = Integer.MAX_VALUE;
            for (int i = 0; i < word.length(); i++) {
                // Change one letter at a time
                char[] chars = word.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    chars[i] = c;
                    String newWord = new String(chars);
                    // Check whether the new word is in the dictionary and not visited
                    if (dictionary.contains(newWord) && !visited.contains(newWord)) {
                        int heuristic = Heuristic.heuristic(newWord, end);
                        // Check whether the heuristic value is less than the previous heuristic value
                        if (heuristic < minHeuristic) {
                            minHeuristic = heuristic;
                            nextNode = new NodeGBFS(newWord, node);
                        }
                    }
                }
            }
    
            if (nextNode == null) {
                // No path found
                return null;
            }
            node = nextNode;
        }
    }
}
