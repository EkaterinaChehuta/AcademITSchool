package ekaterina.chehuta.shape.main;

import ekaterina.chehuta.shape.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();

        shapes.add(new Square(5));
        shapes.add(new Triangle(20, 4, 36, 10, 8, 4));
        shapes.add(new Rectangle(4, 4));
        Circle circle1 = new Circle(4);
        shapes.add(circle1);
        Circle circle2 = new Circle(4);
        shapes.add(circle2);
        Square square = new Square(4);
        shapes.add(square);
        Triangle triangle1 = new Triangle(2, 5, 8, 20, 49, 7);
        Triangle triangle2 = new Triangle(-2, -5, -8, -20, -49, -7);

        shapes.sort(new AreaComparator());
        System.out.println("Фигура с максимальной площадью: " + shapes.get(0));
        System.out.println();

        shapes.sort(new PerimeterComparator());
        System.out.println("Фигура со вторым по величине периметром: " + shapes.get(1));
        System.out.println();

        System.out.println(circle1.hashCode());
        System.out.println(circle2.hashCode());
        System.out.println(circle1.equals(circle2));
        System.out.println(circle1.hashCode());
        System.out.println(square.hashCode());
        System.out.println(circle1.equals(square));
        System.out.println(triangle1.hashCode());
        System.out.println(triangle2.hashCode());
        System.out.println(triangle1.equals(triangle2));
    }
}