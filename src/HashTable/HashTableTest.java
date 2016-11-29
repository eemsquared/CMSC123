package HashTable;

/**
 * Created by mmcalvarez on 11/29/2016.
 */

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HashTableTest {
    HashTable<String> t;
    @Before
    public void setUp() throws Exception {
        t = new HashTable<String>(10);
    }

    @Test
    public void add() throws Exception {
        t.add("Hello");
        t.add("World");
        assertTrue(t.contains("Hello"));
        assertTrue(t.contains("World"));
    }

    @Test
    public void remove() throws Exception {
        t.add("Hello");
        t.add("World");
        t.remove("Hello");
        assertFalse(t.contains("Hello"));
        assertTrue(t.contains("World"));
    }

    @Test
    public void contains() throws Exception {
        t.add("MM");
        t.add("Winnah");
        assertTrue(t.contains("MM"));
        assertTrue(t.contains("Winnah"));
    }

}