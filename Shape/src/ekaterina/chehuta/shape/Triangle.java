package ekaterina.chehuta.shape;

public class Triangle implements Shape {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getY1() {
        return y1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public double getY2() {
        return y2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    public double getX3() {
        return x3;
    }

    public void setX3(double x3) {
        this.x3 = x3;
    }

    public double getY3() {
        return y3;
    }

    public void setY3(double y3) {
        this.y3 = y3;
    }

    private static double getSideLength(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
    }

    @Override
    public double getWidth() {
        return Math.max(x1, Math.max(x2, x3)) - Math.min(x1, Math.min(x2, x3));
    }

    @Override
    public double getHeight() {
        return Math.max(y1, Math.max(y2, y3)) - Math.min(y1, Math.min(y2, y3));
    }

    @Override
    public double getArea() {
        double sideALength = getSideLength(x1, y1, x2, y2);
        double sideBLength = getSideLength(x2, y2, x3, y3);
        double sideCLength = getSideLength(x1, y1, x3, y3);

        return 0.25 * Math.sqrt((sideALength + sideBLength + sideCLength) *
                (sideBLength + sideCLength - sideALength) *
                (sideALength + sideCLength - sideBLength) *
                (sideALength + sideBLength - sideCLength));
    }

    @Override
    public double getPerimeter() {
        return getSideLength(x1, y1, x2, y2) + getSideLength(x2, y2, x3, y3) + getSideLength(x1, y1, x3, y3);
    }

    @Override
    public String toString() {
        return String.format("Triangle.%nPointCoordinatesOne = (%f, %f)%nPointCoordinatesTwo = (%f, %f)%nPointCoordinatesTree = (%f, %f)%n" +
                        "SideALength = %f%nSideBLength = %f%nSideCLength = %f%nWidth = %f%nHeight = %f%nArea = %f%nPerimeter = %f",
                x1, y1, x2, y2, x3, y3, getSideLength(x1, y1, x2, y2), getSideLength(x2, y2, x3, y3), getSideLength(x1, y1, x3, y3),
                getWidth(), getHeight(), getArea(), getPerimeter());
    }

    @Override
    public boolean equals(Object shape) {
        if (this == shape) {
            return true;
        }

        if (shape == null || getClass() != shape.getClass()) {
            return false;
        }

        Triangle triangle = (Triangle) shape;

        return x1 == triangle.x1 && x2 == triangle.x2 && x3 == triangle.x3 &&
                y1 == triangle.y1 && y2 == triangle.y2 && y3 == triangle.y3;
    }

    @Override
    public int hashCode() {
        final int prime = 23;
        int hash = 1;
        hash = prime * hash + Double.hashCode(x1);
        hash = prime * hash + Double.hashCode(x2);
        hash = prime * hash + Double.hashCode(x3);
        hash = prime * hash + Double.hashCode(y1);
        hash = prime * hash + Double.hashCode(y2);
        hash = prime * hash + Double.hashCode(y3);
        return hash;
    }
}