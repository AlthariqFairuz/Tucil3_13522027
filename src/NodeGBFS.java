package src;

public class NodeGBFS extends Node{
    
    protected NodeGBFS parent;        
    // Constructor
    public NodeGBFS(String word,  NodeGBFS parent) {
        super(word);
        this.parent = parent;
    }

    public String getWord() {
        return word;
    }

    public NodeGBFS getParent() {
        return parent;
    }

}
