package ekaterina.chehuta.lambdas.main;

import ekaterina.chehuta.lambdas.Person;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> list = Arrays.asList(
                new Person("����", 33),
                new Person("����", 16),
                new Person("����", 25),
                new Person("����", 16),
                new Person("����", 47),
                new Person("����", 8));

        list.forEach(System.out::println);

        // �) �������� ������ ���������� ����
        List<String> uniqueNamesList = list.stream()
                .map(Person::getName)
                .distinct()
                .collect(Collectors.toList());

        // �) ������� ������ ���������� ���� � �������: �����: ����, ������, ����.
        System.out.println(uniqueNamesList.stream()
                .collect(Collectors.joining(", ", "�����: ", ".")));

        // �) �������� ������ ����� ������ 18, ��������� ��� ��� ������� �������
        List<Person> minorsList = list.stream()
                .filter(person -> person.getAge() < 18)
                .collect(Collectors.toList());

        double averageAge = minorsList.stream()
                .mapToDouble(Person::getAge)
                .average()
                .orElseThrow(() -> new NoSuchElementException("���������� ����� ������� �������."));

        System.out.println("������ ������������������: " + minorsList);
        System.out.println("������� �������: " + averageAge);

        // �) ��� ������ ����������� �������� Map, � ������� ����� � �����, � �������� � ������� �������
        Map<String, Double> averageAgesMap = list.stream()
                .collect(Collectors.groupingBy(Person::getName, Collectors.averagingDouble(Person::getAge)));

        System.out.println(averageAgesMap);

        // �) �������� �����, ������� ������� �� 20 �� 45, ������� � ������� �� ����� � ������� �������� ��������
        List<Person> middleAgePersonsList = list.stream()
                .filter(person -> person.getAge() >= 20 && person.getAge() <= 45)
                .sorted(Comparator.comparing(Person::getAge).reversed())
                .collect(Collectors.toList());

        System.out.println(middleAgePersonsList);
    }
}
