public class HeapItem {
    Object item;
    Integer key;

    // Constructor
    HeapItem(Object t, Integer k) {
        item = t;
        key = k;
    }

    public String toString() {
        return item + " " + Integer.toString(key);
    }
}
