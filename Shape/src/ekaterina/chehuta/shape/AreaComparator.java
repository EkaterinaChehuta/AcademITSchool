package ekaterina.chehuta.shape;

import java.util.Comparator;

public class AreaComparator implements Comparator<Shapes> {
    @Override
    public int compare(Shapes o1, Shapes o2) {
        if (o1.getArea() == o2.getArea()) {
            return 0;
        } else if (o1.getArea() < o2.getArea()) {
            return 1;
        }

        return -1;
    }
}