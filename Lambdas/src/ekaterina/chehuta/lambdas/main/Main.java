package ekaterina.chehuta.lambdas.main;

import ekaterina.chehuta.lambdas.Person;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Main {
    public static void main(String[] args) {
        List<Person> list = Arrays.asList(
                new Person("Вася", 33),
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

        OptionalDouble optionalDouble = minorsList.stream()
                .mapToDouble(Person::getAge)
                .average();

        double averageAge = optionalDouble.isPresent() ? optionalDouble.getAsDouble(): 0.0;

        System.out.println("Список не совершеннолетних: " + minorsList);
        System.out.println("Средний возрос: " + averageAge);

        // Г) при помощи группировки получить Map, в котором ключи – имена, а значения – средний возраст
        Map<String, Double> mapName = list.stream()
                .collect(Collectors.groupingBy(Person::getName, Collectors.averagingDouble(Person::getAge)));

        System.out.println(mapName);

        // Д) получить людей, возраст которых от 20 до 45, вывести в консоль их имена в порядке убывания возраста
        List<Person> averageAgePersonList = list.stream()
                .filter(person -> person.getAge() >= 20 && person.getAge() <= 45)
                .collect(Collectors.toList());

        System.out.println(averageAgePersonList.stream()
                .sorted(Comparator.comparing(Person::getAge).reversed())
                .collect(Collectors.toList()));
    }
}
