package ekaterina.chehuta.matrix;

import ekaterina.chehuta.vector.Vector;

public class Matrix {
    private int countLines;
    private int countColumns;
    private Vector[] vectors;

    // Конструктор. Матрица нулей размерностью n x m
    public Matrix(int n, int m) {
        this.countLines = n;
        this.countColumns = m;

        vectors = new Vector[n];

        for (int i = 0; i < n; i++) {
            vectors[i] = new Vector(m);
        }
    }

    // Конструктор копирования
    public Matrix(Matrix matrix) {
        countLines = matrix.vectors.length;

        for (Vector e : matrix.vectors) {
            countColumns = Math.max(e.getSize(), countColumns);
        }

        vectors = new Vector[countLines];

        for (int i = 0; i < countLines; i++) {
            vectors[i] = new Vector(countColumns);

            for (int j = 0; j < matrix.vectors[i].getSize(); j++) {
                vectors[i].setComponent(j, matrix.vectors[i].getComponent(j));
            }
        }
    }

    // Конструктор. Заполнение матрицы значениями из двумерного массив
    public Matrix(double[][] array) {
        countLines = array.length;

        for (double[] e : array) {
            countColumns = Math.max(e.length, countColumns);
        }

        vectors = new Vector[countLines];

        for (int i = 0; i < countLines; i++) {
            vectors[i] = new Vector(countColumns);

            for (int j = 0; j < array[i].length; j++) {
                vectors[i].setComponent(j, array[i][j]);
            }
        }
    }

    // Конструктор. Заполнение матрицы значениями из массива векторов-строк
    public Matrix(Vector[] vector) {
        countLines = vector.length;

        for (Vector e : vector) {
            countColumns = Math.max(e.getSize(), countColumns);
        }

        vectors = new Vector[countLines];

        for (int i = 0; i < countLines; i++) {
            vectors[i] = new Vector(countColumns);

            for (int j = 0; j < vector[i].getSize(); j++) {
                vectors[i].setComponent(j, vector[i].getComponent(j));
            }
        }
    }

    //Получение размеров матрицы
    public int[] getLength() {
        return new int[]{countLines, countColumns};
    }

    // Задание вектора-строки по индексу
    public void setComponentString(int index, Vector vector) {
        if (countLines < index) {
            throw new IllegalArgumentException("Передан не верный аргумент. Индекс больше размера матрицы.");
        }

        if (vector.getSize() > vectors[index].getSize()) {
            throw new IllegalArgumentException("Передан не верный аргумент. Размер переданного вектора больше размера матрицы.");
        }

        if (vector.getSize() < vectors[index].getSize()) {
            Vector v = new Vector(vectors[index].getSize());

            for (int i = 0; i < vector.getSize(); i++) {
                v.setComponent(i, vector.getComponent(i));
            }

            vectors[index] = v;
        } else {
            vectors[index] = vector;
        }
    }

    //Получение вектора-строки по индексу
    public Vector getComponentString(int index) {
        if (countColumns < index) {
            throw new IllegalArgumentException("Передан не верный аргумент. Индекс больше размера матрицы.");
        }

        return vectors[index];
    }

    //Получение вектора-столбца по индексу
    public Vector getComponentColumn(int index) {
        if (countColumns < index) {
            throw new IllegalArgumentException("Передан не верный аргумент. Индекс больше размера матрицы.");
        }

        countLines = vectors.length;
        Vector vector = new Vector(countLines);

        for (int i = 0; i < countLines; i++) {
            vector.setComponent(i, vectors[i].getComponent(index));
        }

        return vector;
    }

    //Транспонирование матрицы
    public Matrix getTransposeMatrix() {
        countLines = vectors[0].getSize();
        countColumns = vectors.length;

        Matrix matrix = new Matrix(countLines, countColumns);

        for (int i = 0; i < countColumns; i++) {
            for (int j = 0; j < countLines; j++) {
                matrix.vectors[j].setComponent(i, vectors[i].getComponent(j));
            }
        }

        return matrix;
    }

