import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Consumer;

public class HashSet<T> implements Set<T> {

    static final Boolean EXIST = true;

    final Map<T, Boolean> elements = new HashMap<>();

    @Override
    public int size() {
        // BEGIN (write your solution here)
        return elements.size();
        // END
    }

    @Override
    public boolean isEmpty() {
        // BEGIN (write your solution here)
        return elements.size() == 0;
        // END
    }

    @Override
    public boolean contains(Object o) {
        // BEGIN (write your solution here)
        return elements.containsKey(o);
        // END
    }

    @Override
    public Iterator<T> iterator() {
        // BEGIN (write your solution here)
        return elements.keySet().iterator();
        // END
    }

    @Override
    public Object[] toArray() {
        // BEGIN (write your solution here)
        return elements.keySet().toArray();
        // END
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        // BEGIN (write your solution here)
        if (a.length >= this.size()) {
            return (T1[]) Arrays.copyOf(elements.keySet().toArray(), size());
        } else {
            T[] t = (T[]) elements.keySet().toArray();
            a = (T1[]) Array.newInstance(t[0].getClass(), size());
            System.arraycopy(t, 0, a, 0, size());
        }
        return a;
        // END
    }

    @Override
    public boolean add(T t) {
        // BEGIN (write your solution here)
        if (elements.containsKey(t)) {
            return false;
        } else {
            elements.put(t, true);
        }
        return true;
        // END
    }

    @Override
    public boolean remove(Object o) {
        // BEGIN (write your solution here)
        return elements.remove(o) != null;
        // END
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        // BEGIN (write your solution here)
        return c != null && elements.keySet().containsAll(c);
        // END
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        // BEGIN (write your solution here)
        for (T t : c) {
            this.add(t);
        }
        return true;
        // END
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        // BEGIN (write your solution here)
        this.removeIf(t -> !c.contains(t));
        return true;
        // END
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        // BEGIN (write your solution here)
        this.removeIf(c::contains);
        return true;
        // END
    }

    @Override
    public void clear() {
        // BEGIN (write your solution here)
        elements.clear();
        // END
    }

    @Override
    public boolean equals(Object o) {
        // BEGIN (write your solution here)
        if (!(o instanceof HashSet)) {
            return false;
        }
        if (((HashSet<?>) o).size() != this.size()) {
            return false;
        }

        return this.containsAll((Collection<?>) o) && ((HashSet<?>) o).containsAll(this);
        // END
    }

    @Override
    public int hashCode() {
        // BEGIN (write your solution here)
        int hash = 0;
        for (T t : this) {
            hash += t.hashCode();
        }
        return hash;
        // END
    }
}