package ekaterina.chehuta.shape;

public class Square implements Shapes {
    private double sideLong;

    public Square(double sideLong) {
        this.sideLong = sideLong;
    }

    public double getSideLong() {
        return sideLong;
    }

    public void setSideLong(double sideLong) {
        this.sideLong = sideLong;
    }

    public double getWidth() {
        return sideLong;
    }

    public double getHeight() {
        return sideLong;
    }

    public double getArea() {
        return getHeight() * getWidth();
    }

    public double getPerimeter() {
        return (getHeight() + getWidth()) * 2;
    }
}
