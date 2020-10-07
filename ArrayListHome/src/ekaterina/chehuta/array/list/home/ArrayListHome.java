package ekaterina.chehuta.array.list.home;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ArrayListHome {
    public static void main(String[] args) {
        ArrayList<String> stringsList = getNumbersList("C:\\Users\\Ekaterina\\IdeaProjects\\AcademITSchool\\ArrayListHome\\src\\ekaterina\\chehuta\\array\\list\\home\\list");
        System.out.println(stringsList);

        ArrayList<Integer> integersList = getIntegersList(stringsList);

        removesEvenIntegersFromList(integersList);
        System.out.println(integersList);

        ArrayList<Integer> newIntegersList = getUniqueIntegersList(integersList);
        System.out.println(newIntegersList);
    }

    public static ArrayList<String> getNumbersList(String Url) {
        ArrayList<String> arrayList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(Url))) {
            String string;

            while ((string = bufferedReader.readLine()) != null) {
                arrayList.add(string);
            }
        } catch (IOException e) {
            throw new NumberFormatException("Список не состоит из целых чисел.");
        }

        return arrayList;
    }

    public static ArrayList<Integer> getIntegersList(ArrayList<String> arrayList) {
        ArrayList<Integer> integersList = new ArrayList<>();

        for (String s : arrayList) {
            try {
                integersList.add(Integer.parseInt(s));
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Список не состоит из целых чисел.");
            }
        }

        return integersList;
    }

    // Есть список из целых чисел. Удалить из него все четные числа. В
    // этой задаче новый список создавать нельзя
    public static void removesEvenIntegersFromList(ArrayList<Integer> integersList) {
        for (int i = 0; i < integersList.size(); i++) {
            if (integersList.get(i) % 2 == 0) {
                integersList.remove(i);
                i--;
            }
        }
    }

    // Надо создать новый список, в котором будут элементы первого списка
    // в таком же порядке, но без повторений
    public static ArrayList<Integer> getUniqueIntegersList(ArrayList<Integer> integersList) {
        ArrayList<Integer> uniqueIntegersList = new ArrayList<>();

        e:
        for (Integer integer : integersList) {
            for (Integer value : uniqueIntegersList) {
                if (integer.equals(value)) {
                    continue e;
                }
            }

            uniqueIntegersList.add(integer);
        }

        return uniqueIntegersList;
    }
}