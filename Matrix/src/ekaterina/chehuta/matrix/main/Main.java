package ekaterina.chehuta.matrix.main;

import ekaterina.chehuta.matrix.Matrix;
import ekaterina.chehuta.vector.Vector;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Конструктор. Матрица нулей размерностью n x m
        Matrix matrix = new Matrix(0, 5);
        System.out.println(matrix);

        // Конструктор копирования
        Vector[] vector = new Vector[]{new Vector(4.0, 6, 8), new Vector(2.0, 6, 3, 7)};
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

        System.out.println(Arrays.toString(matrix.getLength()));

        Matrix matrix2 = new Matrix(new Vector[]{new Vector(1.0, 2, 3, 4), new Vector(5.0, 6, 7, 8, 5)});
        System.out.println(matrix2);
        matrix2.setComponentString(1, new Vector(8.0, 7, 6, 5)); // Задание вектора-строки
        System.out.println(matrix2);
        System.out.println("Получение вектора-строки: " + matrix2.getComponentString(1));
        System.out.println("Получение вектора-столбца: " + matrix2.getComponentColumn(0));

        System.out.println("Транспонирование матрицы:");
        System.out.println("Исходная матрица: " + matrix2);
        System.out.println("Транспонированая матрица: " + matrix2.getTransposeMatrix());

        System.out.println(matrix1);
        matrix1.productMatrixOnScalar(2);
        System.out.println("Умножение матрицы на скаляр: " + matrix1);

        System.out.println("Детерминант матрицы: " + matrix2.getMatrixDeterminant());

        Matrix matrix3 = new Matrix(new Matrix(new Vector[]{new Vector(1.0, 2, 3, 4), new Vector(5.0, 6, 7, 8, 2)}));
        Vector vector3 = new Vector(2.0, 0, 2, 2, 2);
        System.out.println(matrix3);
        matrix3.productMatrixOnVector(vector3);
        System.out.println("Умножение матрицы на вектор: " + matrix3);
        matrix2.addMatrices(matrix3);
        System.out.println("Сложение матриц: " + matrix2);
        matrix2.subtractMatrices(matrix3);
        System.out.println("Вычитание матриц: " + matrix2);

        System.out.println(matrix3);
        System.out.println(matrix2);
        System.out.println("Сложение матриц: " + Matrix.getMatricesSum(matrix3, matrix2));

        System.out.println("Вычитание матриц: " + Matrix.getMatricesDifference(matrix3, matrix2));

        System.out.println("Умножение матриц: " + Matrix.getMatricesProduct(matrix3, matrix2));
    }
}
