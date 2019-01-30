package binarytree;

/**
 *
 * @author matthew.towles
 * @param <Node>
 */
class BTNode<Node extends BTNode<Node>> {
    Node left;
    Node right;
    Node parent;
}
