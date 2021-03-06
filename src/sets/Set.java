package sets;

/**
 * Set of unique elements
 * Either ordered or unordered
 * 
 * @author matthew.towles
 * @param <T> - type of set
 */
public interface Set<T> {
    
    /**
     * @return number of elements in the set
     */
    int size();
    
    /**
     * @param x - element to add if not already present
     * @return boolean - true if added, false otherwise
     */
    boolean add(T x);
    
    /**
     * @param x - element to remove
     * @return - element if removed, otherwise null
     */
    T remove(T x);
}
