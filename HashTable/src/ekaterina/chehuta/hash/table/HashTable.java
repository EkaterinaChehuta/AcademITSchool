package ekaterina.chehuta.hash.table;

import java.util.*;

public class HashTable<E> implements Collection<E> {
    private ArrayList<E>[] table;
    private int size;
    private int count;
    private int modCount;

    public HashTable(int size) {
        this.size = size;
        table = new ArrayList[size];
    }

    public int getCount() {
        return count;
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
        int key = o.hashCode() % size;

        if (table[key] != null) {
            for (E v : table[key]) {
                if (v.equals(o)) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyArrayListIterator();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(table, size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            //noinspection unchecked
            a = (T[]) Arrays.copyOf(table, size, a.getClass());
        }

        //noinspection SuspiciousSystemArraycopy
        System.arraycopy(table, 0, a, 0, size);
        return a;
    }

    @Override
    public boolean add(E e) {
        int key = e.hashCode() % size;

        if (table[key] == null) {
            table[key] = new ArrayList<>();
        }

        table[key].add(e);
        count++;
        modCount++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int key = o.hashCode() % size;

        if (table[key] != null) {
            if (table[key].remove(o)) {
                count--;
                modCount++;
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        int count = 0;

        for (Object o : c) {
            if (contains(o)) {
                count++;
            }
        }

        return count == c.size();
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E v : c) {
            add(v);
        }

        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        int oldCardinality = count;

        for (Object o : c) {
            remove(o);
        }

        return oldCardinality != count;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean isModified = false;

        e:
        for (Object o : c) {
            int key = o.hashCode() % size;

            for (int i = 0; i < table[key].size(); i++) {
                if (!Objects.equals(table[key].get(i), o)) {
                    table[key].remove(i);
                    count--;
                    isModified = true;
                    continue e;
                }
            }
        }

        return isModified;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            table[i] = null;
        }

        modCount++;
        count = 0;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(table);
    }

    private class MyArrayListIterator implements Iterator<E> {
        private int currentIndexTable = 0;
        private int currentIndexArrayList = -1;
        private int expectedModCount = modCount;

        public boolean hasNext() {
            if (currentIndexArrayList + 1 >= table[currentIndexTable].size()) {
                while (currentIndexTable + 1 < size) {
                    if (table[currentIndexTable + 1] != null) {
                        currentIndexArrayList = 0;
                        return true;
                    }

                    currentIndexTable++;
                }

                return false;
            }

            return true;
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Коллекция закончилась.");
            }

            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException("В процессе обхода коллекция была изменена.");
            }

            if (currentIndexArrayList + 1 >= table[currentIndexTable].size()) {
                while (currentIndexTable + 1 < size) {
                    if (table[currentIndexTable + 1] != null) {
                        currentIndexArrayList = 0;
                        return table[currentIndexTable + 1].get(currentIndexArrayList);
                    }

                    currentIndexTable++;
                }
            }

            currentIndexArrayList++;
            return table[currentIndexTable].get(currentIndexArrayList);
        }
    }
}