package ekaterina.chehuta.list.main;

import ekaterina.chehuta.list.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();

//        System.out.println(linkedList);
        linkedList.insertItem(3);
        linkedList.insertItem(4);
        linkedList.insertItem(5);
        linkedList.insertItem(6);
        linkedList.insertItem(8);
        linkedList.insertItem(5);
        linkedList.insertItem(5);
        linkedList.insertItem(3);
        linkedList.insertItem(4);
        linkedList.insertItem(5);

        System.out.println(linkedList);

        System.out.println(linkedList.getCount());
        System.out.println(linkedList.getListItemData());
        System.out.println(linkedList.getListItemData(2));
        System.out.println(linkedList.setItem(2, 9));
        System.out.println(linkedList);
        System.out.println(linkedList.removeListItem(2));
        System.out.println(linkedList);
//        linkedList.insertItem(10, 7);
        System.out.println(linkedList);
        System.out.println(linkedList.removeItem(2));
        System.out.println(linkedList);
        System.out.println(linkedList.removeListItem());
        linkedList.reverseList();
        System.out.println(linkedList);
        SinglyLinkedList<Integer> linkedList2 = new SinglyLinkedList<>();
//        System.out.println(linkedList2.copyList(linkedList));

        System.out.println(new SinglyLinkedList<>());
    }
}
