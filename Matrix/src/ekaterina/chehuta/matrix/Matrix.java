package ekaterina.chehuta.matrix;

import ekaterina.chehuta.vector.Vector;

import java.util.Arrays;

public class Matrix {
    private Vector[] vectors;

    // Конструктор. Матрица нулей размерностью n x m
    public Matrix(int rowsCount, int columnsCount) {
        if (rowsCount <= 0) {
            throw new IllegalArgumentException("Передан не верный аргумент колличества строк в матрице. \"" + rowsCount + "\". " +
                    "Аргумент должен быть больше 0.");
        }

        if (columnsCount <= 0) {
            throw new IllegalArgumentException("Передан не верный аргумент колличества столбцов в матрице. \"" + columnsCount + "\". " +
                    "Аргумент должен быть больше 0.");
        }

        vectors = new Vector[rowsCount];

        for (int i = 0; i < rowsCount; i++) {
            vectors[i] = new Vector(columnsCount);
        }
    }

    // Конструктор копирования
    public Matrix(Matrix matrix) {
        int rowsCount = matrix.vectors.length;
        vectors = new Vector[rowsCount];

        for (int i = 0; i < rowsCount; i++) {
            vectors[i] = new Vector(matrix.vectors[i]);
        }
    }

    // Конструктор. Заполнение матрицы значениями из двумерного массив
    public Matrix(double[][] array) {
        int rowsCount = array.length;
        int columnsCount = array[0].length;

        for (double[] e : array) {
            columnsCount = Math.max(e.length, columnsCount);
        }

        vectors = new Vector[rowsCount];

        for (int i = 0; i < rowsCount; i++) {
            vectors[i] = new Vector(columnsCount, array[i]);
        }
    }

    // Конструктор. Заполнение матрицы значениями из массива векторов-строк
    public Matrix(Vector[] vector) {
        int rowsCount = vector.length;
        int columnsCount = vector[0].getSize();

        for (Vector e : vector) {
            columnsCount = Math.max(e.getSize(), columnsCount);
        }

        vectors = new Vector[rowsCount];

        for (int i = 0; i < rowsCount; i++) {
            vectors[i] = new Vector(columnsCount);

            for (int j = 0; j < vector[i].getSize(); j++) {
                vectors[i].setComponent(j, vector[i].getComponent(j));
            }
        }
    }

    //Получение размеров матрицы
    public int getRowsCount() {
        return vectors.length;
    }

    public int getColumnsCount() {
        return vectors[0].getSize();
    }

    // Задание вектора-строки по индексу
    public void setComponentRow(int index, Vector vector) {
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException("Передан не верный аргумент индекса \"" + index + "\". " +
                    "Индекс не может быть отрицательным.");
        }

        if (vectors.length <= index) {
            throw new ArrayIndexOutOfBoundsException("Передан не верный аргумент индекса \"" + index + "\". " +
                    "Индекс больше размера матрицы. " +
                    "Допустимый диапазон индекса: от \"0\" до \"" + (vectors.length - 1) + "\".");
        }

        if (vector.getSize() > vectors[index].getSize()) {
            throw new IllegalArgumentException("Передан не верный аргумент вектора \"" + vector + "\". " +
                    "Размер переданного вектора больше размера матрицы. " +
                    "Допустимый размер вектора: \"" + vectors[0].getSize() + "\".");
        }

