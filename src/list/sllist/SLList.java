package list.sllist;

/**
 * Singly-Linked List
 * 
 * @author matthew.towles
 * @param <T>
 */
public class SLList<T> implements stack.Stack<T>, queue.Queue<T> {
    
    /**
     * Left-most/Lowest indexed node
     */
    Node head;
    
    /**
     * Right-most/highest indexed node
     */
    Node tail;
    
    /**
     * Number of elements
     */
    int n;


    /**
     * @time O(1)
     * @param x
     * @return 
     */
    @Override
    public T push(T x) {
        Node u = new Node();
        u.x = x;
        u.next = head; // head will be 2nd behind u now 
        head = u;
        if (n == 0) {
            tail = u;
        }
        n++;
        return x;
    }


    /**
     * the returned value is copied from head node
     * then head node is dereferenced
     * i guess the system just knows that its free memory now?
     * 
     * @time O(1)
     * @return popped element
     */
    @Override
    public T pop() {
        // no nodes to return 
        if (n == 0) {
            return null;
        }
        // get value from head to return 
        T x = (T) head.x;
        // head now is element after head 
        head = head.next;
        // decrement length and check if last el is being removed
        if (--n == 0) {
            tail = null;
        }
        return x;
    }


    /**
     * Same as pop method
     * Implementation of queue method
     * 
     * @time O(1)
     * @return 
     */
    @Override
    public T remove() {
        return pop();
    }
    

    /**
     * Adds Node to the end of the linked-list (tail)
     * @time O(1)
     * @param x
     * @return boolean
     */
    @Override
    public boolean add(T x) {
        Node u = new Node();
        u.x = x;
        // if no nodes in list right now then head and tail = u
        if (n == 0) {
            head = u;
        } else {
            // (( tail.next was = null before ))
            // current tail needs to reference new node 
            tail.next = u;
        }
        // new node is tail 
        tail = u;
        n++;
        return true;
    }
}
