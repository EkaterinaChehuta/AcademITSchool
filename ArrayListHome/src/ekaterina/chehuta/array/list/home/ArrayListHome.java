package ekaterina.chehuta.array.list.home;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ArrayListHome {
    public static void main(String[] args) {
        ArrayList<String> arrayList = readEndWrite("C:\\Users\\Ekaterina\\IdeaProjects\\AcademITSchool\\ArrayListHome\\src\\ekaterina\\chehuta\\array\\list\\home\\list");
        System.out.println(arrayList);

        oddNumbersList(arrayList);
        System.out.println(arrayList);

        ArrayList<String> arrayList1 = getLinkedList(arrayList);
        System.out.println(arrayList1);
    }

    public static ArrayList<String> readEndWrite(String fileReader) {
        ArrayList<String> arrayList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileReader))) {
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                arrayList.add(string);
            }
        } catch (IOException ignore) {
        }

        return arrayList;
    }

    //    Есть список из целых чисел. Удалить из него все четные числа. В
//    этой задаче новый список создавать нельзя
    public static void oddNumbersList(ArrayList<String> arrayList) {
        int[] integerList = new int[arrayList.size()];

        for (int i = 0; i < arrayList.size(); i++) {
            try {
                integerList[i] = Integer.parseInt(arrayList.get(i));

                if (integerList[i] % 2 == 0) {
                    arrayList.remove(i);
                    i--;
                }
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Список не состоит из целых чисел.");
            }
        }
    }

    //    Надо создать новый список, в котором будут элементы первого списка
//    в таком же порядке, но без повторений
    public static ArrayList<String> getLinkedList(ArrayList<String> arrayList) {
        ArrayList<String> newArrayList = new ArrayList<>(arrayList);
        int[] integerNewList = new int[arrayList.size()];

        for (int i = 0; i < newArrayList.size(); i++) {
            try {
                integerNewList[i] = Integer.parseInt(arrayList.get(i));

                for (int j = i + 1; j < newArrayList.size() - 1; j++) {
                    integerNewList[j] = Integer.parseInt(arrayList.get(j));

                    if (integerNewList[i] == integerNewList[j]) {
                        newArrayList.remove(j);
                        j--;
                    }
                }
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Список не состоит из целых чисел.");
            }
        }

        return newArrayList;
    }
}