        if (vector.getSize() < vectors[index].getSize()) {
            Vector newVector = new Vector(vectors[index].getSize());

            for (int i = 0; i < vector.getSize(); i++) {
                newVector.setComponent(i, vector.getComponent(i));
            }

            vectors[index] = newVector;
        } else {
            vectors[index] = new Vector(vector);
        }
    }

    //Получение вектора-строки по индексу
    public Vector getComponentRow(int index) {
        if (vectors.length <= index) {
            throw new ArrayIndexOutOfBoundsException("Передан не верный аргумент индекса строки \"" + index + "\". " +
                    "Индекс больше размера матрицы. " +
                    "Допустимый диапазон индекса: от \"0\" до \"" + (vectors.length - 1) + "\".");
        }

        return new Vector(vectors[index]);
    }

    //Получение вектора-столбца по индексу
    public Vector getComponentColumn(int index) {
        if (vectors[0].getSize() <= index) {
            throw new ArrayIndexOutOfBoundsException("Передан не верный аргумент индекса столбца \"" + index + "\". " +
                    "Индекс больше размера матрицы. " +
                    "Допустимый диапазон индекса: от \"0\" до \"" + (vectors[0].getSize() - 1) + "\".");
        }

        int rowsCount = vectors.length;
        Vector vector = new Vector(rowsCount);

        for (int i = 0; i < rowsCount; i++) {
            vector.setComponent(i, vectors[i].getComponent(index));
        }

        return vector;
    }

    //Транспонирование матрицы
    public Matrix getTranspose() {
        int rowsCount = vectors[0].getSize();
        int columnsCount = vectors.length;

        Matrix matrix = new Matrix(rowsCount, columnsCount);

        for (int i = 0; i < columnsCount; i++) {
            for (int j = 0; j < rowsCount; j++) {
                matrix.vectors[j].setComponent(i, vectors[i].getComponent(j));
            }
        }

        vectors = matrix.vectors;
        return this;
    }

    //Умножение на скаляр
    public void multiplyOnScalar(int scalar) {
        for (Vector vector : vectors) {
            vector.multiplyOnScalar(scalar);
        }
    }

    //Вычисление определителя матрицы
    public double getDeterminant() {
        int rowsCount = vectors.length;
        int columnsCount = vectors[0].getSize();

        if (rowsCount != columnsCount) {
            throw new IllegalArgumentException("Невозможео вычислить детерминант. Матрица не являетс квадратной.");
        }

        if (vectors.length == 2) {
            return vectors[0].getComponent(0) * vectors[1].getComponent(1) -
                    vectors[0].getComponent(1) * vectors[1].getComponent(0);
        }

        double det = 0;

        for (int i = 0; i < columnsCount; i++) {
            int k = i;
            double prom = 1;

            for (int j = 0; j < rowsCount; j++, k++) {
                if (k >= columnsCount) {
                    k = 0;
                }

                prom *= vectors[j].getComponent(k);
            }

            det += prom;
        }

        for (int i = columnsCount - 1; i >= 0; i--) {
            int k = i;
            double prom = 1;

            for (int j = 0; j < rowsCount; j++, k--) {
                if (k < 0) {
                    k = columnsCount - 1;
                }

                prom *= vectors[j].getComponent(k);
            }

            det -= prom;
        }

        return Math.abs(det);
    }


    @Override
    public String toString() {
        return Arrays.toString(vectors);
    }

    //Умножение матрицы на вектор
    public Vector multiplyOnVector(Vector vector) {
        if (vector.getSize() != vectors[0].getSize()) {
            throw new IllegalArgumentException("Передан не верный аргумент. Размер вектора \"" + vector.getSize() + "\"" +
                    " не равен колличеству столбцов в матрице \"" + vectors[0].getSize() + "\"");
        }

        Vector newVector = new Vector(vectors.length);

        for (int i = 0; i < vectors.length; i++) {
            double vectorComponent = 0;
            for (int j = 0; j < vector.getSize(); j++) {
                vectorComponent += vector.getComponent(j) * vectors[i].getComponent(j);
            }

            newVector.setComponent(i, vectorComponent);
        }

        return newVector;
    }

    //Сложение матриц
    public void add(Matrix matrix) {
        if (vectors.length != matrix.vectors.length || vectors[0].getSize() != matrix.vectors[0].getSize()) {
            throw new IllegalArgumentException("Передан не верный аргумент. Размеры матриц не равны.");
        }

        for (int i = 0; i < vectors.length; i++) {
            vectors[i].add(matrix.vectors[i]);
        }
    }

    //Вычитание матриц
    public void subtract(Matrix matrix) {
        if (vectors.length != matrix.vectors.length || vectors[0].getSize() != matrix.vectors[0].getSize()) {
            throw new IllegalArgumentException("Передан не верный аргумент. Размеры матриц не равны.");
        }

        for (int i = 0; i < vectors.length; i++) {
            vectors[i].subtract(matrix.vectors[i]);
        }
    }

    //Сложение матриц
    public static Matrix getSum(Matrix matrix1, Matrix matrix2) {
        if (matrix1.vectors.length != matrix2.vectors.length || matrix1.vectors[0].getSize() != matrix2.vectors[0].getSize()) {
            throw new IllegalArgumentException("Передан не верный аргумент. Размеры матриц не равны.");
        }

        Matrix newMatrix = new Matrix(matrix1);
        newMatrix.add(matrix2);
        return newMatrix;
    }

    //Вычитание матриц
    public static Matrix getDifference(Matrix matrix1, Matrix matrix2) {
        if (matrix1.vectors.length != matrix2.vectors.length || matrix1.vectors[0].getSize() != matrix2.vectors[0].getSize()) {
            throw new IllegalArgumentException("Передан не верный аргумент. Размеры матриц не равны.");
        }

        Matrix newMatrix = new Matrix(matrix1);
        newMatrix.subtract(matrix2);
        return newMatrix;
    }

    // Умнжение матриц
    public static Matrix getProduct(Matrix matrix1, Matrix matrix2) {
        if (matrix1.vectors.length != matrix2.vectors[0].getSize()) {
            throw new IllegalArgumentException("Произведение матриц не возможно. " +
                    "Колличество строк " + "\"" + matrix1.vectors.length + "\"" +
                    " не равно колличеству столбцов " + "\"" + matrix2.vectors[0].getSize() + "\".");
        }

        Matrix newMatrix = new Matrix(matrix1.vectors.length, matrix2.vectors[0].getSize());
        double matrixComponent;

        for (int i = 0; i < matrix1.vectors.length; i++) {
            for (int j = 0; j < matrix2.vectors[0].getSize(); j++) {
                matrixComponent = Vector.getScalarProduct(matrix1.getComponentRow(i),matrix2.getComponentColumn(j));
                newMatrix.vectors[i].setComponent(j,matrixComponent);
            }
        }

        return newMatrix;
    }
}