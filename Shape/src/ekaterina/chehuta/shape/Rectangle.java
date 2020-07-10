package ekaterina.chehuta.shape;

public class Rectangle implements Shapes {
    private double sideALong;
    private double sideBLong;

    public Rectangle(double sideALong, double sideBLong) {
        this.sideALong = sideALong;
        this.sideBLong = sideBLong;
    }

    public double getSideALong() {
        return sideALong;
    }

    public void setSideALong(double sideALong) {
        this.sideALong = sideALong;
    }

    public double getSideBLong() {
        return sideBLong;
    }

    public void setSideBLong(double sideBLong) {
        this.sideBLong = sideBLong;
    }

    public double getWidth() {
        return sideALong;
    }

    public double getHeight() {
        return sideBLong;
    }

    public double getArea() {
        return getHeight() * getWidth();
    }

    public double getPerimeter() {
        return (getHeight() + getWidth()) * 2;
    }

    @Override
    public String toString() {
        return "Rectangle: " +
                "\nWidth = " + getWidth() +
                "\nHeight = " + getHeight() +
                "\nArea = " + getArea() +
                "\nPerimeter = " + getPerimeter();
    }
}