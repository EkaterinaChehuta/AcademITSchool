package ekaterina.chehuta.matrix.main;

import ekaterina.chehuta.matrix.Matrix;
import ekaterina.chehuta.vector.Vector;

public class Main {
    public static void main(String[] args) {
        // Конструктор. Матрица нулей размерностью n x m
        Matrix matrix = new Matrix(2, 5);
        System.out.println(matrix);

        // Конструктор копирования
        Vector[] vector = new Vector[]{new Vector(1.9,5), new Vector(2.0, 6, 3, 7)};
        Matrix matrix1 = new Matrix(vector);
        System.out.println(new Matrix(matrix1));

        // Конструктор. Заполнение матрицы значениями из двумерного массив
        double[][] array = {{1, 2, 3, 4}, {5, 6, 7}};
        System.out.println(new Matrix(array));

        // Конструктор. Заполнение матрицы значениями из массива векторов-строк
        Vector vector1 = new Vector(2.0, 4.0, 6.0, 7, 8, 9);
        Vector vector2 = new Vector(1.0, 2, 3, 4);
        Vector[] vectors = {vector1, vector2};
        System.out.println(new Matrix(vectors));

        System.out.println(matrix.getRowsCount());
        System.out.println(matrix.getColumnsCount());
        Matrix matrix2 = new Matrix(new Vector[]{new Vector(1.0, 2, 3, 4), new Vector(5.0, 6, 7, 8, 5)});
        System.out.println(matrix2);
        matrix2.setComponentRow(1, new Vector(8.0, 7, 6, 5)); // Задание вектора-строки
        System.out.println("Получение вектора-строки: " + matrix2.getComponentRow(1));
        System.out.println("Получение вектора-столбца: " + matrix2.getComponentColumn(4));

        System.out.println("Транспонирование матрицы:");
        Matrix matrix5 = new Matrix(new Vector[]{new Vector(1.0, 2, 3, 4), new Vector(5.0, 6, 7, 8, 5)});
        System.out.println("Исходная матрица: " + matrix5);
        System.out.println("Транспонированая матрица: " + matrix5.getTranspose());
        System.out.println(matrix5);

        System.out.println(matrix1);
        matrix1.multiplyOnScalar(2);
        System.out.println("Умножение матрицы на скаляр: " + matrix1);

        Matrix matrix4 = new Matrix(new Vector[]{new Vector(8.0,3),new Vector(2.0,3)});
        System.out.println("Детерминант матрицы: " + matrix4.getDeterminant());

        Matrix matrix3 = new Matrix(new Matrix(new Vector[]{new Vector(1.0, 2, 3, 4), new Vector(5.0, 6, 7, 8, 2)}));
        Vector vector3 = new Vector(2.0, 0, 2, 2, 2);
        System.out.println(matrix3);
        System.out.println(vector3);
        System.out.println("Умножение матрицы на вектор: " + matrix3.multiplyOnVector(vector3));

        Matrix matrix7 = new Matrix(new Matrix(new Vector[]{new Vector(1.0, 2, 3, 4), new Vector(5.0, 6, 7, 8, 2)}));
        Matrix matrix6 = new Matrix(new Matrix(new Vector[]{new Vector(1.0, 2, 3, 4), new Vector(5.0, 6, 7, 8, 2)}));

        System.out.println(matrix6);
        System.out.println(matrix7);

        matrix6.add(matrix7);
        System.out.println("Сложение матриц: " + matrix7);

        System.out.println(matrix6);

        matrix6.subtract(matrix7);
        System.out.println("Вычитание матриц: " + matrix7);

        System.out.println(matrix6);
        System.out.println(matrix7);

        System.out.println("Сложение матриц: " + Matrix.getSum(matrix6, matrix7));

        System.out.println("Вычитание матриц: " + Matrix.getDifference(matrix6, matrix7));

        System.out.println(matrix2);
        System.out.println(matrix5);

        System.out.println("Умножение матриц: " + Matrix.getProduct(matrix5, matrix2));
    }
}
