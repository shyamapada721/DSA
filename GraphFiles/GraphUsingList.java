package GraphFiles;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphUsingList {
    int noOfVertices;
    ArrayList<ArrayList<Integer>> adjList;

    public GraphUsingList(){
       super(); 
    }

    public GraphUsingList(int noOfVertices){
        this.noOfVertices = noOfVertices;
        this.adjList = new ArrayList<>();
        int noOfList=0;
        for( ; noOfList <= noOfVertices; noOfList++){
            this.adjList.add(new ArrayList<Integer>());
        }
    }

    public void addEdge(int src, int dest){
        this.adjList.get(src).add(dest);
        this.adjList.get(dest).add(src);

    }


    public void printGraph(){
        for(int i=0; i<adjList.size(); i++){
            System.out.print("Vertex : "+i);
            for(int j=0; j<adjList.get(i).size(); j++){
                System.out.print("-->"+adjList.get(i).get(j));
            }
            System.out.println();
        }
    }

    public ArrayList<Integer> BFSTraversal(){
        ArrayList<Integer> resultList = new ArrayList<>();
        Queue<Integer> nodeQueue = new LinkedList<>();
        int[] visited = new int[this.noOfVertices+1];
        nodeQueue.offer(0);
        visited[0] = 1;

        while(!nodeQueue.isEmpty()){
            int polledNode = nodeQueue.poll();
            resultList.add(polledNode);
            for(int node : this.adjList.get(polledNode)){
                if(visited[node] == 0){
                    nodeQueue.add(node);
                    visited[node] = 1;
                }
            }
        }



        return resultList;
    }

}