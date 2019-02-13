package heap;

import java.util.Comparator;
import queue.PriorityQueue;

/**
 * Meldable Heap
 * 
 * Implements priority queue
 * add(x) and remove() in O(log n) time
 * 
 * No restrictions on a shape of binary tree underlying
 * add(x) and remove() implemented in terms of merge(h1,h2) 
 * merge(h1,h2) takes two heap nodes, merges them
 *  then returns a heap node that is the root of a heap that contains all
 *  elements in subtree rooted at h1 and for h2 as well
 * 
 * @author matthew.towles
 * @param <T>
 */
public class MeldableHeap<T> implements PriorityQueue<T> {
    
    
    /**
     * Root node
     */
    Node r;
    
    int n;
    
    Comparator c;
    
    
    /**
     * @time O(log n)
     * @param x
     * @return 
     */    
    @Override
    public boolean add(T x) {
       Node<T> u = new Node();
        u.x = x;
        // merge new node with root
        r = merge(u, r);
        r.parent = null;
        n++;
        return true;
    }

    
    /**
     * @time O(log n)
     * @return 
     */
    @Override
    public T remove() {
        T x = (T) r.x;
        r = merge(r.left, r.right);
        if (r != null) {
            r.parent = null;
        }
        n--;
        return x;
    }
    
    /**
     * remove(u) - remove node u and its key u.x from heap in O(log n)
     * 
     * absorb(h) - add all element of MeldableHeap h to this heap in O(log n)
     */
    
    
    /**
     * If either h1 or h2 is null, merge with empty set and just return
     * Otherwise, check if h1.x or h2.x smaller
     * Merge the larger one into the smaller one's child
     * We make sure h1 is smaller than h2 by reversing rolls and calling merge
     * 
     * Merge h2 into one of h1's children at random (left/right)
     * Do this last step recursively 
     * Finally return h1 - our new heap
     * 
     * @param h1
     * @param h2
     * @return new heap - h1 with h2 merged into one of its children
     */
    public Node<T> merge(Node<T> h1, Node<T> h2) {
        if (h1 == null) {
            // h1 + h2 = h2 = h2 + null
            return h2;
        }
        if (h2 == null) {
            // h1 = h1 + h2 = null + h1
            return h1;
        }
        // h1 and h2 have content:
        // make sure h1.x <= h2.x - otherwise call merge(h2, h1)
        if (c.compare(h2.x, h1.x) < 0) {
            return merge(h2, h1);
        }
        // now we know h1.x <= h2.x
        // random - 50/50 true/false
        if (randomBoolean()) { // 50% chance - random:
            h1.left = merge(h1.left, h2);
            h1.left.parent = h1;
        } else {                  // 50% chance - random:
            h1.right = merge(h1.right, h2);
            h1.right.parent = h1;
        }
        return h1;
    }

    /**
     * 50/50 returns true/false
     * @return 
     */
    public boolean randomBoolean() {
        return Math.random() > 0.5;
    }
    
    
    @Override
    public T findMin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }            
}
