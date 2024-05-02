package src;
import java.util.*;

import Utils.Node;

public class UCS {


    public static List<String> findLadderUCS(String start, String end, Set<String> dictionary) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.getCost()));
        queue.add(new Utils.Node(start, 0, null));

        // Save the cost of each word
        Map<String, Integer> costs = new HashMap<>();
        costs.put(start, 0);
        int totalNodeVisited = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
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
                    if (dictionary.contains(newWord)) {
                        int newCost = costs.get(word) + 1;
                        // Check whether the new word is not in the costs map or the new cost is less than the previous cost
                        if (!costs.containsKey(newWord) || newCost < costs.get(newWord)) {
                            queue.add(new Node(newWord, newCost, node));
                            costs.put(newWord, newCost);
                        }
                    }
                }
            }
        }
        return null;
    }
}
