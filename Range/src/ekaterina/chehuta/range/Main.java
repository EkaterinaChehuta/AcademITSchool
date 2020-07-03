package ekaterina.chehuta.range;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите начало диапазона: ");
        double from = scanner.nextDouble();

        System.out.println("Введите конец диапазона: ");
        double to = scanner.nextDouble();

        System.out.printf("Введите число из диапзона от %f до %f.%n ", from, to);
        double number = scanner.nextDouble();

        Range range = new Range(from, to);

        System.out.println("Длина диапазона: " + range.getLength());

        if (!range.isInside(number)) {
            System.out.printf("Число %.2f не принадлежит диапазону от %.2f до %.2f.%n", number, range.getFrom(), range.getTo());
        } else {
            System.out.printf("Число %.2f принадлежит диапазону от %.2f до %.2f.%n", number, range.getFrom(), range.getTo());

            range.setFrom(from / 2);
            range.setTo(to / 2);

            if (range.isInside(number)) {
                System.out.printf("Число %.2f принадлежит диапазону от %.2f до %.2f.%n", number, range.getFrom(), range.getTo());
            } else {
                System.out.printf("Число %.2f не принадлежит диапазону от %.2f до %.2f.%n", number, range.getFrom(), range.getTo());
            }
        }
    }
}
