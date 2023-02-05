package GraphFiles;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        //This code is to test the graph implementation using matrix
        /* 
        Graph graph = new Graph(3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.showMatrix();
        System.out.println(graph.isVertexConnected(1, 3));
        */
        
//This code is to test the graph implementaion using the arraylist
        /* 
        GraphUsingList graph = new GraphUsingList(8);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 6);
        graph.addEdge(4, 7);
        graph.addEdge(7, 8);

        ArrayList<Integer> bfsList = graph.BFSTraversal();
        for(int node : bfsList){
            System.out.print("--> "+node);
        }
        System.out.println();
        
        

        graph.printGraph();
        */

//This code is to test the graph implementation using hashmap
/* 
        GraphUsingMap graph = new GraphUsingMap<>(true);
        graph.addEdge(0,1);
        graph.addEdge(1,4);
        graph.addEdge(2,0);


        System.out.println("The node 2 is present : "+graph.hasNode(2));
        System.out.println("The node 5 is present : "+graph.hasNode(5));
        System.out.println("The Edge present between 1 to 4 : "+graph.hasEdge(1, 4));
        System.out.println("The Edge present between 1 to 0 : "+graph.hasEdge(1, 0));

        System.out.println("The path existing between 0 and 4 using bfs : "+graph.bfs(0, 4));
        System.out.println("The path existing between 0 and 4 using dfs : "+graph.dfs(0, 4));

        System.out.println("The path existing between 0 and 2 using bfs : "+graph.bfs(0, 2));
        System.out.println("The path existing between 0 and 2 using dfs : "+graph.dfs(0, 2));
    */

//The code is to test the Weighted Graph
    GraphWeighted graph = new GraphWeighted<>(true);
    graph.addEdge(0, 1, 3);
    graph.addEdge(0, 2, 4);

    graph.addEdge(1, 3, 1);

    graph.addEdge(2, 1, 2);

    System.out.println("The edge present between 0 and 1 : "+graph.hasEdge(0, 1));
    System.out.println("The edge present between 2 and 3 : "+graph.hasEdge(2, 3));






    }
}
