package Graphs;

import sun.awt.image.ImageWatched;

import java.lang.reflect.Array;
import java.util.*;

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
        for(int i = 0; i < adj[source].size(); i++) {
            edges.add(String.valueOf(adj[source].get(i)));
        }

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
        int source = Math.abs(Integer.valueOf(src));

        LinkedList<String> queue = new LinkedList<>();
        LinkedList<String> queue2 = new LinkedList<>();
        boolean[] visited = new boolean[n];

        visited[source] = true;
        queue.add(String.valueOf(source));

        while(!queue.isEmpty()){
            src = queue.remove();
            queue2.add(src);

            for(int i = 0; i < adj[source].size(); i++){
                if(!visited[adj[source].get(i)]){
                    visited[adj[source].get(i)] = true;
                    queue.add(String.valueOf(adj[source].get(i)));
                }
            }
        }

        return queue2;
    }

    public List<String> dfs(String src) {
        int source = Math.abs(Integer.valueOf(src));
        boolean flag = false;

        Stack<String> stack = new Stack<>();
        Stack<String> stack2 = new Stack<>();

        boolean[] visited = new boolean[n];

        visited[source] = true;
        stack.push(String.valueOf(source));

        while(!stack.isEmpty()){
            src = stack.pop();
            stack2.push(src);

           /* if(!visited[Integer.valueOf(src)]){
                visited[Integer.valueOf(src)] = true;
            }*/

            List<String> neighbors = outEdges(src);

            for(int i = 0; i < neighbors.size(); i++){
               if(!stack2.contains(neighbors.get(i))){
                   stack.push(neighbors.get(i));

               }
              /* if(!flag){
                   stack.push(neighbors.get(i));
                   System.out.println(neighbors.get(i));
                   System.out.println("gggg");
                   System.out.println(stack);
               }*/
            }
        }


        return stack2;
    }
}
