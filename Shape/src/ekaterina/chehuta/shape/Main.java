package ekaterina.chehuta.shape;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Shapes> shapes = new ArrayList<>();
        AreaComparator areaComparator = new AreaComparator();
        PerimeterComparator perimeterComparator =new PerimeterComparator();

        shapes.add(new Square(4));
        shapes.add(new Triangle(20, 4, 36, 10, 8, 4));
        shapes.add(new Rectangle(4, 4));
        shapes.add(new Circle(4));

        shapes.sort(areaComparator);
        System.out.println("Фигура с максимальной площадью: " + shapes.get(0));
        System.out.println();

        shapes.sort(perimeterComparator);
        System.out.println("Фигура со вторым по величине периметром: " + shapes.get(1));
    }
}