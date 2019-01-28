package list.dllist;

import list.List;

/**
 *
 * @author matthew.towles
 * @param <T>
 */
public class DLList<T> implements List<T> {

    /**
     * length of the DLList
     */
    public int n;
    
    /**
     * the dummy node that we will always have
     */
    public Node dummy;

    
    /**
     * constructor - initialize dummy and size
     */
    public DLList() {
        dummy = new Node();
        dummy.next = dummy;
        dummy.prev = dummy;
        n = 0;
    }

    
    @Override
    public int size() {
        return n;
    }
    
    
    /** 
     * get the value of iTH node in DLL
     * 
     * @time O(1 + min(i, n-i)) 
     * @param i
     * @return element at i
     */
    @Override
    public T get(int i) {
        // dummy node doesn't count towards n
        if (i < 0 || i > n - 1) {
            throw new IndexOutOfBoundsException();
        }
        return (T)getNode(i).x;
    }

    // 
    /**
     * set value of iTH node in DLL to x
     * 
     * @time O(1 + min(i, n-i)) time -- time to access i 
     */
    @Override
    public T set(int i, T x) {
        if (i < 0 || i > n - 1) {
            throw new IndexOutOfBoundsException();
        }
        Node u = getNode(i);
        // set new data y equal to retreived node data 
        T y = (T)u.x;
        // set u.x to arg x
        u.x = (T)x;
        // give back the old value of u.x
        return y;
    }
    

    /**
     * @time O(1 + min(i, n-i))
     * @param i
     * @param x 
     */
    @Override
    public void add(int i, T x) {
        if (i < 0 || i > n) {
            throw new IndexOutOfBoundsException();
        }
        addBefore(getNode(i), x);
    }
    

    /**
     * @time O(1 + min(i, n-i)) time due to getNode(i) look up 
     */
    @Override
    public T remove(int i) {
        if (i < 0 || i > n) {
                throw new IndexOutOfBoundsException();
        }
        // this is all our time -- finding the iTH node 
        Node w = getNode(i);
        // calling our remove(Node w) fn
        remove(w);
        return (T)w.x;
    }


    /**
     * @time O(1 + min(i, n-i))
     * @param i
     * @return 
     */
    public Node getNode(int i) {
        Node p = null;
        // if node is in first half of DLL 
        if (i < n/2) {
            p = dummy.next;
            // loop til we get to the node 
            for (int j = 0; j < i; j++) {
                p = p.next;
            }
        } else {
            // looking for node in 2nd half of DLL 
            p = dummy;
            // loop from top down to iTH node 
            for (int j = n; j > i; j--) {
                p = p.prev;
            }
        }
        return p;
    }

    /**
     * adds new node with data x before Node w 
     * @param w
     * @param x
     * @return 
     */
    public Node addBefore(Node w, T x) {
        Node u = new Node();
        u.x = x;
        // both pointing to same prev 
        u.prev = w.prev;
        // u.prev and u have same next now
        u.next = w;
        // u.next is w ergo u.next.prev is w.prev 
        u.next.prev = u;
        u.prev.next = u;
        n++;
        return u;
    }

    
    /**
     * removes Node from DLL 
     * @param w 
     */
    public void remove(Node w) {
        // tell prev to skip over w 
        w.prev.next = w.next;
        // tell next to skip w for its prev ref
        w.next.prev = w.prev;
        // decrement since we lost w 
        n--;
    }
}