    //Умножение на скаляр
    public void productMatrixOnScalar(int scalar) {
        for (int i = 0; i < countLines; i++) {
            for (int j = 0; j < countColumns; j++) {
                vectors[i].setComponent(j, vectors[i].getComponent(j) * scalar);
            }
        }
    }

    //Вычисление определителя матрицы
    public double getMatrixDeterminant() {
        countLines = vectors.length;
        countColumns = vectors[0].getSize();

        double det = 0;

        for (int i = 0; i < countColumns; i++) {
            int k = i;
            double prom = 1;

            for (int j = 0; j < countLines; j++, k++) {
                if (k >= countColumns) {
                    k = 0;
                }

                prom *= vectors[j].getComponent(k);
            }

            det += prom;
        }

        for (int i = countColumns - 1; i >= 0; i--) {
            int k = i;
            double prom = 1;

            for (int j = 0; j < countLines; j++, k--) {
                if (k < 0) {
                    k = countColumns - 1;
                }

                prom *= vectors[j].getComponent(k);
            }

            det -= prom;
        }

        return Math.abs(det);
    }

    @Override
    public String toString() {
        if (countLines == 0) {
            return "{}";
        }

        StringBuilder arrayString = new StringBuilder("{");

        int i = 0;
        for (; i < countLines - 1; i++) {
            arrayString.append(vectors[i]);
            arrayString.append(", ");
        }

        arrayString.append(vectors[i]);

        return arrayString.toString() + "}";
    }

    //Умножение матрицы на вектор
    public void productMatrixOnVector(Vector vector) {
        if (vector.getSize() > vectors[0].getSize()) {
            throw new IllegalArgumentException("Передан не верный аргумент. Длина вектора больше размера матрицы.");
        }

        for (Vector e : vectors) {
            for (int j = 0; j < countColumns; j++) {
                e.setComponent(j, e.getComponent(j) * vector.getComponent(j));
            }
        }
    }

    //Сложение матриц
    public void addMatrices(Matrix matrix) {
        if (vectors.length != matrix.vectors.length || vectors[0].getSize() != matrix.vectors[0].getSize()) {
            throw new IllegalArgumentException("Передан не верный аргумент. Размеры матриц не равны.");
        }

        for (int i = 0; i < countLines; i++) {
            for (int j = 0; j < countColumns; j++) {
                vectors[i].setComponent(j, vectors[i].getComponent(j) + matrix.vectors[i].getComponent(j));
            }
        }
    }

    //Вычитание матриц
    public void subtractMatrices(Matrix matrix) {
        if (vectors.length != matrix.vectors.length || vectors[0].getSize() != matrix.vectors[0].getSize()) {
            throw new IllegalArgumentException("Передан не верный аргумент. Размеры матриц не равны.");
        }

        for (int i = 0; i < countLines; i++) {
            for (int j = 0; j < countColumns; j++) {
                vectors[i].setComponent(j, vectors[i].getComponent(j) - matrix.vectors[i].getComponent(j));
            }
        }
    }

    //Сложение матриц
    public static Matrix getMatricesSum(Matrix matrix1, Matrix matrix2) {
        Matrix newMatrix = new Matrix(matrix1);
        newMatrix.addMatrices(matrix2);
        return newMatrix;
    }

    //Вычитание матриц
    public static Matrix getMatricesDifference(Matrix matrix1, Matrix matrix2) {
        Matrix newMatrix = new Matrix(matrix1);
        newMatrix.subtractMatrices(matrix2);
        return newMatrix;
    }

    // Умнжение матриц
    public static Matrix getMatricesProduct(Matrix matrix1, Matrix matrix2) {
        if (matrix1.countLines != matrix2.countLines || matrix1.countColumns != matrix2.countColumns) {
            throw new IllegalArgumentException("Передан не верный аргумент. Размеры матриц не равны.");
        }

        Matrix newMatrix = new Matrix(matrix1.countLines, matrix1.countColumns);
        for (int i = 0; i < matrix1.countLines; i++) {
            for (int j = 0; j < matrix1.countColumns; j++) {
                newMatrix.vectors[i].setComponent(j, matrix1.vectors[i].getComponent(j) * matrix2.vectors[i].getComponent(j));
            }
        }

        return newMatrix;
    }
}