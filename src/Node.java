package src;

public abstract class Node {

    protected String word; 
    // Constructor
    public Node(String word) {
        this.word = word;
    }

    public abstract String getWord();
}
