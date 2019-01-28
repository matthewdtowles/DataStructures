package queue;

import java.util.NoSuchElementException;

/**
 *
 * @author matthew.towles
 * @param <T> - type of ArrayQueue
 */
public class ArrayQueue<T> implements Queue<T> {

    /**
     * Array of elements backing queue
     */
    T[] a;
    
    /**
     * Next element to remove
     */
    int j;
    
    /**
     * Number of elements in the queue
     */
    int n;
    
    
    /**
     * Add element x to a[]
     * Check if a[] is full first
     * Call resize() if a is full
     * Stores x in a[(j + n)%a.length]
     * 
     * @time O(1) - ignoring resize()
     * @param x element added to a[]
     * @return true if added, else false
     */
    @Override
    public boolean add(T x) {
        if (n + 1 > a.length) {
            resize();
        }
        a[(j+n) % a.length] = x;
        n++;
        return true;    
    }

    
    /**
     * @time O(1) - ignoring resize()
     * @return removed element
     */
    @Override
    public T remove() {
        if (n == 0) {
            throw new NoSuchElementException();
        }
        T x = a[j];
        j = (j + 1) % a.length;
        n--;
        if (a.length >= 3*n) {
            resize();
        }
        return x;   
    }
    
    
    /**
     * Resizes backing array a[]
     * 
     * @time O(n)
     */
    public void resize() {
        T[] b = (T[])new Object[Math.max(n*2, 1)];
        for (int k = 0; k < n; k++) {
            b[k] = a[(j+k) % a.length];
        }
        a = b;
        j = 0;
    }
    
}
