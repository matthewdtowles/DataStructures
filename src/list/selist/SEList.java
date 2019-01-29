package list.selist;

/**
 * Space-Efficient Linked-List
 * Implements the List Interface
 * get/set time: O(1 + min(i, n-i)/b)
 * add(i,x)/remove(i) ops in O(b + min(i, n-i)/b) 
 * 
 * Space used that stores n elements is:  n + O(b + n/b)
 * 
 * SEList is a trade off between ArrayList and DLList
 * Mix of these two structs depends on block size b
 * If b is very low then this behaves like a DLList
 * If b is very high or b > n, then all elements in single array
 * and it is like an array list
 * 
 * @author matthew.towles
 * @param <T>
 */
public class SEList<T> {
    
    /**
     * Number of elements
     */
    int n;
    
    /**
     * Max number of elements per block - 1
     */
    int b;
    
    /**
     * Dummy node to connect back to front
     */
    Node dummy;
    
    

    /**
     * Running time determined by getLocation 
     * @time O(1 + min(i, n-i)/b)
     * @param i
     * @return element at index i
     */
    T get(int i) {
        if (i < 0 || i > n - 1) {
            throw new IndexOutOfBoundsException();
        }
        Location l = getLocation(i);
        return (T)l.node.block.get(l.elementIndex);
    }
    

    /**
     * @time O(1 + min(i, n-i)/b)
     * @param i
     * @param x
     * @return element set
     */
    T set(int i, T x) {
        if (i < 0 || i > n - 1) {
            throw new IndexOutOfBoundsException();
        }
        Location l = getLocation(i);
        T y = (T)l.node.block.get(l.elementIndex);
        l.node.block.set(l.elementIndex,x);
        return y;
    }
    
   
    /** 
     * Add x to end of list
     * @param x
     * @return boolean
     */
    boolean add(T x) {
        Node last = dummy.prev;
        // last block full or does not exist
        if (last == dummy || last.block.size() == b+1) {
            // add a new last block before dummy
            // last = new block before dummy
            last = addBefore(dummy);
        }
        // should be add(i,x)
        // append element x to last block
        last.block.add(x);
        n++;
        return true;
    }
    
    
    /**
     * Add new block before given block
     * 
     * @param node
     * @return newNode added
     */
    Node addBefore(Node node) {
        // new block
        Node newNode = new Node(b);
        // newNode -> node
        newNode.next = node;
        // previous <- newNode -> node
        newNode.prev = node.prev;
        // previous <-> newNode -> node
        node.prev.next = newNode;
        // previous <-> newNode <-> node
        node.prev = newNode;
        return newNode;
    }
	
    
    /**
     * Insert element into iTH position of List
     * @time O(b + min(i, n-i)/b) with Amortization
     * @param i
     * @param x 
     */
    void add(int i, T x) {
        if (i < 0 || i > n) {
            throw new IndexOutOfBoundsException();
        }
        
        // add to the end 
        if (i == n) {
            add(x);
            return;
        }
        
        // find index and block of i 
        Location l = getLocation(i);
        // location's block/node 
        Node u = l.node;
        // shifts 
        int r = 0;
        // number of shifts less than size of block 
        // and our node is not dummy 
        // and block is full
        while (r < b && u != dummy && u.block.size() == b+1) {
            u = u.next;
            r++;
        }
        if (r == b) {      
            // b blocks each with b+1 elements
            spread(l.node);
            u = l.node;
        } 
        
        if (u == dummy) {  
            // ran off the end - add new node
            u = addBefore(u);
        }
        while (u != l.node) { 
            // work backwards, shifting elements
            u.block.add(0, u.prev.block.remove(u.prev.block.size()-1));
            u = u.prev;
        }
        u.block.add(l.elementIndex, x);
        n++;
    }
    
    
    /**
     * Removes iTH el from SEList
     * @time O(b + min(i, n-i)/b) with Amortization
     * @param i
     * @return removed element
     */
    T remove(int i) {
        if (i < 0 || i > n - 1) {
            throw new IndexOutOfBoundsException();
        }
        
        Location l = getLocation(i);
        T y = (T)l.node.block.get(l.elementIndex);
        Node u = l.node;
        int r = 0;
        
        while (r < b && u != dummy && u.block.size() == b-1) {
            u = u.next;
            r++;
        }
        
        if (r == b) {  
            // b blocks each with b-1 elements
            gather(l.node);
        }
        u = l.node;
        u.block.remove(l.elementIndex);
        
        while (u.block.size() < b-1 && u.next != dummy) {
            u.block.add(u.next.block.remove(0));
            u = u.next;
        }
        
        if (u.block.isEmpty()) {
            remove(u);
        }
        n--;
        return y;
    }
    
    
    /**
     * Remove node block
     * @param u - node to remove
     */
    void remove(Node u) {
        u.prev.next = u.next;
        u.next.prev = u.prev;
    }
	
    
    /**
     * @time O(b^2)
     * @param u
     */
    void spread(Node u) {
        Node w = u;
        for (int j = 0; j < b; j++) {
            w = w.next;
        }
        w = addBefore(w);
        while (w != u) {
            while (w.block.size() < b)
                w.block.add(0,w.prev.block.remove(w.prev.block.size()-1));
            w = w.prev;
        }
    }
	
    
    /**
     * @time O(b^2)
     * @param u 
     */
    void gather(Node u) {
        Node w = u;
        for (int j = 0; j < b-1; j++) {
            while (w.block.size() < b) {
                w.block.add(w.next.block.remove(0));
            }
            w = w.next;
        }
        remove(w);
    }
	

    /**
     * Returns Location(Node, index) of element
     * Time due to skipping b-1 el each step
     * 
     * @time O(1 + min(i, n-i)/b) 
     * @param i
     * @return 
     */
    Location getLocation(int i) {
        // if looking in first half, start at beginning
        if (i < n/2) {
            Node u = dummy.next;
            while (i >= u.block.size()) {
                i -= u.block.size();
                u = u.next;
            }
            return new Location(u, i);
        } else {
            // i in second half of SEList, so start at end 
            Node u = dummy;
            int idx = n;
            while (i < idx) {
                u = u.prev;
                idx -= u.block.size();
            }
            return new Location(u, i-idx);
        }
    }
 
    
}