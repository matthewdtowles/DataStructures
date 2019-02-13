package heap;

import java.util.Comparator;
import queue.PriorityQueue;

/**
 * BinaryHeap
 * 
 * add and remove ops in O(log n) 
 * @author matthew.towles
 * @param <T>
 */
public class BinaryHeap<T> implements PriorityQueue<T> {

    /**
     * Number of elements
     */
    public int n;
    
    /**
     * Elements stored in array
     */
    public T[] a;
    
    public Comparator c;
    
    
    /**
     * Constructor
     * @param a
     * @param c 
     */
    public BinaryHeap(T[] a, Comparator c) {
        this.a = a;
        this.c = c;
        n = a.length;
        for (int i = n/2 - 1; i >= 0; i--) {
            trickleDown(i);
        }
    }
    
    
    /**
     * Add a new element to array a
     * @time O(log n)
     * @param x
     * @return 
     */
    @Override
    public boolean add(T x) {
        // if a is full, resize it
        if (n + 1 > a.length) {
            resize();
        }
        // actually add x to array and increment n
        a[n++] = x;
        // maintain heap property
        // swap x with parent until x no longer smaller than parent
        bubbleUp(n-1);
        return true;    
    }
    

    /**
     * Removes smallest element - root
     * Maintains heap
     * Replace root with last element
     * Call trickleDown to move element back where it belongs
     * Find new root in process of trickleDown
     * 
     * @time O(log n)
     * @return removed element
     */
    @Override
    public T remove() {
        // x = root
        T x = a[0];
        // root = last element; decrement n
        a[0] = a[--n];
        // move new root down to where it belongs
        trickleDown(0);
        if (3*n < a.length) resize();
        return x;
    }
    
    
    /**
     * Compare element at i to its children
     * If it is smallest then we are done
     * Otherwise, swap this with smallest of children; continue
     * 
     * @param i 
     */
    public final void trickleDown(int i) {
        do {
            int j = -1;
            // index of right child
            int rightIndex = right(i);
            // check if larger than right child
            if (rightIndex < n && c.compare(a[rightIndex], a[i]) < 0) {
                // right child smaller than element
                
                int leftIndex = left(i);
                // check if left child is smaller than right child
                if (c.compare(a[leftIndex], a[rightIndex]) < 0) {
                    // left child is smallest - save its index for swap
                    j = leftIndex;
                } else {
                    // right child smallest - save index for swap
                    j = rightIndex;
                }
            } else { 
                // element < rightChild
                
                int leftIndex = left(i);
                if (leftIndex < n && c.compare(a[leftIndex], a[i]) < 0) {
                    // element > leftChild - save index for swap
                    j = leftIndex;
                }
            }
            // only swap if j was updated with a child's index
            if (j >= 0) {
                // swap elements at indexes i and j
                swap(i, j);
            }
            // current index for element is now j
            i = j;
            // as long as i is not root aka 0, keep going
        } while (i >= 0);
    }
    
    
    /**
     * Swap x with parent until [x > parent]
     * @param i 
     */
    public void bubbleUp(int i) {
        int p = parent(i);
        while (i > 0 && c.compare(a[i], a[p]) < 0) {
            swap(i,p);
            i = p;
            p = parent(i);
        }
    }
    
    
    /**
     * Swap values in a based on positions i, p given
     * @param i - child to become parent
     * @param p - parent to become child
     */
    public void swap(int i, int p) {
        T tmp = a[i];
        a[i] = a[p];
        a[p] = tmp;
    }
          
        
    /**
     * Double size of array
     */
    public void resize() {
        T[] b = (T[])new Object[Math.max(n*2, 1)];
        System.arraycopy(a, 0, b, 0, n);
        a = b;
    }
    
    
    /**
     * @param i
     * @return position of Node's left child
     */
    int left(int i) {
        return 2*i + 1;
    }
    
    
    /**
     * @param i
     * @return position of Node's right child
     */
    int right(int i) {
        return 2*i + 2;
    }
    
    
    /**
     * @param i
     * @return position of node's parent
     */
    int parent(int i) {
        return (i-1)/2;
    }
    
    /**
     *
     * @param x0
     * @param x1
     * @return
     */
    public static int compare(int x0, int x1) {
        return x0 - x1;
    }
    
    
    @Override
    public T findMin() {
        return a[0];
    }
    
}
