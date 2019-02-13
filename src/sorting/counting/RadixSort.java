package sorting.counting;

/**
 * RadixSort
 * 
 * Sorts w-bit integers using w/d passes of
 * count sort to sort integers d bits at a time
 * 
 * Sorts integers by least significant d bits
 * then their next significant d bits, etc...
 * 
 * Refer to http://opendatastructures.org/ods-java/11_2_Counting_Sort_Radix_So.html
 * figure 11.8
 * 
 * @author matthew.towles
 * @date Feb 13, 2019
 */
public class RadixSort {
    
    int w;
    int d;
    
    public RadixSort(int w, int d) {
        this.w = w;
        this.d = d;
    }

    int[] sort(int[] a) {
        int[] b = null;
        
        for (int p = 0; p < w/d; p++) {
            int c[] = new int[1<<d];
            b = new int[a.length];
            // next 3 for loops implement count sort
            // breaking down:  (a[i] >> d * p) & ((1 << d) - 1)
            // extracts the integer whose binary representation
            // is given by bits (p + 1)d - 1,...,pd of a[i]
            for (int i = 0; i < a.length; i++) {
                c[(a[i] >> d * p) & ((1 << d) - 1)]++;
            }
            for (int i = 1; i < 1<<d; i++) {
                c[i] += c[i-1];
            }
            for (int i = a.length - 1; i >= 0; i--) {
                b[--c[(a[i] >> d * p) & ((1 << d) - 1)]] = a[i];
            }
        }
        return b;
    }
}
