package list;

/**
 * Uses two ArrayStacks so that operations are fast at either end
 * Places ArrayStacks back to back to do this
 * Same asymptotic performance as ArrayDeque
 * 
 * @author matthew.towles
 * @param <T>
 */
public class DualArrayDeque<T> implements List<T> {

    /**
     * Elements 0, ..., front.size() - 1
     * Stored in reverse order
     */
    List<T> front;
    
    /**
     * Elements front.size(), ..., size() - 1
     * Stored in normal order
     */
    List<T> back;
    
    
    /**
     * @time O(1)
     * @return 
     */
    @Override
    public int size() {
        return front.size() + back.size();
    }

    
    /**
     * @time O(1)
     * @param i
     * @return 
     */
    @Override
    public T get(int i) {
        if (i < front.size()) {
            return front.get(front.size()-i-1);
        } else {
            return back.get(i-front.size());
        }
    }

    
    /**
     * @time O(1)
     * @param i
     * @param x
     * @return 
     */
    @Override
    public T set(int i, T x) {
        if (i < front.size()) {
            return front.set(front.size()-i-1, x);
            
        } else {
            return back.set(i-front.size(), x);
        }
    }

    
    /**
     * Must balance the two stacks
     * @time O(1 + min(i, n-i))
     * @param i
     * @param x 
     */
    @Override
    public void add(int i, T x) {
        if (i < front.size()) { 
            front.add(front.size()-i, x);
        } else {
            back.add(i-front.size(), x);
        }
        balance();
    }

    
    /**
     * Must balance the two stacks
     * @time O(1 + min(i, n-i))
     * @param i
     * @return removed element
     */
    @Override
    public T remove(int i) {
        T x;
        if (i < front.size()) {
            x = front.remove(front.size()-i-1);
        } else {
            x = back.remove(i-front.size());
        }
        balance();
        return x;
    }
    
    
    /**
     * NEED TO ACTUALLY IMPLEMENT THIS
     * Ensures that front and back contain >= n/4 elements
     * If not, balances so each are n/2 elements
     * 
     * @time O(n)
     */
    public void balance() {
        int n = size();
        if (3*front.size() < back.size()) {
//            int s = n/2 - front.size();
//            List<T> l1 = newStack();
//            List<T> l2 = newStack();
//            l1.addAll(back.subList(0,s));
//            Collections.reverse(l1);
//            l1.addAll(front);
//            l2.addAll(back.subList(s, back.size()));
//            front = l1;
//            back = l2;
        } else if (3*back.size() < front.size()) {
//            int s = front.size() - n/2;
//            List<T> l1 = newStack();
//            List<T> l2 = newStack();
//            l1.addAll(front.subList(s, front.size()));
//            l2.addAll(front.subList(0, s));
//            Collections.reverse(l2);
//            l2.addAll(back);
//            front = l1;
//            back = l2;
        }
    }
    
}
