package maze;

import java.util.PriorityQueue;

public class Maze {

    static String[][] maze ={ //
            {" ", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "||", " |"}, //
            {" ", " ", "|", " ", "|", " ", "|", " ", " ", " ", " ", " ", " |"}, //
            {"| ", " ", "|", " ", " ", " ", "|", " ", "|", "|", "|", " ", " |"}, //
            {"| ", " ", " ", " ", "|", "|", "|", " ", " ", " ", " ", " ", " |"}, //
            {"| ", " ", "|", " ", " ", " ", " ", " ", "|", "|", "|", " ", " |"}, //
            {"| ", " ", "|", " ", "|", "_", "|", " ", "|", " ", " ", " ", " |"}, //
            {"| ", " ", "|", " ", "|", " ", " ", " ", "|", "_", "|", " ", " |"}, //
            {"| ", " ", "|", " ", "|", "_", "|", " ", "|", " ", "|", " ", " |"}, //
            {"| ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|", " ", " |"}, //
            {"| ", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", " ", "  "}};
    /*{
        {" ", "-", "-", "-", "|"},
        {" ", " ", "|", " ", "|"},
        {"|", " ", "|", " ", " "},
        {"|", " ", " ", " ", " "},
        {"-", "-", "-", "-", " "},};*/
    static int finalI = maze.length - 1;
    static int finalJ = maze.length - 1;
 static int count =0;
    public static void main(String[] args) {

        Astar();
        String[][] m1 = { //
            {"| ", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "||", " |"}, //
            {"| ", " ", "|", " ", "|", " ", "|", " ", " ", " ", " ", " ", " |"}, //
            {"| ", " ", "|", " ", " ", " ", "|", " ", "|", "|", "|", " ", " |"}, //
            {"| ", " ", " ", " ", "|", "|", "|", " ", " ", " ", " ", " ", " |"}, //
            {"| ", " ", "|", " ", " ", " ", " ", " ", "|", "|", "|", " ", " |"}, //
            {"| ", " ", "|", " ", "|", "_", "|", " ", "|", " ", " ", " ", " |"}, //
            {"| ", " ", "|", " ", "|", " ", " ", " ", "|", "_", "|", " ", " |"}, //
            {"| ", " ", "|", " ", "|", "_", "|", " ", "|", " ", "|", " ", " |"}, //
            {"| ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|", " ", " |"}, //
            {"| ", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", " |"}};

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze.length; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println("\n");
        }

    }

    public static void Astar() {

        PriorityQueue<Node> pQueue = new PriorityQueue<>();
        boolean[][] visited = new boolean[maze[0].length][maze.length];
        pQueue.add(new Node(0, 0, 0));

        while (!pQueue.isEmpty()) {
            Node current = pQueue.remove();
            if (current.row == finalI && current.clum == finalJ) {
                maze[current.row][current.clum] = "*";
                break;
            }
            if (!visited[current.row][current.clum]) {
                visited[current.row][current.clum] = true;
                maze[current.row][current.clum] = " " +Integer.toString(count++);
                if ((current.row + 1 < maze[0].length) ) {
                    if (maze[current.row + 1][current.clum].equalsIgnoreCase(" ")) {
                        Node newNode = new Node(current.row + 1, current.clum,current);
                        process(current,newNode, pQueue);
                    }}
                if(current.clum + 1 < maze.length){
                    if (maze[current.row][current.clum + 1].equalsIgnoreCase(" ") ) {
                        Node newNode = new Node(current.row, current.clum + 1,current);
                        process(current,newNode, pQueue);
                    }
                }
                if (current.row - 1 > 0){
                    if (maze[current.row - 1][current.clum].equalsIgnoreCase(" ")) {
                        Node newNode = new Node(current.row - 1, current.clum,current);
                        process(current,newNode, pQueue);
                    }
                }
                if ((current.clum - 1 > 0)) {
                    if (maze[current.row][current.clum - 1].equalsIgnoreCase(" ")) {
                        Node newNode = new Node(current.row, current.clum - 1,current);
                        process(current,newNode, pQueue);
                    }
                }
            }
        }

    }

    public static void process(Node current,Node newNode, PriorityQueue<Node> pQueue) {
        newNode.setHurstec(Math.abs(newNode.row - finalI) + Math.abs(newNode.clum - finalJ));
        newNode.addCost(); // hurstic + cost 
        
        pQueue.add(newNode); // add the move to the PQ mnbbmhbm

    }
}
