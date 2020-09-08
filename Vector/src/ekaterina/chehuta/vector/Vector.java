package ekaterina.chehuta.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    // Конструктор. Размерность n, все компоненты равны 0
    public Vector(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Передан не верный аргумент. Размер вектора должен быть больше 0.");
        }

        components = new double[size];
    }

    // Конструктор копирования
    public Vector(Vector vector) {
        components = Arrays.copyOf(vector.components, vector.components.length);
    }

    // Конструктор. Заполнение вектора значениями из массив
    public Vector(double... array) {
        if (array.length <= 0) {
            throw new IllegalArgumentException("Передан не верный аргумент. Размер массива должен быть больше 0.");
        }

        components = Arrays.copyOf(array, array.length);
    }

    // Конструктор. Заполнение вектора значениями из массива.
    public Vector(int size, double... array) {
        if (size <= 0) {
            throw new IllegalArgumentException("Передан не верный аргумент. Размер вектора должен быть больше 0.");
        }

        components = Arrays.copyOf(array, size);
    }

    // Метод получения размерности вектора
    public int getSize() {
        return components.length;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");

        for (int i = 0; i < components.length - 1; i++) {
            stringBuilder.append(components[i]);
            stringBuilder.append(", ");
        }

        stringBuilder.append(components[components.length - 1]);
        stringBuilder.append("}");

        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Vector vector = (Vector) o;

        if (components.length != vector.components.length) {
            return false;
        }

        for (int i = 0; i < vector.components.length; i++) {
            if (vector.components[i] != components[i]) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(components);
    }

    // Прибавление вектара к другому вектору
    public void add(Vector vector) {
        if (components.length < vector.components.length) {
            components = Arrays.copyOf(components, vector.components.length);
        }

        for (int i = 0; i < vector.components.length; i++) {
            components[i] += vector.components[i];
        }
    }

    // Вычитание из вектора другого вектора
    public void subtract(Vector vector) {
        if (components.length < vector.components.length) {
            components = Arrays.copyOf(components, vector.components.length);
        }

        for (int i = 0; i < vector.components.length; i++) {
            components[i] -= vector.components[i];
        }
    }

    // Умножение вектора на скаляр
    public void multiplyOnScalar(double scalar) {
        for (int i = 0; i < components.length; i++) {
            components[i] *= scalar;
        }
    }

    // Разворот вектора (умножение всех компонент на -1)
    public void reverse() {
        multiplyOnScalar(-1);
    }

    // Получение длинны вектора
    // todo вычисляется не верно
    public double getLength() {
        double min = components[0];
        double max = components[0];

        for (double e : components) {
            if (min > e) {
                min = e;
            }

            if (max < e) {
                max = e;
            }
        }

        return Math.abs(max - Math.abs(min));
    }

    // Получение компоненты вектора по индексу
    public double getComponent(int index) {
        return components[index];
    }

    // Установка компоненты вектора по индексу
    public void setComponent(int index, double component) {
        components[index] = component;
    }

    // Сложение двух векторов
    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector newVector = new Vector(vector1);
        newVector.add(vector2);
        return newVector;
    }

    // Разность двух векторов
    public static Vector getDifference(Vector vector1, Vector vector2) {
        Vector newVector = new Vector(vector1);
        newVector.subtract(vector2);
        return newVector;
    }

    // Скалярное произведение двух векторов
    public static double getScalarProduct(Vector vector1, Vector vector2) {
        double scalarProduct = 0;
        int size = Math.min(vector1.components.length, vector2.components.length);

        for (int i = 0; i < size; i++) {
            scalarProduct += (vector1.components[i] * vector2.components[i]);
        }

        return scalarProduct;
    }
}