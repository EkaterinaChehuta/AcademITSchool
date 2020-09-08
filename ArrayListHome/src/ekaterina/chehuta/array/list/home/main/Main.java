package ekaterina.chehuta.array.list.home.main;

import ekaterina.chehuta.array.list.home.ArrayListHome;

public class Main {
    public static void main(String[] args){
        ArrayListHome<String> list = new ArrayListHome<>("C:\\Users\\Ekaterina\\IdeaProjects\\AcademITSchool\\ArrayListHome\\src\\ekaterina\\chehuta\\array\\list\\home\\list");
        System.out.println(list);
        System.out.println(list.getSize());

        list.oddNumbersList();
        System.out.println(list);
        System.out.println(list.getSize());

        ArrayListHome<String> newList = new ArrayListHome<>(list.getLinkedList());
        System.out.println(newList);
        System.out.println(newList.getSize());

        System.out.println(list);
        System.out.println(list.getSize());
    }
}