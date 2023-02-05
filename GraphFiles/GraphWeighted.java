package GraphFiles;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Edge<T> {
    T connectedVertex;
    int weight;

    public Edge(T vertex, int edgeWeight) {
        this.connectedVertex = vertex;
        this.weight = edgeWeight;
    }

    public String toString() {
        return "Vertex : " + connectedVertex + " with weight : " + weight;
    }
}

public class GraphWeighted<T> {
    Map<T, LinkedList<Edge<T>>> adj = new HashMap<>();
    boolean directed;

    public GraphWeighted() {
        this.directed = false;
    }

    public GraphWeighted(boolean directed) {
        this.directed = directed;
    }

    public void addEdge(T src, T dest, int weight) {
        adj.putIfAbsent(src, new LinkedList<>());
        adj.putIfAbsent(dest, new LinkedList<>());

        Edge srcToDest = new Edge(dest, weight);
        this.adj.get(src).add(srcToDest);

        if (!directed) {
            Edge destToSrc = new Edge(src, weight);
            this.adj.get(dest).add(destToSrc);
        }

    }

    public Edge<T> findEdgeByVertex(T src, T dest) {
        LinkedList<Edge<T>> srcAdjacentVertices = this.adj.get(src);
        for (Edge<T> edge : srcAdjacentVertices) {
            if (edge.connectedVertex.equals(dest))
                return edge;
        }
        return null;
    }

    public void removeNode(T node) {
        if (!directed) {
            LinkedList<Edge<T>> nodeConnectedEdges = this.adj.get(node);
            for (Edge<T> edge : nodeConnectedEdges) {
                T adjacentVertex = edge.connectedVertex;
                Edge<T> adjacentEdge = findEdgeByVertex(adjacentVertex, node);
                this.adj.get(adjacentVertex).remove(adjacentEdge);
            }
        } else {
            for (T vertex : this.adj.keySet()) {
                Edge<T> adjacentEdge = findEdgeByVertex(vertex, node);
                if (adjacentEdge != null)
                    this.adj.get(vertex).remove(adjacentEdge);
            }
        }
        this.adj.remove(node);
    }

    public void removeEdge(T src, T dest) {
        LinkedList<Edge<T>> srcEdges = this.adj.get(src);
        LinkedList<Edge<T>> destEdges = this.adj.get(dest);
        if (srcEdges == null || destEdges == null) {
            return;
        }
        Edge<T> srcEdge = findEdgeByVertex(src, dest);
        srcEdges.remove(srcEdge);
        if (!directed) {
            Edge<T> destEdge = findEdgeByVertex(dest, src);
            destEdges.remove(destEdge);
        }
    }

    public boolean hasNode(T node){
        return this.adj.containsKey(node);
    }

    public boolean hasEdge(T src, T dest){
        Edge<T> srcToDest = findEdgeByVertex(src, dest);
        if(directed){
            return srcToDest != null;
        }else{
            Edge<T> destToSrc = findEdgeByVertex(dest, src);
            return srcToDest != null && destToSrc != null;
        }
    }

}
