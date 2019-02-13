package sorting.comparison;

import heap.BinaryHeap;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * HeapSort
 * An in-place sorting algorithm
 * Uses BinaryHeap data structure
 * BinaryHeap is a heap that uses an array
 * HeapSort converts input array `a`
 * into a heap and extracts min value (repeatedly)
 * 
 * It does so because heaps have lowest value
 * at a[0]
 * 
 * Repeatedly swaps a[0] and a[n-1] 
 * decrements n
 * and calls trickleDown(0) so that a[0],...a[n-2]
 * are a valid heap
 * 
 * Process ends when n=0
 * And elements of a are in descending order
 * So reverse a to obtain final order
 * 
 * Key sub-routine is constructor for turning
 * unsorted array a into a heap
 * In a binary heap, children of a[i] are at
 * positions a[2i+i] and a[2i+2]
 * This implies that each element in latter
 * half of a have no children and so each
 * is a sub-heap of size 1
 * By the time trickleDown(i) is called each of
 * the two children of a[i] are the root of a sub heap
 * So calling trickleDown(i) makes a[i] into the root
 * of its own subheap
 * 
 * The "bottom-up" strategy detailed above works better
 * than just calling add(x) n times which would run in n log n
 * Bottom up strategy is in O(n) time
 * 
 * TLDR: 
 * 1. transform array to heap
 * 2. repeatedly extract min from a
 * 3. reverse elements in a
 * 
 * Note: the iTH call operates on a heap size of n-i
 * and performs no more than 2log(n-i) compares
 * 
 * @author matthew.towles
 * @date Feb 13, 2019
 */
public class HeapSort {

    <T> void sort(T[] a, Comparator<T> c) {
        BinaryHeap<T> h = new BinaryHeap<>(a, c);
        while (h.n > 1) {
            h.swap(--h.n, 0);
            h.trickleDown(0);
        }
        Collections.reverse(Arrays.asList(a));
    }
}
