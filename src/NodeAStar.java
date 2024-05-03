package src;

public class NodeAStar extends Node {
   
    protected NodeAStar parent;
    protected Integer cost;
    protected Integer heuristic;

    // Constructor
    public NodeAStar(String word, NodeAStar parent, Integer cost, Integer heuristic) {
        super(word);
        this.parent = parent;
        this.cost = cost;
        this.heuristic = heuristic;
    }

    public String getWord() {
        return word;
    }

    public NodeAStar getParent() {
        return parent;
    }

    public Integer getCost() {
        return cost;
    }

    public Integer getHeuristic() {
        return heuristic;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public void setHeuristic(Integer heuristic) {
        this.heuristic = heuristic;
    }
    
}
