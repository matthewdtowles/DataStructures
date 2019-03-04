package sandbox;

import binarytree.BTNode;
import binarytree.BinarySearchTree;

/**
 * Test
 * 
 * @author matthew.towles
 * @date Feb 13, 2019
 */
public class Test {
    public static void main(String[] args) {
        int[] a = {7,9,0,1,2,0,9,7,4,4,6,9,1,0,9,3,2,5,9};
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        int i = 0;
        for(int z : a) {
            
            //if (bst.root != null)
               //System.out.println(i++ + ": " + bst.root.value);
            
            //BTNode<Integer> newNode = new BTNode();
            //newNode.value = z;
            bst.bstadd(z);
        }
//        p(bst.root);
//        p(bst.root.left);
//        p(bst.root.right);
        
        traverse(bst.root.left);

    }
    
    public static String traverse(BTNode node) {
        if (node.left != null) {
            p(node);
            return traverse(node.left);
        }
        return Integer.toString(node.value);
    }
    
    
    public static void p(BTNode node) {
        System.out.println("val: " + node.value);
        System.out.println("lt,rt:  " + node.left.value + " | " + node.right.value);
                
    }

}
