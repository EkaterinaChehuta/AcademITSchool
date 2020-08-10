package ekaterina.chehuta.list.main;

import ekaterina.chehuta.list.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();

        linkedList.addElement(3);
        linkedList.addElement(5);
        linkedList.addElement(5);
        linkedList.addElement(6);
        linkedList.addElement(8);
        linkedList.addElement(5);
        linkedList.addElement(5);
        linkedList.addElement(3);
        linkedList.addElement(5);
        linkedList.addElement(5);

        System.out.println(linkedList);

        System.out.println(linkedList.getCount());
        System.out.println(linkedList.getElement());
        System.out.println(linkedList.getElement(2));
        System.out.println(linkedList.setElement(2, 9));
        System.out.println(linkedList);
        System.out.println(linkedList.removeElement(2));
        System.out.println(linkedList);
        linkedList.insertElement(9, 7);
        System.out.println(linkedList);
        System.out.println(linkedList.removeItem(5));
        System.out.println(linkedList);
        System.out.println(linkedList.removeElement());
        linkedList.reverseList();
        System.out.println(linkedList);
        SinglyLinkedList<Integer> linkedList2 = new SinglyLinkedList<>();
        System.out.println(linkedList2.copeList(linkedList));
    }
}
