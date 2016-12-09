package Graphs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertFalse;

/**
 * Created by mmcalvarez on 12/8/2016.
 */
public class GraphTest {

    Graph g = new Graph(10);

    @Test
    public void addNode() throws Exception {
        g.addNode("2");
        g.addNode("1");
        assertFalse(g.hasEdge("1", "2"));
    }

    @Test
    public void addEdge() throws Exception {

        g.addEdge("1", "3");
        g.addEdge("7", "6");
        g.addEdge("5", "1");
        assertTrue(g.hasEdge("1", "3"));
        assertFalse(g.hasEdge("2", "3"));
    }

    @Test
    public void removeEdge() throws Exception {

        g.addEdge("1", "3");
        g.addEdge("7", "6");
        g.addEdge("5", "1");
        g.addEdge("5", "9");
        g.removeEdge("5", "9");
        g.removeEdge("5", "1");
        assertTrue(g.hasEdge("1", "3"));
        assertFalse(g.hasEdge("2", "3"));
        assertFalse(g.hasEdge("5", "1"));
    }

    @Test
    public void hasEdge() throws Exception {

        g.addEdge("1", "3");
        g.addEdge("7", "6");
        assertTrue(g.hasEdge("1", "3"));
        assertFalse(g.hasEdge("5", "1"));
    }

    @Test
    public void outEdges() throws Exception {
        List<String> list;

        g.addEdge("1", "4");
        g.addEdge("2", "6");
        g.addEdge("2", "7");
        g.addEdge("2", "9");

        list = g.outEdges("2");
        assertEquals(list.toString(), "[6, 7, 9]");
    }

    @Test
    public void inEdges() throws Exception {
        List<String> list;

        g.addEdge("1", "4");
        g.addEdge("2", "6");
        g.addEdge("2", "7");
        g.addEdge("2", "9");
        g.addEdge("3", "4");
        g.addEdge("5", "4");

        list = g.inEdges("4");
        assertEquals(list.toString(), "[1, 3, 5]");
    }

    @Test
    public void bfs() throws Exception {

        g.addNode("1");
        g.addNode("2");
        g.addNode("3");
        g.addNode("5");
        g.addEdge("1", "4");
        g.addEdge("2", "6");
        g.addEdge("2", "7");
        g.addEdge("2", "9");
        g.addEdge("3", "4");
        g.addEdge("5", "4");
        g.addEdge("2", "1");

        List<String> ans = g.bfs("2");
        assertEquals(ans.toString(), "[2, 6, 7, 9, 1]");

    }

    @Test
    public void dfs() throws Exception {
        g.addNode("1");
        g.addNode("2");
        g.addNode("3");
        g.addNode("5");
        g.addNode("6");
        g.addEdge("1", "4");
        g.addEdge("2", "6");
        g.addEdge("2", "7");
        g.addEdge("2", "9");
        g.addEdge("3", "4");
        g.addEdge("5", "4");
        g.addEdge("2", "1");
        g.addEdge("6", "5");
        g.addEdge("5", "9");

        List<String> ans = g.dfs("2");
        assertEquals(ans.toString(), "[2, 1, 4, 9, 7, 6, 5]");
        System.out.println(g.dfs("2"));
        System.out.println(ans.toString());
    }
}