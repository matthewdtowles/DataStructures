package binarytree;

/**
 *
 * @author matthew.towles
 * @param <T>
 */
public class BinaryTree<T> {
    
    /**
     * Root node
     */
    public BTNode root;
    
    public int size;
    
    
    /**
     * Compute depth of a node
     * Counts number of steps on path from u to root
     * 
     * @param node - node to count depth of
     * @return number of steps on path from u to root
     */
    int depth(BTNode node) {
        int d = 0;
        while (node != root) {
            node = node.parent;
            d++;
        }
        return d;
    }
    
    
    /**
     * Recursively count sizes of two subtrees rooted at children of u
     * @param node
     * @return number of nodes in binary tree
     */
    int size(BTNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + size(node.left) + size(node.right);
    }
    
    
    /**
     * Compute height of a node
     * Get height of node's subtrees
     * Take the larger of the two, + 1 and return it
     * @param node
     * @return height of u
     */
    int height(BTNode node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }
    
    
    /**
     * Recursive way to Depth-first traverse BT
     * @param node 
     */
    void traverse(BTNode node) {
        if (node == null){
            return;
        }
        traverse(node.left);
        traverse(node.right);
    }
    
    
    /**
     * Depth-first Non-recursive way to traverse BT
     */
    void traverse2() {
        BTNode node = root, prev = null, next;
        while (node != null) {
            if (prev == node.parent) {
                if (node.left != null) {
                    next = node.left;
                }
                else if (node.right != null) {
                    next = node.right;
                }
                else {
                    next = node.parent;
                }
            } else if (prev == node.left) {
                if (node.right != null) {
                    next = node.right;
                }
                else {
                    next = node.parent;
                }
            } else {
                next = node.parent;
            }
            prev = node;
            node = next;
        }
    }
    
    /**
     * Breadth First Traversal
     */
//    void bfTraverse() {
//        queue.Queue<Node> q = new LinkedList<Node>();
//        if (root != nil) q.add(root);
//        while (!q.isEmpty()) {
//            Node u = q.remove();
//            if (u.left != nil) q.add(u.left);
//            if (u.right != nil) q.add(u.right);
//        }
//    }
        
}
