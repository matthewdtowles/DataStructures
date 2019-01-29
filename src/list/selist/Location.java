package list.selist;

/**
 *
 * @author matthew.towles
 */
public class Location {
    
    /**
     * Node that contains the element
     */
    Node node;
    
    /**
     * Index of element within block
     */
    int elementIndex;
    
    /**
     * 
     * @param node
     * @param elementIndex 
     */
    Location(Node node, int elementIndex) {
        this.node = node;
        this.elementIndex = elementIndex;
    }
}
