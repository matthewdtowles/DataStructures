package recursion;

/**
 * Fibonacci
 * 
 * @author matthew.towles
 * @date Feb 11, 2019
 */
public class Fibonacci {

    /**
     * @param n
     * @return nth int in fibonacci sequence
     */
    public static int fibonacci(int n) {
        if (n == 0) 
            return 0; // base case 1
        if (n == 1)
            return 1; // base case 2
        // recursive case:
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
