package list.selist;

/**
 * Node for Space-Efficient Linked Lists
 * 
 * @author matthew.towles
 * @param <T>
 */
public class Node<T> {
    public list.BDeque<T> block;
    public Node<T> prev;
    public Node<T> next;
    public Node right;
    public Node left;
    
    public Node(int b) {
        block = new list.BDeque<>(b);
    }
}
