package Heap;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class HeapSorterTest {

    int[] items;
    HeapSorter hs;

    @Before
    public void setUp() throws Exception {
        items = new int[]{8, 12, 2, 10, 6, 4};
        hs = new HeapSorter(items);
    }

    @Test
    public void add() throws Exception {
        hs.add(8);
        assertEquals(
                Arrays.toString(new int[]{8, 12, 2, 10, 6, 4}),
                Arrays.toString(items)
        );
        hs.add(12);
        assertEquals(
                Arrays.toString(new int[]{12, 8, 2, 10, 6, 4}),
                Arrays.toString(items)
        );
    }

    @Test
    public void bubbleUp() throws Exception {
        hs.bubbleUp(1);
        assertEquals(
                Arrays.toString(new int[]{12, 8, 2, 10, 6, 4}),
                Arrays.toString(items)
        );
    }

    @Test
    public void parent() throws Exception {
        assertEquals(0, hs.parent(1));
    }

    @Test
    public void sort() throws Exception {
        hs.sort();
        assertEquals(
                Arrays.toString(new int[]{2, 4, 6, 8, 10, 12}),
                Arrays.toString(items)
        );
    }

    @Test
    public void swap() throws Exception {
        hs.swap(1, 2);

        assertEquals(
                Arrays.toString(new int[]{8, 2, 12, 10, 6, 4}),
                Arrays.toString(items)
        );
    }

    @Test
    public void remove() throws Exception {
        hs.remove();
    }

    @Test
    public void trickleDown() throws Exception {
        // TODO
        hs.trickleDown(2);
        assertEquals(
                Arrays.toString(new int[]{8, 12, 2, 10, 6, 4}),
                Arrays.toString(items)
        );
    }

    @Test
    public void hasLeft() throws Exception {
        assertTrue("true", hs.hasLeft(1));
    }

    @Test
    public void hasRight() throws Exception {
        assertTrue("true", hs.hasRight(1));
    }

    @Test
    public void right() throws Exception {
        assertEquals(6, hs.right(1));
    }

    @Test
    public void left() throws Exception {
        assertEquals(12, hs.left(0));
    }

}