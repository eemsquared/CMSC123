package Trees;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by mmcalvarez on 11/8/2016.
 */
public class MyBinarySearchTreeTest extends TestCase {
    MyBinarySearchTree tree;

    @Override
    protected void setUp() throws Exception {
        tree = new MyBinarySearchTree();
    }

    @Test
    public void testAdd2() throws Exception {
        tree.add(45);
        tree.add(31);
        assertTrue(tree.contains(45));
        assertTrue(tree.contains(31));
    }

    @Test
    public void testAdd() throws Exception {
        tree.add(15);
        assertTrue(tree.contains(15));
    }

    @Test
    public void testAddFail() throws Exception {
        tree.add(1);
        try {
            tree.add(1);
        } catch (Exception e) {
            //expected
        }
    }

    @Test
    public void testAddMany() throws Exception {
        tree.add(5);
        tree.add(10);
        tree.add(30);
        tree.add(20);
        tree.add(40);
        assertEquals(tree.toString(), "5 10 20 30 40 ");
    }

    @Test
    public void testRemove() throws Exception {
        tree.add(10);
        tree.remove(10);
        assertEquals(false, tree.contains(10));
        System.out.println(tree.toString());
    }

    @Test
    public void testRemove2children() throws Exception {
        tree.add(10);
        tree.add(3);
        tree.add(2);
        tree.add(11);
        tree.add(8);
        tree.add(12);
        tree.remove(3);
        assertEquals(false, tree.contains(3));
        assertEquals(tree.toString(), "2 8 10 11 12 ");
    }

    @Test
    public void testRemoveLeaf() throws Exception {
        tree.add(10);
        tree.add(3);
        tree.add(2);
        tree.add(11);
        tree.add(8);
        tree.add(12);
        tree.remove(2);
        assertEquals(false, tree.contains(2));
        assertEquals(tree.toString(), "3 8 10 11 12 ");
    }

    @Test
    public void testRemoveOneChild() throws Exception {
        tree.add(10);
        tree.add(3);
        tree.add(2);
        tree.add(11);
        tree.add(8);
        tree.add(12);
        tree.remove(11);
        assertEquals(false, tree.contains(11));
        assertEquals(tree.toString(), "2 3 8 10 12 ");
    }

    @Test
    public void testRemove2() throws Exception {
        tree.add(15);
        tree.add(20);
        tree.remove(15);
        tree.remove(20);
        assertFalse(tree.contains(15));
        assertFalse(tree.contains(20));
    }

    @Test
    public void testContains() throws Exception {
        tree.add(5);
        tree.add(10);
        tree.add(30);
        tree.add(20);
        tree.add(40);
        assertTrue(tree.contains(5));
        assertFalse(tree.contains(16));
    }


}