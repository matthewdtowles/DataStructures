package deque;

/**
 * Represents a sequence of elements with front and back
 * Elements can be added at the front or the back
 * Note:  a stack uses addFirst(x), removeFirst()
 *        a queue uses addLast(x), removeFirst()
 * 
 * @author matthew.towles
 * @param <T> -  Deque type
 */
public interface Deque<T> {
    
    /**
     * Like Stack::push(x) 
     * @param x 
     */
    void addFirst(T x);
    
    /**
     * Like Queue::add(x)
     * @param x 
     */
    void addLast(T x);
    
    /**
     * Remove and return the first or top item
     * Like Queue::remove() and Stack::pop()
     * 
     * @return removed item
     */
    T removeFirst();
    
    /**
     * Remove and return the last or bottom item
     * @return removed item
     */
    T removeLast();
}
