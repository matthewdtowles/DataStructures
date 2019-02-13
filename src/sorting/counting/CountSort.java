package sorting.counting;

import java.util.Arrays;

/**
 * CountSort
 * Sorts an input array - a
 * a consists of n integers
 * each integer in range of (0,...,k-1)
 * 
 * Sorts a using aux array c of counters
 * Outputs sorted a as aux array b
 * 
 * The algorithm:
 * for each i in {0,...,k-1}:
 *   c[i] = number of occurrences of i in a
 * 
 * Output will look like:
 *   c[0] - number of occurences of 0
 *   c[1] - number of occurences of 1
 *   ...
 *   c[k-1] - occurences of k-1
 * 
 * 
 * E.g:
 *   a:  {3,2,1,5,3}
 *   c:  {1,2,4,4,5}
 *   b:  {1,2,3,3,5}
 * 
 * Runs in O(n+k) time
 * 
 * @author matthew.towles
 * @date Feb 13, 2019
 */
public class CountSort {
    
    /**
     * Counting sort method
     * @param a - array to sort
     * @param k - range of values in a
     * @return b - sorted array
     */
    public int[] sort(int [] a, int k) {
        
        // aux array c is size of k
        int c[] = new int[k];
        
        // counts number of occurrences of i in a
        // saves to c[i]
        for (int i = 0; i < a.length; i++) {
            // a[i] becomes a key in c
            // and we count up how many of that key
            // are in a and keep it in c
            System.out.println("a[" + i + "]: " + a[i]);
            c[a[i]]++;
        }
        
        // computes a running sum of counters
        // so that c[i] bcomes number of elements in a
        // that are less than/equal to i
        for (int i = 1; i < k; i++) {
            c[i] += c[i-1];
        }
        
        // output array same length as a
        int b[] = new int[a.length];
        
        // scan a backwards and place its elements
        // into output array, b
        // a[i] is placed at location b[c[i] - 1]
        // c[i] value is decremented
        for (int i = a.length - 1; i >= 0; i--) {
            System.out.println("loop " + i + " - before - " + Arrays.toString(b));
            b[--c[a[i]]] = a[i];
            System.out.println("a[i] = " + a[i]);
            System.out.println("after - " + Arrays.toString(b));
        }
        
        return b;
    }
    
    public void test(){
        int[] a = {7,2,9,0,1,2,0,9,7,4,4,6,9,1,0,9,3,2,5,9};
        CountSort cs = new CountSort();
        int[] b = cs.sort(a, 10);
        for(int z : b) {
            System.out.print(z + ", ");
        }
    }
}
