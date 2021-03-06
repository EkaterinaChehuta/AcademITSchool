package ekaterina.chehuta.array.list.main;

import ekaterina.chehuta.array.list.ArrayList;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Double> arrayList = new ArrayList<>(10);
        System.out.println(arrayList);
        arrayList.add(1.0);
        arrayList.add(3.0);
        arrayList.add(5.0);
        arrayList.add(3.0);
        arrayList.add(7.0);
        arrayList.add(6.0);
        System.out.print(arrayList.size());
        System.out.println(arrayList);

        ArrayList<Double> arrayList1 = new ArrayList<>();
        arrayList1.add(5.0);
        arrayList1.add(7.0);
        arrayList1.add(1, 8.0);
        System.out.print(arrayList1.size());
        System.out.println(arrayList1);
        System.out.println();

        Double[] doubles = new Double[8];
        System.out.println(Arrays.toString(doubles));
        System.out.println(Arrays.toString(arrayList.toArray(doubles)));

        System.out.println(arrayList.containsAll(arrayList1));

        arrayList.add(3,null);
        System.out.println(arrayList);
        System.out.println(arrayList.remove(null));

        System.out.println(arrayList.size() + " = " + arrayList + " addAll " + arrayList1.size() + " = " + arrayList1);
        arrayList.addAll(2, arrayList1);
        System.out.print(arrayList.size());
        System.out.println(arrayList);

        arrayList.removeAll(arrayList1);
        System.out.print(arrayList.size());
        System.out.println(" removeAll " + arrayList);
        System.out.println(arrayList.contains(3.0));

        ArrayList<Double> arrayList2 = new ArrayList<>();
        arrayList2.add(1.0);
        arrayList2.add(6.0);
        System.out.print(arrayList2.size());
        System.out.println(arrayList2);
        System.out.println(" retainAll " + arrayList.retainAll(arrayList2));
        System.out.print(arrayList.size());
        System.out.println(arrayList);

        arrayList.set(0, 5.0);
        System.out.println(arrayList);

        ArrayList<Integer> arrayList3 = new ArrayList<>(4);
        arrayList3.add(5);
        arrayList3.add(5);
        arrayList3.add(5);
        System.out.println(arrayList3);

        System.out.println(arrayList3.remove(null));
    }
}