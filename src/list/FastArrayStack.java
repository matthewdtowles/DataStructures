package list;

/**
 * A Faster Implementation of ArrayStack
 * @author matthew.towles
 * @param <T> - type of FastArrayStack
 */
public class FastArrayStack<T> extends ArrayStack<T> {
    
    @Override
    public void resize() {
        T[] b = (T[])new Object[Math.max(n*2, 1)];
        System.arraycopy(a, 0, b, 0, n);
        a = b;
    }
    
    
    @Override
    public void add(int i, T x) {
        if (i < 0 || i > n) throw new IndexOutOfBoundsException();
        if (n + 1 > a.length) resize();
        System.arraycopy(a, i, a, i+1, n-i); 
        a[i] = x;
        n++;
    }
    
    
    @Override
    public T remove(int i) {
        if (i < 0 || i > n - 1) throw new IndexOutOfBoundsException();
        T x = a[i];
        System.arraycopy(a, i+1, a, i, n-i-1);
        n--; 
        if (a.length >= 3*n) resize();
        return x;
    }
}
