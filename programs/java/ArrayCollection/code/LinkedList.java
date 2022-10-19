import java.util.*;

public class LinkedList<T> implements List<T> {

    private Item<T> firstInList = null;

    private Item<T> lastInList = null;

    private int size;

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public boolean contains(final Object o) {
        // BEGIN (write your solution here)
        if (firstInList == null) {
            return false;
        }
        if (o == null) {
            for (T t : this) {
                if (t == null) {
                    return true;
                }
            }
        } else {
            for (T t : this) {
                if (o.equals(t)) {
                    return true;
                }
            }
        }
        return false;
        // END
    }

    @Override
    public Iterator<T> iterator() {
        return new ElementsIterator(0);
    }

    @Override
    public Object[] toArray() {
        // BEGIN (write your solution here)
        Object[] array = new Object[size];
        int index = 0;
        Item<T> item = firstInList;
        while (item != null) {
            array[index] = item.element;
            index++;
            item = item.nextItem;
        }
        return array;
        // END
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        // BEGIN (write your solution here)
        if (a.length < size) {
            return (T1[]) Arrays.copyOf(this.toArray(), size, a.getClass());
        }
        System.arraycopy(this.toArray(), 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }
        return a;
        // END
    }

    @Override
    public boolean add(final T newElement) {
        // BEGIN (write your solution here)
        if (firstInList == null) {
            firstInList = new Item<>(newElement, null, null);
            lastInList = firstInList;
        } else {
            Item item = new Item(newElement, lastInList, null);
            lastInList.nextItem = item;
            lastInList = item;
        }
        size++;
        return true;
        // END
    }

