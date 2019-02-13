package sorting.comparison;

import java.util.Arrays;
import java.util.Comparator;

/**
 * MergeSort
 * 
 * Uses recursive divide and conquer
 * If a.length is 1 or less
 *   then a is already sorted
 * Else
 *   split a in half:
 *     a0 = a[0], ... , a[n/2 - 1]
 *     a1 = a[n/2], ... , a[n - 1]
 * Recursively sort a0 and a1
 * Then merge the sorted a0 and a1
 * 
 * @author matthew.towles
 * @param <T> data type we will sort
 * @date Feb 13, 2019
 */
public class MergeSort<T> {

    /**
     * The sorting part of the algorithm
     * Other part is merging
     * How sorting works:
     * If a is one element or less then it is sorted
     * So split a in half until we reach this
     * Then merge sorted arrays
     * Note that as they are merged, the new arrays
     * are still sorted and so the final array is sorted
     * 
     * @param <T>
     * @param a
     * @param c 
     */
    <T> void sort(T[] a, Comparator<T> c) {
        if (a.length <= 1) {
            return;
        }
        T[] a0 = Arrays.copyOfRange(a, 0, a.length/2);
        T[] a1 = Arrays.copyOfRange(a, a.length/2, a.length);
        sort(a0, c);
        sort(a1, c);
        merge(a0, a1, a, c);
    }
    
    
    /**
     * Merge part of algorithm
     * Loop through all elements in a0, a1
     * 1. if looked a0 exhausted
     *    then a.next = a1.next
     *    and increment i1
     * 2. or if a1 exhausted
     *    then a.next = a0.next
     *    and increment i0
     * 3. or if a1.next > a0.next 
     *    a.next = a0.next
     *    and increment i0
     * 4. if none of the above:
     *    a.next = a1.next
     *    increment i1
     * 
     * Succinctly:
     * If either half has been looped through
     * insert next element from the other half
     * Otherwise check if a0 or a1 next element is larger
     * Insert the smaller one into a
     * 
     * Performs at most (n-1) comparisons
     * before a0 or a1 have been looped through
     * 
     * 
     * @param <T> - data type being merged
     * @param a0 - first half
     * @param a1 - second half
     * @param a - array merging into
     * @param c - comparator for compare(a,b) method
     */
    <T> void merge(T[] a0, T[] a1, T[] a, Comparator<T> c) {
        int i0 = 0;
        int i1 = 0;
        for (int i = 0; i < a.length; i++) {
            // if looked through all of a0
            // next element in a is next one in a1
            if (i0 == a0.length) {
                a[i] = a1[i1++];
            }
            // if looked through all of a1
            // next el in a is next one in a0
            else if (i1 == a1.length) {
                a[i] = a0[i0++];
            }
            // if a0's el < a1's, insert a0[i0] and ++i0
            else if (c.compare(a0[i0], a1[i1]) < 0) {
                a[i] = a0[i0++];
            }
            // insert a1[i1] into a
            else {
                a[i] = a1[i1++];
            }
        }
    }
}
