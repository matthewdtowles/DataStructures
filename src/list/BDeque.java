package list;

/**
 * Bounded Deque
 * Size of backing array is fixed at b + 1
 * Size does not grow/shrink
 * Allows for addition/removal at front/back in O(1)
 * Helps when elements need to be shifted from block to block
 * 
 * @author matthew.towles
 * @param <T>
 */
public class BDeque<T> extends ArrayDeque<T> {
    
    public BDeque(int b) {
        //super(list.selist.SEList.this.type());
        a = (T[])new Object[b + 1];
    }
    
    /**
     * Append element to block
     * @param x 
     */
    public void add(T x) {
        add(n, x);
    }
    
    
    /**
     * Return whether any elements exist in block
     * 
     * @return boolean
     */
    public boolean isEmpty() {
        return n == 0;
    }
    
    @Override
    public void resize() {}
}
