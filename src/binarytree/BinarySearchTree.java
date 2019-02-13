package binarytree;

import java.util.Comparator;
import list.selist.Node;

/**
 * Binary Search Tree
 * 
 * Implements SSet Interface
 * add, remove, find in O(n) time
 * @author matthew.towles
 * @param <T>
 */
public abstract class BinarySearchTree<T> extends BinaryTree<T> implements sets.SSet {
    
    Comparator c;
    
    /**
     * Search for x and return if found
     * @param x
     * @return x if found, else null
     */
    T findEQ(T x) {
        BTNode u = r;
        while (u != null) {
            int comp = c.compare(x, u.x);
            if (comp < 0) 
                u = u.left;
            else if (comp > 0)
                u = u.right;
            else
                return (T) u.x;
        }
        return null;
    }
     
    
    /**
     * Find smallest value stored in BST >= x
     * @param x
     * @return smallest value >= x
     */
    T bstfind(T x) {
        BTNode w = r, z = null;
        while (w != null) {
            int comp = c.compare(x, w.x);
            if (comp < 0) {
                z = w;
                w = w.left;
            } else if (comp > 0) {
                w = w.right;
            } else {
                return (T) w.x;
            }
        }
        return (T) z.x;
    }
    
    
    
    /**
     * Adding
     */
    
    /**
     * Add new node to BST
     * @param x
     * @return 
     */
//    boolean bstadd(T x) {
//        Node p = findLast(x);
//        return addChild(p, newNode(x));        
//    }
    
    
    /**
     * Find where new x will belong
     * @param x
     * @return 
     */
//    Node findLast(T x) {
//        Node w = r, prev = null;
//        while (w != null) {
//            prev = w;
//            int comp = c.compare(x, w.x);
//            if (comp < 0) {
//                w = w.left;
//            } else if (comp > 0) {
//                w = w.right;
//            } else {
//                return w;
//            }
//        }
//        return prev;
//    }
    
    
    /**
     * Add child to left or right of new parent?
     * @param p
     * @param u
     * @return 
     */
//    boolean addChild(Node p, Node u) {
//        if (p == nil) {
//            r = u;              // inserting into empty tree
//        } else {
//            int comp = c.compare(u.x, p.x);
//            if (comp < 0) {
//                p.left = u;
//            } else if (comp > 0) {
//                p.right = u;
//            } else {
//                return false;   // u.x is already in the tree
//            }
//            u.parent = p;
//        }
//        n++;
//        return true;        
//    }
    
    
    
    /**
     * Removal:
     */
    
    
    /**
     * Remove u and make u.parent the parent of u.child
     * @param u 
     */
//    void splice(Node u) {
//        Node s, p;
//        if (u.left != null) {
//            s = u.left;
//        } else {
//            s = u.right;
//        }
//        if (u == r) {
//            r = s;
//            p = nil;
//        } else {
//            p = u.parent;
//            if (p.left == u) {
//                p.left = s;
//            } else {
//                p.right = s; 
//            }
//        }
//        if (s != nil) {
//            s.parent = p;
//        }
//        n--;
//    }
    
    
    /**
     * Removes u and replaces with w node
     * @param u 
     */
//    public void remove(Node u) {
//        if (u.left == nil || u.right == nil) {
//            splice(u);
//        } else {
//            Node w = u.right;
//            while (w.left != nil) 
//                w = w.left;
//            u.x = w.x;
//            splice(w);
//        }
//    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public Object remove(Object x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Node newNode(T x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}