package ekaterina.chehuta.shape;

import java.util.Comparator;

public class PerimeterComparator implements Comparator<Shapes> {
    @Override
    public int compare(Shapes o1, Shapes o2) {
        if (o1.getPerimeter() == o2.getPerimeter()) {
            return 0;
        } else if (o1.getPerimeter() < o2.getPerimeter()) {
            return 1;
        }

        return -1;
    }
}
