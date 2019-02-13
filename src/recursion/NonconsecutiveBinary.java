package recursion;

/**
 * NonconsecutiveBinary
 * 
 * @author matthew.towles
 * @date Feb 11, 2019
 */
public class NonconsecutiveBinary {
    
    /**
     * Sees if string is correct length
     * If it is: print it out
     * If not: add "0" and continue to build
     * Add "1" to string if current bit not "1"
     * @param s - string that will be printed out
     * @param n - how many bits number will be
     */
    public static void nextBit(String s, int n) {
        // base case
        if (s.length() == n) {
            System.out.println(s);
            return;
        }
        // recursive case: always add 0
        nextBit(s + "0", n); 
        // recursive case: do not allow consecutive 1's
        if (! s.endsWith("1")) {
            nextBit(s + "1", n);
        }
    }
}
