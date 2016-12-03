package HashTable;

/**
 * Created by mmcalvarez on 12/3/2016.
 */
public class HashTableLinearProbing {
    private int capacity;
    private MyInt[] items;
    private int collisions;

    public HashTableLinearProbing(int capacity) {
        this.capacity = capacity;
        this.items = new MyInt[capacity];
        this.collisions = 0;
    }

    private int index(int hash) {
        return hash % capacity;
    }

    public boolean add(MyInt value) {
        int i = index(value.hashCode());
        /*if (items[i] == null) {
            items[i] = value;
            return true;
        } else {

            collisions++;

        }*/
        while(items[i] != null && items[i].equals(value)){
            collisions++;
            i += 1;
        }
        if(items[i] == null){
            items[i] = value;
            return true;
        }else {
            return false;
        }
    }

    int succ(int i) {
        return i + 1 == capacity ? 0 : i + 1;
    }

    public boolean remove(MyInt value) {
        int i = index(value.hashCode());

        if (items[i] == null) {
            return false;
        }

        if (value.equals(items[i])) {
            items[i] = new Bridge();
            return true;
        }


        return false;
    }

    public boolean contains(MyInt value) {
        int i = index(value.hashCode());

       /* if (items[i] == null) {
            return false;
        }

        if (value.equals(items[i])) {
            return true;
        }*/
       while (items[i] != null && items[i].equals(value)) {
           if (value.equals(items[i])) {
               return true;
           }
           if(items[i] == null){
               return  false;
           }else {
               i += 1;
           }
       }
       return false;
    }

    public String toString() {
        String val = "[";
        for (int i = 0; i < capacity; i++) {
            if (items[i] != null) {
                val += items[i].toString();
            } else {
                val += " ";
            }

            if (i < capacity - 1) {
                val += ", ";
            }
        }
        val += "]";
        return val;
    }

    public int getCollisions() {
        return collisions;
    }

    private class Bridge extends MyInt {
        public Bridge(int val) {
            super(val);
        }

        public Bridge() {
            super(0);
        }

        @Override
        public String toString() {
            return "B";
        }
    }
}
