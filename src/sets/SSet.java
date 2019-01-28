package sets;

/**
 * Represents a sorted set of elements
 * Stores elements from some total order
 * This allows for two elements to be compared
 * Supports size(), add(x), remove(x) exactly as USet
 * 
 * Slower runtime that USet
 * Higher implementation complexity than USet
 * 
 * SSet Implementations {find(x)} | {add(x)/remove(x)}
 *   SkiplistSSet   O(log n) | O(log n)
 *   Treap          O(log n) | O(log n)
 *   ScapegoatTree  O(log n) | O(log n)
 *   RedBlackTree   O(log n) | O(log n)
 *   BinaryTrie^    O(w)     | O(w)
 *   XFastTrie^     O(log w) | O(w)
 *   YFastTrie^     O(log w) | O(log w)
 *   BTree          O(log n) | O(B + log n)
 * ^ denotes structure only stores w-bit integer data
 * 
 * @author matthew.towles
 * @param <T> - type of sorted set
 */
public interface SSet<T> extends Set {
    
    /**
     * Locate x in the sorted set
     * Returns result even if no element equal to x in the set
     * 
     * @param x - element to find
     * @return the smallest element that is >= x, else null
     */
    public T find(T x);
}
