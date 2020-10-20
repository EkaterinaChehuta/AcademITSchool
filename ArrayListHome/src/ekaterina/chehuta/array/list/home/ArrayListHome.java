package ekaterina.chehuta.array.list.home;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ArrayListHome {
    public static void main(String[] args) throws IOException {
        ArrayList<String> stringsList = getStringsList("ArrayListHome/list.txt");
        System.out.println(stringsList);

        ArrayList<Integer> integersList = getIntegersList(stringsList);

        removeEvenIntegersFromList(integersList);
        System.out.println(integersList);

        ArrayList<Integer> newIntegersList = getUniqueIntegersList(integersList);
        System.out.println(newIntegersList);
    }

    public static ArrayList<String> getStringsList(String fileName) throws IOException {
        ArrayList<String> arrayList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String string;

            while ((string = bufferedReader.readLine()) != null) {
                arrayList.add(string);
            }
        }

        return arrayList;
    }

    public static ArrayList<Integer> getIntegersList(ArrayList<String> stringsList) {
        ArrayList<Integer> integersList = new ArrayList<>();

        for (String s : stringsList) {
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
    public static void removeEvenIntegersFromList(ArrayList<Integer> integersList) {
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
        ArrayList<Integer> uniqueIntegersList = new ArrayList<>(integersList.size());

        for (Integer integer : integersList) {
            if (!uniqueIntegersList.contains(integer)) {
                uniqueIntegersList.add(integer);
            }
        }

        return uniqueIntegersList;
    }
}