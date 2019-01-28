package queue;

/**
 * Represents a collection of elements 
 * Add elements and remove the next element (FIFO)
 * Removes items in the order they were added
 * 
 * @author matthew.towles
 * @param <T> - Queue type
 */
public interface Queue<T> {

    /**
     * Add x to queue
     * Often called "enqueue()"
     * 
     * @param x - x will be added to Queue
     */
    public void add(T x);
    
    /**
     * Remove first item from queue and return it
     * Often called "dequeue()"
     * Priority queue may use something like "deleteMin()"
     * 
     * @return removed item
     */
    public T remove();
}
