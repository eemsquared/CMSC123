package HashTable;

/**
 * Created by mmcalvarez on 11/29/2016.
 */

import java.util.LinkedList;
import java.util.List;

public class HashTable<V> {

    private int capacity;
    private List<V>[] buckets;

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.buckets = new LinkedList[capacity];
    }

    public void add(V value) {
        int hash = value.hashCode() % capacity;
        hash = Math.abs(hash);

        if(buckets[hash] == null){
            buckets[hash] = new LinkedList<V>();
        }
        buckets[hash].add(value);
    }

    public void remove(V value) {
        int hash = value.hashCode() % capacity;
        hash = Math.abs(hash);

        if(buckets[hash].equals(value)){
            buckets[hash].remove(hash);
        }else {
            //List<V> list = buckets[capacity];
            for(int i = 0; i < buckets[hash].size(); i++){
                if(buckets[hash].get(i).equals(value)){
                    buckets[hash].remove(i);
                }
            }
        }
    }

    public boolean contains(V value) {
        int hash = value.hashCode() % capacity;
        hash = Math.abs(hash);

        if(buckets[hash].equals(value)){
            return true;
        }else {
            List<V> list = buckets[hash];
            for(int i = hash + 1; i < capacity; i++){
                if(list.contains(value)){
                    return true;
                }
            }
        }
        return false;
    }
}
