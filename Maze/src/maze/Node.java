package maze;

public class Node implements Comparable<Node> {

    int row = 0;
    int clum = 0;
    Node parent;
    double hurestic;
    double cost;
    double total;

    public Node(int row, int clum, double total) {
        this.row = row;
        this.clum = clum;
        this.total = total;
    }

    public Node(int row, int clum) {
        this.row = row;
        this.clum = clum;
    }

    public Node(int row, int clum, Node parent) {
        this.row = row;
        this.clum = clum;
        this.parent = parent;
        total = parent.getCost();
    }
    
    public void setHurstec(double hurestic){
       this.hurestic = hurestic ;
       this.total += this.hurestic;
    }
    public void addCost(){
       this.cost = this.cost + 10;
       this.total += this.cost;
    }
    public double getTotal(){
        return this.total;
    }
    public double getCost(){
        return this.cost;
    }

    public int compareTo(Node current) {
        if (this.total > current.total) {
            return 1;
        } else if (this.total < current.total) {
            return -1;
        } else {
            return 0;
        }
    }
}
