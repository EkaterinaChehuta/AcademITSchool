package ekaterina.chehuta.list;

public class SinglyLinkedList<E> { // односвязный список
    private ListItem<E> head; // ссылка на первый элемент
    private int count; // длинна списка

    public SinglyLinkedList() {
    }

    public int getCount() {  // получение размера списка
        ListItem<E> list = head;
        count = 0;

        while (list != null) {
            list = list.getNext();
            count++;
        }

        return count;
    }

    public E getElement() {  // получение значение первого элемента
        return head.getData();
    }

    public E getElement(int index) { // получение значение элемента по индексу
        ListItem<E> list = head;

        for (int i = 0; i != index; i++) {
            list = list.getNext();
        }

        return list.getData();
    }

    public E setElement(int index, E data) { // изменение значение элемента по индексу, выдать старое значение элемента
        ListItem<E> list = head;

        for (int i = 0; i != index; i++) {
            list = list.getNext();
        }

        E element = list.getData();
        list.setData(data);

        return element;
    }

    public E removeElement(int index) {  // удаление элемента по индексу, пусть выдает значение элемента
        ListItem<E> list = head;

        for (int i = 0; i != index - 1; i++) {
            list = list.getNext();
        }

        E element = list.getNext().getData();
        list.setNext(list.getNext().getNext());

        return element;
    }

    public void addElement(E data) { // вставка элемента в начало
        head = new ListItem<>(data, head);
    }

    public void insertElement(int index, E data) { // вставка элемента по индексу
        ListItem<E> list = head;

        if (index == 0) {
            addElement(data);
        } else if (index >= count) {
            throw new IllegalArgumentException ("Переданный аргумент не принадлежит диапазону. Список имеет меньшую длину.");
        } else {
            for (int i = 1; i < index; i++) {
                list = list.getNext();
            }

            ListItem<E> element = new ListItem<>(data, list.getNext());
            list.setNext(element);
        }
    }

    public boolean removeItem(E data) { //удаление узла по значению, пусть выдает true, если элемент был удален
        boolean result = false;

        while (data == head.getData()) {
            head = head.getNext();
            result = true;
        }

        ListItem<E> list = head;

        while (list.getNext() != null) {
            if (data == list.getNext().getData()) {
                list.setNext(list.getNext().getNext());
                result = true;
            } else {
                list = list.getNext();
            }
        }

        return result;
    }

    public E removeElement() { // удаление первого элемента, пусть выдает значение элемента
        E element = head.getData();
        head = head.getNext();
        return element;
    }

    public void reverseList() {  // разворот списка за линейное время
        ListItem<E> list = head;
        ListItem<E> prev = null;

        while (list != null) {
            ListItem<E> list2 = list.getNext();
            list.setNext(prev);
            prev = list;
            list = list2;
        }

        head = prev;
    }

    public SinglyLinkedList<E> copeList(SinglyLinkedList<E> linkedList) { // копирование списка
        SinglyLinkedList<E> copeLinkedList = new SinglyLinkedList<>();

        for (ListItem<E> list = linkedList.head; list != null; list = list.getNext()) {
            copeLinkedList = linkedList;
        }

        return copeLinkedList;
    }

    @Override
    public String toString() {
        StringBuilder arrayString = new StringBuilder("{");

        ListItem<E> list = head;

        for (; list.getNext() != null; list = list.getNext()) {
            arrayString.append(list.getData());
            arrayString.append(",");
        }

        arrayString.append(list.getData());

        return arrayString + "}";
    }
}
