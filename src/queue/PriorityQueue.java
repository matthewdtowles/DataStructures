package queue;

/**
 * A queue which each element has a priority associated
 * Higher priority element served before lower
 * 
 * PriorityQueue Implementations {findMin()} | {add(x)/remove()}
 *   BinaryHeap     O(1) | O(log n)
 *   MeldableHeap   O(1) | O(log n)
 * 
 * @author matthew.towles
 * @param <T> - type of PriorityQueue
 */
public interface PriorityQueue<T> extends Queue {
    
    /**
     * @return highest priority item
     */
    public T findMin();
}
