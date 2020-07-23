package ekaterina.chehuta.vector;

public class Vector {
    private int n;
    private double[] array;

    // Конструктор. Размерность n, все компоненты равны 0
    public Vector(int n) {
        this.n = n;
        if (n <= 0) {
            throw new IllegalArgumentException("n");
        }

        this.array = new double[n];
    }

    // Конструктор копирования
    public Vector(Vector vector) {
        this.n = vector.array.length;
        this.array = vector.array;
        System.arraycopy(vector.array, 0, this.array, 0, n);
    }

    // Конструктор. Заполнение вектора значениями из массив
    public Vector(double... array) {
        this.n = array.length;
        this.array = new double[n];
        System.arraycopy(array, 0, this.array, 0, n);
    }

    // Конструктор. Заполнение вектора значениями из массива.
    public Vector(int n, double... array) {
        this.n = n;
        if (n <= 0) {
            throw new IllegalArgumentException("n");
        }

        this.array = new double[n];
        System.arraycopy(array, 0, this.array, 0, array.length);
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public double[] getArray() {
        return array;
    }

    public void setArray(double[] array) {
        this.array = array;
    }

    // Метод получения размерности вектора
    public int getSize() {
        this.n = 0;

        for (double e : this.array) {
            n++;
        }

        return n;
    }

    @Override
    public String toString() {
        if (array.length == 0) {
            return "{}";
        }

        StringBuilder arrayString = new StringBuilder("{");

        int i = 0;
        for (; i < array.length - 1; i++) {
            arrayString.append(array[i]);
            arrayString.append(", ");
        }

        return arrayString.toString() + array[i] + "}";
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

        if (array.length != vector.array.length) {
            return false;
        }

        for (int i = 0; i < vector.array.length; i++) {
            if (vector.array[i] != array[i]) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;

        for (double e : array) {
            result += e;
        }

        return result;
    }

    // Прибавление вектара к другому вектору
    public Vector getArraysSum(Vector v) {
        Vector vector = new Vector(v.array.length + this.array.length);
        int i = 0;

        for (; i < array.length; i++) {
            vector.array[i] = array[i];
        }

        for (int j = 0; j < v.array.length; j++, i++) {
            vector.array[i] = v.array[j];
        }

        return vector;
    }

    // Вычитание из вектора другого вектора
    public Vector getArraysDifference(Vector v) {
        this.n = 0;

        for (double e : this.array) {
            n++;
        }

        for (double f : v.array) {
            n--;
        }

        Vector vector = new Vector(n);

        System.arraycopy(this.array, 0, vector.array, 0, n);

        return vector;
    }

    // Умножение вектора на скаляр
    public Vector getArrayProductOnScalar(Vector v1, Vector v2) {
        this.n = this.array.length;
        arraysScalarProduct(v1, v2);
        Vector vector = new Vector(n);

        for (int i = 0; i < n; i++) {
            vector.array[i] = this.array[i] * scalarProduct;
        }

        return vector;
    }

    // Разворот вектора (умножение всех компонент на -1)
    public Vector getReverseArray() {
        Vector vector = new Vector(this.array.length);
        int i = 0;

        for (double e : array) {
            vector.array[i] = (-e);
            i++;
        }

        return vector;
    }

    // Получение длинны вектора
    public int getLength() {
        int length = 0;

        for (double e : this.array) {
            length++;
        }

        return length - 1;
    }

    // Установка компоненты вектора по индексу
    public void installComponent(int index, double component) {
        this.array[index] = component;
    }

    // Получение компоненты вектора по индексу
    public double getComponent(int index) {
        if (index > this.array.length - 1) {
            throw new RuntimeException("Компонента с таким индексом нет в массиве.");
        }

        return array[index];
    }

    // Сложение двух векторов
    public static Vector arraysSum;

    public static void arraysSum(Vector v1, Vector v2) {
        int n = Math.max(v1.array.length, v2.array.length);

        arraysSum = new Vector(n);
        Vector vector = new Vector(n);

        System.arraycopy(v1.array, 0, arraysSum.array, 0, v1.array.length);
        System.arraycopy(v2.array, 0, vector.array, 0, v2.array.length);

        for (int i = 0; i < n; i++) {
            arraysSum.array[i] += vector.array[i];
        }
    }

    // Разность двух векторов
    public static Vector arraysDifference;

    public static void arraysDifference(Vector v1, Vector v2) {
        int n = Math.max(v1.array.length, v2.array.length);

        arraysDifference = new Vector(n);
        Vector vector = new Vector(n);

        System.arraycopy(v1.array, 0, arraysDifference.array, 0, v1.array.length);
        System.arraycopy(v2.array, 0, vector.array, 0, v2.array.length);

        for (int i = 0; i < n; i++) {
            arraysDifference.array[i] -= vector.array[i];
        }
    }

    // Скалярное произведение двух векторов
    public static int scalarProduct;

    public static void arraysScalarProduct(Vector v1, Vector v2) {
        int i = 0;
        int n = Math.min(v1.array.length, v2.array.length);

        for (; i < n; i++) {
            scalarProduct += (v1.array[i] * v2.array[i]);
        }
    }
}