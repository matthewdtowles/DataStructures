package binarytree;

import java.util.Comparator;

/**
 * Binary Search Tree
 
 Implements SSet Interface
 add, remove, find in O(size) time
 * @author matthew.towles
 * @param <T>
 */
public class BinarySearchTree<T> extends BinaryTree<T> implements sets.SSet<T> {
    
    Comparator<Integer> comparator;
    
    /**
     * Search for value and return if found
     * @param value
     * @return value if found, else null
     */
    int findEQ(int value) {
        BTNode node = root;
        while (node != null) {
            int comp = compare(value, node.value);
            if (comp < 0) {
                node = node.left;
            }
            else if (comp > 0) {
                node = node.right;
            } else {
                return node.value;
            }
        }
        return 0;
    }
     
    
    /**
     * Find smallest value stored in BST >= value
     * @param value
     * @return smallest value >= value
     */
    int bstfind(int value) {
        BTNode subroot = root, smallestNode = null;
        while (subroot != null) {
            int comp = compare(value, subroot.value);
            if (comp < 0) {
                smallestNode = subroot;
                subroot = subroot.left;
            } else if (comp > 0) {
                subroot = subroot.right;
            } else {
                return subroot.value;
            }
        }
        return smallestNode.value;
    }
    
    
    
    /**
     * ADDING METHODS
     */
    
    /**
     * Add new node to BST
     * @param value
     * @return 
     */
    public boolean bstadd(int value) {
        BTNode node = findLast(value);
        return addChild(node, newNode(value));        
    }
    
    
    /**
     * Find where new value will belong
     * @param value
     * @return 
     */
    BTNode findLast(int value) {
        BTNode rt = root, prev = null;
        while (rt != null) {
            prev = rt;
            //System.out.println("in findLast():::->  value: " + value + " -- & -- rt.value: " + rt.value);
            int comp;
            comp = compare(value, rt.value);
            if (comp < 0) {
                rt = rt.left;
            } else if (comp > 0) {
                rt = rt.right;
            } else {
                return rt;
            }
        }
        return prev;
    }
    

    int compare(int a, int b) {
        return a - b;
    }
    
    /**
     * Add child to left or right of new parent?
     * @param node1
     * @param node2
     * @return 
     */
    public boolean addChild(BTNode node1, BTNode node2) {
        if (node1 == null) {
            root = node2;              // inserting into empty tree
        } else {
            int comp = compare(node2.value, node1.value);
            if (comp < 0) {
                node1.left = node2;
            } else if (comp > 0) {
                node1.right = node2;
            } else {
                return false;   // node2.value is already in the tree
            }
            node2.parent = node1;
        }
        size++;
        return true;        
    }
    
    
    
    /**
     * REMOVAL METHODS:
     */
    
    
    /**
     * Remove node and make node.parent the parent of node.child
     * @param node 
     */
    public void splice(BTNode node) {
        BTNode node1, node2;
        if (node.left != null) {
            node1 = node.left;
        } else {
            node1 = node.right;
        }
        if (node == root) {
            root = node1;
            node2 = null;
        } else {
            node2 = node.parent;
            if (node2.left == node) {
                node2.left = node1;
            } else {
                node2.right = node1; 
            }
        }
        if (node1 != null) {
            node1.parent = node2;
        }
        size--;
    }
    
    
    /**
     * Removes given node and replaces with correct node
     * @param node 
     */
    public void remove(BTNode node) {
        if (node.left == null || node.right == null) {
            splice(node);
        } else {
            BTNode replacerNode = node.right;
            while (replacerNode.left != null) 
                replacerNode = replacerNode.left;
            node.value = replacerNode.value;
            splice(replacerNode);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object remove(Object x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private BTNode newNode(int value) {
        BTNode node = new BTNode();
        node.value = value;
        return node;
    }

    @Override
    public T find(T x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(Object x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}