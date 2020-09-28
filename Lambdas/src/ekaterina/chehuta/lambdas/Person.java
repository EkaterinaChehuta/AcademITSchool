package ekaterina.chehuta.lambdas;

import java.util.*;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "(name: " + name + ", " +
                "age: " + age + ")";
    }

    public static void main(String[] args) {
        List<Person> list = Arrays.asList(new Person("Вася", 33),
                new Person("Коля", 16),
                new Person("Дима", 25),
                new Person("Саша", 16),
                new Person("Вася", 47),
                new Person("Коля", 8));

        list.forEach(System.out::println);

        // А) получить список уникальных имен
        List<String> uniqueNamesList = list.stream()
                .map(Person::getName)
                .distinct()
                .collect(Collectors.toList());

        // Б) вывести список уникальных имен в формате: Имена: Иван, Сергей, Петр.
        System.out.println(uniqueNamesList.stream()
                .collect(Collectors.joining(", ", "Имена: ", ".")));

        // В) получить список людей младше 18, посчитать для них средний возраст
        List<Person> minorsList = list.stream()
                .filter(person -> person.getAge() < 18)
                .collect(Collectors.toList());

        double middleAge = minorsList.stream()
                .mapToInt(Person::getAge)
                .average().getAsDouble();

        System.out.println("Список не совершеннолетних: " + minorsList);
        System.out.println("Средний возрос: " + middleAge);

        // Г) при помощи группировки получить Map, в котором ключи – имена, а значения – средний возраст
        Map<String, Double> map = list.stream()
                .collect(Collectors.groupingBy(Person::getName, Collectors.averagingDouble(Person::getAge)));

        System.out.println(map);

        // Д) получить людей, возраст которых от 20 до 45, вывести в консоль их имена в порядке убывания возраста
        List<Person> listMiddleAge = list.stream()
                .filter(person -> person.getAge() > 20 && person.getAge() < 45)
                .collect(Collectors.toList());

        System.out.println(listMiddleAge.stream()
                .sorted(Comparator.comparing(person -> person.age))
                .collect(Collectors.toList()));
    }
}

