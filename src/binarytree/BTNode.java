package binarytree;

/**
 *
 * @author matthew.towles
 * @param <Node>
 */
public class BTNode<Node extends BTNode<Node>> {
    public Node left;
    public Node right;
    public Node parent;
    public Object x;
}
