package ekaterina.chehuta.list;

import java.util.*;

public class SinglyLinkedList<E> { // односвязный список
    private ListItem<E> head; // ссылка на первый элемент
    private int count = 0; // длинна списка

    public SinglyLinkedList() {
    }

    private ListItem<E> findListItem(int index) {
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException("Выход индекса за нижнюю границу списка.");
        }

        if (index >= count) {
            throw new ArrayIndexOutOfBoundsException("Выход индекса за верхнюю границу списка.");
        }

        ListItem<E> listItem = head;

        for (int i = 0; i != index; i++) {
            listItem = listItem.getNext();
        }

        return listItem;
    }

    // получение размера списка
    public int getCount() {
        return this.count;
    }

    // получение значение первого элемента
    public E getListItemData() {
        if (head == null) {
            throw new NullPointerException("В списке нет элементов.");
        }

        return head.getData();
    }

    // получение значение элемента по индексу
    public E getListItemData(int index) {
        if (head == null) {
            throw new NullPointerException("В списке нет элементов.");
        }

        return this.findListItem(index).getData();
    }

    // изменение значение элемента по индексу, выдать старое значение элемента
    public E setItem(int index, E newData) {
        ListItem<E> listItem = this.findListItem(index);

        E data = listItem.getData();
        listItem.setData(newData);

        return data;
    }

    // удаление элемента по индексу, пусть выдает значение элемента
    public E removeListItem(int index) {
        if (head == null) {
            throw new NullPointerException("В списке нет элементов.");
        }

        ListItem<E> listItem = this.findListItem(index);
        E data = listItem.getNext().getData();
        listItem.setNext(listItem.getNext().getNext());
        count--;

        return data;
    }

    // вставка элемента в начало
    public void insertItem(E data) {
        head = new ListItem<>(data, head);
        count++;
    }

    // вставка элемента по индексу
    public void insertItem(int index, E data) {
        if (index == 0) {
            head = new ListItem<>(data, head);
        } else {
            ListItem<E> listItem = this.findListItem(index - 1);

            if (listItem.getNext() == null) { // При вставке в конец NullPointerException
                ListItem<E> newListItem = new ListItem<>(data, null);
                listItem.setNext(newListItem);
            } else {
                ListItem<E> newListItem = new ListItem<>(data, listItem.getNext());
                listItem.setNext(newListItem);
            }
        }

        count++;
    }

    //удаление узла по значению, пусть выдает true, если элемент был удален
    public boolean removeItem(E data) {
        for (ListItem<E> listItem = head; listItem.getNext() != null; listItem = listItem.getNext()) {
            if (data.equals(listItem.getNext().getData())) {
                listItem.setNext(listItem.getNext().getNext());
                count--;
                return true;
            }
        }

        return false;
    }

    // удаление первого элемента, пусть выдает значение элемента
    public E removeListItem() {
        E data = head.getData();
        head = head.getNext();
        count--;
        return data;
    }

    // разворот списка за линейное время
    public void reverseList() {
        ListItem<E> listItem = head;
        ListItem<E> prev = null;

        while (listItem != null) {
            ListItem<E> listItem2 = listItem.getNext();
            listItem.setNext(prev);
            prev = listItem;
            listItem = listItem2;
        }

        head = prev;
    }

    // копирование списка
    public SinglyLinkedList<E> copyList(SinglyLinkedList<E> linkedList) {
        SinglyLinkedList<E> copeLinkedList = new SinglyLinkedList<>();
        copeLinkedList.head = head;
        int index = 0;

        for (ListItem<E> listItem = head; listItem != null; listItem = listItem.getNext()) {
            copeLinkedList.insertItem(index, listItem.getData());
            index++;
        }

        return copeLinkedList;
    }

//todo нужно сделать полностью без конкатенаций
    @Override
    public String toString() {
        if (head == null) {
            return "{}";
        }

        ListItem<E> listItem = head;
        StringBuilder arrayString = new StringBuilder("{");

        while (listItem.getNext() != null) {
            arrayString.append(listItem.getData());
            arrayString.append(", ");
            listItem = listItem.getNext();
        }

        arrayString.append(listItem.getData());

        return arrayString + "}";
    }
}