    @Override
    public void add(final int index, final T element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(final Object o) {
        // BEGIN (write your solution here)
        Item<T> item = firstInList;
        while (!item.element.equals(o)) {
            item = item.nextItem;
            if (item == null) {
                return false;
            }
        }
        if (item == firstInList) {
            firstInList = firstInList.nextItem;
            firstInList.prevItem = null;
            size--;
            return true;
        }
        if (item == lastInList) {
            lastInList = lastInList.prevItem;
            lastInList.nextItem = null;
            size--;
            return true;
        }
        item.prevItem.nextItem = item.nextItem;
        item.nextItem.prevItem = item.prevItem;
        this.size--;

        return true;
        // END
    }

    @Override
    public T remove(final int index) throws IndexOutOfBoundsException {
        // BEGIN (write your solution here)
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        T t;
        if (index == 0) {
            t = firstInList.element;
            if (size == 1) {
                firstInList = null;
                size--;
                return t;
            }
            firstInList = firstInList.nextItem;
            firstInList.prevItem = null;
            size--;
            return t;
        }
        Item<T> item = firstInList;
        for (int i = 0; i < index; i++) {
            item = item.nextItem;
        }
        if (item == lastInList) {
            t = lastInList.element;
            lastInList.prevItem.nextItem = null;
            lastInList = lastInList.prevItem;
            size--;
            return t;
        }
        t = item.element;
        item.prevItem.nextItem = item.nextItem;
        item.nextItem.prevItem = item.prevItem;
        size--;
        return t;
        // END
    }

    private void remove(final Item<T> current) {
        // BEGIN (write your solution here)
        current.prevItem.nextItem = current.nextItem;
        current.nextItem.prevItem = current.prevItem;
        size--;
        // END
    }

    @Override
    public boolean containsAll(final Collection<?> c) {
        for (final Object item : c) {
            if (!this.contains(item)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(final Collection<? extends T> c) {
        for (final T item : c) {
            add(item);
        }
        return true;
    }

    @Override
    public boolean addAll(final int index, final Collection elements) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(final Collection<?> c) {
        for (final Object item : c) {
            remove(item);
        }
        return true;
    }

    @Override
    public boolean retainAll(final Collection<?> c) {
        this.removeIf(item -> !c.contains(item));
        return true;
    }

    @Override
    public void clear() {
        // BEGIN (write your solution here)
        firstInList = null;
        lastInList = null;
        size = 0;
        // END
    }

    @Override
    public List<T> subList(final int start, final int end) {
        return null;
    }

    @Override
    public ListIterator<T> listIterator() {
        return new ElementsIterator(0);
    }

    @Override
    public ListIterator<T> listIterator(final int index) {
        return new ElementsIterator(index);
    }

    @Override
    public int lastIndexOf(final Object target) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(final Object o) {
        // BEGIN (write your solution here)
        if (firstInList == null) {
            throw new IllegalStateException("List is empty");
        }
        int index = 0;
        Item<T> item = firstInList;
        if (o == null) {
            while (item.element != null) {
                item = item.nextItem;
                if (item == null) {
                    return -1;
                }
                index++;
            }
        } else {
            while (!o.equals(item.element)) {
                item = item.nextItem;
                if (item == null) {
                    return -1;
                }
                index++;
            }
        }
        return index;
        // END
    }

    @Override
    public T set(final int index, final T element) {
        // BEGIN (write your solution here)
        if (index == 0) {
            T t = firstInList.element;
            firstInList.element = element;
            return t;
        }
        Item<T> item = firstInList;
        int current = 0;
        while (current != index) {
            item = item.nextItem;
            current++;
        }
        T t = item.element;
        item.element = element;
        return t;
        // END
    }

    @Override
    public T get(final int index) {
        // BEGIN (write your solution here)
        if (index == 0) {
            return firstInList.element;
        }
        Item<T> item = firstInList;
        int current = 0;
        while (current != index) {
            item = item.nextItem;
            current++;
        }
        return item.element;
        // END
    }

    private Item<T> getItemByIndex(final int index) {
        // BEGIN (write your solution here) An auxiliary method for searching for node by index.
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            return firstInList;
        }
        if (index == size - 1) {
            return lastInList;
        }
        Item<T> item = firstInList;
        int current = 0;
        while (current != index) {
            item = item.nextItem;
            current++;
        }
        return item;
        // END
    }

    private class ElementsIterator implements ListIterator<T> {

        private Item<T> currentItemInIterator;

        private Item<T> lastReturnedItemFromIterator;

        private int index;

        ElementsIterator(final int index) {
            // BEGIN (write your solution here)
            currentItemInIterator = (index == size) ? null : getItemByIndex(index);
            this.index = index;
            // END
        }

        @Override
        public boolean hasNext() {
            // BEGIN (write your solution here)
            return LinkedList.this.size > index;
            // END
        }

        @Override
        public T next() {
            // BEGIN (write your solution here)
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (index == 0) {
                lastReturnedItemFromIterator = firstInList;
                currentItemInIterator = lastReturnedItemFromIterator.nextItem;
            } else {
                lastReturnedItemFromIterator = getItemByIndex(index);
                currentItemInIterator = lastReturnedItemFromIterator.nextItem;
                if (currentItemInIterator != null) {
                    currentItemInIterator.prevItem = lastReturnedItemFromIterator;
                }
            }
            index++;
            return lastReturnedItemFromIterator.element;
            // END
        }

        @Override
        public boolean hasPrevious() {
            // BEGIN (write your solution here)
            return index > 0;
            // END
        }

        @Override
        public T previous() {
            // BEGIN (write your solution here)
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            lastReturnedItemFromIterator = getItemByIndex(index - 1);
            currentItemInIterator = lastReturnedItemFromIterator.prevItem;
            index--;
            return lastReturnedItemFromIterator.element;
            // END
        }

        @Override
        public void add(final T element) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(final T element) {
            // BEGIN (write your solution here)
            if (lastReturnedItemFromIterator == null) {
                throw new IllegalStateException();
            }
            lastReturnedItemFromIterator.element = element;
            // END
        }

        @Override
        public int previousIndex() {
            // BEGIN (write your solution here)
            return index - 1;
            // END
        }

        @Override
        public int nextIndex() {
            // BEGIN (write your solution here)
            return index;
            // END
        }

        @Override
        public void remove() {
            // BEGIN (write your solution here)
            if (lastReturnedItemFromIterator == null) {
                throw new IllegalStateException();
            }
            if (index == 1) {
                if (currentItemInIterator != null) {
                    currentItemInIterator.prevItem = null;
                    firstInList = currentItemInIterator;
                }
                lastReturnedItemFromIterator = null;
                index--;
                size--;
                return;
            }
            lastReturnedItemFromIterator.prevItem.nextItem = currentItemInIterator;
            currentItemInIterator.prevItem = lastReturnedItemFromIterator.prevItem;
            lastReturnedItemFromIterator = null;
            index--;
            size--;
            // END
        }
    }

    private static class Item<T> {

        private T element;

        private Item<T> nextItem;

        private Item<T> prevItem;

        Item(final T element, final Item<T> prevItem, final Item<T> nextItem) {
            this.element = element;
            this.nextItem = nextItem;
            this.prevItem = prevItem;
        }

        public Item<T> getNextItem() {
            return nextItem;
        }

        public Item<T> getPrevItem() {
            return prevItem;
        }
    }
}

