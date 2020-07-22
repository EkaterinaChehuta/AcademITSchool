package ekaterina.chehuta.shape;

public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getWidth() {
        return radius * 2;
    }

    @Override
    public double getHeight() {
        return radius * 2;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return String.format("Circle.%nRadius = %f%nArea = %f%nPerimeter = %f", radius, getArea(), getPerimeter());
    }

    @Override
    public boolean equals(Object shape) {
        if (this == shape) {
            return true;
        }

        if (shape == null || getClass() != shape.getClass()) {
            return false;
        }

        Circle circle = (Circle) shape;

        return radius == circle.radius;
    }

    @Override
    public int hashCode() {
        return (int) getRadius();
    }
}