package src;

public class NodeUCS extends Node {
   
    protected NodeUCS parent;  
    protected Integer cost;
    // Constructor
    public NodeUCS(String word, Integer cost,  NodeUCS parent) {
        super(word);
        this.parent = parent;
        this.cost = cost;
    }

    public String getWord() {
        return word;
    }

    public NodeUCS getParent (){
        return parent;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}
