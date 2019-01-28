package list;

/**
 * Addresses issue of wasted space
 * Stores n elements using O(sqrt(n)) arrays
 * At most, O(sqrt(n)) locations are unused at any time
 * Stores elements in a list of r arrays called blocks
 * 
 * @author matthew.towles
 * @param <T>
 */
public class RootishArrayStack<T> implements List<T> {

    /**
     * A list of arrays
     * Each array in the list is a block
     * The list is a list of blocks
     */
    List<T[]> blocks;
    
    /**
     * Size in number of elements - not number of blocks
     */
    int n;
    
    
    /**
     * Find the block index that holds index i
     * @time O(1)
     * @param i
     * @return block index
     */
    public int i2b(int i) {
        double db = (-3.0 + Math.sqrt(9 + 8*i)) / 2.0;
        int b = (int)Math.ceil(db);
        return b;
    }
    
    
    /**
     * @time O(1)
     * @return 
     */
    @Override
    public int size() {
        return n;
    }
    

    /**
     * @time O(1) - depending on T
     * @param i
     * @return 
     */
    @Override
    public T get(int i) {
        if (i < 0 || i > n - 1) {
            throw new IndexOutOfBoundsException();
        }
        int b = i2b(i);
        int j = i - b*(b+1)/2;
        return blocks.get(b)[j];    
    }

    
    /**
     * @time O(1) - depending on T
     * @param i
     * @param x
     * @return 
     */
    @Override
    public T set(int i, T x) {
        if (i < 0 || i > n - 1) {
            throw new IndexOutOfBoundsException();
        }
        int b = i2b(i);
        int j = i - b*(b+1)/2;
        T y = blocks.get(b)[j];
        blocks.get(b)[j] = x;
        return y;    
    }

    
    /**
     * Adds element
     * Check if all blocks full
     * If all full, call grow() and:
     *   Shift elements i,...,n-1 to right by 1 for x at i
     * 
     * @time O(1 + n - i)
     * @param i
     * @param x 
     */
    @Override
    public void add(int i, T x) {
        if (i < 0 || i > n) {
            throw new IndexOutOfBoundsException();
        }
        int r = blocks.size();
        if (r*(r+1)/2 < n + 1) {
            grow();
        }
        n++;
        for (int j = n-1; j > i; j--) {
            set(j, get(j-1));
        }
        set(i, x);    
    }

        
    /**
     * Add block
     * @time O(r) - O(1) amortized in add
     */
    public void grow() {
        T[] b = (T[])new Object[blocks.size()+1];
        blocks.add(blocks.size(), b);
    }
    
    
    /**
     * Shifts elements i+1,...,n left by 1
     * If more than one empty block then shrink()
     * 
     * @time O(n - i)
     * @param i
     * @return 
     */
    @Override
    public T remove(int i) {
        if (i < 0 || i > n - 1) {
            throw new IndexOutOfBoundsException();
        }
        T x = get(i);
        for (int j = i; j < n-1; j++) {
            set(j, get(j+1));
        }
        n--;
        int r = blocks.size();
        if ((r-2)*(r-1)/2 >= n) {
            shrink();
        }
        return x;
    }
    
    
    /**
     * Remove all but one empty blocks
     * @time O(r) - O(1) amortized in remove
     */
    public void shrink() {
        int r = blocks.size();
        while (r > 0 && (r-2)*(r-1)/2 >= n) {
            blocks.remove(blocks.size()-1);
            r--;
        }        
    }
}
