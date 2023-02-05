/* 
 * This is a undirected unweighted graph implementation using the adjacency matrix
 */





package GraphFiles;

import java.util.List;

class Graph{
    int noOfVertex;
    int[][] adjacencyMatrix;

    public Graph(){
        super();
    }

    public Graph(int vertex){
        this.noOfVertex = vertex;
        this.adjacencyMatrix = new int[vertex+1][vertex+1];
    }

    public String addEdge(int sourceVertex, int destinationVertex){
        adjacencyMatrix[sourceVertex][destinationVertex] = 1;
        adjacencyMatrix[destinationVertex][sourceVertex] = 1;
        return "An Edge added between vertex "+sourceVertex+" and vertex "+destinationVertex;
    }

    public String removeEdge(int sourceVertex, int destinationVertex){
        adjacencyMatrix[sourceVertex][destinationVertex] = 0;
        adjacencyMatrix[destinationVertex][sourceVertex] = 0;
        return "An Edge removed between vertex "+sourceVertex+" and vertex "+destinationVertex;
    }

    public boolean isVertexConnected(int src, int dest){
        return this.adjacencyMatrix[src][dest] == 1;
    }

















    public void showMatrix(){
        for(int[] oneNode : this.adjacencyMatrix){
            for(int node : oneNode){
                System.out.print(node+" ");
            }
            System.out.println();
        }
    }




}