/*
 * This is a Graph implementaion using the HashMap. Here, I take every vertex as a key and their adjacent nodes as value stored in a LinkedList. This implementation can be used for both directed and undirected. 
 */

package GraphFiles;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;

public class GraphUsingMap<T> {
    Map<T, LinkedList<T>> adj = new HashMap<>();
    boolean directed;

    public GraphUsingMap() {
        // By default the graph is undirected
        directed = false;
    }

    public GraphUsingMap(boolean directed) {
        this.directed = directed;
    }

    public void addEdge(T src, T dest) {
        this.adj.putIfAbsent(src, new LinkedList<>());
        this.adj.putIfAbsent(dest, new LinkedList<>());
        this.adj.get(src).add(dest);
        if (!directed) { // If the graph is undirected
            this.adj.get(dest).add(src);
        }

    }

    public void removeEdge(T src, T dest) {
        LinkedList<T> adjListToSrc = this.adj.get(src);
        LinkedList<T> adjListToDest = this.adj.get(dest);

        adjListToSrc.remove(dest);
        if (!directed) {
            adjListToDest.remove(src);
        }
    }

    public void removeNode(T src) {
        if (!directed) {
            LinkedList<T> adjListToSrc = this.adj.get(src);
            for (T node : adjListToSrc) {
                this.adj.get(node).remove(node);
            }
        } else {
            for (T key : this.adj.keySet()) {
                this.adj.get(key).remove(src);
            }
        }
        this.adj.remove(src);
    }

    public boolean hasNode(T node) {
        return this.adj.containsKey(node);
    }

    public boolean hasEdge(T src, T dest) {
        LinkedList<T> adjListToSrc = this.adj.get(src);
        if (directed) {
            return adjListToSrc.contains(dest);
        } else {
            LinkedList<T> adjListToDest = this.adj.get(dest);
            return adjListToSrc.contains(dest) && adjListToDest.contains(src);
        }
    }

    public boolean dfs(T src, T dest) {
        HashMap<T, Boolean> visited = new HashMap<>();
        return dfsHelper(src, dest, visited);
    }

    public boolean dfsHelper(T src, T dest, HashMap<T, Boolean> visited) {
        if (src == dest)
            return true;
        visited.put(src, true);
        for (T node : this.adj.get(src)) {
            if (visited.get(node) == null) {
                return dfsHelper(node, dest, visited);

            }

        }
        return false;
    }

    public boolean bfs(T src, T dest) {
        HashMap<T, Boolean> visited = new HashMap<>();
        return bfsHelper(src, dest, visited);
    }

    public boolean bfsHelper(T src, T dest, HashMap<T, Boolean> visited) {
        if (src == dest)
            return true;
        Queue<T> nodeQueue = new LinkedList<T>();
        nodeQueue.offer(src);
        visited.put(src, true);

        while (!nodeQueue.isEmpty()) {
            T polledNode = nodeQueue.poll();
            for (T node : this.adj.get(polledNode)) {
                if (node.equals(dest)) {
                    return true;
                }
                if (visited.get(node) == null) {
                    nodeQueue.offer(node);
                    visited.put(node, true);
                }

            }
        }
        return false;
    }

}
