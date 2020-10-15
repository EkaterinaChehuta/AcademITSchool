package ekaterina.chehuta.hash.table.main;

import ekaterina.chehuta.hash.table.HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        HashTable<String> hashTable = new HashTable<>(5);
        System.out.print(hashTable.getCount() + " = ");
        System.out.print(hashTable);
        System.out.println(" = " + hashTable.size());

        hashTable.add("t");
        hashTable.add("p");
        hashTable.add("p");
        hashTable.add("o");
        hashTable.add("m");
        hashTable.add("f");

        System.out.print(hashTable.getCount() + " = ");
        System.out.print(hashTable);
        System.out.println(" = " + hashTable.size());

        hashTable.remove("l");
        System.out.print(hashTable.getCount() + " = ");
        System.out.print(hashTable);
        System.out.println(" = " + hashTable.size());

        Collection<String> collection = new ArrayList<>();
        collection.add("t");
        collection.add("q");
        collection.add("z");
        System.out.print(collection.size() + " = ");
        System.out.println(collection);

        hashTable.addAll(collection);
        System.out.print(hashTable.getCount() + " = ");
        System.out.print(hashTable);
        System.out.println(" = " + hashTable.size());

        System.out.println(hashTable.containsAll(collection));

        Collection<String> collection2 = new ArrayList<>();
        collection2.add("t");
        collection2.add("q");
        collection2.add("z");
        System.out.print(collection2.size() + " = ");
        System.out.println(collection2);

        hashTable.removeAll(collection2);
        System.out.print(hashTable.getCount() + " = ");
        System.out.print(hashTable);
        System.out.println(" = " + hashTable.size());

        Collection<String> collection3 = new ArrayList<>();
        collection3.add("p");
        collection3.add("t");
        collection3.add("n");
        System.out.print(collection3.size() + " = ");
        System.out.println(collection3);

        hashTable.retainAll(collection3);
        System.out.print(hashTable.getCount() + " = ");
        System.out.print(hashTable);
        System.out.println(" = " + hashTable.size());

        System.out.println(Arrays.toString(hashTable.toArray()));

        hashTable.clear();
        System.out.println(hashTable);
    }
}
