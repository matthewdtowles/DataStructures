/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytree;

/**
 *
 * @author matthew.towles
 */
public class BinaryTree {
    
    /**
     * Root node
     */
    BTNode r;
    
    
    
    /**
     * Compute depth of a node
     * Counts number of steps on path from u to root
     * 
     * @param u - node to count depth of
     * @return number of steps on path from u to root
     */
    int depth(BTNode u) {
        int d = 0;
        while (u != r) {
            u = u.parent;
            d++;
        }
        return d;
    }
    
    
    /**
     * Recursively count sizes of two subtrees rooted at children of u
     * @param u
     * @return number of nodes in binary tree
     */
    int size(BTNode u) {
        if (u == null) {
            return 0;
        }
        return 1 + size(u.left) + size(u.right);
    }
    
    
    /**
     * Compute height of a node
     * Get height of node's subtrees
     * Take the larger of the two, + 1 and return it
     * @param u
     * @return height of u
     */
    int height(BTNode u) {
        if (u == null) {
            return -1;
        }
        return 1 + Math.max(height(u.left), height(u.right));
    }
    
    
    /**
     * Recursive way to Depth-first traverse BT
     * @param u 
     */
    void traverse(BTNode u) {
        if (u == null){
            return;
        }
        traverse(u.left);
        traverse(u.right);
    }
    
    
    /**
     * Depth-first Non-recursive way to traverse BT
     */
    void traverse2() {
        BTNode u = r, prev = null, next;
        while (u != null) {
            if (prev == u.parent) {
                if (u.left != null) {
                    next = u.left;
                }
                else if (u.right != null) {
                    next = u.right;
                }
                else {
                    next = u.parent;
                }
            } else if (prev == u.left) {
                if (u.right != null) {
                    next = u.right;
                }
                else {
                    next = u.parent;
                }
            } else {
                next = u.parent;
            }
            prev = u;
            u = next;
        }
    }
    
    /**
     * Breadth First Traversal
     */
//    void bfTraverse() {
//        queue.Queue<Node> q = new LinkedList<Node>();
//        if (r != nil) q.add(r);
//        while (!q.isEmpty()) {
//            Node u = q.remove();
//            if (u.left != nil) q.add(u.left);
//            if (u.right != nil) q.add(u.right);
//        }
//    }
        
}
