import java.util.*;

// Note that this is a min heap
public class myHeap {

    // The core of the heap is a dynamic array
    private Vector<HeapItem> Heap = new Vector<HeapItem>();

    // Two following function maintain the heap property
    private void fixHeapUp(int i) {
        while (i > 0) {
            int pi = (i - 1)>>1; // Parent index

            if (Heap.get(i).key < Heap.get(pi).key) {
                Collections.swap(Heap, i, pi);
                i = pi;
            }
            else {
                return;
            }
        }
    }

    private void fixHeapDown(int i) {
        while (true) {
            int lchild = (i << 1) + 1, rchild = (i << 1) + 2;

            if (lchild >= Heap.size()) {
                return;
            }


            int min_child;
            // identify the child with minimum key.
            if (rchild >= Heap.size() || Heap.get(lchild).key <= Heap.get(rchild).key) {
                min_child = lchild;
            }
            else {
                min_child = rchild;
            }

            // if there is a violation of the heap property of i, swap its node
            // with the node held by the minimum-key child and repeat with this child
            if (Heap.get(min_child).key < Heap.get(i).key) {
                Collections.swap(Heap, i, min_child);
                i = min_child;
            }
            else {
                return;
            }
        }
    }

    // Constructor
    public myHeap() {}

    // return the min item of the heap, which is the root
    public HeapItem min() {
        if (Heap.size() > 0) {
            return Heap.get(0);
        }
        else {
            return new HeapItem(-1, -1);
        }
    }

    // return the size of the heap
    public Integer size() {
        return Heap.size();
    }

    // Inserting a HeapItem, which is an Object with its key
    public void insert(Object item, Integer key) {
        HeapItem node = new HeapItem(item, key);

        // Adding the item to the heap
        Heap.add(node);
        // maintain heap property
        fixHeapUp(Heap.size() - 1);
    }

    public void popMin() {
        // Move the last item to the top, if the size is 1,
        // just pop the item.
        Heap.set(0, Heap.lastElement());
        Heap.remove(Heap.size() - 1);

        // If heap is not empty, restore heap property
        if (Heap.size() > 0) {
            fixHeapDown(0);
        }
    }

}
