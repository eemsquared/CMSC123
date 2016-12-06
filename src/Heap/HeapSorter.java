package Heap;

public class HeapSorter {

    private int[] items;
    private int heapSize;
    private final int ROOT = 0;

    public HeapSorter(int[] items) {
        this.items = items;
        this.heapSize = 0;
    }

    public void sort() {
       /* for (int i = 0; i < items.length; i++) {
            add(items[i]);
        }

        for (int i = items.length - 1; i >= 0; i--) {
            items[i] = remove();
        }*/

        for (int i = 0; i < items.length; i++) {
            add(items[i]);
        }

        for (int i = items.length - 1; i >= 0; i--) {
            items[i] = remove();
        }
    }

    public void add(int x) {
        /*if(heapSize == items.length){
            throw new IndexOutOfBoundsException();
        }
        else {
            items[heapSize] = x;
            bubbleUp(heapSize);
            heapSize++;
        }*/

        items[heapSize] = x;
        bubbleUp(heapSize);
        heapSize++;
    }

    public void bubbleUp(int i) {
        if (i != ROOT) {
            if (items[i] > items[parent(i)]) {
                swap(i, parent(i));
            }
            else {
                bubbleUp(parent(i));
            }
        }

        /*if (i != ROOT) {
            if (items[(i - 1) / 2] < items[i]) {
                swap(i, (i - 1) / 2);
            }

            bubbleUp((i - 1) / 2);
        }*/
    }

    public void swap(int i, int j) {
        int temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    public int parent(int i) {
        return (i - 1) / 2;
    }

    public int remove() {

        int oldTop = items[ROOT];
        heapSize--;

        if(heapSize > 0) {
            items[ROOT] = items[heapSize];
            trickleDown(ROOT);
        }

        return oldTop;
    }

    public void trickleDown(int i) {
       /* int temp = i;

        while((hasLeft(temp) || hasRight(temp)) && (items[i] > right(temp) || items[i] > left(temp))) {
                swap(i, min(right(temp), left(temp)));
        }

        swap(temp, i);*/

        int j;

        if ((2 * i) + 1 >= heapSize) {
            j = i;
        } else if ((2 * i) + 2 == heapSize || items[(2 * i) + 1] > items[(2 * i) + 2]) {
            j = (2 * i) + 1;
        } else {
            j = (2 * i) + 2;
        }

        if (items[i] < items[j]) {
            swap(i, j);
            trickleDown(j);
        }
    }

    private int min(int i, int j){
        return i > j ? j : i;
    }

    public boolean hasLeft(int i) {
        if((2 * i) + 1 != 0) return true;
        else return false;
    }

    public boolean hasRight(int i) {
        if((2 * i) + 2 != 0) return true;
        else return false;
    }

    public int right(int i) {
        return items[(2 * i) + 2];
    }

    public int left(int i) {
        return items[(2 * i) + 1];
    }

}