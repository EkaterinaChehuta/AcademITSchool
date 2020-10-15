package ekaterina.chehuta.array.list;

import java.util.*;

public class ArrayList<E> implements List<E> {
    private E[] items;
    private int size;
    private int modCount;

    public ArrayList() {
        int minSize = 1;
        //noinspection unchecked
        items = (E[]) new Object[minSize];
    }

    public ArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Передан не верный аргумент: \"" + capacity + "\". Аргумент должен быть больше \"0\".");
        }
        //noinspection unchecked
        items = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyArrayListIterator();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(items, size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            //noinspection unchecked
            a = (T[]) Arrays.copyOf(items, size, a.getClass());
        }

        //noinspection SuspiciousSystemArraycopy
        System.arraycopy(items, 0, a, 0, size);
        return a;
    }

    @Override
    public boolean add(E element) {
        add(size, element);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);

        if (index >= 0) {
            remove(index);
            return true;
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        int cardinality = 0;

        for (Object o : c) {
            if (contains(o)) {
                cardinality++;
            }
        }

        return cardinality == c.size();
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addAll(size, c);
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Индекс \"" + index +
                    "\" выходит за границы списка. Допустимый диапазон индексов от \"0\" до \"" + (size - 1) + "\".");
        }

        if (c.size() == 0) {
            return false;
        }

        ensureCapacity(size + c.size());

        System.arraycopy(items, index, items, index + c.size(), size - index);

        Object[] items = this.items;
        System.arraycopy(c.toArray(), 0, items, index, c.size() - 1);

        size += c.size();
        modCount++;
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) { // упадет на 0
        boolean isModified = false;

        for (Object o : c) {
            if (contains(o)) {
                remove(o);
                isModified = true;
            }
        }

        modCount++;
        return isModified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean isModified = false;

        for (int i = 0; i < size; i++) {
            if (!c.contains(items[i])) {
                remove(i);
                i--;
                isModified = true;
            }
        }

        return isModified;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            items[i] = null;
        }

        modCount++;
        size = 0;
    }

    @Override
    public E get(int index) {
        indexCheck(index);

        return items[index];
    }

    @Override
    public E set(int index, E element) {
        indexCheck(index);
        E oldElement = items[index];
        items[index] = element;
        modCount++;

        return oldElement;
    }

    @Override
    public void add(int index, E element) {
        if (index > size && index < 0) {
            throw new IndexOutOfBoundsException("Индекс \"" + index +
                    "\" выходит за границы списка. Допустимый диапазон индексов от \"0\" до \"" + (size - 1) + "\".");
        }

        ensureCapacity(size);

        if (size - index >= 0) {
            System.arraycopy(items, index, items, index + 1, size - index);
        }

        items[index] = element;
        modCount++;
        size++;
    }

    public void ensureCapacity(int minCapacity) {
        if (minCapacity < size) {
            items = Arrays.copyOf(items, size + 1);
            size++;
            return;
        }

        items = Arrays.copyOf(items, minCapacity + 1);
    }

    public void trimToSize() {
        if (size < items.length) {
            items = Arrays.copyOf(items, size);
        }
    }

    @Override
    public E remove(int index) {
        indexCheck(index);

        E e = items[index];

        if (index < size - 1) {
            System.arraycopy(items, index + 1, items, index, size - index - 1);
        }

        items[size - 1] = null;
        size--;
        modCount++;
        return e;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < items.length; i++) {
                if (items[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < items.length; i++) {
                if (Objects.equals(o, items[i])) {
                    return i;
                }
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = items.length - 1; i >= 0; i--) {
                if (items[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = items.length - 1; i >= 0; i--) {
                if (Objects.equals(o, items[i])) {
                    return i;
                }
            }
        }

        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    } // без реализации

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    } // без реализации

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    } // без реализации

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

    private void indexCheck(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Индекс \"" + index +
                    "\" выходит за границы списка. Допустимый диапазон индексов от \"0\" до \"" + (size - 1) + "\".");
        }
    }

    private class MyArrayListIterator implements Iterator<E> {
        private int currentIndex = -1;
        private int expectedModCount = modCount;

        public boolean hasNext() {
            return currentIndex + 1 < size;
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Коллекция закончилась.");
            }

            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException("В процессе обхода коллекция была изменена.");
            }

            ++currentIndex;
            return items[currentIndex];
        }
    }
}
