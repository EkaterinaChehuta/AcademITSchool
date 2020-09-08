package ekaterina.chehuta.array.list.home;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ArrayListHome<E> {
    private String[] list;
    private int size;

    // конструктор заполнения списка из файла
    public ArrayListHome(String address) {
        try (FileReader fileReader = new FileReader(address)) {
            Scanner scanner = new Scanner(fileReader);
            list = new String[size];

            String x;
            int i = 0;
            while (scanner.hasNext()) {
                x = scanner.next();

                if (size >= list.length) {
                    ensureCapacity(size);
                }

                list[i] = x;
                i++;
                size++;
            }

            trimToSize();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // конструктор копирования списка
    public ArrayListHome(ArrayListHome<E> arrayListHome) {
        list = Arrays.copyOf(arrayListHome.list, arrayListHome.size);
        size = arrayListHome.size;
    }

    // конструктор заполнения списка из массива
    public ArrayListHome(String... arrayList) {
        list = Arrays.copyOf(arrayList, arrayList.length);
        size = arrayList.length;
    }

    public int getSize() {
        return this.size;
    }

    // увеличение размера списка в 2 раза
    public void ensureCapacity(int minCapacity) {
        list = Arrays.copyOf(list, minCapacity * 2 + 1);
    }

    public void oddNumbersList() {
        int[] integerList = new int[size];

        for (int i = 0; i < size; i++) {
            try {
                integerList[i] = Integer.parseInt(list[i]);

                if (integerList[i] % 2 == 0) {
                    remove(i);
                    i--;
                }
            } catch (NumberFormatException remove) {
                remove(i);
            }
        }

        trimToSize();
    }

    public ArrayListHome<String> getLinkedList() {
        ArrayListHome<String> newArrayListHome = new ArrayListHome<>(list);
        newArrayListHome.size = newArrayListHome.list.length;
        int[] integerNewList = new int[newArrayListHome.size];

        for (int i = 0; i < newArrayListHome.size; i++) {
            try {
                integerNewList[i] = Integer.parseInt(newArrayListHome.list[i]);

                for (int j = i + 1; j < newArrayListHome.size - 1; j++) {

                    try {
                        integerNewList[j] = Integer.parseInt(newArrayListHome.list[j]);

                        if (integerNewList[i] == integerNewList[j]) {
                            newArrayListHome.remove(j);
                            j--;
                        }
                    } catch (NumberFormatException remove) { // если встречается буква
                        newArrayListHome.remove(j);
                        j--;
                    }
                }

            } catch (NumberFormatException remove) { // если встречается буква
                newArrayListHome.remove(i);
                i--;
            }
        }

        trimToSize();
        return newArrayListHome;
    }

    public void remove(int index) {
        if (size - 1 - index >= 0) System.arraycopy(list, index + 1, list, index, size - 1 - index);

        size--;
    }

    public void trimToSize() {
        if (size < list.length) {
            list = Arrays.copyOf(list, size);
        }
    }

    public String toString() {
        return Arrays.toString(list);
    }
}