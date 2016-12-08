package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by mmcalvarez on 12/8/2016.
 */
public class Graph {

    private int n;
    private List<Integer>[] adj;

    public Graph(int n){
        this.n = n;
        this.adj = new List[n];
        for(int i = 0; i < n; i++){
            adj[i] = new LinkedList<>(); //make a linked list on each array index
        }
    }
    public void addNode(String src) {       //not correct implementation
        int source = Math.abs(Integer.valueOf(src));

        for(int i = 0; i < adj.length; i++){
            if(adj[i].equals(source)){
                adj[i].add(source);
            }
        }
    }

    public void addEdge(String src, String dst) {
        int source = Math.abs(Integer.valueOf(src));
        int dest = Math.abs(Integer.valueOf(dst));

        adj[source].add(dest);

    }

    public void removeEdge(String src, String dst) {
        int source = Math.abs(Integer.valueOf(src));
        int dest = Math.abs(Integer.valueOf(dst));

        if(adj[source].equals(dest)){
            adj[source].remove(source);
        } else {
            for(int i = 0; i < adj[source].size(); i++){
                if(adj[source].get(i).equals(dest)){
                    adj[source].remove(i);
                }
            }
        }
    }

    public boolean hasEdge(String src, String dst) {
        int source = Math.abs(Integer.valueOf(src));
        int dest = Math.abs(Integer.valueOf(dst));

        return adj[source].contains(dest);
    }

    public List<String> outEdges(String src) {
        int source = Math.abs(Integer.valueOf(src));

        List<String> edges = new ArrayList<>();
        edges.add(String.valueOf(adj[source]));
        return edges;
    }

    public List<String> inEdges(String src) {
        int source = Math.abs(Integer.valueOf(src));

        List<String> edges = new ArrayList<>();

       for(int i = 0; i < n; i++){
           if(adj[i].contains(source)){
               edges.add(String.valueOf(i));
           }
       }
       return edges;
    }

    public List<String> bfs(String src) {
        return null;
    }

    public List<String> dfs(String src) {
        return null;
    }
}
