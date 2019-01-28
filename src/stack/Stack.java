package stack;

/**
 * Represents a collection of elements
 * Uses LIFO for adding/removing
 * 
 * @author matthew.towles
 * @param <T> - Stack type
 */
public interface Stack<T> {
    
    /**
     * Adds x to the top of the Stack
     * 
     * @param x 
     * @return x if push successful, else null
     */
    T push(T x);
    
    /**
     * Removes last item added to Stack and returns it
     * 
     * @return - removed item
     */
    T pop();
}
