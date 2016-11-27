package Splay;

import junit.framework.TestCase;
import org.junit.Test;

public class SplayTreeTest extends TestCase {
    @Test
    public void testSplay() throws Exception {
        SplayTree tree = new SplayTree();
        tree.add(20);
        tree.add(10);
        tree.add(30);
        tree.add(25);


        assertEquals("root should be 20", (Integer) 20, tree.root());
        assertTrue("splay should find 25", tree.splay(25));
        assertEquals("root after splay should be 25", (Integer) 25, tree.root());
    }

}