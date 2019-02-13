package sorting.comparison;

import java.util.Comparator;

/**
 * QuickSort
 * Picks a random pivot element: `x`
 * From a collection: `a`
 * Partition `a` into 3:
 * 1. elements less than `x`
 * 2. elements equal to `x`
 * 3. elements greater than `x`
 * Then recursively sort first and third
 * 
 * All done in place so no copies
 * To accomplish this, sort(a,i,n,c) 
 * only sort subarray a[i],...,a[i+n-1]
 * Initially called with a, 0, a.length, c
 * which is whole array of a
 * 
 * The in place partitioning swaps elements
 * in a and computes indices p and q:
 *          x > a[i]: if p >= i >= 0
 * a[i] {   = x:      if q > i > p
 *          > x       if n-1 >= i >= q
 * Iteratively p++ and q--
 * While maintaining first and last of 3 conditions
 * Each step, el at j is moved to front or back
 * 
 * This works very much like a random BST
 * With root node being like the pivot
 * and then all following nodes that are less to the left
 * and greater nodes to the right
 * 
 * With quicksort, another random pivot is chosen in the
 * "smaller" sub-array and then the "larger" array
 * 
 * Max no. of comparisons expected is 2n(ln)n+O(n)
 * 
 * @author matthew.towles
 * @param <T>
 * @date Feb 13, 2019
 */
public class QuickSort<T> {
    
    /**
     * Called first which calls other sort()
     * @param <T>
     * @param a - array to sort
     * @param c - comparator for compare method 
     */
    <T> void sort(T[] a, Comparator<T> c) {
        sort(a, 0, a.length, c);
    }
    
    
    /**
     * Called by initial sort() method
     * @param <T>
     * @param a - array to sort
     * @param i - index to begin at
     * @param n - number of elements in array/subarray
     * @param c - comparator for compare method
     */
    <T> void sort(T[] a, int i, int n, Comparator<T> c) {
        if (n <= 1) {
            return;
        }
        
        // this really should be a random pivot, but middle isn't too bad
        T x = a[n/2];
        
        int p = i - 1;
        int j = i;
        int q = i + n;
        
        // a[i...p] < x, a[p+1...q-1]??x, a[q...i+n-1] > x
        while(j < q) {
            int comp = c.compare(a[j], x);
            // move to beginning of array
            if (comp < 0) {
                swap(a, j++, ++p);
            }
            // move to end of array
            else if (comp > 0) {
                swap(a, j, --q);
            }
            // keep in middle of array
            else {
                j++;
            }
        }
        
        // a[i...p] < x, a[p+1...q-1] = x, a[q...i+n-1] > x
        sort(a, i, p - i + 1, c);
        sort(a, q, n - (q - i), c);
    }

    private <T> void swap(T[] a, int i, int i0) {
        T tmp = a[i];
        a[i] = a[i0];
        a[i0] = tmp;
    }
}
