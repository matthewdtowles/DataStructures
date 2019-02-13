package sandbox;

import sorting.counting.CountSort;

/**
 * Test
 * 
 * @author matthew.towles
 * @date Feb 13, 2019
 */
public class Test {
    public static void main(String[] args) {
        int[] a = {7,2,9,0,1,2,0,9,7,4,4,6,9,1,0,9,3,2,5,9};
        CountSort cs = new CountSort();
        int[] b = cs.sort(a, 10);
        for(int z : b) {
            System.out.print(z + ", ");
        }
    }
}
