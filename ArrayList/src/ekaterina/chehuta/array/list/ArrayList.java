package ekaterina.chehuta.array.list;

import java.util.*;

public class ArrayList<E> implements List<E> {
    private E[] items;
    private int size;
    private int modCount;

    public ArrayList() {
        //noinspection unchecked
        items = (E[]) new Object[size];
    }

    public ArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Передан не верный аргумент: \"" + capacity + "\"." + "Аргумент должен быть больше \"0\".");
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
        System.arraycopy(items, 0, a, 0, size); //todo a
        return a;
    }

    @Override
    public boolean add(E element) {
        add(size, element);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        modCount++;

        for (int i = 0; i < size; i++) {
            if (items[i].equals(o)) {
                System.arraycopy(items, i + 1, items, i, size - i - 1);
                size--;
                trimToSize();
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        boolean x = false;
        int modCount = 0;

        for (int i = 0; i < c.size(); i++) {
            if (contains(c.toArray()[i])) {
                modCount++;
            }
        }

        if (modCount == c.size()) {
            x = true;
        }

        return x;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        modCount++;
        boolean x = false;

        for (E e : c) {
            add(e);
            x = true;
        }

        return x;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        modCount++;

        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Индекс " + "\"" + index + "\"" +
                    " выходит за границы списка. Допустимый диапазон индексов от \"0\" до " + "\"" + (size - 1) + "\".");
        }

        ensureCapacity(size + c.size());
        boolean x = false;

        for (E e : c) {
            add(index, e);
            index++;
            x = true;
        }

        return x;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean x = false;
        modCount++;

        for (int i = 0; i < c.size(); i++) {
            for (int j = 0; j < items.length; j++) {
                if (items[j].equals(c.toArray()[i])) {
                    System.arraycopy(items, j + 1, items, j, items.length - 1 - j);
                    size--;
                    x = true;
                }
            }
        }

        trimToSize();
        return x;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean x = false;
        modCount++;

        for (Object ignored : c) {
            for (E e : items) {
                if (!c.contains(e)) {
                    remove(e);
                    x = true;
                }
            }
        }

        trimToSize();
        return x;
    }

    @Override
    public void clear() {
        modCount++;

        for (int i = size - 1; i >= 0; i--) {
            remove(i);
        }
    }

    @Override
    public E get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Индекс " + "\"" + index + "\"" +
                    " выходит за границы списка. Допустимый диапазон индексов от \"0\" до " + "\"" + (size - 1) + "\".");
        }

        return items[index];
    }

    @Override
    public E set(int index, E element) {

        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Индекс " + "\"" + index + "\"" +
                    " выходит за границы списка. Допустимый диапазон индексов от \"0\" до " + "\"" + (size - 1) + "\".");
        }

        return items[index] = element;
    }

    @Override
    public void add(int index, E element) {
        modCount++;

        if (index < 0) {
            throw new IndexOutOfBoundsException("Индекс " + "\"" + index + "\"" +
                    " выходит за границы списка. Допустимый диапазон индексов от \"0\" до " + "\"" + (size - 1) + "\".");
        }

        size++;

        if (index >= items.length) {
            ensureCapacity(index);
        } else if (size > items.length) {
            ensureCapacity(size);
        }

        if (size - 1 - index >= 0) {
            System.arraycopy(items, index, items, index + 1, size - 1 - index);
        }

        items[index] = element;
        trimToSize();
    }

    public void ensureCapacity(int minCapacity) {
        items = Arrays.copyOf(items, minCapacity + 1);
    }

    public void trimToSize() {
        if (size < items.length) {
            items = Arrays.copyOf(items, size);
        }
    }

    @Override
    public E remove(int index) {
        modCount++;

        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Индекс " + "\"" + index + "\"" +
                    " выходит за границы списка. Допустимый диапазон индексов от \"0\" до " + "\"" + (size - 1) + "\".");
        }

        E e = items[index];

        if (index < size - 1) {
            System.arraycopy(items, index + 1, items, index, size - index - 1);
        }

        items[size - 1] = null;
        size--;
        trimToSize();
        return e;
    }

    @Override
    public int indexOf(Object o) {
        Object[] objects = items;

        if (o == null) {
            for (int i = 0; i < objects.length; i++) {
                if (objects[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < objects.length; i++) {
                if (o.equals(objects[i])) {
                    return i;
                }
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        Object[] objects = items;

        if (o == null) {
            for (int i = objects.length - 1; i >= 0; i--) {
                if (objects[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = objects.length - 1; i >= 0; i--) {
                if (o.equals(objects[i])) {
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
        return Arrays.toString(items);
    }

    private class MyArrayListIterator implements Iterator<E> {
        private int currentIndex = -1;
        int expectedModCount = modCount;

        public boolean hasNext() {
            return currentIndex + 1 < size;
        }

        public E next() {
            if (currentIndex >= size) {
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
