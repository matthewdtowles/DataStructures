package list.dllist;

/**
 *
 * @author matthew.towles
 * @param <T>
 */
public class Node<T> {
    /**
     * Node data
     */
    public T x;
    
    /**
     * Ref to node before this one
     */
    public Node prev;
    
    /**
     * Ref to node after this one
     */
    public Node next;
}
