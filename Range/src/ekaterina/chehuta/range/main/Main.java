package ekaterina.chehuta.range.main;

import ekaterina.chehuta.range.Range;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Получение интервала-пересечения двух интервалов.
        Range range1 = new Range(2,4);
        Range range2 = new Range(3,8);

        System.out.println(Arrays.toString(range1.getArraysIntersection(range2)));

        range2.setFrom(4);

        System.out.println(Arrays.toString(range1.getArraysIntersection(range2)));
        System.out.println();

        // Получение объединения двух интервалов.
        System.out.println(Arrays.toString(range1.getArraysCombining(range2)));
        System.out.println();

        // Получение разности двух интервалов.
        Range range3 = new Range(2,10);
        Range range4 = new Range(3,8);

        System.out.println(Arrays.toString(range3.getArraysDifference(range4)));
        System.out.println(Arrays.toString(range4.getArraysDifference(range3)));

        range3.setTo(8);

        System.out.println(Arrays.toString(range3.getArraysDifference(range4)));

        range4.setFrom(2);

        System.out.println(Arrays.toString(range3.getArraysDifference(range4)));

        range3.setTo(10);

        System.out.println(Arrays.toString(range3.getArraysDifference(range4)));

        range3.setFrom(8);

        System.out.println(Arrays.toString(range3.getArraysDifference(range4)));
    }
}
