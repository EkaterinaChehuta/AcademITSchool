package ekaterina.chehuta.vector.main;

import ekaterina.chehuta.vector.Vector;

import static ekaterina.chehuta.vector.Vector.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Vector(3)); // Размерность n, все компоненты 0
        Vector vector = new Vector(3.6, 5.6);
        System.out.println(new Vector(vector)); // Копирование
        double[] array = {3, 4, 5};
        System.out.println(new Vector(array)); // Заполнение значениями из массива
        System.out.println(new Vector(4, 3, 5, 6)); // Заполнение значениями из массива и размерностью n

        System.out.println("n = " + vector.getSize()); // Размерность вектора

        Vector vector1 = new Vector(2.0, 4.0, 6.0);
        Vector vector2 = new Vector(1.0, 2, 3, 4, 5, 6);
        System.out.println("Прибавление вектара к другому вектору: " + vector1.getArraysSum(vector2));

        Vector vector3 = new Vector(4.0, 5, 6);
        System.out.println("Вычитание из вектора другого вектора: " + vector2.getArraysDifference(vector3));

        System.out.println("Умножение вектора на скаляр: " + vector2.getArrayProductOnScalar(vector1, vector2));

        System.out.println("Разворот вектора (умножение всех компонент на -1): " + vector2.getReverseArray());

        System.out.println("Получение длинны вектора: " + vector2.getLength());

        vector2.installComponent(1, 23); //Установка компоненты вектора по индексу

        System.out.println("Получение компоненты вектора по индексу: " + vector2.getComponent(1));
        //System.out.println("Получение компоненты вектора по индексу: " + vector2.getComponent(6)); // Исключение RuntimeException

        Vector vector4 = new Vector(4, 3.0, 6.0);

        arraysSum(vector3, vector4);
        System.out.println("Сложение двух векторов: " + arraysSum);

        arraysDifference(vector3, vector4);
        System.out.println("Разность двух векторов: " + arraysDifference);

        Vector vector5 = new Vector(1.0, 2, 3);
        Vector vector6 = new Vector(1.0, 2, 3, 4);

        arraysScalarProduct(vector5, vector6);
        System.out.println("Скалярное произведение двух векторов: " + scalarProduct);

        Vector vector7 = new Vector(2.0, 4.0, 6.0);
        System.out.println(vector1.equals(vector7)); // Сравнение (векторы имеют одинаковую размерност и соответствующие компоненты равны)
        System.out.println(vector5.equals(vector7)); // (векторы имеют одинаковую размерность)

        Vector vector8 = new Vector(2.0, 4.0, 6.0, 7);
        System.out.println(vector7.equals(vector8));
    }
}