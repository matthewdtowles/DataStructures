package list;

/**
 * Represents a sequence X[0], X[1], ..., X[n - 1]
 * Efficiently can implement Stack, Deque, Queue interfaces
 * 
 * Implementations {get(i)/set(i,x)} | {add(i,x)/remove(i)}:
 *   ArrayStack         O(1)                    | O(1 + n - i)
 *   ArrayDeque         O(1)                    | O(1 + min(i, n - i))
 *   DualArrayDeque     O(1)                    | O(1 + min(i, n - i))
 *   RootishArrayStack  O(1)                    | O(1 + n - i)
 *   DLList             O(1 + min(i, n - i))    | O(1 + min(i, n - i))
 *   SEList             O(1 + min(i, n - i)/b)  | O(b + min(i, n - i)/b)
 *   SkiplistList       O(log n)                | O(log n)
 * 
 * @author matthew.towles
 * @param <T> - List type
 */
public interface List<T> {
    
    /**
     * Returns length of list
     * @return length of the list
     */
    int size();
    
    /**
     * Return value at index i
     * @param i - index to get value from
     * @return value at index i
     */
    T get(int i);
    
    /**
     * Set value of list at index i to x
     * @param i - index to set
     * @param x - value to set at index i
     * @return value set, else null
     */
    T set(int i, T x);
    
    /**
     * Add value x at index i
     * Displaces x[i], ..., x[n - 1]
     * Each index after x[i] gets incremented
     * Increment size
     * Set x[i] = x
     * 
     * add(0, x) equivalent Deque.addFirst(x)
     * add(size(), x) equivalent Deque.addLast(x)
     * 
     * @param i - index to insert new value, x to
     * @param x - value to insert at i
     */
    void add(int i, T x);
    
    /**
     * Remove value at index i
     * Displaces x[i+1], ..., x[n-1]
     * Each of these displaced elements must be decremented
     * Decrement size as well
     * 
     * remove(0) equivalent Deque.removeFirst()
     * remove(size() - 1) equivalent Deque.removeLast()
     * 
     * @param i - index to remove
     * @return value removed
     */
    T remove(int i);
}
