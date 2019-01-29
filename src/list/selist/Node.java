package list.selist;

/**
 * Node for Space-Efficient Linked Lists
 * 
 * @author matthew.towles
 * @param <T>
 */
public class Node<T> {
    list.BDeque<T> block;
    Node<T> prev;
    Node<T> next;
    
    public Node(int b) {
        block = new list.BDeque<>(b);
    }
}
