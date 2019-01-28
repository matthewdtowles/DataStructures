package list;

/**
 * Implements a List with a backing array
 * Elements stored in a[0], ..., a[n-1]
 * a.length >= n
 * 
 * @author matthew.towles
 * @param <T> - type of ArrayStack
 */
public class ArrayStack<T> implements List<T> {

    /**
     * Backing array where elements are stored
     */
    T[] a;
    
    /**
     * Number of elements actually stored in this.a
     */
    int n;
    
    
    
    /**
     * @time O(1)
     * @return n - size of a[]
     */
    @Override
    public int size() {
        return n;
    }
    

    /**
     * @time O(1)
     * @param i
     * @return 
     */
    @Override
    public T get(int i) {
        if (i < 0 || i > n - 1) {
            throw new IndexOutOfBoundsException();
        }
        return a[i];
    }
    

    /**
     * @time O(1)
     * @param i index
     * @param x value to set a[i] to
     * @return value set
     */
    @Override
    public T set(int i, T x) {
        if (i < 0 || i > n - 1) {
            throw new IndexOutOfBoundsException();
        }
        T y = a[i];
        a[i] = x;
        return y;
    }
    

    /**
     * Insert x into a[i]
     * Shifts original a[i] -> a[n - 1] to a[i + 1] -> a[n]
     * 
     * @time O(1 + n - i)
     * @param i index
     * @param x element
     */
    @Override
    public void add(int i, T x) {
        if (i < 0 || i > n) {
            throw new IndexOutOfBoundsException();
        }
        if (n + 1 > a.length) {
            resize();
        }
        for (int j = n; j > i; j--) {
            a[j] = a[j-1];
        }
        a[i] = x;
        n++;    
    }
    

    /**
     * Removes a[i] and shifts elements after to the left
     * 
     * @time O(1 + n - i)
     * @param i
     * @return x - element removed
     */
    @Override
    public T remove(int i) {
        if (i < 0 || i > n - 1) {
            throw new IndexOutOfBoundsException();
        }
        
        T x = a[i];
        
        for (int j = i; j < n-1; j++) {
            a[j] = a[j+1];
        }
        
        n--;
        if (a.length >= 3*n) {
            resize();
        }
        return x;    
    }
    
    
    /**
     * Doubles the array size
     * Allocates a new array of size 2n
     * Copies elements of this.a into first n position in b
     * Sets a to new array, b
     * 
     * @time O(n)
     */
    @SuppressWarnings("ManualArrayToCollectionCopy")
    public void resize() {
        // new empty array type T, size 2*n
        T[] b = (T[])new Object[Math.max(n*2, 1)];
        for (int i = 0; i < n; i++) {
            b[i] = a[i];
        }
        // System.arraycopy(a, 0, b, 0, Math.max(n*2,1)); does same as above - 2 to 3 x faster
        a = b;
    }
    
}
