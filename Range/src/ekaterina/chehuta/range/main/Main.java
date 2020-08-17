package ekaterina.chehuta.range.main;

import ekaterina.chehuta.range.Range;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Получение интервала-пересечения двух интервалов.
        Range range1 = new Range(2, 4);
        Range range2 = new Range(3, 8);

        System.out.println(range1.getIntersection(range2));

        range2.setFrom(4);

        System.out.println(range1.getIntersection(range2));
        System.out.println();

        // Получение объединения двух интервалов.
        Range range5 = new Range(1,2);
        Range range6 = new Range(3,6);
        System.out.println(Arrays.toString(range5.getUnion(range6)));

        range5.setTo(3);

        System.out.println(Arrays.toString(range6.getUnion(range5)));

        range6.setFrom(4);

        System.out.println(Arrays.toString(range6.getUnion(range5)));
        System.out.println();

        // Получение разности двух интервалов.
        Range range3 = new Range(3, 5);
        Range range4 = new Range(1, 7);

        System.out.println(Arrays.toString(range3.getDifference(range4)));
        System.out.println(Arrays.toString(range4.getDifference(range3)));

        range3.setTo(8);

        System.out.println(Arrays.toString(range3.getDifference(range4)));

        range4.setFrom(2);

        System.out.println(Arrays.toString(range3.getDifference(range4)));

        range3.setTo(10);

        System.out.println(Arrays.toString(range3.getDifference(range4)));

        range3.setFrom(8);

        System.out.println(Arrays.toString(range3.getDifference(range4)));
    }
}
