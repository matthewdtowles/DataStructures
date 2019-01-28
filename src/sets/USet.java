package sets;

/**
 * Unordered Set of unique elements
 * Mimics a mathematical set
 * No specific order
 * 
 * USet Implementations {find(x)} | {add(x)/remove(x)}:
 *   ChainedHashTable   O(1) | O(1)
 *   LinearHashTable    O(1) | O(1)
 * 
 * @author matthew.towles
 * @param <T> - type of Unordered Set
 */
public interface USet<T> extends Set {
    
    /**
     * @param x - element to find
     * @return - element if exists, otherwise null
     */
    T find(T x);
}
