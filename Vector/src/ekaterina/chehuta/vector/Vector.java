package ekaterina.chehuta.vector;

public class Vector {
    private double[] vectorComponents;

    // Конструктор. Размерность n, все компоненты равны 0
    public Vector(int vectorSize) {
        if (vectorSize <= 0) {
            throw new IllegalArgumentException("В качестве аргумента передано не подходящее число. Аргумент должен быть больше 0.");
        }

        vectorComponents = new double[vectorSize];
    }

    // Конструктор копирования
    public Vector(Vector vector) {
        int vectorSize = vector.vectorComponents.length;
        vectorComponents = new double[vectorSize];
        System.arraycopy(vector.vectorComponents, 0, vectorComponents, 0, vectorSize);
    }

    // Конструктор. Заполнение вектора значениями из массив
    public Vector(double... array) {
        if (array.length <= 0) {
            throw new IllegalArgumentException("В качестве аргумента передано не подходящее число. Аргумент должен быть больше 0.");
        }

        vectorComponents = new double[array.length];
        System.arraycopy(array, 0, vectorComponents, 0, array.length);
    }

    // Конструктор. Заполнение вектора значениями из массива.
    public Vector(int vectorSize, double... array) {
        if (vectorSize <= 0) {
            throw new IllegalArgumentException("В качестве длинны массива передано не подходящее число. Аргумент должен быть больше 0.");
        }

        if (vectorSize < array.length) {
            throw new IllegalArgumentException("В качестве длинны массива передано не подходящее число. Аргумент должен быть больше или равен длинне передаваемого массива.");
        }

        vectorComponents = new double[vectorSize];
        System.arraycopy(array, 0, vectorComponents, 0, array.length);
    }

    // Метод получения размерности вектора
    public int getSize() {
        return vectorComponents.length;
    }

    @Override
    public String toString() {
        if (vectorComponents.length == 0) {
            return "{}";
        }

        StringBuilder stringBuilder = new StringBuilder("{");


        for (int i = 0; i < vectorComponents.length - 1; i++) {
            stringBuilder.append(vectorComponents[i]);
            stringBuilder.append(", ");
        }

        stringBuilder.append(vectorComponents[vectorComponents.length - 1]);
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

        if (vectorComponents.length != vector.vectorComponents.length) {
            return false;
        }

        for (int i = 0; i < vector.vectorComponents.length; i++) {
            if (vector.vectorComponents[i] != vectorComponents[i]) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 23;
        int hash = 1;

        for(double e: vectorComponents) {
            hash = prime * hash + Double.hashCode(e);
        }

        return hash;
    }

    // Прибавление вектара к другому вектору
    public Vector addVector(Vector v) {
        if (vectorComponents.length < v.vectorComponents.length) {
            Vector vector = new Vector(v.vectorComponents.length);
            System.arraycopy(vectorComponents, 0, vector.vectorComponents, 0, vectorComponents.length);
            vectorComponents = vector.vectorComponents;
        }

        for (int i = 0; i < v.vectorComponents.length; i++) {
            vectorComponents[i] += v.vectorComponents[i];
        }

        return this;
    }

    // Вычитание из вектора другого вектора
    public Vector subtractVector(Vector v) {
        if (vectorComponents.length < v.vectorComponents.length) {
            Vector vector = new Vector(v.vectorComponents.length);
            System.arraycopy(vectorComponents, 0, vector.vectorComponents, 0, vectorComponents.length);
            vectorComponents = vector.vectorComponents;
        }

        for (int i = 0; i < v.vectorComponents.length; i++) {
            vectorComponents[i] -= v.vectorComponents[i];
        }

        return this;
    }

    // Умножение вектора на скаляр
    public Vector productVectorOnScalar(int scalar) {
        for (int i = 0; i < vectorComponents.length; i++) {
            vectorComponents[i] = vectorComponents[i] * scalar;
        }

        return this;
    }

    // Разворот вектора (умножение всех компонент на -1)
    public Vector getReverseVector() {
        int scalar = -1;
        for (int i = 0; i < vectorComponents.length; i++) {
            vectorComponents[i] *= scalar;
        }

        return this;
    }

    // Получение длинны вектора
    public int getLength() {
        int length = 0;

        for (double e : vectorComponents) {
            length++;
        }

        return length - 1;
    }

    // Установка компоненты вектора по индексу
    public void setComponent(int index, double component) {
        vectorComponents[index] = component;
    }

    // Получение компоненты вектора по индексу
    public double getComponent(int index) {
        return vectorComponents[index];
    }

    // Сложение двух векторов
    public static Vector getVectorsSum(Vector v1, Vector v2) {
        return v1.addVector(v2);
    }

    // Разность двух векторов
    public static Vector getVectorsDifference(Vector v1, Vector v2) {
        return v1.subtractVector(v2);
    }

    // Скалярное произведение двух векторов
    public static double getVectorsScalarProduct(Vector v1, Vector v2) {
        double scalarProduct = 0;
        int vectorSize = Math.min(v1.vectorComponents.length, v2.vectorComponents.length);

        for (int i = 0; i < vectorSize; i++) {
            scalarProduct += (v1.vectorComponents[i] * v2.vectorComponents[i]);
        }
        return scalarProduct;
    }
}