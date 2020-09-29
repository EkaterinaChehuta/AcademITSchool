package ekaterina.chehuta.list;

public class ListItem<E> { //элемент или узел списка
    private E data; // данные которые хранит узел
    private ListItem<E> next; // ссылка на следующий элемент

    public ListItem(E data) {
        this.data = data;
    }

    public ListItem(E data, ListItem<E> next){
        this.data = data;
        this.next = next;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public ListItem<E> getNext() {
        return next;
    }

    public void setNext(ListItem<E> next) {
        this.next = next;
    }
}