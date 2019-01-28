package list;

/**
 * Allows for efficient add/remove at both ends
 * Uses circular array technique like ArrayQueue
 * 
 * @author matthew.towles
 * @param <T> - type of ArrayDeque
 */
public class ArrayDeque<T> implements List<T> {

    /**
     * Array of elements
     */
    T[] a;
    
    /**
     * Index of next item to be removed
     */
    int j;
    
    /**
     * Number of elements in a[]
     */
    int n;
    
    
    /**
     * @time O(1)
     * @return 
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
        if (i < 0 || i > n-1) {
            throw new IndexOutOfBoundsException();
        }
        return a[(j+i)%a.length];
    }

    
    /**
     * @time O(1)
     * @param i
     * @param x
     * @return 
     */
    @Override
    public T set(int i, T x) {
        if (i < 0 || i > n-1) {
            throw new IndexOutOfBoundsException();
        }
        T y = a[(j+i)%a.length];
        a[(j+i)%a.length] = x;
        return y;
    }

    
    /**
     * @time O(1 + min(i, n - i))
     * @param i
     * @param x 
     */
    @Override
    public void add(int i, T x) {
        if (i < 0 || i > n) {
            throw new IndexOutOfBoundsException();
        }
        if (n+1 > a.length) {
            resize();
        }
        if (i < n/2) {
            // shift a[0],..,a[i-1] left one position
            j = (j == 0) ? a.length - 1 : j - 1; //(j-1)mod a.length
            for (int k = 0; k <= i-1; k++) {
                a[(j+k)%a.length] = a[(j+k+1)%a.length];
            }
        } else { 
            // shift a[i],..,a[n-1] right one position
            for (int k = n; k > i; k--) {
                a[(j+k)%a.length] = a[(j+k-1)%a.length];
            }
        }
        a[(j+i)%a.length] = x;
        n++;
    }

    
    /**
     * @time O(1 + min(i, n - i))
     * @param i
     * @return removed item
     */
    @Override
    public T remove(int i) {
        if (i < 0 || i > n - 1) {
            throw new IndexOutOfBoundsException();
        }
        T x = a[(j+i)%a.length];
        if (i < n/2) { 
            // shift a[0],..,[i-1] right one position
            for (int k = i; k > 0; k--) {
                a[(j+k)%a.length] = a[(j+k-1)%a.length];
            }
            j = (j + 1) % a.length;
        } else { 
            // shift a[i+1],..,a[n-1] left one position
            for (int k = i; k < n-1; k++) {
                a[(j+k)%a.length] = a[(j+k+1)%a.length];
            }
        }
        n--;
        if (3*n < a.length) {
            resize();
        }
        return x;
    }
    
    
    /**
     * Resize a[] 2x
     * 
     * @time O(n)
     */
    public void resize() {
        T[] b = (T[])new Object[Math.max(n*2, 1)];
        System.arraycopy(a, 0, b, 0, n);
        a = b;
    }
    
}
