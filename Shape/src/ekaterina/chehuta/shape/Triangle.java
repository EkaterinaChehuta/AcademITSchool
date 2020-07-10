package ekaterina.chehuta.shape;

public class Triangle implements Shapes {
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

    public double getWidth() {
        return Math.max(x1, Math.max(x2, x3)) - Math.min(x1, Math.max(x2, x3));
    }

    public double getHeight() {
        return Math.max(y1, Math.max(y2, y3)) - Math.min(y1, Math.max(y2, y3));
    }

    public double getArea() {
        return 0.5 * getHeight() * getWidth();
    }

    public double getPerimeter() {
        double sideALength = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        double sideBLength = Math.sqrt(Math.pow((x3 - x2), 2) + Math.pow((y3 - y2), 2));
        double sideCLength = Math.sqrt(Math.pow((x3 - x1), 2) + Math.pow((y3 - y1), 2));

        return sideALength + sideBLength + sideCLength;
    }

    @Override
    public String toString() {
        return "Triangle: " +
                "\nWidth = " + getWidth() +
                "\nHeight = " + getHeight() +
                "\nArea = " + getArea() +
                "\nPerimeter = " + getPerimeter();
    }
}